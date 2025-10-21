package examinationsprojekt.utils;

import java.util.Scanner;

public class ReadUserTerminalInput implements IReadUserInput {
    @Override
    public String stringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public double doubleInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
