/*
 * Created on 13 fvr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

/**
 * @author Aurlie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SoundComponent extends util.Component
{
	/* (non-Javadoc)
	 * @see util.Component#initialise()
	 */
	protected void initialise()
	{
	}

	/* (non-Javadoc)
	 * @see util.Component#update()
	 */
	protected void update()
	{
		try
		{
			Thread.sleep(30);
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

	}

}
