import static org.junit.Assert.assertTrue;

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

}
