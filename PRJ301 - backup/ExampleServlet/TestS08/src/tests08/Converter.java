/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests08;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Converter {

    /**
     * Converts Hexadecimal and Octal numbers to Binary based on user input. The
     * user can input a Hexadecimal number ending with 'h' or an Octal number
     * ending with 'q'. The program continues to prompt the user until 'exit' is
     * entered.
     */
    public void convert() {
        Scanner sc = new Scanner(System.in);  // Scanner for user input
        String input;                          // Input string from user
        String binary;                         // Binary result placeholder
        boolean isValid = false;           // Flag to check if exit is requested

        do {
            try {
                System.out.println("Convert Hexadecimal number / Octal number to Binary program");
                System.out.print("Enter a Hexadecimal (h) / Octal (q) number ('exit' to stop): ");
                input = sc.nextLine().toLowerCase().trim();

                if (input.equalsIgnoreCase("exit")) {
                    isValid = true;
                    break;
                } else if (input.isEmpty() || input.equals("h") || input.equals("q")) {
                    throw new IllegalArgumentException("Input cannot be empty. Please enter a valid Hexadecimal or Octal number.");
                } else if (!input.matches("^[0-9a-fA-F]+h$") && !input.matches("^[0-7]+q$")) {
                    throw new IllegalArgumentException("Invalid input. Please enter a valid Hexadecimal (0-9, A-F) ending with 'h' or an Octal (0-7) ending with 'q'.");
                } else if (input.endsWith("h")) {
                    binary = hexToBinary(input);
                    System.out.println(binary);
                } else if (input.endsWith("q")) {
                    binary = octalToBinary(input);
                    System.out.println(binary);
                }
                System.out.println("--------------------");
                System.out.print("Press enter to do another conversion.");
                sc.nextLine();
                System.out.println("--------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("--------------------");
                System.out.println(e.getMessage());
                System.out.println("--------------------");
            }
        } while (!isValid);
    }

    /**
     * Converts a Hexadecimal number to Binary.
     *
     * @param hexNumber The Hexadecimal number string.
     * @return A string containing the binary representation and any error
     * messages if invalid characters are found.
     */
    private String hexToBinary(String hexNumber) {
        int i = 0;  // Index for iteration

        // String to store the binary result
        String binaryValue = "";
        // String to store the final result with separators
        String finalBinaryValue = "--------------------\n";
        // Iterate through each character in the Hexadecimal input
        while (i < hexNumber.length() - 1) {
            char c = hexNumber.charAt(i);  // Get the current character

            // Convert the Hexadecimal character to Binary
            switch (c) {
                case '0':
                    binaryValue += " 0000";
                    break;
                case '1':
                    binaryValue += " 0001";
                    break;
                case '2':
                    binaryValue += " 0010";
                    break;
                case '3':
                    binaryValue += " 0011";
                    break;
                case '4':
                    binaryValue += " 0100";
                    break;
                case '5':
                    binaryValue += " 0101";
                    break;
                case '6':
                    binaryValue += " 0110";
                    break;
                case '7':
                    binaryValue += " 0111";
                    break;
                case '8':
                    binaryValue += " 1000";
                    break;
                case '9':
                    binaryValue += " 1001";
                    break;
                case 'a':
                    binaryValue += " 1010";
                    break;
                case 'b':
                    binaryValue += " 1011";
                    break;
                case 'c':
                    binaryValue += " 1100";
                    break;
                case 'd':
                    binaryValue += " 1101";
                    break;
                case 'e':
                    binaryValue += " 1110";
                    break;
                case 'f':
                    binaryValue += " 1111";
                    break;
            }
            i++;  // Increment index
        }
        // Add the 'b' suffix to indicate binary representation
        binaryValue += "b";
        // If valid, display the binary result
        finalBinaryValue += "Binary number:" + binaryValue;
        return finalBinaryValue;  // Return the final result
    }

    /**
     * Converts an Octal number to Binary.
     *
     * @param octalNumber The Octal number string.
     * @return A string containing the binary representation and any error
     * messages if invalid characters are found.
     */
    static String octalToBinary(String octalNumber) {
        int i = 0;  // Index for iteration

        // String to store the binary result
        String binaryValue = "";
        // String to store the final result with separators
        String finalBinaryValue = "--------------------\n";
        // Iterate through the octal string
        while (i < octalNumber.length() - 1) {
            char c = octalNumber.charAt(i);  // Get the current character

            // Convert the Octal character to Binary
            switch (c) {
                case '0':
                    binaryValue += " 000";
                    break;
                case '1':
                    binaryValue += " 001";
                    break;
                case '2':
                    binaryValue += " 010";
                    break;
                case '3':
                    binaryValue += " 011";
                    break;
                case '4':
                    binaryValue += " 100";
                    break;
                case '5':
                    binaryValue += " 101";
                    break;
                case '6':
                    binaryValue += " 110";
                    break;
                case '7':
                    binaryValue += " 111";
                    break;
            }
            i++;  // Increment index
        }

        // Add the 'b' suffix to indicate binary representation
        binaryValue += "b";
        // If valid, display the binary result
        finalBinaryValue += "Binary number:" + binaryValue;
        return finalBinaryValue;  // Return the final result
    }
}
