package by.training.homework4_1.console;

import java.util.Scanner;

public class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        boolean correctInput = false;
        while (!correctInput) {
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
            } else {
                correctInput = true;
            }
        }
        return scanner.nextInt();
    }
}
