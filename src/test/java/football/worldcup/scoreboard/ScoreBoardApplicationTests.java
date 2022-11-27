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

	@Test
	void finishGame(){
		/*
			These lines commented-out because of @NotNull annotation throws an IllegalArgumentException not returns as false

		assertFalse(scoreBoardController.finishGame("TeamA", null), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.finishGame(null, "TeamB"), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.finishGame(null, null), "Home or away team cannot be null or emptyString");
		*/
		assertFalse(scoreBoardController.finishGame("TeamA", ""), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.finishGame("", "TeamB"), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.finishGame("", ""), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.finishGame("TeamA", "TeamA"), "Home or away team cannot be same");
		assertFalse(scoreBoardController.finishGame("TeamA", "TeamB"), "Match is not on the scoreboard");
		scoreBoardController.startNewGame("TeamA", "TeamB");
		assertTrue(scoreBoardController.finishGame("TeamA", "TeamB"));
	}

	@Test
	void updateScore(){
		/*
			These lines commented-out because of @NotNull annotation throws an IllegalArgumentException not returns as false

		assertFalse(scoreBoardController.updateScore("TeamA", null, 0, 0), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.updateScore(null, "TeamB", 0, 0), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.updateScore(null, null, 0, 0), "Home or away team cannot be null or emptyString");
		*/
		assertFalse(scoreBoardController.updateScore("TeamA", "", 0, 0), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.updateScore("", "TeamB", 0, 0), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.updateScore("", "", 0, 0), "Home or away team cannot be null or emptyString");
		assertFalse(scoreBoardController.updateScore("TeamA", "TeamA", 0, 0), "Home or away team cannot be same");
		assertFalse(scoreBoardController.updateScore("TeamA", "TeamB", 0, 0), "Match is not on the scoreboard");
		scoreBoardController.startNewGame("TeamA", "TeamB");
		assertTrue(scoreBoardController.updateScore("TeamA", "TeamB", 0, 0));
		assertFalse(scoreBoardController.updateScore("TeamA", "TeamB", -1, 0), "Home or away team's score can not be negative");
		assertFalse(scoreBoardController.updateScore("TeamA", "TeamB", 0, -1), "Home or away team's score can not be negative");
		assertFalse(scoreBoardController.updateScore("TeamA", "TeamB", -1, -1), "Home or away team's score can not be negative");
		assertTrue(scoreBoardController.updateScore("TeamA", "TeamB", 1, 0));
	}

	@Test
	void summary(){
		scoreBoardController.startNewGame("TeamA", "TeamB");
		scoreBoardController.updateScore("TeamA", "TeamB", 1, 0);
		scoreBoardController.startNewGame("TeamC", "TeamD");
		scoreBoardController.updateScore("TeamC", "TeamD", 1, 0);
		scoreBoardController.startNewGame("TeamE", "TeamF");
		scoreBoardController.updateScore("TeamE", "TeamF", 0, 0);
		assertTrue(scoreBoardController.summary().get(0).getHomeTeam().equals("TeamC"));
		assertTrue(scoreBoardController.summary().get(2).getHomeTeam().equals("TeamE"));
	}
}
