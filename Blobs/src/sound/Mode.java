/*
 * Created on 19-Feb-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package sound;

/**
 * @author Olivier
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Mode
{
	/* For non looping samples. */
	public final static int LOOP_OFF = 0x00000001;

	/* For forward looping samples. */
	public final static int LOOP_NORMAL = 0x00000002;

	/* For bidirectional looping samples. =no effect if in hardware). */
	public final static int LOOP_BIDI = 0x00000004;

	/* For 8 bit samples. */
	public final static int EIGHT_BITS = 0x00000008;

	/* For 16 bit samples. */
	public final static int SIXTEEN_BITS = 0x00000010;

	/* For mono samples. */
	public final static int MONO = 0x00000020;

	/* For stereo samples. */
	public final static int STEREO = 0x00000040;

	/* For user created source data containing unsigned samples. */
	public final static int UNSIGNED = 0x00000080;

	/* For user created source data containing signed data. */
	public final static int SIGNED = 0x00000100;

	/* For user created source data stored as delta values. */
	public final static int DELTA = 0x00000200;

	/* For user created source data stored using IT214 compression. */
	public final static int IT214 = 0x00000400;

	/* For user created source data stored using IT215 compression. */
	public final static int IT215 = 0x00000800;

	/*
	 * Attempts to make samples use 3d hardware acceleration. =if the card
	 * supports it)
	 */
	public final static int HW3D = 0x00001000;

	/*
	 * Tells software =not hardware) based sample not to be included in 3d
	 * processing.
	 */
	public final static int TWO_D = 0x00002000;

	/* For a streamimg sound where you feed the data to it. */
	public final static int STREAMABLE = 0x00004000;

	/*
	 * "name" will be interpreted as a pointer to data for streaming and
	 * samples.
	 */
	public final static int LOADMEMORY = 0x00008000;

	/* Will ignore file format and treat as raw pcm. */
	public final static int LOADRAW = 0x00010000;

	/*
	 * For Stream_Open - for accurate Stream_GetLengthMs/Stream_SetTime.
	 * WARNING, see Stream_Open for inital opening time performance issues.
	 */
	public final static int MPEGACCURATE = 0x00020000;

	/*
	 * For forcing stereo streams and samples to be mono - needed if using HW3D
	 * and stereo data - incurs a small speed hit for streams
	 */
	public final static int FORCEMONO = 0x00040000;

	/* 2D hardware sounds. allows hardware specific effects */
	public final static int HW2D = 0x00080000;

	/*
	 * Allows DX8 FX to be played back on a sound. Requires DirectX 8 - Note
	 * these sounds cannot be played more than once, be 8 bit, be less than a
	 * certain size, or have a changing frequency
	 */
	public final static int ENABLEFX = 0x00100000;

	/*
	 * For FMODCE only - decodes mpeg streams using a lower quality decode, but
	 * faster execution
	 */
	public final static int MPEGHALFRATE = 0x00200000;

	/* Contents are stored compressed as IMA ADPCM */
	public final static int IMAADPCM = 0x00400000;

	/* For PS2 only - Contents are compressed as Sony VAG format */
	public final static int VAG = 0x00800000;

	/*
	 * For Stream_Open/FMUSIC_LoadSong - Causes stream or music to open in the
	 * background and not block the foreground app. See Stream_GetOpenState or
	 * FMUSIC_GetOpenState to determine when it IS ready.
	 */
	public final static int NONBLOCKING = 0x01000000;

	/* For Gamecube only - Contents are compressed as Gamecube DSP-ADPCM format */
	public final static int GCADPCM = 0x02000000;

	/*
	 * For PS2 and Gamecube only - Contents are interleaved into a multi-channel
	 * =more than stereo) format
	 */
	public final static int MULTICHANNEL = 0x04000000;

	/* For PS2 only - Sample/Stream is forced to use hardware voices 00-23 */
	public final static int USECORE0 = 0x08000000;

	/* For PS2 only - Sample/Stream is forced to use hardware voices 24-47 */
	public final static int USECORE1 = 0x10000000;

	/*
	 * For PS2 only - "name" will be interpreted as a pointer to data for
	 * streaming and samples. The address provided will be an IOP address
	 */
	public final static int LOADMEMORYIOP = 0x20000000;

	/*
	 * Skips id3v2 etc tag checks when opening a stream, to reduce seek/read
	 * overhead when opening files =helps with CD performance)
	 */
	public final static int IGNORETAGS = 0x40000000;

	/* Specifies an internet stream */
	public final static int STREAM_NET = 0x80000000;

	public final static int NORMAL = SIXTEEN_BITS | SIGNED | MONO;
}
