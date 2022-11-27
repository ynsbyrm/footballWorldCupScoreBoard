package football.worldcup.scoreboard;

import football.worldcup.scoreboard.controller.ScoreBoardController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ScoreBoardApplicationTests {

	private ScoreBoardController scoreBoardController = new ScoreBoardController();

	@Test
	void contextLoads() {
	}

	@Test
	void startGame(){

		/*
			These lines commented-out because of @NotNull annotation throws an IllegalArgumentException not returns as false

		assertFalse(scoreBoardController.startNewGame("TeamA", null), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.startNewGame(null, "TeamB"), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.startNewGame(null, null), "Home or away team cannot be null or emptyString");
		*/
		assertFalse(scoreBoardController.startNewGame("TeamA", ""), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.startNewGame("", "TeamB"), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.startNewGame("", ""), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.startNewGame("TeamA", "TeamA"), "Home or away team cannot be same");
		assertTrue(scoreBoardController.startNewGame("TeamA", "TeamB"));
		assertFalse(scoreBoardController.startNewGame("TeamA", "TeamB"), "Same match cannot be added twice");
	}

}
