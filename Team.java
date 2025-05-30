import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private String name;
    private Player player;
    private ArrayList<Player> teamPlayers;
    Scanner scanner = new Scanner(System.in);
    private Teams teams;
    private int totalPlayers;
    private double credit;
    private double age;
    private int playerNumber;

    public Team(String name, double credit, double age, int playerNumber)
    {
        this.name = name;
        this.credit = credit;
        this.age = age;
        this.playerNumber = playerNumber;
        this.teamPlayers = new ArrayList<Player>();
    }

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public double getAge() {
        return age;
    }

    public double getAverageCredit(double credit) {
        double totalTeamCredit = 0.00;
        double averageCredit = 0;
        double totalPlayers = 0.00;
        for (Player player: teamPlayers) {
            totalTeamCredit += player.getPlayerCredit();
            totalPlayers ++;
        }
        if (totalPlayers == 0) {
            return 0.00;
        } else {
            averageCredit = totalTeamCredit / totalPlayers;
        }
        return averageCredit;
    }

    public double getAverageAge(double age) {
        double totalAge = 0;
        double totalPlayers = 0.00;
        for (Player player : teamPlayers) {
            totalAge += player.getPlayerAge();
            totalPlayers ++;
        }
        if (totalPlayers == 0) {
            return 0.00;
        } else {
            return totalAge/totalPlayers;
        }
    }

    public int getTotalPlayerNumber() {
        return teamPlayers.size();
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getAllPlayers() {
        return teamPlayers;
    }

    public void setAllPlayers(ArrayList<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public void addPlayer(Player player) {
        teamPlayers.add(teamPlayers.size(), player);
    }

    public void addNewPlayerToTeam (String teamNameInput) {
        System.out.print("Please enter the player's name: ");
        String newName = scanner.nextLine();
        System.out.print("Please enter the player's credit: ");
        double newCredit = scanner.nextDouble();
        System.out.print("Please enter the player's age: ");
        double newAge = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Please enter the player's No: ");
        Scanner scanner = new Scanner(System.in);
        int newNumber = scanner.nextInt();
        scanner.nextLine();
        boolean numberCheck = false;
        while (numberCheck == false) {
            if (getName().equals(teamNameInput)) {
                for (Player player : teamPlayers) {
                    if (player.getPlayerUniformNumber() == newNumber) {
                        numberCheck = true;
                        System.out.print("This number has been occupied by: " + player.getPlayerName() + ". Please re-enter the No: ");
                        newNumber = scanner.nextInt();
                    }
                }
            }
        }
        if (numberCheck) {
            addPlayer(new Player(newName, newCredit, newAge, newNumber, 0, teamNameInput));
            System.out.println("Player " + newName + " added!");
        } 
    }

    public boolean hasPlayer(Player player) {
        return teamPlayers.contains(player);
    }

    public boolean nameCheck(String name) {
        return getName().equals(name);
    }
}