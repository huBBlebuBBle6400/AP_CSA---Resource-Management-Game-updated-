import java.util.Scanner;

/**
 * A utility class for console input/output operations.
 */
public class Util {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Clears the console screen.
     */
    public static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pauses the console and waits for the user to press enter.
     */
    public static void pauseConsole() {
        System.out.println("Press enter to continue");
        scan.nextLine();
    }

    /**
     * Reads an integer input from the console.
     *
     * @param min the minimum valid value for the input
     * @param max the maximum valid value for the input
     * @return the integer value entered by the user
     */
    public static int enterInt(int min, int max) {
        int input;
        while (true) {
            System.out.print("Enter number: ");
            try {
                input = Integer.parseInt(scan.nextLine());
                if (input >= min && input <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                // do nothing
            }
            System.out.println("Invalid input, enter again");
        }
        return input;
    }
}
