package football.worldcup.scoreboard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    @Override
    public String toString(){
        return homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
    }
}
