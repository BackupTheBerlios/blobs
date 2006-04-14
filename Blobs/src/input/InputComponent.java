/*
 * Created on 13 fvr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package input;

import java.util.HashMap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

/**
 * @author Aurlie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InputComponent extends util.Component
{
	public interface Event
	{
	}
	
	class KeyboardEvent implements Event
	{
	}
	
	public interface Handler
	{
		void handle(Event event);
	}
	
	main.MainComponent mainComponent;
	render.RenderComponent renderComponent;
	
	public InputComponent(main.MainComponent main,render.RenderComponent render)
	{
		mainComponent=main;
		renderComponent=render;
		
		register(Keyboard.KEY_ESCAPE,
		         new Handler()
		         {
					public void handle(Event event)
					{
						mainComponent.incomingMessageQ.add(new main.HaltMessage());
					}
		         });
		
		register(Keyboard.KEY_F1,
		         new Handler()
		         {
					public void handle(Event event)
					{
						renderComponent.incomingMessageQ.add(new render.SwitchModeMessage());
					}
		         });
	}
	
	HashMap<Integer,Handler> handlerMap=new HashMap<Integer,Handler>();
	
	private void register(Integer keyId, Handler handler)
	{
		handlerMap.put(keyId,handler);
	}

	/* (non-Javadoc)
	 * @see Component#initialise()
	 */
	protected void initialise()
	{
		try
		{
			Keyboard.create();
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Component#update()
	 */
	synchronized protected void update()
	{
		Keyboard.poll();
		
		while(Keyboard.next())
		{
			Handler handler=handlerMap.get(Keyboard.getEventKey());
		
			if(handler != null)
			{
				handler.handle(new KeyboardEvent());
			}
				
		}
		
		try
		{
			sleep(20);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		incomingMessageQ.dispatchAll();
	}

	/* (non-Javadoc)
	 * @see Component#cleanup()
	 */
	protected void cleanup()
	{
		Keyboard.destroy();
	}
}