import java.util.ArrayList;
public class Season {
    private ArrayList<Game> schedule;
    private ArrayList<Team> currentTeamList;
    private Integer round;
    private Teams teams;
    private Team team;
    private ArrayList<Record>  records;
    public Association association;
    private Game game;
    private String teamOne;
    private String teamTwo;
    private String teamThree;
    private String teamFour;

    public Season(Association association, Teams teams)
    {
        this.association = association;
        this.currentTeamList = new ArrayList<Team>();
        for (Team team : teams.getAllTeams()) {
            this.currentTeamList.add(team);
        }
        game = new Game();
    }

    public void menu3() {
        char choice;
        System.out.println("1. Add a team to the round.");
        System.out.println("2. Display the current round.");
        System.out.println("3. Play games.");
        System.out.println("4. Display the game result records.");
        System.out.println("R. Return to previous menu.");
        while ((choice = menuChoice3()) != 'R') {
            switch (choice) {
                case '1' : addTeam(); break;
                case '2' : displayRound(); break;
                case '3' : playGame(); break;
                case '4' : displayResults(); break;
                case 'R' : Return(); break;
                default : Help(); break;
            }
        }
        association.menu();
        System.out.println("Welcome to the Association! Please make a selection from the menu:");
        System.out.println("1. Explore the teams.");
        System.out.println("2. Arrange a new season.");
        System.out.println("X. Exit the system.");
    }

    public void addTeam() {
        Game game = new Game();
        System.out.println("The existing teams are as follows: ");
        for (int i = 0; i < currentTeamList.size(); i++) {
            System.out.print(currentTeamList.get(i).getName());
            if (i < currentTeamList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Please enter the team's name that you want to schedule: ");
        this.teamOne = In.nextLine();
        boolean teamCheck = false;
        for (Team team : currentTeamList) {
            if (team.getName().equals(teamOne)) {
                teamCheck = true;
                break;
            }
        }

        if (!teamCheck) {
            System.out.println("No such team! Please try again");
            System.out.println("The existing teams are as follows: ");
            for (int i = 0; i < currentTeamList.size(); i++) {
                System.out.print(currentTeamList.get(i).getName());
                if (i < currentTeamList.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println("Please enter the team's name that you want to schedule: ");
            teamOne = In.nextLine();
        }
        System.out.println("Team " + teamOne + " has been added at the Game 1 position 1");
        currentTeamList.removeIf(team -> team.getName().equals(teamOne));
        System.out.println("The existing teams are as follows: ");
        for (int i = 0; i < currentTeamList.size(); i++) {
            System.out.print(currentTeamList.get(i).getName());
            if (i < currentTeamList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Please enter the team's name that you want to schedule: ");
        this.teamTwo = In.nextLine();
        System.out.println("Team " + teamTwo + " has been added at the Game 1 position 2");
        currentTeamList.removeIf(team -> team.getName().equals(teamTwo));
        System.out.println("The existing teams are as follows: ");
        for (int i = 0; i < currentTeamList.size(); i++) {
            System.out.print(currentTeamList.get(i).getName());
            if (i < currentTeamList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Please enter the team's name that you want to schedule: ");
        this.teamThree = In.nextLine();
        System.out.println("Team " + teamThree + " has been added at the Game 2 position 1");
        currentTeamList.removeIf(team -> team.getName().equals(teamThree));
        System.out.println("The existing teams are as follows: ");
        for (int i = 0; i < currentTeamList.size(); i++) {
            System.out.print(currentTeamList.get(i).getName());
            if (i < currentTeamList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Please enter the team's name that you want to schedule: ");
        this.teamFour = In.nextLine();
        teamCheck = false;
        for (Team team : currentTeamList) {
            if (team.getName().equals(teamFour)) {
                teamCheck = true;
                break;
            }
        }
        if (!teamCheck) {
            System.out.println("No such team! Please try again");
            System.out.println("The existing teams are as follows: ");
            for (int i = 0; i < currentTeamList.size(); i++) {
                System.out.print(currentTeamList.get(i).getName());
                if (i < currentTeamList.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println("Please enter the team's name that you want to schedule: ");
            teamFour = In.nextLine();
        }
        System.out.println("Team " + teamFour + " has been added at the Game 2 position 2");
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        menu3();
    }

    public void displayRound() {
        Utils.GameHeader();
        System.out.format(Utils.GamesFormat, this.teamOne, " vs ", this.teamTwo);
        System.out.format(Utils.GamesFormat, this.teamThree, " vs ", this.teamFour);
        Utils.GameEnd();
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        menu3();
    }

    public void playGame() {
        Game game = new Game();
        game.playGame2();
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        menu3();
    }

    public void displayResults() {
        Utils.RecordHeader(); 
        System.out.format(Utils.RecordFormat, 1, 1, this.teamOne, this.teamTwo);
        Utils.RecordEnd();
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        menu3();
    }

    private char menuChoice3() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void Help() {
        System.out.println("Please enter a number between 1 and 4 or press R to return to the previous menu.");
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        menu3();
    }

    public void Return() {
        System.out.print("Done");
        System.exit(0);
    }
}