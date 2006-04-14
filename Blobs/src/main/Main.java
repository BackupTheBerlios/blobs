/*
 * Created on 13 fvr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;

/**
 * @author Aurlie
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main
{
	public static void main(String args[])
	{
		MainComponent app = new MainComponent();
        int status = app.main("Client", args);
        System.gc();
        System.exit(status);
	}
}
