package games_java.GuessTheNumber;

import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		// create the user input scanner object
		Scanner sc = new Scanner(System.in);

		// your code goes here!
		int num = (int) (Math.random() * 100 + 1);

		int guess = 0;

		while (guess != num) {
			System.out.println("Guess the Number 1-100");
			guess = sc.nextInt();
			if (guess > num) {
				System.out.println("guess is too high!");
			} else if (guess < num) {
				System.out.println("guess is too low!");
			} else {
				System.out.println("Correct!");
			}
		}

		sc.close(); // close the scanner
		System.exit(0); // exit the program
	}
}
