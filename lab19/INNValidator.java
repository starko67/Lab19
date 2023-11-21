package lab19;
import java.util.Scanner;

public class INNValidator {
    static class InvalidINNException extends Exception {
        InvalidINNException(String message) {
            super(message);
        }
    }

    public static void checkINN(String inn) throws InvalidINNException {
        if (inn == null || (inn.length() != 10 && inn.length() != 12 && inn.matches("\\d+"))) {
            throw new InvalidINNException("Длина ИНН должна быть 10 или 12 цифр");
        }

        if (!inn.matches("\\d+")) {
            throw new InvalidINNException("ИНН должен содержать только цифры");
        }

        if (inn.length() == 10 && !checkINN10Digits(inn)) {
            throw new InvalidINNException("Неверная контрольная сумма для 10-значного ИНН");
        }

        if (inn.length() == 12 && !checkINN12Digits(inn)) {
            throw new InvalidINNException("Неверная контрольная сумма для 12-значного ИНН");
        }
    }

    private static boolean checkINN10Digits(String inn) {
        // Реализация проверки для 10-значного ИНН
        return true; // Ваша реальная реализация
    }

    private static boolean checkINN12Digits(String inn) {
        // Реализация проверки для 12-значного ИНН
        return true; // Ваша реальная реализация
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ИНН: ");
        String userINN = scanner.nextLine();

        try {
            checkINN(userINN); // Проверяем введенный ИНН
            System.out.println("ИНН действителен");
        } catch (InvalidINNException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

