/*
 * Created on 13 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MessageQueue extends LinkedBlockingQueue<Message>
{
	private static final long serialVersionUID = 65263L;
	
	public interface MessageHandler
	{
		void handle(Message event);
	}
	
	HashMap<Class, MessageHandler> eventDispatchInfo=new HashMap<Class, MessageHandler>();
	
	public void bind(Class eventObjectClass, MessageHandler handler)
	{
		eventDispatchInfo.put(eventObjectClass,handler);
	}
	
	public void dispatchAll()
	{
		if(!isEmpty())
		{
			Message event=poll();
			
			handleMessage(event);
		}
	}
	
	public void takeAndDispatch() throws InterruptedException
	{
		Message event=take();
		
		handleMessage(event);
	}

	/**
	 * @param event
	 */
	private void handleMessage(Message event)
	{
		MessageHandler handler=eventDispatchInfo.get(event.getClass());
		
		if (handler != null)
		{
			handler.handle(event);
		}
	}
}
