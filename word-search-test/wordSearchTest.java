import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class wordSearchTest {

	@Test
	public void doesTxtFileExist() {
		// check if we have actual txt file to use
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.foundTxtFile());
	}

	@Test
	public void canReadTxtFile() {
		// check if we can read txt file
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.readTxtFile());
	}

	@Test
	public void extractPuzzleWords() {
		// check if puzzle words were read and split from first line of txt file
		WordSearch wordSearch = new WordSearch();

		List<String> tempList = new ArrayList<String>();
		tempList.add("BONES");
		tempList.add("KHAN");
		tempList.add("KIRK");
		tempList.add("SCOTTY");
		tempList.add("SPOCK");
		tempList.add("SULU");
		tempList.add("UHURA");

		assertEquals(tempList, wordSearch.getPuzzleWords("WordPuzzle.txt"));
	}

	@Test
	public void checkGridCoords() {
		// check if testValue will match letter at 2D array index
		WordSearch wordSearch = new WordSearch();
		char testValue = 'I';
		char testValueTwo = 'B';

		assertEquals(testValue, wordSearch.makePuzzleGrid("WordPuzzle.txt")[0][7]);
		assertEquals(testValueTwo, wordSearch.makePuzzleGrid("WordPuzzle.txt")[14][14]);
	}

	@Test
	public void foundWordInGrid() {
		// check if word is in row
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.foundWordLeftToRight("JOC"));
	}

}
