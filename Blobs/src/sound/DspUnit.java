/*
 * Created on 16-Feb-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

import org.lwjgl.fmod3.FSoundDSPUnit;
import org.lwjgl.fmod3.callbacks.FSoundDSPCallback;
import static org.lwjgl.fmod3.FSound.*;

/**
 * @author Olivier
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class DspUnit
{
	FSoundDSPUnit fdspUnit=null;
	
	DspUnit(FSoundDSPUnit unit)
	{
		fdspUnit=unit;
	}
	
	static DspUnit create(FSoundDSPCallback callbackHandler, int priority)
	{
		return new DspUnit(FSOUND_DSP_Create(callbackHandler, priority));
	}
	
	static DspUnit getClearUnit()
	{
		return new DspUnit(FSOUND_DSP_GetClearUnit());
	}
	
	static DspUnit getClipAndCopyUnit()
	{
		return new DspUnit(FSOUND_DSP_GetClipAndCopyUnit());
	}
	
	static DspUnit getFFTUnit()
	{
		return new DspUnit(FSOUND_DSP_GetFFTUnit());
	}
	
	static DspUnit getMusicUnit()
	{
		return new DspUnit(FSOUND_DSP_GetMusicUnit());
	}
	
	static DspUnit getSFXUnit()
	{
		return new DspUnit(FSOUND_DSP_GetSFXUnit());
	}
	
	static void free(DspUnit unit)
	{
		FSOUND_DSP_Free(unit.fdspUnit);
	}
	
	void setActive(boolean active)
	{
		FSOUND_DSP_SetActive(fdspUnit, active);
	}
	
	void setPriority(int priority)
	{
		FSOUND_DSP_SetPriority(fdspUnit, priority);
	}
	
	boolean getActive()
	{
		return FSOUND_DSP_GetActive(fdspUnit);
	}
	
	int getPriority()
	{
		return FSOUND_DSP_GetPriority(fdspUnit);
	}

	
	static int getBufferLength()
	{
		return FSOUND_DSP_GetBufferLength();
	}
	
	static int getBufferLengthTotal()
	{
		return FSOUND_DSP_GetBufferLengthTotal();
	}
	
	static java.nio.FloatBuffer getSpectrum()
	{
		return FSOUND_DSP_GetSpectrum();
	}
	
	static boolean mixBuffers(java.nio.ByteBuffer destbuffer, 
	                          java.nio.ByteBuffer srcbuffer, 
	                          int len, int freq, int vol, int pan, int mode)
	{
		return FSOUND_DSP_MixBuffers(destbuffer, srcbuffer, len, freq, vol, pan, mode);
	}
}
