/* Name: Tiffany Tran
   Name of the program: Countdown.java
   Teacher: Ms. Dyke
   Date: January 5th, 2015
   Assignment: This class creates a timer that is used in a timed game.

   Name              Type           Purpose

   c                 reference      Points to the console class.
   time              static int     Used within the loops.
*/

import java.awt.*;
import hsa.Console;
import java.lang.*;
import javax.swing.JOptionPane;


//This initializes the class Countdown and extends it.
public class Countdown extends Thread
{
    private Console c;
    public static int time;

    /* This method created the timer with the help of the for loop. The if
      statement will tell the user they ran out of time when the timer is 0.
      
      Name              Type           Purpose

      font              Font           Stores the font.
      maroon            Color          Stores the color maroon.
      e                 refernece      Points to the Exception class.
    */
    public void timer ()
    {
	Font font = new Font ("Courier New", 1, 17);
	Color maroon = new Color (128, 0, 0);

	for (time = 180 ; time >= 0 ; time--)
	{
	    c.setFont (font);
	    c.setColor (Color.black);
	    c.fillRect (560, 60, 30, 20);
	    c.setColor (Color.white);
	    c.drawString (time + "", 560, 73);
	    if (time == 0)
	    {
		c.drawString ("You ran out of time, please enter any key to continue.", 60, 103);
	    }
	    try
	    {
		Thread.sleep (1000);
	    }
	    catch (Exception e)
	    {
	    }
	}

    }


    // This is the class constructor.
    public Countdown (Console con)
    {
	c = con;
    }


    //This is used to run the timer method.
    public void run ()
    {
	timer ();
    }
} // Countdown1 class bracket


