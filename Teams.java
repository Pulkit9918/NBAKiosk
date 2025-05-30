import java.util.ArrayList;
import java.util.Scanner;

public class Teams {
    public ArrayList<Team> teams = new ArrayList<Team>();
    public Association association;
    private Player player;
    private Players players;
    Scanner scanner = new Scanner(System.in);
    private Team team;
    public Teams(Association association)
    {
        teams.add(new Team("Suns", 2500.00, 26, 1));
        teams.add(new Team("Bulls", 1500.00, 29, 3));
        teams.add(new Team("Hawks", 2200.00, 24, 11));
        teams.add(new Team("Nets", 2400.00, 26, 1));
        players = new Players();
        this.association = association;
    }

    public void menu2() {
        char choice;
        System.out.println("1. Display all teams.");
        System.out.println("2. Display all players.");
        System.out.println("3. Add a new team.");
        System.out.println("4. Manage an existing team.");
        System.out.println("5. Delete an existing team.");
        System.out.println("6. Display all players by an level.");
        System.out.println("R. Return to previous menu.");
        while ((choice = menuChoice2()) != 'R') {
            switch (choice) {
                case '1' : displayTeam(); break;
                case '2' : displayPlayers(); break;
                case '3' : addNewTeam(); break;
                case '4' : manageTeam(); break;
                case '5' : deleteTeam(); break;
                case '6' : displayPlayersLevel(); break;
                case 'R' : Return(); 
                default : Help(); break;
            }
        }
        association.menu();
        System.out.println("Welcome to the Association! Please make a selection from the menu:");
        System.out.println("1. Explore the teams.");
        System.out.println("2. Arrange a new season.");
        System.out.println("X. Exit the system.");
    }

    public void menu4(String teamNameInput) {
        char choice;
        System.out.println("1. Display team's players.");
        System.out.println("2. Add a new player.");
        System.out.println("3. Update an existing player.");
        System.out.println("4. Delete an existing player.");
        System.out.println("R. Return to previous menu.");
        while ((choice = menuChoice2()) != 'R') {
            switch (choice) {
                case '1': displayTeamPlayers(teamNameInput); break;
                case '2': addNewPlayer(teamNameInput); break;
                case '3': updatePlayer(teamNameInput); break;
                case '4': deletePlayer(teamNameInput); break;
                case 'R': Return(); break;
                default : Help(); break;
            }
        }
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
    }

     public void displayTeam() {
        Utils.teamsHeader(); 
        for (Team team: teams) {
            System.out.format(Utils.teamsFormat, team.getName(), totalPlayerNumber(team.getName()), averageCreditValue(team.getName()), averageAgeValue(team.getName()));
        }
        Utils.teamTableEnd();
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

     public void displayPlayers() {
        Utils.DisplayPlayerFromAllTeamsHeader(); 
        String a = "Suns";
        for (Player player: players.getAllPlayers()) {
            String teamName = player.getTeam();
            if (teamName != a) {
                Utils.DisplayPlayerFromAllTeamsEnd();
                a = teamName;
            }
            String playerName = player.getPlayerName();
            double playerCredit = player.getPlayerCredit();
            String playerLevel = player.getLevel(player.getPlayerCredit());
            int playerAge = player.getPlayerAge();
            int playerUniformNumber = player.getPlayerUniformNumber();
            System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, playerName, playerCredit, playerLevel, playerAge, playerUniformNumber, teamName);
        }
        Utils.DisplayPlayerFromAllTeamsEnd();
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

     public void addNewTeam() {
        System.out.print("Please enter the name of the team: ");
        String newTeamName = scanner.nextLine();
        boolean teamNameExists = false;
        for (Team team : teams) {
            if (newTeamName.equals(team.getName())) {
                teamNameExists = true;
                System.out.print("Team " + newTeamName + " already exist! Please enter a new name: ");
                newTeamName = scanner.nextLine();
            } 
        }
        teams.add(new Team(newTeamName, 0, 0.00, 0));
            System.out.println("Team " + newTeamName + " added!");
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

     public void manageTeam() {
        System.out.print("Please enter the team's name that you want to manage: ");
        String teamNameInput = scanner.nextLine();
        boolean teamMatch = false;
        for (Team team: teams) {
            if (teamNameInput.equals(team.getName())) {
                teamMatch = true;
                System.out.println("Welcome to the " + teamNameInput + " 's Page! Please make a selection from the menu:");
                menu4(teamNameInput);
            }
        }
        if (!teamMatch) {
            System.out.println("Team does not exist!");
        }
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

     public void deleteTeam() {
        System.out.print("Please enter the team's name that you want to delete: ");
        String deleteTeamName = scanner.nextLine();
        boolean teamMatch = false; 

        for (Team team : teams) {
            if (deleteTeamName.equals(team.getName())) {
                teams.remove(team);
                System.out.println("The team " + deleteTeamName + " has been deleted.");
                teamMatch = true;
                break;
            } 
        }
        if (!teamMatch) {
            System.out.println("That team does not exist.");
        }
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

     public void displayPlayersLevel() {
        boolean levelCheck = false;
        System.out.print("Please enter the player's level that you want to view: ");
        while(!levelCheck) {
            String levelNameCheck = scanner.nextLine();
            for (Player player : players.getAllPlayers()) {
                if (levelNameCheck.equals(player.getLevel(player.getPlayerCredit()))) {
                    levelCheck = true;
                    Utils.DisplayPlayerFromAllTeamsHeader();
                    for (Player p : players.getAllPlayers()) {
                        if (levelNameCheck.equals(p.getLevel(p.getPlayerCredit()))) {
                    String playerName = p.getPlayerName();
                    double playerCredit = p.getPlayerCredit();
                    String playerLevel = p.getLevel(p.getPlayerCredit());
                    int playerAge = p.getPlayerAge();
                    int playerUniformNumber = p.getPlayerUniformNumber();
                    String playerTeam = p.getTeam();
                    System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, playerName, playerCredit, playerLevel, playerAge, playerUniformNumber, playerTeam);
                       }
                    } 
                    Utils.DisplayPlayerFromAllTeamsEnd();
                    break;
                }
            }
            if (!levelCheck) {
                System.out.print("No such level! Please re-enter the level: ");
            } 
        }
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        menu2();
     }

    private char menuChoice2() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void Help() {

    }

    public void Return() {
        System.out.print("Done");
        System.exit(0);
    }

    public void displayTeamPlayers(String teamNameInput) {
        Utils.playerHeader();
        initialisePlayerToTeam();
        switch (teamNameInput) {
                    case "Suns":
                            sunsTeamPlayers();
                        break;
                    case "Bulls":
                        bullsTeamPlayers();
                        break;
                    case "Hawks":
                        hawksTeamPlayers();
                        break;
                    case "Nets":
                        netsTeamPlayers();
                        break;
                }
        Utils.playerTableEnd();
        System.out.println("Welcome to the " + teamNameInput + " 's Page! Please make a selection from the menu:");
        menu4(teamNameInput);
    }

    public void addNewPlayer(String teamNameInput) { 
        System.out.print("Please enter the player's name: ");
        String newName = scanner.nextLine();
        System.out.print("Please enter the player's credit: ");
        double newCredit = scanner.nextDouble();
        System.out.print("Please enter the player's age: ");
        double newAge = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Please enter the player's No: ");
        int newNumber = scanner.nextInt();
        // team.addNewPlayerToTeam(teamNameInput);
        // Player newPlayer = new Player(newName, newCredit, newAge, newNumber, 0, teamNameInput);
        // team.addPlayer(newPlayer);
        System.out.println("Player " + newName + " added!");
        System.out.println("Welcome to the " + teamNameInput + " 's Page! Please make a selection from the menu:");
        menu4(teamNameInput);
    }

    public void updatePlayer(String teamNameInput) {
        System.out.print("Please enter the player's name: ");
        String name = scanner.nextLine();
        for (Player player : players.getAllPlayers()) {
            if (name.equals(player.getPlayerName()) ) {
                System.out.print("Please enter the name: ");
                String newName = scanner.nextLine();
                System.out.print("Please enter the credit: ");
                double newCredit = scanner.nextDouble();
                System.out.print("Please enter the age: ");
                double newAge = scanner.nextDouble();
                System.out.println("Please enter the No: ");
                int newNumber = scanner.nextInt();
            } else {
                System.out.println("Player does not exist.");
                break;
            }
        }
        System.out.println("Welcome to the " + teamNameInput + " 's Page! Please make a selection from the menu:");
        menu4(teamNameInput);
    }

    public void deletePlayer(String teamNameInput) {
        System.out.print("Please enter the player's name: ");
        String playerNameCheck = scanner.nextLine();
        boolean playerCheck = false;
        // for (Player player : players) {
        //     if (playerNameCheck.equals(player.getPlayerName())) {
        //         players.remove(player);
        //         playerCheck = true;
        //     }
        // }
        // if (!playerCheck) {
        //     System.out.println("Player does not exist");
        // }
        System.out.println("Welcome to the " + teamNameInput + " 's Page! Please make a selection from the menu:");
        menu4(teamNameInput);
    }

    public ArrayList<Team> getAllTeams() {
        return teams;
    }
        
    public int totalPlayerNumber(String teamName) {
        int playerCount = 0;
        for (Player player : players.getAllPlayers()) {
            if (player.getTeam().equals(teamName)) {
                playerCount++;
            }
        }
        return playerCount;
    }

    public int creditCount(String teamName) {
        int creditCount = 0;
        for (Player player : players.getAllPlayers()) {
            if (player.getTeam().equals(teamName)) {
                creditCount++;
            }
        }
        return creditCount;
    }

    public int ageCount(String teamName) {
        int ageCount = 0;
        for (Player player : players.getAllPlayers()) {
            if (player.getTeam().equals(teamName)) {
                ageCount++;
            }
        }
        return ageCount;
    }

    public double averageCreditValue(String teamName) {
        double creditValue = 0.00;
        int playerCount = 0;
        for (Player player : players.getAllPlayers()) {
            if (player.getTeam().equals(teamName)) {
                creditValue += player.getPlayerCredit();
                playerCount++;
            }
        }
        if (playerCount > 0) {
            return creditValue / playerCount;
        } else {
            return 0.00; 
        }
    }

    public double averageAgeValue(String teamName) {
        double ageValue = 0.00;
        int playerCount = 0;
        for (Player player : players.getAllPlayers()) {
            if (player.getTeam().equals(teamName)) {
                ageValue += player.getPlayerAge();
                playerCount++;
            }
        }
        if (playerCount > 0) {
            return ageValue / playerCount;
        } else {
            return 0.00; 
        }
    }

    public void initialisePlayerToTeam () {
        for (Team team : teams) {
            for (Player player : players.getAllPlayers()) {
                switch (team.getName()) {
                    case "Suns":
                        if (player.getTeam().equals("Suns")) {
                            team.addPlayer(player);
                        }
                        break;
                    case "Bulls":
                        if (player.getTeam().equals("Bulls")) {
                            team.addPlayer(player);
                        }
                        break;
                    case "Hawks":
                        if (player.getTeam().equals("Hawks")) {
                            team.addPlayer(player);
                        }
                        break;
                    case "Nets":
                        if (player.getTeam().equals("Nets")) {
                            team.addPlayer(player);
                        }
                        break;
                }
            }
        }
    }

    public void sunsTeamPlayers () {
        for (Team team : teams) {
            if (team.getName().equals("Suns")) {
                ArrayList<Player> players = team.getAllPlayers();
                for (Player player : players) {
                    String name = player.getPlayerName();
                    double credit = player.getPlayerCredit();
                    String level = player.getLevel(player.getPlayerCredit());
                    int age = player.getPlayerAge();
                    int number = player.getPlayerUniformNumber();
                    System.out.format(Utils.PlayerFormat, name, credit, level, number, age);
                    player.setTeam("Suns");
                }
                break;
            }
        }
    }

    public void bullsTeamPlayers () {
        for (Team team : teams) {
            if (team.getName().equals("Bulls")) {
                ArrayList<Player> players = team.getAllPlayers();
                for (Player player : players) {
                    String name = player.getPlayerName();
                    double credit = player.getPlayerCredit();
                    String level = player.getLevel(player.getPlayerCredit());
                    int age = player.getPlayerAge();
                    int number = player.getPlayerUniformNumber();
                    System.out.format(Utils.PlayerFormat, name, credit, level, number, age);
                    player.setTeam("Bulls");
                }
                break;
            }
        }
    }

    public void netsTeamPlayers () {
        for (Team team : teams) {
            if (team.getName().equals("Nets")) {
                ArrayList<Player> players = team.getAllPlayers();
                for (Player player : players) {
                    String name = player.getPlayerName();
                    double credit = player.getPlayerCredit();
                    String level = player.getLevel(player.getPlayerCredit());
                    int age = player.getPlayerAge();
                    int number = player.getPlayerUniformNumber();
                    System.out.format(Utils.PlayerFormat, name, credit, level, number, age);
                    player.setTeam("Nets");
                }
                break;
            }
        }
    }

    public void hawksTeamPlayers () {
        for (Team team : teams) {
            if (team.getName().equals("Hawks")) {
                ArrayList<Player> players = team.getAllPlayers();
                for (Player player : players) {
                    String name = player.getPlayerName();
                    double credit = player.getPlayerCredit();
                    String level = player.getLevel(player.getPlayerCredit());
                    int age = player.getPlayerAge();
                    int number = player.getPlayerUniformNumber();
                    System.out.format(Utils.PlayerFormat, name, credit, level, number, age);
                    player.setTeam("Hawks");
                }
                break;
            }
        }
    }

    public Team getTeamName(String teamNameInput) {
    for (Team team : teams) {
        if (team.getName().equals(teamNameInput)) {
            return team;
        }
    }
        return null; 
    }
}