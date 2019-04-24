import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class wordSearchTest {

	@Test
	public void doesTxtFileExist() {
		// test if we have actual txt file to use
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");
		assertTrue(wordSearch.foundTxtFile());
	}

	@Test
	public void canReadTxtFile() {
		// test if we can read txt file
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");
		assertTrue(wordSearch.readTxtFile());
	}

	@Test
	public void extractPuzzleWords() {
		// test if puzzle words can be read and split from first line of txt file
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");

		List<String> tempList = new ArrayList<String>();
		tempList.add("BONES");
		tempList.add("KHAN");
		tempList.add("KIRK");
		tempList.add("SCOTTY");
		tempList.add("SPOCK");
		tempList.add("SULU");
		tempList.add("UHURA");

		assertEquals(tempList, wordSearch.getPuzzleWords());
	}

	@Test
	public void checkGridCoords() {
		// test if testValues will match letter at 2D array index after reading grid
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");
		char testValue = 'I';
		char testValueTwo = 'B';

		assertEquals(testValue, wordSearch.makePuzzleGrid()[0][7]);
		assertEquals(testValueTwo, wordSearch.makePuzzleGrid()[14][14]);
	}

	@Test
	public void findWordLeftToRight() {
		// test if random txt can be found from left to right on grid
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");
		String testString = "JOC:\t (0,10) (0,11) (0,12)";
		String testStringTwo = "KAM:\t (7,4) (7,5) (7,6)";

		assertEquals(testString, wordSearch.wordLeftToRight("JOC"));
		assertEquals(testStringTwo, wordSearch.wordLeftToRight("KAM"));
	}

	@Test
	public void findWordRightToLeft() {
		// test if one of the puzzle words can be found in reverse in a row
		WordSearch wordSearch = new WordSearch("WordPuzzle.txt");
		String testString = "KIRK:\t (7,4) (7,3) (7,2) (7,1)";

		assertEquals(testString, wordSearch.wordRightToLeft("KIRK"));
	}

}
