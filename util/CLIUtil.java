package util;

import java.util.Scanner;
import exception.EmptyInputException;
import exception.InvalidNumberException;

public class CLIUtil {
    private static Scanner sc = new Scanner(System.in);

    public static String readString(String message) throws EmptyInputException {
        System.out.println(message);
        String input = sc.nextLine();
        if(input.trim().isEmpty()) throw new EmptyInputException("Input tdk boleh kosong.");

        return input;
    }

    public static int readInt(String message) throws EmptyInputException, InvalidNumberException {
        String input = readString(message);

        if (!isInteger(input)) throw new InvalidNumberException("Input harus angka bulat.");

        int number = 0;
        int start = 0;
        boolean negative = false;

        if (input.charAt(0) == '-') {
            negative = true;
            start = 1;
        }

        for (int i = start; i < input.length(); i++) {
            number = number * 10 + (input.charAt(i) - '0');
        }

        if (negative) number = -number;

        return number;
    }

    public static double readDouble(String message) throws EmptyInputException, InvalidNumberException {
        String input = readString(message);

        if (!isDouble(input)) throw new InvalidNumberException("Input harus berupa angka.");

        return Double.parseDouble(input);
    }

    private static boolean isInteger(String input) {
        int start = 0;

        if (input.charAt(0) == '-') start = 1;
        if (start == input.length()) return false;

        for (int i = start; i < input.length(); i++) {
            if(input.charAt(i) < '0' || input.charAt(i) > '9') return false;
        }
        return true;
    }

    private static boolean isDouble(String input) {
        int start = 0;
        int dotCount = 0;
        int digitCount = 0;

        if (input.charAt(0) == '-') start = 1;
        if (start == input.length()) return false;

        for (int i = start; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character >= '0' && character <= '9') digitCount++;
            else if (character == '-') {
                dotCount++;
                if (dotCount > 1) return false;
            } else return false;
        }
        return digitCount > 0;
    }
}
