/*
 * Created on 14 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;
import org.lwjgl.fmod3.FSoundReverbChannelProperties;
import static org.lwjgl.fmod3.FSound.*;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Channel
{
	int id;
	
	Playable currentlyPlayed;
		
	public Channel(int id)
	{
		this.id=id;
	}
	
	boolean get3DAttributes(java.nio.FloatBuffer pos, java.nio.FloatBuffer vel)
	{
		return FSOUND_3D_GetAttributes(id,pos,vel);
	}
	
	boolean get3DMinMaxDistance(java.nio.FloatBuffer minmax)
	{
		return FSOUND_3D_GetMinMaxDistance(id,minmax);
	}
	
	boolean set3DAttributes(java.nio.FloatBuffer pos, java.nio.FloatBuffer vel)
	{
		return FSOUND_3D_SetAttributes(id, pos, vel);
	}

	boolean set3DMinMaxDistance(int min, int max)
	{
		return FSOUND_3D_SetMinMaxDistance(id, min, max);
	}
 
	boolean disableFX()
	{
		return FSOUND_FX_Disable(id);
	}

	int enableFX(int fxtype)
	{
		return FSOUND_FX_Enable(id, fxtype);
	}
	
	int getAmplitude()
	{
		return FSOUND_GetAmplitude(id);
	}
	
	int getCurrentPosition()
	{
		return FSOUND_GetCurrentPosition(id);
	}
	
	Sample getCurrentSample()
	{
		if(currentlyPlayed!=null && currentlyPlayed.getClass()==Sample.class)
		{
			return (Sample)currentlyPlayed;
		}
		return null;
	}
	
	int getFrequency()
	{
		return FSOUND_GetFrequency(id);
	}

	int getLoopMode()
	{
		return FSOUND_GetLoopMode(id);
	}

	boolean getMute()
	{
		return FSOUND_GetMute(id);
	}

	int getNumSubChannels()
	{
		return FSOUND_GetNumSubChannels(id);
	}

	int getPan()
	{
		return FSOUND_GetPan(id);
	}
	
	boolean isPaused()
	{
		return FSOUND_GetPaused(id);
	}

	int getPriority()
	{
		return FSOUND_GetPriority(id);
	}
	
	int getReserved()
	{
		return FSOUND_GetReserved(id);
	}
	
	int getSubChannel(int subChannel)
	{
		return FSOUND_GetSubChannel(id, subChannel);
	}
	
	int getSurround()
	{
		return FSOUND_GetSurround(id);
	}
	
	int getVolume()
	{
		return FSOUND_GetVolume(id);
	}
	


	FSoundReverbChannelProperties getReverbProperties()
	{
		FSoundReverbChannelProperties result = null;
		if(FSOUND_Reverb_GetChannelProperties(id, result))
		{
			return result;
		}
		else
		{
			return null;
		}
	}

	boolean setReverbProperties(FSoundReverbChannelProperties properties)
	{
		return FSOUND_Reverb_SetChannelProperties(id, properties);
	}

	boolean setCurrentPosition(int offset)
	{
		return FSOUND_SetCurrentPosition(id, offset);
	}
 	
	boolean setFrequency(int freq)
	{
		return FSOUND_SetFrequency(id, freq); 
	}
	
	boolean setLevels(int frontleft, int center, int frontright, int backleft, int backright, int lfe)
	{
		return FSOUND_SetLevels(id, frontleft, center, frontright, backleft, backright, lfe);
	}
	
	boolean setLoopMode(int loopmode)	
	{
		return FSOUND_SetLoopMode(id, loopmode); 
	}
	
	boolean setMute(boolean mute)
	{
		return FSOUND_SetMute(id, mute); 
	}
	
	boolean setPan(int pan)
	{
		return FSOUND_SetPan(id, pan);
	}

	boolean setPaused(boolean paused)
	{
		return FSOUND_SetPaused(id, paused); 
	}
	 	
	boolean setPriority(int priority)
	{
		return FSOUND_SetPriority(id, priority); 
	}
	
	boolean setReserved(boolean reserved)
	{
		return FSOUND_SetReserved(id, reserved); 
	}
	
	boolean setSurround(boolean surround)
	{
		return FSOUND_SetSurround(id, surround); 
	}
	
	boolean setVolume(int vol)
	{
		return FSOUND_SetVolume(id, vol); 
	}
	
	boolean setVolumeAbsolute(int vol)
	{
		return FSOUND_SetVolumeAbsolute(id, vol); 
	}
	
	
	boolean stop()
	{
		boolean result=FSOUND_StopSound(id);
		currentlyPlayed=null;
		return result; 
	}
	
	boolean isPlaying()
	{
		boolean result=FSOUND_IsPlaying(id);
		
		if(!result)
		{
			currentlyPlayed=null;
		}
		
		return result;
	}
	
	int play(Sample sample)
	{
		currentlyPlayed=sample;
		return FSOUND_PlaySound(id, sample.fsample);
	}
	
	int play(Sample sample, DspUnit dspunit, boolean startpaused)
	{
		currentlyPlayed=sample;
		return nFSOUND_PlaySoundEx(id, sample.fsample, dspunit.fdspUnit, startpaused);
	}
	
	int play(Stream stream)
	{
		currentlyPlayed=stream;
		return FSOUND_Stream_Play(id, stream.fstream); 
	}
	
	int play(Stream stream, DspUnit dspunit, boolean paused)
	{
		currentlyPlayed=stream;
		return FSOUND_Stream_PlayEx(id, stream.fstream, dspunit.fdspUnit, paused);
	}
}
