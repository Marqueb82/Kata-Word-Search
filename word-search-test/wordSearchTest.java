import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class wordSearchTest {

	@Test
	public void doesTxtFileExist() {
		// check if we have actual txt file to use
		assertTrue(WordSearch.foundTxtFile());
	}

	@Test
	public void canReadTxtFile() {
		// check if we have actual txt file to use
		assertTrue(WordSearch.readTxtFile());
	}

	@Test
	public void extractPuzzleWords() {
		// check if puzzle words were read and split from first line of txt file
		List<String> tempList = new ArrayList<String>();
		tempList.add("BONES");
		tempList.add("KHAN");
		tempList.add("KIRK");
		tempList.add("SCOTTY");
		tempList.add("SPOCK");
		tempList.add("SULU");
		tempList.add("UHURA");

		assertEquals(tempList, WordSearch.puzzleWords("WordPuzzle.txt"));
	}

}
