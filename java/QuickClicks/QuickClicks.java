package java.QuickClicks;

import static java.QuintOS.*;

import java.time.Instant;

public class QuickClicks {
	String target = " .d88b.\n.8P  Y8.\n88    88\n88    88\n'8b  d8'\n 'Y88P'";

	String imposter = " .d88b.\n.8P  Y8.\n86    88\n88    68\n'8b  d8'\n 'Y88P'";

	int targetRow = 0;
	int targetCol = 0;

	int clickLimit = 10;
	long[] time_machine = new long[clickLimit];
	int index = 0;

	void calculateStats() {
		int[] speeds = new int[clickLimit - 1];
		String sp = "";

		int sum = 0;
		int avrg = 0;
		int slowest = 0;
		int fastest = 100000;

		for (int i = 0; i < clickLimit - 1; i++) {
			speeds[i] = (int) (time_machine[i + 1] - time_machine[i]);
			sp += speeds[i] + ", ";
			sum += speeds[i];

			if (speeds[i] <= fastest) {
				fastest = speeds[i];
			}
			if (speeds[i] >= slowest) {
				slowest = speeds[i];
			}
		}

		avrg = sum / speeds.length;

		alert(sp + "\n\naverage: " + Math.round(avrg) + "\nslowest: " + slowest + "\nfastest: " + fastest, 10, 30, 40);
	}

	void makeTargets() {

		time_machine[index] = Instant.now().toEpochMilli();
		index++;

		erase();

		String pattern1 = "{[]}".repeat(19) + "{[";
		String pattern2 = "{II}".repeat(19) + "{[";

		txt(pattern1, 1, 1);
		txt(pattern2, 2, 1);

		for (int i = 1; i <= 28; i++) {
			if (i % 2 == 0) {
				txt(pattern1, i, 1);
			} else {
				txt(pattern2, i, 1);
			}
		}

		if (index == clickLimit) {
			calculateStats();

		} else {

			/*
			 * Part A0: change the values of row and col to be random, within the bounds of
			 * the screen.
			 */
			targetRow = (int) (Math.random() * 23 + 1); // 23
			targetCol = (int) (Math.random() * 71 + 1); // 71

			button(target, targetRow, targetCol, () -> {
				makeTargets();
			});

			for (int i = 0; i < 8; i++) {
				int row_I = (int) (Math.random() * 23 + 1); // 23
				int col_I = (int) (Math.random() * 71 + 1); // 71
				button(imposter, row_I, col_I, () -> {
					gameOver();
				});
			}
		}
	}

	void startGame() {
		alert("Press the right zero", 10, 30, 20, 1);
		index = 0;
		makeTargets();
	}

	void gameOver() {
		erase();
		txt(target, targetRow, targetCol);
		alert("GAME OVER!!", 10, 30, 20, 1);
		startGame();
	}

	/* don't edit the code below this line */

	public QuickClicks() {
		startGame();
	}

	public static void main(String[] args) {
		new QuickClicks();
	}
}
