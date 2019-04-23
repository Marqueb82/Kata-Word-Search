import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	public static boolean foundTxtFile() {

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

	public static boolean readTxtFile() {

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

	public static List<String> puzzleWords(String file) {

		List<String> puzzleWords = new ArrayList<String>();

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

}
