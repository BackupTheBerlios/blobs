/*
 * Created on 13 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

import org.lwjgl.fmod3.FMOD;
import org.lwjgl.fmod3.FMODException;
import static org.lwjgl.fmod3.FSound.*;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Component extends util.Component
{
	/* (non-Javadoc)
	 * @see util.Component#initialise()
	 */
	protected void initialise()
	{
		try
		{

			

			
//			Stream localStream=Stream.open("Cool.mp3",Mode.NORMAL,0,0);
//			
//			Stream aStream=Stream.open("http://205.188.234.3:8004",Mode.STREAM_NET,0,0);
//			
//			channels[0].play(aStream);
//			channels[1].play(localStream);
		}
		catch (FMODException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see util.Component#update()
	 */
	protected void update()
	{
		FSOUND_Update();
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
