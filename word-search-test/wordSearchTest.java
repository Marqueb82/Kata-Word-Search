import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class wordSearchTest {

	@Test
	public void doesTxtFileExist() {
		// test if we have actual txt file to use
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.foundTxtFile());
	}

	@Test
	public void canReadTxtFile() {
		// test if we can read txt file
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.readTxtFile());
	}

	@Test
	public void extractPuzzleWords() {
		// test if puzzle words can be read and split from first line of txt file
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
		// test if testValues will match letter at 2D array index after reading grid
		WordSearch wordSearch = new WordSearch();
		char testValue = 'I';
		char testValueTwo = 'B';

		assertEquals(testValue, wordSearch.makePuzzleGrid("WordPuzzle.txt")[0][7]);
		assertEquals(testValueTwo, wordSearch.makePuzzleGrid("WordPuzzle.txt")[14][14]);
	}

	@Test
	public void foundWordLeftToRight() {
		// test if random piece of txt can be found from left to right on grid
		WordSearch wordSearch = new WordSearch();
		String testString = "JOC:\t (0,10) (0,11) (0,12)";

		assertEquals(testString, wordSearch.findWordLeftToRight("JOC"));
	}

}
