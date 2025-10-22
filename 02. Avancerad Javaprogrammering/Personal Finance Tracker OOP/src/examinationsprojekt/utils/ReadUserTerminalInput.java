package examinationsprojekt.utils;

import java.util.Scanner;

public class ReadUserTerminalInput implements IReadUserInput {
    @Override
    public String stringInput() {
        System.out.println(" >");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public double doubleInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(" >");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
