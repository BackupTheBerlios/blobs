/*
 * Created on 13 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package render;

import main.HaltMessage;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.glu.GLU.*;

/**
 * @author Aurélie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Component extends util.Component
{
	private String windowTitle;
	
	private float rtri; // Angle For The Triangle ( NEW )
	private float rquad; // Angle For The Quad ( NEW )
	
	private boolean fullscreen=false;
	private DisplayMode displayMode;

	private main.Component mainComponent;

	public Component(main.Component main)
	{
		mainComponent=main;
		
		incomingMessageQ.bind(SwitchModeMessage.class,new switchMode());
	}
	
	protected void initialiseGL()
	{
		glEnable(GL_TEXTURE_2D); // Enable Texture Mapping
		glShadeModel(GL_SMOOTH); // Enable Smooth Shading
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
		glClearDepth(1.0); // Depth Buffer Setup
		glEnable(GL_DEPTH_TEST); // Enables Depth Testing
		glDepthFunc(GL_LEQUAL); // The Type Of Depth Testing To
		// Do

		glMatrixMode(GL_PROJECTION); // Select The Projection
		// Matrix
		glLoadIdentity(); // Reset The Projection Matrix

		// Calculate The Aspect Ratio Of The Window
		gluPerspective(	45.0f,
						(float) displayMode.getWidth() / (float) displayMode.getHeight(),
						0.1f,
						100.0f);
		glMatrixMode(GL_MODELVIEW); // Select The Modelview
		// Matrix

		// Really Nice Perspective Calculations
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	}
	
	protected void initialiseDisplay() throws LWJGLException
	{
		Display.setFullscreen(fullscreen);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++)
		{
			if (d[i].getWidth() == 640 && d[i].getHeight() == 480
				&& d[i].getBitsPerPixel() == 32)
			{
				displayMode = d[i];
				break;
			}
		}
		Display.setDisplayMode(displayMode);
		Display.setTitle("A title"/*windowTitle*/);
		Display.setVSyncEnabled(true);
		Display.create();
	}
	

	/* (non-Javadoc)
	 * @see Component#initialise()
	 */
	protected void initialise()
	{
		try
		{
			initialiseDisplay();
			initialiseGL();
		}
		catch (LWJGLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Component#update()
	 */
	synchronized protected void update()
	{
		render();
		
		Display.update();
		if(Display.isCloseRequested())
		{
			mainComponent.incomingMessageQ.add(new HaltMessage());
		}
		
		incomingMessageQ.dispatchAll();
		//Display.sync(60);
		//yield();
	}
	
	
	private class switchMode implements util.MessageQueue.MessageHandler
	{
		/* (non-Javadoc)
		 * @see MessageQueue.MessageHandler#handle(Message)
		 */
		public void handle(util.Message event)
		{
			fullscreen = !fullscreen;
			try
			{
				Display.setFullscreen(fullscreen);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see Component#cleanup()
	 */
	protected void cleanup()
	{
		Display.destroy();
	}
	
	private boolean render()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear
		// The
		// Screen
		// And
		// The
		// Depth
		// Buffer

		glLoadIdentity(); // Reset The Current
		// Modelview Matrix

		glTranslatef(-1.5f, 0.0f, -6.0f); // Move Left 1.5
		// Units And
		// Into The
		// Screen 6.0
		glRotatef(rtri, 0.0f, 1.0f, 0.0f); // Rotate The
		// Triangle On
		// The Y axis (
		// NEW )
		glBegin(GL_TRIANGLES); // Drawing Using
		// Triangles
		glColor3f(1.0f, 0.0f, 0.0f); // Red
		glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle
		// (Front)
		glColor3f(0.0f, 1.0f, 0.0f); // Green
		glVertex3f(-1.0f, -1.0f, 1.0f); // Left Of Triangle
		// (Front)
		glColor3f(0.0f, 0.0f, 1.0f); // Blue
		glVertex3f(1.0f, -1.0f, 1.0f); // Right Of Triangle
		// (Front)
		glColor3f(1.0f, 0.0f, 0.0f); // Red
		glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle
		// (Right)
		glColor3f(0.0f, 0.0f, 1.0f); // Blue
		glVertex3f(1.0f, -1.0f, 1.0f); // Left Of Triangle
		// (Right)
		glColor3f(0.0f, 1.0f, 0.0f); // Green
		glVertex3f(1.0f, -1.0f, -1.0f); // Right Of
		// Triangle
		// (Right)
		glColor3f(1.0f, 0.0f, 0.0f); // Red
		glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle
		// (Back)
		glColor3f(0.0f, 1.0f, 0.0f); // Green
		glVertex3f(1.0f, -1.0f, -1.0f); // Left Of
		// Triangle
		// (Back)
		glColor3f(0.0f, 0.0f, 1.0f); // Blue
		glVertex3f(-1.0f, -1.0f, -1.0f); // Right Of
		// Triangle
		// (Back)
		glColor3f(1.0f, 0.0f, 0.0f); // Red
		glVertex3f(0.0f, 1.0f, 0.0f); // Top Of Triangle
		// (Left)
		glColor3f(0.0f, 0.0f, 1.0f); // Blue
		glVertex3f(-1.0f, -1.0f, -1.0f); // Left Of Triangle
		// (Left)
		glColor3f(0.0f, 1.0f, 0.0f); // Green
		glVertex3f(-1.0f, -1.0f, 1.0f); // Right Of Triangle
		// (Left)
		glEnd(); // Finished
		// Drawing The
		// Triangle

		glLoadIdentity(); // Reset The Current
		// Modelview Matrix
		glTranslatef(1.5f, 0.0f, -7.0f); // Move Right 1.5
		// Units And Into
		// The Screen 6.0
		glRotatef(rquad, 1.0f, 1.0f, 1.0f); // Rotate The
		// Quad On The X
		// axis ( NEW )
		glColor3f(0.5f, 0.5f, 1.0f); // Set The Color To
		// Blue One Time
		// Only
		glBegin(GL_QUADS); // Draw A Quad
		glColor3f(0.0f, 1.0f, 0.0f); // Set The Color To
		// Green
		glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The
		// Quad (Top)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The
		// Quad (Top)
		glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of
		// The Quad (Top)
		glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of
		// The Quad (Top)
		glColor3f(1.0f, 0.5f, 0.0f); // Set The Color To
		// Orange
		glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The
		// Quad (Bottom)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The
		// Quad (Bottom)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of
		// The Quad (Bottom)
		glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of
		// The Quad (Bottom)
		glColor3f(1.0f, 0.0f, 0.0f); // Set The Color To
		// Red
		glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The
		// Quad (Front)
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The
		// Quad (Front)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of
		// The Quad (Front)
		glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of
		// The Quad (Front)
		glColor3f(1.0f, 1.0f, 0.0f); // Set The Color To
		// Yellow
		glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of
		// The Quad (Back)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of
		// The Quad (Back)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The
		// Quad (Back)
		glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The
		// Quad (Back)
		glColor3f(0.0f, 0.0f, 1.0f); // Set The Color To
		// Blue
		glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The
		// Quad (Left)
		glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The
		// Quad (Left)
		glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of
		// The Quad (Left)
		glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of
		// The Quad (Left)
		glColor3f(1.0f, 0.0f, 1.0f); // Set The Color To
		// Violet
		glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The
		// Quad (Right)
		glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The
		// Quad (Right)
		glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of
		// The Quad (Right)
		glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of
		// The Quad (Right)
		glEnd(); // Done Drawing
		// The Quad

		rtri += 0.2f; // Increase The
		// Rotation Variable
		// For The Triangle
		// ( NEW )
		rquad -= 0.15f; // Decrease The
		// Rotation Variable
		// For The Quad (
		// NEW )
		return true;
	}


}
