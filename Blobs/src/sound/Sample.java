/*
 * Created on 14 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

import org.lwjgl.fmod3.FSoundSample;
import org.lwjgl.fmod3.FSoundSampleLock;
import static org.lwjgl.fmod3.FSound.*;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Sample implements Playable
{
	public FSoundSample fsample=null;
	
	Sample(FSoundSample sample)
	{
		fsample=sample;
	}
	
	Sample(int index, java.nio.ByteBuffer data, int inputmode, int offset, int length)
	{
		fsample=FSOUND_Sample_Load(index, data, inputmode, offset, length);
	}
	
	Sample(int index, String name, int inputmode, int offset, int length)
	{
		fsample=FSOUND_Sample_Load(index, name, inputmode, offset, length);
	}
 
	Sample(int index, int length, int mode, int deffreq, int defvol, int defpan, int defpri)
	{
		fsample=FSOUND_Sample_Alloc(index, length, mode, deffreq, defvol, defpan, defpri);
	}
	
	Sample(int sampno)
	{
		fsample=FSOUND_Sample_Get(sampno);
	}

	public void finalize()
	{
		FSOUND_Sample_Free(fsample);
	}
	
	boolean getDefaults(java.nio.IntBuffer deffreq, 
	                    java.nio.IntBuffer defvol, 
	                    java.nio.IntBuffer defpan, 
	                    java.nio.IntBuffer defpri)
	{
		return FSOUND_Sample_GetDefaults(fsample, deffreq, defvol, defpan, defpri);
	}
		
    boolean getDefaults(java.nio.IntBuffer deffreq, 
                        java.nio.IntBuffer defvol, 
                        java.nio.IntBuffer defpan, 
                        java.nio.IntBuffer defpri, 
                        java.nio.IntBuffer varfreq, 
                        java.nio.IntBuffer varvol, 
                        java.nio.IntBuffer varpan)
    {
    	return FSOUND_Sample_GetDefaultsEx(fsample, 
    	                                   deffreq, 
    	                                   defvol,  
    	                                   defpan, 
    	                                   defpri, 
    	                                   varfreq, 
    	                                   varvol,  
    	                                   varpan);
    }
    
    int getLength()
    {
    	return FSOUND_Sample_GetLength(fsample);
    }
    
    int getLoopPoints(java.nio.IntBuffer loopstart, java.nio.IntBuffer loopend)
    {
    	return FSOUND_Sample_GetLoopPoints(fsample, loopstart, loopend);
    }
    
    int getMinMaxDistance(java.nio.FloatBuffer min, java.nio.FloatBuffer max)
    {
    	return FSOUND_Sample_GetMinMaxDistance(fsample, min, max);
    }
    
    int getMode()
    {
    	return FSOUND_Sample_GetMode(fsample);
    }
      
    String getName()
    {
    	return FSOUND_Sample_GetName(fsample);
    }
    

     
    boolean lock(int offset, int length, FSoundSampleLock lock)
    {
    	return FSOUND_Sample_Lock(fsample, offset, length, lock);
    }
    
    boolean setDefaults(int deffreq, 
                        int defvol, 
                        int defpan, 
                        int defpri)
    {
    	return FSOUND_Sample_SetDefaults(fsample, deffreq, defvol, defpan, defpri);
    }
    
    boolean setDefaults(int deffreq, 
                        int defvol, 
                        int defpan, 
                        int defpri, 
                        int varfreq, 
                        int varvol, 
                        int varpan)
    {
    	return FSOUND_Sample_SetDefaultsEx(fsample, deffreq, defvol, defpan, defpri, varfreq, varvol, varpan);
    }
    
    boolean setMaxPlaybacks(int max)
    {
    	return FSOUND_Sample_SetMaxPlaybacks(fsample, max);
    }
    
    boolean setMinMaxDistance(float min, float max)
    {
    	return FSOUND_Sample_SetMinMaxDistance(fsample, min, max);
    }
    
    boolean setMode(int mode)
    {
    	return FSOUND_Sample_SetMode(fsample, mode);
    }
    
    boolean unlock(FSoundSampleLock lock)
    {
    	return FSOUND_Sample_Unlock(fsample, lock);
    }
    
    boolean upload(java.nio.ByteBuffer srcdata, int mode)
    {
    	return FSOUND_Sample_Upload(fsample, srcdata, mode);
    }
    
    boolean setLoopPoints(int loopstart, int loopend)
    {
    	return nFSOUND_Sample_SetLoopPoints(fsample, loopstart, loopend);
    }
}
