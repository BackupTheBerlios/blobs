/*
 * Created on 13 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class Component extends Thread
{

	public MessageQueue incomingMessageQ=new MessageQueue();
	
	boolean running=true;
	final Lock lock=new ReentrantLock(); 
	final Condition initialised=lock.newCondition();
	
	public void waitUntilInitialised() throws InterruptedException
	{
		lock.lock();
		try
		{
			initialised.await();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	final public void run()
	{
		initialise();
		
		lock.lock();
		try
		{
			initialised.signalAll();
		}
		finally
		{
			lock.unlock();
		}
		
		while (running)
		{
			update();
		}
		
		cleanup();
	}

	final public void halt()
	{
		running=false;
	}
	
	boolean isRunning()
	{
		return running;
	}

	protected abstract void initialise();
	protected abstract void update();
	protected abstract void cleanup();
	
}

