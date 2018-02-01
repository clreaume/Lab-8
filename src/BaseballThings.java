/*
 * Cara Reaume
 * Description: this lab returns the batting averages and slugging percentages for a user-entered number of baseball players.
 */
import java.util.Arrays;
import java.util.Scanner;

public class BaseballThings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numBatters = Validator.getInt(input, "Enter the number of batters: ");

		int[][] batterStats = new int[numBatters][]; // initialize 2D array with numBatters-number sub arrays
		// will look something like: { {bat1, bat2}, {bat1, bat2, bat3}, {bat1} }

		for (int i = 0; i < batterStats.length; ++i) { // iterate through batters
			System.out.printf("For batter %d,", i + 1);
			int numAtBats = Validator.getInt(input, " please enter the number of at-bats: ", 1); // get number of at-bats

			batterStats[i] = new int[numAtBats]; // initialize array for this batter within main array

			for (int j = 0; j < batterStats[i].length; ++j) { // iterate through at-bats for this batter
				System.out.printf("For bat %d (of batter %d),", j + 1, i + 1);
				batterStats[i][j] = Validator.getInt(input, " enter the number of bases earned: ", 0, 4); // get number of bases for this at-bat																										
			}
		}

		for (int[] i : batterStats) { //for each sub-array in main array, aka for each batter
			double numAtBats = i.length; //have to recreate this bc of limited scope of first one

			int legitAtBats = 0;
			int totalBases = 0;

			for (int j : i) { //iterating through at-bats
				if (j != 0) {
					++legitAtBats;
				}
				totalBases += j;
			}

			double battingAvg = legitAtBats / numAtBats;
			double sluggingPercentage = totalBases / numAtBats;
			
			System.out.printf("Batter %d average: %.3f \t slugging percentage: %.3f ",
					Arrays.asList(batterStats).indexOf(i) + 1, battingAvg, sluggingPercentage);
			System.out.println();
		}
	}
}