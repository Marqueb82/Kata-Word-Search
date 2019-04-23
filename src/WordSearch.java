import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	private List<String> puzzleWords;

	public WordSearch() {
	}

	public boolean foundTxtFile() {

		File wordSearch = new File("WordPuzzle.txt");

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

		File wordSearch = new File("WordPuzzle.txt");

		// checks if txt file exist and is readible
		if (wordSearch.canRead()) {
			System.out.println("Can read file");
			return true;
		} else {
			System.out.println("Unable to find file");
		}

		return false;
	}

	public List<String> getPuzzleWords(String file) {

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

	public char[][] makePuzzleGrid(String file) {

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

}
