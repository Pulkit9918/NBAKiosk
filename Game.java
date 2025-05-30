import java.util.ArrayList;
public class Game
{
    private ArrayList<Team> teams;
    private ArrayList<Team> results;
    public Integer term;
    private Season season;
    public Game()
    {
        results = new ArrayList<>();
        teams = new ArrayList<>();
        term = 0;
    }

    public void gameTeamAdd(Team team) {
        teams.add(team);
    }

    public void playGame2() {
        boolean areTeamsAdded = !teams.isEmpty();
        if (!areTeamsAdded) {
            System.out.println("No game in the current round, please add teams to the round first!");
        } else {
            System.out.println("All games finished! You can use 4 to check the results.");
        }
    }

}



