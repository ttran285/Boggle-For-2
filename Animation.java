/* Name: Tiffany Tran
   Name of the program: Animation.java
   Teacher: Ms. Dyke
   Date: December 24th, 2015
   Assignment: This class displays an interesting animation which is played at
   the start of the program.

   Name              Type        Purpose

   c                 reference   Points to the console class.
   x                 int         Used within the loops.
   maroon            Color       Stores the color maroon.
*/

import java.awt.*;
import hsa.Console;
import java.lang.*;

// This initializes the class Animation and implements it.
public class Animation implements Runnable
{
    private Console c;
    int x;
    Color maroon = new Color (128, 0, 0);

    /*This method creates the background using the for loop. The try block
    is used to import the image.

    Name             Type        Purpose

    board            Image       Points to the Image class.
    e                reference   Points to the InterruptedException class.
    */
    public void background ()
    {
	Image board;
	for (x = 0 ; x < 640 ; x++) //Background
	{
	    c.setColor (maroon);
	    c.drawRect (0, 0, x, 500);
	}

	board = Toolkit.getDefaultToolkit ().getImage ("Images/Board.png");
	MediaTracker tracker = new MediaTracker (new Frame ());
	tracker.addImage (board, 0);
	try
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e)
	{
	}

	if (tracker.isErrorAny ())
	{
	    return;
	}
	c.drawImage (board, 50, 50, null);
    }


    /*This creates and animates an animation using the for loops. The
    try block is used to place a delay.

    Name             Type        Purpose

    grey             Color       Stores the color grey.
    brown            Color       Stores the color brown.
    darkGrey         Color       Stores the color dark grey.
    title            Font        Stores the font.
    e                refernece   Points to the Exception class.
    */
    public void animation ()
    {
	Color grey = new Color (181, 167, 154);
	Color brown = new Color (74, 38, 7);
	Color darkGrey = new Color (92, 83, 74);
	Font title = new Font ("Felix Titling", 1, 50);
	c.setColor (Color.black);
	for (x = 0 ; x < 205 ; x++) //Boggle
	{
	    c.fillRect (72 + x, 85, 5, 5);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (x = 0 ; x < 150 ; x++)
	{
	    c.fillRect (277, 85 + x, 5, 5);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}


	c.setFont (title);
	c.drawString ("BOGGLE", 370, 120);

	for (x = 0 ; x < 160 ; x++) //For
	{
	    c.fillRect (72 + x, 155, 5, 5);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.drawString ("FOR", 425, 210);

	for (x = 0 ; x < 160 ; x++) //Two
	{
	    c.fillRect (72 + x, 225, 5, 5);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.drawString ("TWO", 415, 300);

	//Pusheen
	for (x = -300 ; x < 550 ; x++)
	{
	    c.setColor (maroon);
	    c.fillRect (105 + x, 377, 151, 90); //Erase
	    c.setColor (grey);
	    c.fillOval (128 + x, 386, 117, 75); //Main body
	    c.fillRect (143 + x, 441, 85, 20); //Base
	    c.fillArc (130 + x, 405, 40, 56, 170, 100); //Bottom left arc
	    c.fillArc (200 + x, 405, 43, 56, 0, -100); //Bottom right arc
	    c.fillArc (130 + x, 385, 80, 55, 45, 160); //Top left arc
	    c.fillRect (190 + x, 387, 45, 15); //Head
	    c.fillArc (218 + x, 390, 25, 43, 90, -130); //Top right arc
	    int leftEarX[] = {187 + x, 196 + x, 204 + x}; //Left ear
	    int leftEarY[] = {387, 377, 387};
	    c.fillPolygon (leftEarX, leftEarY, 3);
	    int rightEarX[] = {219 + x, 228 + x, 236 + x}; //Right ear
	    int rightEarY[] = {387, 377, 387};
	    c.fillPolygon (rightEarX, rightEarY, 3);
	    c.fillOval (106 + x, 400, 12, 12); //Tail
	    c.fillOval (109 + x, 405, 12, 12);
	    c.fillOval (112 + x, 408, 12, 12);
	    c.fillOval (114 + x, 410, 12, 12);
	    c.fillOval (118 + x, 412, 14, 12);
	    c.fillOval (142 + x, 455, 8, 12); //Feet
	    c.fillOval (165 + x, 455, 8, 12);
	    c.fillOval (197 + x, 455, 8, 12);
	    c.fillOval (220 + x, 455, 8, 12);
	    c.setColor (brown);
	    c.fillRect (240 + x, 400, 15, 3); //Right whiskers
	    c.fillRect (238 + x, 394, 15, 3);
	    c.fillRect (175 + x, 394, 13, 3); //Left whiskers
	    c.fillRect (173 + x, 400, 15, 3);
	    c.fillOval (195 + x, 397, 7, 7); //Left eye
	    c.fillOval (222 + x, 397, 7, 7);
	    c.fillRect (207 + x, 401, 10, 3); //Mouth
	    c.fillRect (211 + x, 398, 2, 6);
	    c.setColor (darkGrey);
	    c.fillArc (147 + x, 380, 13, 14, 20, -180); //Back spots
	    c.fillArc (163 + x, 378, 13, 15, 180, 180);
	    c.fillRect (204 + x, 386, 4, 5); //Head spots
	    c.fillRect (210 + x, 386, 4, 5);
	    c.fillRect (216 + x, 386, 4, 5);
	    c.fillArc (106 + x, 400, 12, 15, 40, 180); //Tail spots
	    int spot1X[] = {110 + x, 120 + x, 125 + x, 115 + x};
	    int spot1Y[] = {415, 409, 412, 420};
	    c.fillPolygon (spot1X, spot1Y, 4);
	    c.fillRect (125 + x, 413, 5, 12);

	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    // This is the class constructor.
    public Animation (Console con)
    {
	c = con;
    }


    //This is used to run the background and animation methods.
    public void run ()
    {
	background ();
	animation ();
    }
} // Animation class bracket


