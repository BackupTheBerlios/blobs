/*
 * Created on 15 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

import org.lwjgl.fmod3.FSoundDSPUnit;
import org.lwjgl.fmod3.FSoundStream;
import org.lwjgl.fmod3.FSoundSyncPoint;
import org.lwjgl.fmod3.FSoundTagField;
import static org.lwjgl.fmod3.FSound.*;
import org.lwjgl.fmod3.callbacks.FSoundDSPCallback;
import org.lwjgl.fmod3.callbacks.FSoundMetaDataCallback;
import org.lwjgl.fmod3.callbacks.FSoundStreamCallback;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Stream implements Playable
{
	FSoundStream fstream=null;
	
	Stream(FSoundStream stream)
	{
		fstream=stream;
	}

	Stream(java.nio.ByteBuffer data, int mode, int offset, int length)
	{
		fstream = FSOUND_Stream_Open(data, mode, offset, length);
	}

	Stream(String name, int mode, int offset, int length)
	{
		fstream = FSOUND_Stream_Open(name, mode, offset, length);
	}

	Stream(FSoundStreamCallback callbackHandler,
			int lenbytes,
			int mode,
			int samplerate)
	{
		fstream = FSOUND_Stream_Create(	callbackHandler,
										lenbytes,
										mode,
										samplerate);
	}

	public void finalize()
	{
		FSOUND_Stream_Close(fstream);
	}
	
	int getNumSyncPoints()
	{
		return nFSOUND_Stream_GetNumSyncPoints(fstream);
	}
	
	FSoundSyncPoint addSyncPoint(int pcmoffset, java.lang.String name)
	{
		return FSOUND_Stream_AddSyncPoint(fstream, pcmoffset, name);
	}
	

	
	FSoundDSPUnit createDSP(FSoundDSPCallback callback, int priority)
	{
		return FSOUND_Stream_CreateDSP(fstream, callback, priority);
	}

	static boolean deleteSyncPoint(FSoundSyncPoint point)
	{
		return FSOUND_Stream_DeleteSyncPoint(point);
	}
	
	boolean findTagField(FSoundTagField field)
	{
		return FSOUND_Stream_FindTagField(fstream, field);
	}
	
	int getLength()
	{
		return FSOUND_Stream_GetLength(fstream);
	}
	
	int getLengthMs()
	{
		return FSOUND_Stream_GetLengthMs(fstream);
	}
	
	int getMode()
	{
		return FSOUND_Stream_GetMode(fstream);
	}
	
	int getNumSubStreams()
	{
		return FSOUND_Stream_GetNumSubStreams(fstream);
	}

	boolean getNumTagFields(java.nio.IntBuffer num)
	{
		return FSOUND_Stream_GetNumTagFields(fstream, num);
	}
	
	int getOpenState()
	{
		return FSOUND_Stream_GetOpenState(fstream);
	}
	
	int getPosition()
	{
		return FSOUND_Stream_GetPosition(fstream);
	}

	Sample getSample()
	{
		return new Sample(FSOUND_Stream_GetSample(fstream));
	}
	
	FSoundSyncPoint getSyncPoint(int index)
	{
		return FSOUND_Stream_GetSyncPoint(fstream, index);
	}
	
	static String getSyncPointInfo(FSoundSyncPoint point, java.nio.IntBuffer pcmoffset)
	{
		return FSOUND_Stream_GetSyncPointInfo(point, pcmoffset);
	}
	
	boolean getTagField(int num, FSoundTagField field)
	{
		return FSOUND_Stream_GetTagField(fstream, num, field);
	}
	
	int getTime()
	{
		return FSOUND_Stream_GetTime(fstream);
	}
	
	static boolean getNetBufferProperties(java.nio.IntBuffer values)
	{
		return FSOUND_Stream_Net_GetBufferProperties(values);
	}
	
	static String getNetLastServerStatus()
	{
		return FSOUND_Stream_Net_GetLastServerStatus();
	}
	
	boolean getNetStatus(java.nio.IntBuffer values)
	{
		return FSOUND_Stream_Net_GetStatus(fstream, values);
	}
	
	static boolean setNetBufferProperties(int buffersize, 
	                                      int prebuffer_percent, 
	                                      int rebuffer_percent)
	{
		return FSOUND_Stream_Net_SetBufferProperties(buffersize, 
		                                             prebuffer_percent, 
		                                             rebuffer_percent);
	}
	
	boolean setNetMetadataCallback(FSoundMetaDataCallback callback)
	{
		return FSOUND_Stream_Net_SetMetadataCallback(fstream, callback);
	}
	
	static boolean setNetProxy(String proxy)
	{
		return FSOUND_Stream_Net_SetProxy(proxy);
	}
	


	static boolean setBufferSize(int ms)
	{
		return FSOUND_Stream_SetBufferSize(ms);
	}
	
	boolean setEndCallback(FSoundStreamCallback callback)
	{
		return FSOUND_Stream_SetEndCallback(fstream, callback);
	}
	
	int setLoopCount(int count)
	{
		return FSOUND_Stream_SetLoopCount(fstream, count);
	}
	
	int setLoopPoints(int loopstart, int loopend)
	{
		return FSOUND_Stream_SetLoopPoints(fstream, loopstart, loopend);
	}
	
	int setMode(int mode)
	{
		return FSOUND_Stream_SetMode(fstream, mode);
	}
	
	int setPosition(int position)
	{
		return FSOUND_Stream_SetPosition(fstream, position);
	}
	
	int setSubStream(int index)
	{
		return FSOUND_Stream_SetSubStream(fstream, index);
	}
	
	int setSubStreamSentence(java.nio.IntBuffer sentencelist)
	{
		return FSOUND_Stream_SetSubStreamSentence(fstream, sentencelist);
	}

	boolean setSyncCallback(FSoundStreamCallback callback)
	{
		return FSOUND_Stream_SetSyncCallback(fstream, callback);
	}
	
	int setTime(int ms)
	{
		return FSOUND_Stream_SetTime(fstream, ms);
	}
	
	boolean stop()
	{
		return FSOUND_Stream_Stop(fstream); 
	}
}
