/*
 * Created on 27 févr. 2005
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
public class System
{
	Channel channels[];
	
	System(int nbChannels)
	{
		try
		{
			FMOD.create();
			
			FSOUND_Init(44100, 
			            nbChannels, 
			            0x0200 /* FSOUND_INIT_STREAM_FROM_MAIN_THREAD */);
			
			channels=new Channel[FSOUND_GetMaxSamples()];
			
			for (int i=0;i<nbChannels;i++)
			{
				channels[i]=new Channel(i);
			}
		}
		catch (FMODException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finalize()
	{
		FSOUND_Close();
		
		FMOD.destroy();
	}
	
	void update()
	{
		FSOUND_Update();
	}
	
	public class ThreeD
	{
		static void 	FSOUND_3D_Listener_GetAttributes(java.nio.FloatBuffer pos, java.nio.FloatBuffer vel, java.nio.FloatBuffer fx, java.nio.FloatBuffer fy, java.nio.FloatBuffer fz, java.nio.FloatBuffer tx, java.nio.FloatBuffer ty, java.nio.FloatBuffer tz)
		static void 	FSOUND_3D_Listener_SetAttributes(java.nio.FloatBuffer pos, java.nio.FloatBuffer vel, float fx, float fy, float fz, float tx, float ty, float tz)
		static void 	FSOUND_3D_Listener_SetCurrent(int current, int numlisteners) 
		static void 	FSOUND_3D_SetDistanceFactor(float scale)
		static void 	FSOUND_3D_SetDopplerFactor(float scale)
		static boolean 	FSOUND_3D_SetMinMaxDistance(int channel, int min, int max)
		static void 	FSOUND_3D_SetRolloffFactor(float rolloff) 
	}

	
	static int 	FSOUND_GetDriver()
	static boolean 	FSOUND_GetDriverCaps(int driverid, java.nio.IntBuffer caps)
	static java.lang.String 	FSOUND_GetDriverName(int driverid)
	static int 	FSOUND_GetNumDrivers()
	static boolean 	FSOUND_SetDriver(int driver) 

	
	static int FSOUND_GetChannelsPlaying()
    static float FSOUND_GetCPUUsage()
	static void 	FSOUND_GetMemoryStats(java.nio.IntBuffer currentallocated_maxallocated)
	static int 	FSOUND_GetMaxChannels()
	static boolean 	FSOUND_GetNumHWChannels(java.nio.IntBuffer twoD_threeD_channels_total) 
	
	static int 	FSOUND_GetError()
	
   	static int 	FSOUND_GetMixer() 
	static int 	FSOUND_GetOutput()
	static int 	FSOUND_GetOutputRate()
    static int 	FSOUND_GetSFXMasterVolume() 
	static float 	FSOUND_GetVersion() 
	
	static boolean 	FSOUND_SetBufferSize(int len_ms)
	
	static boolean 	FSOUND_SetOutput(int output) 
	static void 	FSOUND_SetPanSeperation(float pansep) 
	static void 	FSOUND_SetSFXMasterVolume(int volume) 
	static void 	FSOUND_SetSpeakerMode(int speakermode) 
	
	public class Reverb
	{
		static boolean 	FSOUND_Reverb_GetChannelProperties(int channel, FSoundReverbChannelProperties reverb)
		static boolean 	FSOUND_Reverb_GetProperties(FSoundReverbProperties reverb)
		static boolean 	FSOUND_Reverb_SetChannelProperties(int channel, FSoundReverbChannelProperties reverb)
		static boolean 	FSOUND_Reverb_SetProperties(FSoundReverbProperties reverb) 
	}


	
    
}
