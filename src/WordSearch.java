import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public static List<String> puzzleWords(File file) {

		file = new File("WordPuzzle.txt");
		List<String> puzzleWords = new ArrayList<String>();
		String lineOfWords = "";

		try {
			Scanner sc = new Scanner(file);
			lineOfWords = sc.nextLine();
			sc.close();
		} catch (IOException io) {
			System.out.println("Error occurred");
			io.printStackTrace();
		}

		String[] splitWords = lineOfWords.split(",");

		for (String words : splitWords) {
			puzzleWords.add(words);
		}

		return puzzleWords;

	}

}
