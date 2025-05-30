import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Association
{
    private Teams teams;
    private Season season;
    
    public Association()
    {
        teams = new Teams(this);
        season = new Season(this, this.teams);
    }

    public static void main(String[] args) {
        new Association().menu();
    }

    public void menu() {
        char choice;
        System.out.println("Welcome to the Association! Please make a selection from the menu:");
        System.out.println("1. Explore the teams.");
        System.out.println("2. Arrange a new season.");
        System.out.println("X. Exit the system.");
        while ((choice = menuChoice()) != 'X') {
            switch (choice) {
                case '1' : Explore(); break;
                case '2' : Arrange(); break;
                case 'X' : Exit(); break;
                default : Help(); break;
            }
        }
        System.out.println("Done");
        System.exit(0);
    }

    private char menuChoice() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void Help() {
        System.out.println("Please enter a number 1 or 2, or press X to exit.");
        menu();
    }

    public void Exit() {
        System.out.print("Done");
        System.exit(0);
    }

    public void Explore() {
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        teams.menu2();
    }

    public void Arrange() {
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        season.menu3();
    }
}