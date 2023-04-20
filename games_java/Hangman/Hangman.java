package games_java.Hangman;

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] hangman = new String[] {
				"""
						      +
						      |
						      |
						      |
						      |
						      |
						=========""",
				"""
						     -+
						      |
						      |
						      |
						      |
						      |
						=========""",
				"""
						    --+
						      |
						      |
						      |
						      |
						      |
						=========""",
				"""
						   ---+
						      |
						      |
						      |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						      |
						      |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						      |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						  |   |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						 /|   |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						 /|\\  |
						      |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						 /|\\  |
						 /    |
						      |
						=========""", """
						  +---+
						  |   |
						  O   |
						 /|\\  |
						 / \\  |
						      |
						=========""" };

		String wordsList = "abruptly absurd abyss affix askew avenue awkward axiom azure bagpipes bandwagon banjo bayou beekeeper bikini blitz blizzard boggle bookworm boxcar buckaroo buffalo buffoon buzzard buzzing buzzwords cobweb croquet crypt cycle disavow dizzying duplex dwarves embezzle equip espionage euouae exodus faking fishhook fixable fjord flapjack flopping fluffiness flyby foxglove frazzled frizzled funny gabby galaxy galvanize gazebo gizmo glow glyph gnarly gnostic gossip grogginess haiku haphazard hyphen icebox injury ivory ivy jackpot jawbreaker jaywalk jazzy jelly jigsaw jinx jiujitsu jockey jogging joking jovial joyful juicy jukebox jumbo kayak kazoo keyhole kilobyte kiosk kitsch kiwifruit klutz knapsack lengths lucky luxury marquee matrix megahertz microwave mnemonic mystify nightclub nowadays oxidize oxygen pajama phlegm pixel pizazz polka psyche puppy puzzling quartz queue quip quiz quizzes razzmatazz rhythm scratch snazzy squawk staff strength stretch stronghold stymie subway swivel syndrome thrift thumb topaz transcript transgress transplant twelfth unknown unzip vaporize voodoo vortex walkway waltz wave wavy waxy well whomever witch wizard wristwatch xylophone yacht youthful yummy zigzag zilch zipper zodiac zombie";

		/* Part A: split the words String into an array, choose a random word */
		String[] words = wordsList.split(" ");

		boolean keepingPlaying = true;
		while (keepingPlaying) {

			int choice = (int) (Math.random() * words.length);
			String word = words[choice];

			/* Part B: make a char array with a line for each letter in the word */
			// Example word: 'quiz'
			// lines -> ['_', '_', '_', '_']

			char[] lines = new char[word.length()];

			for (int i = 0; i < word.length(); i++) {
				lines[i] = '_';
			}

			int amountWrong = 0;
			int amountOfWrongLetters = 0;
			int points = 0;
			boolean win = false;

			char[] wrongLetters = new char[hangman.length];

			while (amountWrong < hangman.length) {

				String displayLines = "";
				for (int i = 0; i < word.length(); i++) {
					displayLines += lines[i] + " ";
				}

				String displayWrongLetters = "";
				for (int i = 0; i < amountOfWrongLetters; i++) {
					displayWrongLetters += wrongLetters[i];

					if (i != amountOfWrongLetters - 1) {
						displayWrongLetters += ", ";
					}
				}

				/* Part C: show the lines for the word below the hangman art */
				System.out.println(hangman[amountWrong] + "\n\n" + displayLines + "\n");
				System.out.println(displayWrongLetters);
				String guess = sc.nextLine();

				// if its word
				if (guess.length() > 1) {

					if (guess.equals(word)) {
						win = true;
					} else {
						amountWrong++;
					}

				} else {
					// else the guess is a letter

					boolean isCorrect = false;
					for (int i = 0; i < word.length(); i++) {

						if (guess.charAt(0) == word.charAt(i)) {
							lines[i] = guess.charAt(0);
							points++;
							isCorrect = true;
						}
					}

					if (isCorrect == false) {
						wrongLetters[amountOfWrongLetters] = guess.charAt(0);
						amountWrong++;
						amountOfWrongLetters++;
					}

					if (points == word.length()) {
						win = true;
					}

				}

				if (win == true) {
					break;
				}

			}
			if (win == true) {
				System.out.println("You won!");
			} else {
				System.out.println("You lost! The word was: " + word);

			}

			System.out.println("Keep playing? \"y\" for yes and \"n\" for no");

			String continuation = sc.nextLine();
			if (continuation.charAt(0) == 'y') {
				keepingPlaying = true;
			} else {
				keepingPlaying = false;
			}
		}

		sc.close();
		System.exit(0);
	}
}
