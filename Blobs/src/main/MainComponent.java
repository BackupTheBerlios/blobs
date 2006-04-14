/*
 * Created on 13 fvr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;

import util.MessageQueue;
import Ice.Application;

/**
 * @author Aurlie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MainComponent extends Application
{
	render.RenderComponent renderComponent;
	input.InputComponent inputComponent;
	sound.SoundComponent soundComponent;
	
	public MessageQueue incomingMessageQ=new MessageQueue();
	
	boolean running=true;

	private class halt implements util.MessageQueue.MessageHandler
	{
		/* (non-Javadoc)
		 * @see MessageQueue.MessageHandler#handle(Message)
		 */
		public void handle(util.Message event)
		{
			halt();
		}
	}

	
	/* (non-Javadoc)
	 * @see util.Component#initialise()
	 */
	protected void initialise()
	{
		incomingMessageQ.bind(HaltMessage.class,new halt());
		
		renderComponent = new render.RenderComponent(this);
		
		renderComponent.start();
		
		try
		{
			renderComponent.waitUntilInitialised();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		inputComponent=new input.InputComponent(this, renderComponent);
		inputComponent.start();
		
		soundComponent=new sound.SoundComponent();
		soundComponent.start();
	}

	/* (non-Javadoc)
	 * @see util.Component#update()
	 */
	protected void update()
	{
		try
		{
			incomingMessageQ.takeAndDispatch();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see util.Component#cleanup()
	 */
	protected void cleanup()
	{
		try
		{
			soundComponent.halt();
			soundComponent.join();
			
			inputComponent.halt();
			inputComponent.join();
			
			renderComponent.halt();
			renderComponent.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	final public void halt()
	{
		running=false;
	}
	
	@Override
	public int run(String[] arg0)
	{
		initialise();
		
		while (running)
		{
			update();
		}
		
		cleanup();
		return 0;
	}

}
