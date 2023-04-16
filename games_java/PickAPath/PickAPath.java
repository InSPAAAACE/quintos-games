package games_java.PickAPath;

import java.util.Arrays;
import java.util.Scanner;

public class PickAPath
{
	public static void main(String[] args)
	{
		// create the user input scanner object
		Scanner sc = new Scanner(System.in);
		// your code goes here! below this line

		int path = 0; // initialize path to 0

		boolean gameOver = false;

		while (gameOver == false)
		{
			String msg = ""; // initialize message to empty String
			Integer[] options = new Integer[0];

			if (path == 0)
			{
				/* Part A0: Start your story! */
				msg = "It was a nice sunny day. You decided to do something along walking your dog\n\n\t"
						+ "1: just go on a walk with your dog\n\t" + "2: visit your grandparents with your dog\n\t"
						+ "3: go on a trip with your dog";
				options = new Integer[]
				{ 1, 2, 3 };
			}
			else if (path == 1)
			{
				/* Part A1: continue the story */
				msg = "When you pick up your dog's leash it gets so excited. You tell it that you're going to walk to... \n\t"
						+ "4: the dog park\n\t" + "5: the forest";
				options = new Integer[]
				{ 4, 5 };
			}
			else if (path == 5)
			{
				/* Part A1: continue the story */
				msg = "You need some equipment for that!\n\t"
						+ "2: visit your grandparents with your dog to get the equipment\n\t" + "8: To give up :(";
				options = new Integer[]
				{ 2, 8 };
			}
			else if (path == 4)
			{
				/* Part A1: continue the story */
				msg = "You live your happy life! No adventures then?\n\t" + "8: stay at the dog park\n\t"
						+ "5: go to the forest";
				options = new Integer[]
				{ 8, 5 };
			}
			else if (path == 2 || path == 3)
			{
				msg = "You visit your grandparents as you didn't see them for a long time. You ask them for the equipment for a trip\n\n\t"
						+ "6: you kindly take the equipment and leave your grandparents\n\t" + "7: you stay with them";
				options = new Integer[]
				{ 6, 7 };
			}
			else if (path == 7)
			{
				msg = "After some time you decided to go to sleep.\n\n\t" + "8: you go to sleep";
				options = new Integer[]
				{ 8 };
			}
			else if (path == 8)
			{
				msg = "game over";
				gameOver = true;
			}
			else if (path == 6 || path == 13)
			{
				msg = "You see the tree fallen on your main path. The dog smells danger on the left path. What do you do?\n\n\t"
						+ "9: you choose a path on the right\n\t" + "10: you choose a path on the left\n\t" + "11: you go back";
				options = new Integer[]
				{ 9, 10, 11 };
			}
			else if (path == 11)
			{
				msg = "game over";
				gameOver = true;
			}
			else if (path == 9)
			{
				msg = "You hear the screams of a child but don't know where it is coming from. What do you do?\n\n\t"
						+ "12: you try to look under a bush\n\t" + "13: you go back to the main path";
				options = new Integer[]
				{ 12, 13 };
			}
			else if (path == 12)
			{
				msg = "You see a backpack under a bush. It probably belongs to a child \"You think.\"\n\n\t"
						+ "500: you try to look under a bush again\n\t" + "13: you go back to the main path";
				options = new Integer[]
				{ 500, 13 };
			}
			else if (path == 500)
			{
				msg = "You see a backpack under a bush. Nothing has changed!\"\n\n\t"
						+ "501: you try to look under a bush again\n\t" + "13: you go back to the main path";
				options = new Integer[]
				{ 501, 13 };
			}
			else if (path == 501)
			{
				msg = "You see a backpack under a bush. Stop it!\"\n\n\t" + "502: you try to look under a bush again\n\t"
						+ "13: you go back to the main path";
				options = new Integer[]
				{ 502, 13 };
			}
			else if (path == 502)
			{
				msg = "You see a backpack under a bush. Stop it or I will make you stop!\"\n\n\t"
						+ "503: you try to look under a bush again\n\t" + "13: you go back to the main path";
				options = new Integer[]
				{ 503, 13 };
			}
			else if (path == 503)
			{
				msg = "I warned you\"\n\n\t" + "GAME OVER HAHAHA!";
				gameOver = true;
			}
			else if (path == 10)
			{
				msg = "You see a child running from a wolf. What do you do?\n\n\t"
						+ "14: you try to stop the wolf by yourself to save your dog and the child\n\t"
						+ "15: you use your dog to scare the wolf";
				options = new Integer[]
				{ 14, 15 };
			}
			else if (path == 14)
			{
				msg = "You died to a wolf but saved your dog and a child";
				gameOver = true;
			}
			else if (path == 15)
			{
				msg = "You saved all lives: the wolf was scared by you and your dog's determination";
				gameOver = true;
			}

			// prompt the player to pick a path
			System.out.println(msg);

			if (gameOver == false)
			{
				int userInput = sc.nextInt();

				if (Arrays.asList(options).contains(userInput))
				{
					path = userInput;
				}
				else
				{
					System.out.println("Invalid choice! Try again.\n");
				}
			}

			/*
			 * Part B1: check if the player made a valid choice, reject invalid
			 * choices
			 */

		}

		sc.close();
		System.exit(0); // exit the program
	}
}
