import java.util.ArrayList;

public class Players {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Teams teams;
    private Player player;
    public Players() {
        players.add(new Player("Devin Booker", 2500.00, 2500.00, 26, 1, "Suns"));
        players.add(new Player("Chris Paul", 1500.00, 1500.00, 37, 3, "Suns"));
        players.add(new Player("Deandre Ayton", 2000.00, 2000.00, 24, 22, "Suns"));
        players.add(new Player("Kevin Durant", 3000.00, 3000.00, 34, 35, "Suns"));
        players.add(new Player("Terrence Ross", 1000.00, 1000.00, 32, 8, "Suns"));
        players.add(new Player("Andre Drummond", 1500.00, 1500.00, 29, 3, "Bulls"));
        players.add(new Player("Zach LaVine", 3000.00, 3000.00, 28, 8, "Bulls"));
        players.add(new Player("Dalen Terry", 900.00, 900.00, 20, 25, "Bulls"));
        players.add(new Player("Terry Taylor", 1000.00, 1000.00, 23, 32, "Bulls"));
        players.add(new Player("Carlik Jones", 800.00, 800.00, 25, 22, "Bulls"));
        players.add(new Player("Trae Young", 2200.00, 2200.00, 24, 11, "Hawks"));
        players.add(new Player("John Collins", 2000.00, 2000.00, 25, 20, "Hawks"));
        players.add(new Player("Aaron Holiday", 800.00, 800.00, 26, 3, "Hawks"));
        players.add(new Player("Jalen Johnson", 1000.00, 1000.00, 21, 1, "Hawks"));
        players.add(new Player("Trent Forrest", 1200.00, 1200.00, 24, 2, "Hawks"));
        players.add(new Player("Mikal Bridges", 2400.00, 2400.00, 26, 1, "Nets"));
        players.add(new Player("Ben Simmons", 2000.00, 2000.00, 26, 10, "Nets"));
        players.add(new Player("Patty Mills", 900.00, 900.00, 34, 8, "Nets"));
        players.add(new Player("Joe Harris", 1200.00, 1200.00, 31, 12, "Nets"));
        players.add(new Player("Seth Curry", 1900.00, 1900.00, 32, 30, "Nets"));
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public ArrayList<Player> getAllPlayers() {
        return players;
    }
}