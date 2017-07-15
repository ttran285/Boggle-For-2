/* Name: Tiffany Tran
   Name of program: BoggleFor2.java
   Teacher: Ms. Dyke
   Date: December 17th, 2015
   Assignment: This is a two player boggle game. When the user first runs the program, they will be shown a short animation from the splash screen and then 
   taken to the main menu. At the main menu, the user has the choice of either looking at the instructions, playing the game, looking at the high scores, 
   or exiting the program. If they choose to look at the instructions, they will be taken to the instructions screen and then they can enter any character
   to return back to the main menu after they finish reading it. If they choose to play the game, they will be taken to a level select screen. In the level
   select screen, the user can choose to play a timed game, untimed game, or return to the main menu where they can decide where to go again. If they choose 
   one of the levels, they will be given a chance to enter their names. After entering their names, they will be taken to the game screen where they can play
   the game. A 4x4 grid will randomly generate letters. Using the letters given, the user will have to enter words following all of the rules stated in the
   instructions. The user can choose to leave the game at any time by entering 1 and they will be taken to the main menu. Or, if they stay for the whole game,
   when the game finishes, the users will be taken to the winner screen where their points will be shown and the winner will be shown. It will also tell the
   user if they made it to the top 10 scores. Then, the user will be taken to the main menu. If the user chooses to look at the high scores, they will be 
   taken to the high scores screen where the top 10 high scores will be shown. The user can return to the main menu by pressing any character. Lastly, if
   they choose to exit the game, they will be taken to a goodbye screen where the console screen will close. 
   
   Name              Type             Purpose

   c                 reference        Points to the console class.
   menuChoice        String           Stores the user's menu choice.
   levelChoice       String           Stores the user's level choice.
   pOneName          String           Stores the name of player one.
   pTwoName          String           Stores the name of player two.
   word              String           Stores the word entered by the player during the game.
   player            String           Stores the name of the player that is currently playing.
   x                 int              Used in several loops.
   y                 int              Used in several loops.
   pOneScore         int              Stores the score of player one.
   pTwoScore         int              Stores the score of player two.
   numberOfLine      int              Stores the number of lines and is used in the winner screen. 
   ROW               final int        Stores the number of rows the boggle board contains.
   COL               final int        Stores the number of columns the boggle board contains.
   FILE_NAME         final String     Stores the name of the high score file.
   letterArray       char [][]        Stores the randomly generated letters.
   goodWords         String []        Stores all of the words entered by the user that are good.
   playerNames       String []        Stores the names of the players in the high score file.
   levels            String []        Stores the levels of the players in the high score file.
   split             String []        Used to split the words.
   scores            int []           Stores the scores of the players in the high score file.
   font              Font             Stores the main font used in this program.
   smallFont         Font             Stores a smaller version of the font used in this program.
   numOfWords        int              Stores the number of words there are stored in the goodWords array.*
   firstLetter       int              Used to see if the first letter of the word is present.*
   silver            Color            Stores the color silver.
   maroon            Color            Stores the color maroon.

  STUFF I STILL GOTTA DO:
  - OVERLOAD THE BLACK BOXES

*/

import java.applet.*;
import java.awt.*;
import hsa.*;
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;


// This initializes the class BoggleFor2.
public class BoggleFor2
{
    Console c;
    String menuChoice = "a", levelChoice = "a", pOneName = "a", pTwoName = "a", word = "a", player = "a";
    int x = 0, y = 0, pOneScore = 0, pTwoScore = 0, numberOfLine = 0;
    static final int ROW = 4;
    static final int COL = 4;
    static final String FILE_NAME = "High Scores.bogg";
    char[] [] letterArray = new char [ROW] [COL];
    String[] goodWords = new String [100];
    String[] playerNames = new String [15];
    String[] levels = new String [15];
    int[] scores = new int [15];
    String[] split = new String [4];
    Font font = new Font ("Courier New", 1, 17);
    Font smallFont = new Font ("Courier New", 1, 14);
    Color silver = new Color (171, 166, 166);
    Color maroon = new Color (128, 0, 0);
    int numOfWords = 0, firstLetter = 0;


    // This outputs the title.
    private void title ()
    {
	c.setTextBackgroundColor (maroon);
	Font title = new Font ("Courier New", 1, 25);
	c.clear ();
	c.setColor (Color.white);
	c.setFont (title);
	c.drawString ("Boggle For 2", 230, 25);
	c.setTextColor (Color.white);
    }


    // This pauses the program and allows the user to read the whole screen
    // before pressing a key to continue to the next screen.
    private void pauseProgram ()
    {
	c.setFont (smallFont);
	c.drawString ("Press any key to continue...", 10, 490);
	c.getChar ();
    }


    // This outputs a brief introduction that will close after a few seconds and
    // also calls title.
    public void splashScreen ()
    {
	Animation a = new Animation (c);
	a.run ();
    }


    // This will allow users to choose where they want to go/what they want to do.
    // The while loop makes sure the user will only enter either 1, 2, 3, or 4. If
    // they enter anything other than a number from 1-4, an error message will appear.
    public void mainMenu ()
    {
	title ();

	c.setFont (font);
	c.drawString ("1. Instructions", 20, 70);
	c.drawString ("2. Play Game", 20, 100);
	c.drawString ("3. High Scores", 20, 130);
	c.drawString ("4. Exit", 20, 160);
	c.drawString ("Please enter a number: ", 20, 215);

	while (!menuChoice.equals ("1") && !menuChoice.equals ("2") && !menuChoice.equals ("3") && !menuChoice.equals ("4"))
	{
	    c.setCursor (11, 32);
	    c.println ();
	    c.setCursor (11, 32);
	    c.setTextColor (Color.white);
	    menuChoice = c.readLine ();
	    if (!menuChoice.equals ("1") && !menuChoice.equals ("2") && !menuChoice.equals ("3") && !menuChoice.equals ("4"))
	    {
		JOptionPane.showMessageDialog (null, "Please enter a number from 1-4!", "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
	}
	levelChoice = "a";
    }


    // This outputs the instructions and also calls title.
    public void instructions ()
    {
	title ();
	c.setCursor (3, 1);
	c.println ("Instructions:");
	c.println ("This is a two player game. From the main menu, you can choose to read the instructions, start the game, or exit. If you choose to start the game, you can choose to play a timed or untimed game. In a timed game, each of you will have three minutes to score as many points as possible. In an untimed game, you both will have unlimited amount of time and you enter 2 when you think you've finished your turn. To quit the game midway through, enter 1.");
	c.println ();
	c.println ("The objective of this game is to enter as many words as possible to earn the most points and win. A 4x4 grid will randomly generate letters. Using the letters given, you must find as many words as possible by typing them in and pressing enter.");
	c.println ();
	c.println ("The letters of the word must be adjacent horizontally, vertically, or diagonally, the word must contain at least 3 letters, no letter may be used more than once in a word, words entered more than once do not count, and the word must exist in the English dictionary.");
	c.println ();
	c.println ("Scoring:");
	c.println ("- 3 & 4 letter words: 1 point          - 7 letter words: 4 points");
	c.println ("- 5 letter words: 2 points             - 8 or more letter words: 11 points");
	c.println ("- 6 letter words: 3 points");
	pauseProgram ();
	menuChoice = "a";
    }


    /* This method will allow users to choose the level they want to play and
       allows the user to enter their names. The while loop makes sure the user
       will only enter either 1, 2, 3, or 4. If they enter anything other than
       a number from 1-4, an error message will appear. The if statements within
       the while loop makes sure the name they enter is between 1-8 characters,
       the name they enter does not contain spaces, and the two names are not
       the same. If they break any of these rules, an error message will appear.

       Name              Type        Purpose

       a                 int         Used in the while loop as a condition.
       b                 int         Used in the while loop as a condition.
       letter            char        Used to check for spaces within the names.
    */
    public void levelMenu ()
    {
	int a = 1, b = 1;
	title ();
	char letter;
	c.setFont (font);
	c.drawString ("1. Untimed game", 20, 70);
	c.drawString ("2. Timed game", 20, 100);
	c.drawString ("3. Return to the main menu", 20, 130);
	c.drawString ("Please enter a number: ", 20, 195);

	while (!levelChoice.equals ("1") && !levelChoice.equals ("2") && !levelChoice.equals ("3"))
	{
	    c.setCursor (10, 32);
	    c.println ();
	    c.setCursor (10, 32);
	    levelChoice = c.readLine ();
	    if (levelChoice.equals ("1") || levelChoice.equals ("2"))
	    {
		c.drawString ("Name of player one: ", 20, 255);
		while (a > 0)
		{
		    c.setCursor (13, 28);
		    c.println ();
		    c.setCursor (13, 28);
		    pOneName = c.readLine ();
		    a = -1;
		    for (x = 0 ; x < pOneName.length () ; x++)
		    {
			letter = pOneName.charAt (x);
			if (letter == ' ')
			{
			    JOptionPane.showMessageDialog (null, "The name you enter must not contain spaces!", "ERROR", JOptionPane.ERROR_MESSAGE);
			    a = 1;
			}
		    }
		    if (!(pOneName.length () <= 8 && pOneName.length () > 0))
		    {
			JOptionPane.showMessageDialog (null, "The name you enter must be between 1 and 8 characters inclusive!", "ERROR", JOptionPane.ERROR_MESSAGE);
			a = 1;
		    }
		}
		c.drawString ("Name of player two: ", 20, 315);
		while (b > 0)
		{
		    c.setCursor (16, 28);
		    c.println ();
		    c.setCursor (16, 28);
		    pTwoName = c.readLine ();
		    b = -1;
		    for (x = 0 ; x < pTwoName.length () ; x++)
		    {
			letter = pTwoName.charAt (x);
			if (letter == ' ')
			{
			    JOptionPane.showMessageDialog (null, "The name you enter must not contain spaces!", "ERROR", JOptionPane.ERROR_MESSAGE);
			    b = 1;
			}
		    }
		    if (!(pTwoName.length () <= 8 && pTwoName.length () > 0))
		    {
			JOptionPane.showMessageDialog (null, "The name you enter must be between 1 and 8 characters inclusive!", "ERROR", JOptionPane.ERROR_MESSAGE);
			b = 1;
		    }
		    else
		    {
			if (pTwoName.equals (pOneName))
			{
			    JOptionPane.showMessageDialog (null, "The name you enter must be different from player one's name!", "ERROR", JOptionPane.ERROR_MESSAGE);
			    b = 1;
			}
		    }
		}
		gameScreen ();
		return;
	    }
	    else if (levelChoice.equals ("3"))
	    {
		menuChoice = "a";
		return;
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "Please enter a number from 1-3!.", "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }


    /* This method generates 16 random letters from a-z that will be put onto
       the game board. The while loop makes sure there is at least 3 vowels out
       of the 16 letters and if letters have been repeated and it will
       regenerate the letters if there is less. The for loops are used to
       arrange the letters in grid formation which then prints the letters out
       onto the screen.

       Name              Type             Purpose

       r                 reference        Points to the Random class.
       alphabet          String           Used to store all the letters of the alphabet.
       letterTemp        char[]           A temporary array that stores letters and is used to check for vowels and repeated letters.
       letter            char             Used to check for vowels and repeated letters.
       uniqueLetter      boolean          Used to keep track of if a vowel has been generated yet.
       m                 int              Used in the for loop.
       h                 int              Used in the for loop.
       hasVol            int              A counter used to keep track of the number of vowels generated.
    */
    private void randomLetter ()
    {
	Random r = new Random ();
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char[] letterTemp = new char [ROW * COL];
	char letter;
	boolean uniqueLetter = true;
	int m = 0, hasVow = 0;
	c.setFont (new Font ("Times New Roman", 1, 30));
	c.setColor (Color.black);

	while (hasVow < 2) //Regenerate all letters if there is less than one vowel
	{
	    for (int h = 0 ; h < ROW * COL ; h++) //Generate and check for unique letter
	    {
		letter = (alphabet.charAt (r.nextInt (alphabet.length ())));
		uniqueLetter = true;
		for (m = 0 ; m <= h ; m++)
		{
		    if (letter == letterTemp [m])
		    {
			uniqueLetter = false;
			h--;
			break;
		    }
		}
		if (uniqueLetter == true)
		{
		    letterTemp [h] = letter;
		    if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U')
		    {
			hasVow++;
		    }
		}
	    }
	}
	m = 0;
	for (int row = 0 ; row < ROW ; row++)
	{
	    for (int col = 0 ; col < COL ; col++)
	    {
		letterArray [row] [col] = letterTemp [m];
		m++;
		c.drawString (letterArray [row] [col] + "", (col + 1) * 62, ((row * 65) + 160));
	    }
	}
    }



    /* This method executes the game and displays it. The first try block is used to import the board image. The big while loop is used to allow the user
    to keep on entering words instead of starting the game again everytime they want to enter a word. The if statements work with the black boxes to determine
    if they word they enter is okay. They are also used to figure out how many points the user should get for each word. The try blocks stop the program from
    crashing.

       Name              Type             Purpose

       blackBoard        Image            Points to the Image class.
       click             int              Stores the users response from the JOptionPane.
       lineNum           int              Used to keep track of the number of lines that the words are being printed out from.
       score             int              Stores the score of the current user playing.
       stayInGame        boolean          Used to stay in the game.
       playerInGamer     boolean          Used to determine which player's turn it is.
       cd                reference        Points to the Countdown class.
       cd2               reference        Points to the Countdown class.
    */
    private void gameScreen ()
    {
	title ();
	c.setFont (font);
	Image blankBoard;
	int click, lineNum = 0, score = 0, checkWordValue;
	boolean stayInGame = true, playerInGame = true;
	Countdown cd = new Countdown (c);
	Countdown cd2 = new Countdown (c);

	player = pOneName;

	blankBoard = Toolkit.getDefaultToolkit ().getImage ("Images/BlankBoard.png");
	MediaTracker tracker = new MediaTracker (new Frame ());
	tracker.addImage (blankBoard, 0);
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
	c.drawImage (blankBoard, 35, 110, null);
	randomLetter ();

	c.setFont (font);

	c.setColor (Color.black);
	c.fillRect (5, 55, 627, 25);
	c.fillRect (335, 110, 270, 25);

	c.setColor (silver); //Border
	c.drawRect (5, 55, 627, 25);
	c.drawRect (335, 110, 270, 25);
	c.drawRoundRect (335, 155, 270, 280, 30, 30); //Word box
	c.drawLine (35, 435, 300, 435); //User input box
	c.drawLine (35, 465, 300, 465);

	c.setColor (Color.white);
	c.drawString ("It's " + player + "'s turn!", 35, 73);
	c.drawString ("Score:", 300, 73);
	c.drawString ("0", 365, 73);
	c.drawString ("Words Found", 415, 128);
	c.drawString ("Enter a word:", 35, 415);
	c.setFont (smallFont);
	c.drawString ("Enter 1 to exit.", 505, 490);

	c.setFont (font);
	if (levelChoice.equals ("1"))
	{
	    c.drawString ("Enter 2 when done", 455, 73);
	}

	else
	{
	    c.drawString ("Time left: ", 455, 73);
	    cd.start ();
	}

	cd.time = 180; //SHOULD BE 180

	while (stayInGame == true)
	{
	    while (playerInGame == true && cd.time > 0)
	    {
		c.setCursor (23, 6);
		c.println ();
		c.setCursor (23, 6);

		word = c.readLine ();

		checkWordValue = checkForWord (word);
		if (checkWordValue == 1) //If they want to quit mid game
		{
		    click = JOptionPane.showConfirmDialog (null, "You are in the middle of a game. Are you sure you want to quit?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		    if (click == 0) //If yes, go back to method
		    {
			cd.stop ();
			menuChoice = "a";
			return;
		    }
		}
		else if (checkWordValue == 2) //Only for untimed mode - end of turn (gotta reset stuff)
		{
		    click = JOptionPane.showConfirmDialog (null, "Are you sure you've finished your turn?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		    if (click == 0) //If yes, go back to method
		    {
			if (player.equals (pOneName))
			{
			    playerInGame = false;
			}
			else //Need to fix this
			{
			    playerInGame = false;
			}
		    }
		}

		else //Word is okay
		{
		    if (checkWordValue == 4)
		    {
			if (word.length () == 3 || word.length () == 4)
			{
			    score++;
			}
			else if (word.length () == 5)
			{
			    score += 2;
			}
			else if (word.length () == 6 || word.length () == 7)
			{
			    score += word.length () - 3;
			}
			else
			{
			    score += 11;
			}
			c.setFont (font);
			c.setColor (Color.black);
			c.fillRect (360, 60, 25, 18);
			c.setColor (Color.white);
			c.drawString (score + "", 365, 73);
			
			//Printing out the words on the screen
			c.setFont (smallFont);

			if (lineNum < 13) //&& counter == false)
			{
			    x = 345;
			}
			if (lineNum > 12 && lineNum < 26) // && counter == false)
			{
			    x = 430;
			}
			if (lineNum > 25) // && counter == false)
			{
			    x = 510;
			}

			c.drawString (word, x, 20 * (lineNum % 13) + 178);
			lineNum++;
		    }
		}
	    } //First while loop bracket
	    if (player.equals (pOneName))
	    {
		c.setFont (font);
		pOneScore = score;
		player = pTwoName;
		score = 0;
		c.setColor (Color.black);
		c.fillRect (360, 60, 25, 18); //Erase timer
		c.fillRect (30, 60, 220, 18); //Erase who's turn it is
		c.setColor (maroon);
		c.fillRect (340, 165, 250, 265);
		c.fillRect (60, 85, 540, 22); //Erase the time's up message
		c.fillRect (30, 478, 270, 20); //Erase the word message
		c.setColor (Color.white);
		c.drawString ("0", 365, 73);
		c.drawString ("It's " + player + "'s turn!", 35, 73);
		numOfWords = 0;

		lineNum = 0;

		if (levelChoice.equals ("2"))
		{
		    cd2.start (); //TIMER DOES NOT START AGAIN
		}
		playerInGame = true;
		cd2.time = 180;
	    }
	    else
	    {
		cd.stop ();
		pTwoScore = score;
		stayInGame = false;
	    }
	} //Second while loop bracket
	winnerScreen ();
    } //gameScreen bracket



    /* This is a black box return method that is used to check if a word entered
    by a user meets all of the requirements stated in the instructions. Each if
    statement is used to check for a different thing. They check to see if the
    user has entered 1 (return to menu) or 2 (finished turn). They also check to
    see if the word they enter is more than 2 letters and less than 16 letters
    long, and if the word they enter is an actual English word. The try block,
    while loop, and if statement there is used to check through the word files
    to see if it is an actual English word. It will stop checking when it found
    the word or if it reaches the end of the file. The if statements also checks
    with the other black box to make sure the word exist on the game board and
    if it has already been entered. The try blocks stop the program from
    crashing.

    Name              Type             Purpose

    fileName          String           Stores the file name of the file used to check to see if the word is an actual English word.
    line              String           Used to store all the letters of the alphabet.
    input             reference        Points to the BufferedReader class.
    booleanCounter    boolean          Used in the while loop.
    processing        int              Stores the value being returned based on the word.
    z                 int              Used in the for loop.
    e                 Exception        Points to the Exception class.

    */
    private int checkForWord (String word)  // 1 = Go back to main menu, 2 = Finished turn (UTM), 3 = Invaild word, 4 = Word is okay
    {
	String fileName, line = ""; 
	BufferedReader input;
	boolean booleanCounter = false;
	int processing = 0;
	c.setFont (smallFont);
	c.setColor (maroon);
	c.fillRect (30, 478, 270, 20);
	c.setColor (Color.white);

	if (word.equals ("1"))
	{
	    processing = 1; //Go back to main menu
	}

	else if (word.equals ("2") && levelChoice.equals ("1"))
	{
	    processing = 2; //Only for timed mode --> finished turn
	}
	else
	{
	    if (word.length () <= 2 || word.length () > 16)
	    {
		processing = 3; //Invalid word
		c.drawString ("Word too short", 35, 490);
	    }
	    else
	    {
		fileName = "Dictionary/" + word.substring (0, 1).toUpperCase ();
		try
		{
		    input = new BufferedReader (new FileReader (fileName));
		    while (true)
		    {
			line = input.readLine ();

			if (line.equals ("END OF FILE"))
			{
			    booleanCounter = false; //Invalid word
			    break;
			}
			else
			{
			    if (line.equalsIgnoreCase (word))
			    {
				booleanCounter = true;
				break;
			    }
			}
		    }
		}

		catch (IOException e)
		{
		}
		if (booleanCounter == false)
		{
		    processing = 3;
		    c.drawString ("No such word", 35, 490);
		}
		else
		{
		    if (checkLetterLocation (word) == false)
		    {
			processing = 3;
			c.drawString ("Word does not exist on the grid", 35, 490);
		    }
		    else
		    {
			if (numOfWords == 0)
			{
			    goodWords [0] = word;
			    booleanCounter = true;
			}
			else
			{
			    for (int z = 0 ; z <= numOfWords ; z++)
			    {
				if (word.equalsIgnoreCase (goodWords [z]))
				{
				    booleanCounter = false;
				    processing = 3;
				    c.drawString ("Word already entered", 35, 490);
				    break;
				}
			    }
			}

			if (booleanCounter == true)
			{
			    processing = 4;
			    goodWords [numOfWords] = word;
			    numOfWords++;
			    c.drawString ("Word is good", 35, 490);
			}
		    }

		}

	    }
	}
	return processing;
    }


    /* This black box method checks to see if the letters in the word are located beside each other. The for loops are used to find the location of the first letter and set up the temp array.
    The while loop will keep looping the if statements that check if the words are beside each other until the full word is found or the letters of the word are not beside each other.

       Name                Type             Purpose

       tempArray           char[][]         Used to turn tiles where letters are found into '!' so the letters will not be used twice in a word.
       currentX            int              Stores the current x location of the letter.
       currentY            int              Stores the current y location of the letter.
       location            int              Used to store each letter and make sure the while loop does not loop more than the number of letters in the word.
       matchLetter         boolean          Used to stay in or break out of the while loop.
       lastLetterMatches   boolean          Used to stay in or break out of the while loop.
       processing1         boolean          Stores the value that is returned to the other black box based on the word.
       u                   int              Used in the for loop.
       k                   int              Used in the for loop.
    */
    private boolean checkLetterLocation (String word)
    {
	char[] [] tempArray = new char [ROW + 1] [COL + 1];
	int currentX = 0, currentY = 0, location; //, firstLetterCounter = 0;
	boolean matchLetter = false, lastLetterMatches = true, processing1 = false;
	word = word.toUpperCase ();

	//Checks for match first letters of the word and stores their location in an array --> checks for the location of the first letter of the word
	for (x = 0 ; x < ROW ; x++)
	{
	    for (y = 0 ; y < COL ; y++)
	    {

		if (word.charAt (0) == letterArray [x] [y]) //Shouldn't the charAt of the word increase? No. u only look at the first letter (0)!
		{
		    currentX = x;
		    currentY = y;
		    firstLetter = 1;
		    break;
		}
	    }
	}

	// 1st letter does not match
	if (firstLetter < 1)
	{
	    processing1 = false;
	}

	// Setup tmepArray
	for (int u = 0 ; u < 4 ; u++)
	{
	    for (int k = 0 ; k < 4 ; k++)

		{
		    tempArray [u] [k] = letterArray [u] [k];
		}
	}

	location = 1;
	tempArray [currentX] [currentY] = '!';

	// LOOP - CHECK NEXT LETTER OF THE WORD (THE SECOND LETTER) IF IT IS LESS THAN THE LENGTH OF THE WORD AND TO SEE IF THE LAST LETTER OF THE WORD WAS MATCHED

	while (location < word.length () && lastLetterMatches) //REPRESENTS IF THE LAST LETTER MATCHED //Goes if it's true
	{
	    //Checks south
	    matchLetter = false;
	    if (currentX < 3 && tempArray [currentX + 1] [currentY] != '!' && letterArray [currentX + 1] [currentY] == (word.charAt (location)))
	    {
		currentX = currentX + 1;
		matchLetter = true;
	    }

	    //Checks north
	    else if (currentX > 0 && tempArray [currentX - 1] [currentY] != '!' && letterArray [currentX - 1] [currentY] == (word.charAt (location)))
	    {
		currentX = currentX - 1;
		matchLetter = true;
	    }

	    //Checks east
	    else if (currentY < 3 && tempArray [currentX] [currentY + 1] != '!' && letterArray [currentX] [currentY + 1] == (word.charAt (location)))
	    {
		currentY = currentY + 1;
		matchLetter = true;
	    }

	    //Checks west
	    else if (currentY > 0 && tempArray [currentX] [currentY - 1] != '!' && letterArray [currentX] [currentY - 1] == (word.charAt (location)))
	    {
		currentY = currentY - 1;
		matchLetter = true;
	    }

	    //Checks north east
	    else if (currentX > 0 && currentY < 3 && tempArray [currentX - 1] [currentY + 1] != '!' && letterArray [currentX - 1] [currentY + 1] == (word.charAt (location)))
	    {
		currentX = currentX - 1;
		currentY = currentY + 1;
		matchLetter = true;
	    }

	    //Checks south east
	    else if (currentX < 3 && currentY < 3 && tempArray [currentX + 1] [currentY + 1] != '!' && letterArray [currentX + 1] [currentY + 1] == (word.charAt (location)))
	    {
		currentX = currentX + 1;
		currentY = currentY + 1;
		matchLetter = true;
	    }

	    //Checks north west
	    else if (currentX > 0 && currentY > 0 && tempArray [currentX - 1] [currentY - 1] != '!' && letterArray [currentX - 1] [currentY - 1] == (word.charAt (location)))
	    {
		currentX = currentX - 1;
		currentY = currentY - 1;
		matchLetter = true;
	    }

	    //Checks south west
	    else
	    {
		if (currentX < 3 && currentY > 0 && tempArray [currentX + 1] [currentY - 1] != '!' && letterArray [currentX + 1] [currentY - 1] == (word.charAt (location)))
		{
		    currentX = currentX + 1;
		    currentY = currentY - 1;
		    matchLetter = true;
		}
	    }

	    if (matchLetter == true) //Letter do match
	    {
		if (location == word.length () - 1)  //whole word match
		{
		    lastLetterMatches = false;
		    processing1 = true;
		}
		else
		{
		    tempArray [currentX] [currentY] = '!'; //letters match so far but not the whole word
		    location++;
		    lastLetterMatches = true;
		}
	    }
	    else // (matchLetter == false)  //No match
	    {
		lastLetterMatches = false; //If it's false, it will not re-enter the loop
		processing1 = false;
	    }
	}
	return processing1;
    }


    /* This method outputs the top 10 high scores (if avaliable) to the user. The try block is used to read into the file and the for loop is used to print 
    out all of the scores. The try blocks stop the program from crashing.

       Name              Type             Purpose

       line              String           Used to read in teh data from the high score file.
       input             reference        Points to the BufferedReader class.
       e                 IOException      Points to the IOException class.
    */
    public void highScores ()
    {
	title ();
	String line = "";
	BufferedReader input;
	String[] playerScores = new String [11];

	c.setFont (font);
	c.drawString ("TOP 10 PLAYERS", 252, 90);
	for (int x = 0 ; x < 25 ; x++) //Black boxes
	{
	    c.setColor (Color.black);
	    c.drawRect (5, 105, 627, x);
	}

	c.setColor (silver); //Border
	c.drawRect (5, 105, 627, 25);
	c.setColor (Color.white);
	c.drawString ("Rank", 20, 123);
	c.drawString ("Name", 170, 123);
	c.drawString ("Score", 320, 123);
	c.drawString ("Level", 480, 123);
	for (int rank = 1 ; rank <= 10 ; rank++)
	{
	    c.drawString (rank + ".", 20, 170 + 20 * rank);
	}

	try
	{
	    input = new BufferedReader (new FileReader (FILE_NAME));
	    line = input.readLine ();
	    if (!(line.equals ("This file is compatible with .bogg files.")) || line == null)
	    {
		createHSFile ();
	    }

	    for (x = 0 ; x < 10 ; x++)
	    {
		line = input.readLine ();
		if (line == null)
		{
		    break;
		}

		split = line.split (" ");
		playerNames [x] = split [0];
		playerScores [x] = split [1];
		levels [x] = split [2];

		c.drawString (playerNames [x], 170, 190 + 20 * x);
		c.drawString (playerScores [x], 320, 190 + 20 * x);
		c.drawString (levels [x], 480, 190 + 20 * x);
	    }
	}
	catch (IOException e)
	{
	    createHSFile ();
	}
	pauseProgram ();
	menuChoice = "a";
    }


    /*This method creates a new high score file if the file does not exist or if it get corrupted. The try blocks stop the program from
    crashing.

    Name          Type        Purpose
    output        reference   Points to the PrintWriter class.
    e             Exception   Points to the Exception class.
    */
    private void createHSFile ()
    {
	PrintWriter output;
	try
	{
	    output = new PrintWriter (new FileWriter (FILE_NAME));
	    output.println ("This file is compatible with .bogg files.");
	    output.close ();
	}
	catch (IOException e)
	{
	}
    }


    /* This method tells the user who won and it also calculates if they made it to the top 10 scores. The if statement determine who got the higher
    score. The for loops and if statements order the scores from highest to lowest and then writes it back into the high score
    file. The try blocks stop the program from crashing.

       Name              Type                 Purpose

       tempScore         int                  Used to store the temporary score.
       tempName          String               Used to store the temporary name.
       inputLine         String               Used to read in the data from the high score file.
       tempLevel         String               Used to store the temporary level.
       level             String               Used to store the level.
       stringScores      String               Used to score the score in string form.
       sorted            boolean              Used to keep track of if the scores have been sorted yet.
       output            reference            Points to the PrintWriter class.
       input             reference            Points to the BufferedReader class.
       trophy            Image                Stores the imported image.
       tracker           reference            Points to the MediaTracker class.
       e                 IOException          Points to the IOException class.
       e                 InterruptedException Points to the InterruptedException class.
    */
    private void winnerScreen ()  //Called by gameScreen
    {
	title ();

	int tempScore = 0; 
	String tempName, inputLine, tempLevel, level;
	boolean sorted = false;
	PrintWriter output;
	BufferedReader input;
	String stringScores;
	Image trophy;
	c.setFont (font);
	trophy = Toolkit.getDefaultToolkit ().getImage ("Images/Trophy.png");
	MediaTracker tracker = new MediaTracker (new Frame ());
	tracker.addImage (trophy, 0);

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

	c.drawString (pOneName + " got a score of " + pOneScore + "!", 20, 80);
	c.drawString (pTwoName + " got a score of " + pTwoScore + "!", 20, 110);
	if (pOneScore > pTwoScore)
	{
	    c.drawString (pOneName + " is the winner!", 20, 140);
	}

	else if (pOneScore < pTwoScore)
	{
	    c.drawString (pTwoName + " is the winner!", 20, 140);
	}

	else
	{
	    c.drawString ("It's a tie!", 20, 140);
	}

	c.drawImage (trophy, 240, 250, null);


	try
	{
	    input = new BufferedReader (new FileReader (FILE_NAME));

	    inputLine = input.readLine ();
	    if (!(inputLine.equals ("This file is compatible with .bogg files.")) || inputLine == null)
	    {
		createHSFile ();
	    }

	    for (x = 0 ; x < 11 ; x++)
	    {
		numberOfLine = x;
		inputLine = input.readLine ();
		if (inputLine == null)
		{
		    break;
		}

		split = inputLine.split (" ");
		playerNames [x] = split [0];
		stringScores = split [1];
		scores [x] = Integer.parseInt (split [1]);
		levels [x] = split [2];

	    }
	    playerNames [numberOfLine + 1] = pOneName;
	    playerNames [numberOfLine + 2] = pTwoName;
	    scores [numberOfLine + 1] = pOneScore;
	    scores [numberOfLine + 2] = pTwoScore;
	    
	    if (levelChoice.equals ("1"))
	    {
		level = "Untimed";
	    }
	    else
	    {
		level = "Timed";
	    }

	    levels [numberOfLine + 1] = level;
	    levels [numberOfLine + 2] = level;

	    sorted = false;
	    while (sorted == false)
	    {
		sorted = true;
		for (x = 0 ; x < numberOfLine + 2 ; x++)
		{
		    if (scores [x] < scores [x + 1])
		    {
			tempScore = scores [x + 1];
			tempName = playerNames [x + 1];
			tempLevel = levels [x + 1];

			playerNames [x + 1] = playerNames [x];
			scores [x + 1] = scores [x];
			levels [x + 1] = levels [x];

			playerNames [x] = tempName;
			scores [x] = tempScore;
			levels [x] = tempLevel;
			sorted = false;
		    }

		}
	    }

	    try
	    {
		output = new PrintWriter (new FileWriter (FILE_NAME));
		output.println ("This file is compatible with .bogg files.");
		int max = 10;

		if (numberOfLine < 9)
		{
		    max = numberOfLine + 2;
		}

		for (x = 0 ; x < max ; x++)
		{
		    output.println (playerNames [x] + " " + scores [x] + " " + levels [x]);
		}
		for (x = 0 ; x < max ; x++)
		{
		    if (pOneName.equals (playerNames [x]) && pOneScore == scores [x]) 
		    {
			c.drawString (pOneName + " is on the top 10 list!", 20, 170);
		    }
		    if (pTwoName.equals (playerNames [x]) && pTwoScore == scores [x])
		    {

			c.drawString (pTwoName + " is on the top 10 list!", 20, 200);
		    }
		}
		output.close ();
	    }
	    catch (IOException e)
	    {
	    }
	}
	catch (IOException e)
	{
	    createHSFile ();
	}
	pauseProgram ();
	menuChoice = "a";
    }


    // This outputs the goodbye sentence and closes the console screen.
    public void goodbye ()
    {
	title ();
	c.setFont (font);
	c.drawString ("Thank you for playing this game!", 155, 200);
	c.drawString ("~ Created by Tiffany Tran ~", 180, 230);
	pauseProgram ();
	c.close ();
    }


    // This is the class constructor.
    public BoggleFor2 ()
    {
	c = new Console ("Boggle For 2");
    }


    /* This is the main method. It controls and initiates the methods.

    Name        Type        Purpose

    b           reference   Points to the ReplaceChar class.
    */
    public static void main (String[] args)
    {
	BoggleFor2 b = new BoggleFor2 ();
	b.splashScreen ();
	while (true)
	{
	    b.mainMenu ();
	    if (b.menuChoice.equals ("1"))
		b.instructions ();
	    else if (b.menuChoice.equals ("2"))
		b.levelMenu ();
	    else if (b.menuChoice.equals ("3"))
		b.highScores ();
	    else
		break;
	}
	b.goodbye ();

    } // Main method bracket
} // BoggleFor2 class bracket


