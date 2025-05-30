public class Player {
    private String playerName;
    private double playerCredit;
    private String level;
    private int playerAge;
    private Players players;
    private String team;
    private int playerUniformNumber;
    public Player(String playerName, double playerCredit, double CreditForLevel, int playerAge, int playerUniformNumber, String team)
    {
        this.playerName = playerName;
        this.playerCredit = playerCredit;
        this.playerAge = playerAge;
        this.playerUniformNumber = playerUniformNumber;
        this.level = getLevel(CreditForLevel);
        this.team = team;
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getPlayerCredit() {
        return playerCredit;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public int getPlayerUniformNumber() {
        return playerUniformNumber;
    }

    public String getTeam() {
        return team;
    }

    public String getLevel(double playerCredit) {
        if (playerCredit < 1000) {
            level = "Edge";
        } else if (playerCredit >= 1000 && playerCredit < 1500) {
            level = "Common";
        } else if (playerCredit >= 1500 && playerCredit < 2000) {
            level = "Core";
        } else {
            level = "All Star";
        }
        return level;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPlayerCredit(double playerCredit) {
        this.playerCredit = playerCredit;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public void setPlayerUniformNumber(int playerUniformNumber) {
        this.playerUniformNumber = playerUniformNumber;
    }

    public boolean teamNameCheck(String team) {
        if (getTeam() != team) {
            return false;
        }
        return true;
    }
}