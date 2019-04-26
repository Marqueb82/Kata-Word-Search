import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	private List<String> puzzleWords;
	private String file;

	public WordSearch(String file) {
		this.file = file;
	}

	public boolean foundTxtFile() {

		File wordSearch = new File(file);

		// checks if txt file exist and is readible
		if (wordSearch.exists()) {
			System.out.println("File found");
			return true;
		} else {
			System.out.println("Unable to find file");
		}

		return false;
	}

	public boolean readTxtFile() {

		File wordSearch = new File(file);

		// checks if txt file exist and is readible
		if (wordSearch.canRead()) {
			System.out.println("Can read file");
			return true;
		} else {
			System.out.println("Unable to find file");
		}

		return false;
	}

	public List<String> getPuzzleWords() {

		puzzleWords = new ArrayList<String>();

		try {
			// read txt file first line to find list of puzzle words for search
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String[] lineOfWords = bufferedReader.readLine().split(",");
			bufferedReader.close();

			for (String words : lineOfWords) {
				puzzleWords.add(words);
			}

		} catch (IOException io) {
			System.out.println("Error occurred");
			io.printStackTrace();
		}

		return puzzleWords;
	}

	public char[][] makePuzzleGrid() {

		char[][] puzzleGrid = null;

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// skip first line in txt file which contains list of puzzle words
			bufferedReader.readLine();

			int arrayLength = 0;
			int row = 0;
			int col = 0;
			String line;

			// search through txt file puzzle grid until complete
			while ((line = bufferedReader.readLine()) != null) {

				char[] gridLetters = line.replace(",", "").toCharArray();
				if (puzzleGrid == null) {
					arrayLength = gridLetters.length;
					puzzleGrid = new char[arrayLength][arrayLength];
				}

				// go through line adding letters to array
				for (col = 0; col < arrayLength; col++) {
					puzzleGrid[row][col] = gridLetters[col];
				}
				// next line
				row++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Error occurred");
			e.printStackTrace();
		}

		return puzzleGrid;
	}

	public String wordLeftToRight(String searchFor) {

		// creating 2d array grid from txt file
		char[][] puzzle = makePuzzleGrid();
		int k = 0;
		String foundAt = "";

		// search through 2d grid
		for (int x = 0; x < puzzle.length; x++) {
			for (int y = 0; y < puzzle[x].length; y++) {
				if (searchFor.charAt(k) == puzzle[x][y]) {
					k++;
				} else {
					k = 0;
				}

				if (k == searchFor.length()) {
					foundAt = searchFor + ":" + "\t";
					// get values going left to right down row
					for (int col = y - k + 1; col <= y; col++) {
						foundAt += " " + "(" + x + "," + col + ")";
						k = 0;
					}
				}
			}
		}

		return foundAt;

	}

	public String wordRightToLeft(String searchFor) {

		char[][] puzzle = makePuzzleGrid();
		int k = 0;
		String foundAt = "";

		for (int x = 0; x < puzzle.length; x++) {
			// search row column to column in reverse
			for (int y = puzzle[x].length - 1; y >= 0; y--) {
				if (searchFor.charAt(k) == puzzle[x][y]) {
					k++;
				} else {
					k = 0;
				}

				if (k == searchFor.length()) {
					foundAt = searchFor + ":" + "\t";
					// get values going up row in reverse
					for (int col = y + k - 1; col >= y; col--) {
						foundAt += " " + "(" + x + "," + col + ")";
						k = 0;
					}
				}
			}
		}

		return foundAt;

	}

	public String wordGoingDown(String searchFor) {

		char[][] puzzle = makePuzzleGrid();
		int k = 0;
		String foundAt = "";

		for (int x = 0; x < puzzle.length; x++) {
			for (int y = 0; y < puzzle[x].length; y++) {
				// searching col x row
				if (searchFor.charAt(k) == puzzle[y][x]) {
					k++;
				} else {
					k = 0;
				}

				if (k == searchFor.length()) {
					foundAt = searchFor + ":" + "\t";
					// get values going down col
					for (int row = y - k + 1; row <= y; row++) {
						foundAt += " " + "(" + x + "," + row + ")";
						k = 0;
					}
				}
			}
		}
		return foundAt;

	}

}
