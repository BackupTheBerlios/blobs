/*
 * Created on 13 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Component extends util.Component
{
	render.Component renderComponent;
	input.Component inputComponent;
	sound.Component soundComponent;

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
		
		renderComponent = new render.Component(this);
		
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
					
		inputComponent=new input.Component(this, renderComponent);
		inputComponent.start();
		
		soundComponent=new sound.Component();
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

}
