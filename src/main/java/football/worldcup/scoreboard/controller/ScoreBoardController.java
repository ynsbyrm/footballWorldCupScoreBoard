package football.worldcup.scoreboard.controller;

import football.worldcup.scoreboard.entity.Match;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreBoardController {

    private List<Match> scoreBoard = new ArrayList<>();
    private List<Match> finishedGames = new ArrayList<>();
    public boolean startNewGame(@NotNull String homeTeam, @NotNull String awayTeam){
        if(homeTeam.isBlank() || awayTeam.isBlank() || homeTeam.equals(awayTeam)){
            return false;
        }

        /*
        Only check for contains won't be fit enough because user can try to add same match after score update.
         */
        for(Match currentMatch : scoreBoard){
            if (currentMatch.getHomeTeam().equals(homeTeam) && currentMatch.getAwayTeam().equals(awayTeam)){
                return false;
            }
        }

        scoreBoard.add(new Match(homeTeam, awayTeam, 0, 0));
        return true;
    }

    public boolean finishGame(@NotNull String homeTeam, @NotNull String awayTeam){
        if(homeTeam.isBlank() || awayTeam.isBlank() || homeTeam.equals(awayTeam)){
            return false;
        }

        /*
        Only check for contains won't be fit enough because user can try to add same match after score update.
         */
        for(Match currentMatch : scoreBoard){
            if (currentMatch.getHomeTeam().equals(homeTeam) && currentMatch.getAwayTeam().equals(awayTeam)){
                if(finishedGames.add(currentMatch)){
                    scoreBoard.remove(currentMatch);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateScore(@NotNull String homeTeam, @NotNull String awayTeam, @NotNull int homeTeamScore, @NotNull int awayTeamScore){
        if(homeTeam.isBlank() || awayTeam.isBlank() || homeTeam.equals(awayTeam) || homeTeamScore < 0 || awayTeamScore < 0){
            return false;
        }

        for(int i=0; i<scoreBoard.size(); i++){
            Match currentMatch = scoreBoard.get(i);
            if(currentMatch.getHomeTeam().equals(homeTeam) && currentMatch.getAwayTeam().equals(awayTeam)){
                currentMatch.setHomeTeamScore(homeTeamScore);
                currentMatch.setAwayTeamScore(awayTeamScore);
                return true;
            }
        }
        return false;
    }

    public List<?> summary(){
        return new ArrayList<>();
    }
}
