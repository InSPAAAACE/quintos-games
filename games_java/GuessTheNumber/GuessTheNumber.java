package games_java.GuessTheNumber;

import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		// create the user input scanner object
		Scanner sc = new Scanner(System.in);

		// your code goes here!
		int num = (int) (Math.random() * 100 + 1);

		int guess = 0;

		int turn = 0;

		while (true) {
			while (guess != num && turn < 7) {
				System.out.println("Guess the Number 1-100");
				guess = sc.nextInt();

				if (guess >= 1 && guess <= 100) {

					if (guess > num) {
						System.out.println("guess is too high!");
						turn++;
					} else if (guess < num) {
						System.out.println("guess is too low!");
						turn++;
					} else {
						System.out.println("Correct!");
					}
				} else {
					System.out.println("It is out of range!");
				}
			}
			System.out.println("You are out of attempts!");

			System.out.println("Want to try again?");
			String again = sc.nextLine();

			if (again.charAt(0) == 'y') {
				turn = 0;
			} else {
				break;
			}
		}

		sc.close(); // close the scanner
		System.exit(0); // exit the program
	}
}
