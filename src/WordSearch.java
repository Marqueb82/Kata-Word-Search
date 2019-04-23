import java.io.File;

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

}
