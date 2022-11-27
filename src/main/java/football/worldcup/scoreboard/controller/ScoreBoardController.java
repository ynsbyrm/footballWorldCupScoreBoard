package football.worldcup.scoreboard.controller;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardController {

    public boolean startNewGame(String homeTeam, String awayTeam){
        return true;
    }

    public boolean finishGame(String homeTeam, String awayTeam){
        return true;
    }

    public boolean updateScore(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore){
        return true;
    }

    public List<?> summary(){
        return new ArrayList<>();
    }
}
