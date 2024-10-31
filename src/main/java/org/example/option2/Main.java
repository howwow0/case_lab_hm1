package org.example.option2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Поддерживаемые операции:");
        System.out.println("Сложение (+), Вычитание (-), Умножение (*), Деление (/)");
        System.out.println("Целочисленное деление (//), Возведение в степень (^), Остаток от деления (%)");
        System.out.println("Введите \"exit\" для завершения работы программы.");

        while (true) {
            System.out.print("Введите выражение (например, 5 + 3) или \"exit\" для выхода: ");
            String input = scanner.nextLine();

            // Проверка на выход из программы
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            // Разделение строки ввода на операнды и оператор
            String[] operators = input.split(" ");
            if (!isValidExpression(operators)) {
                System.out.println("Неверный ввод. Попробуйте снова.");
                continue;
            }

            try {
                //У нас всего 3 элемента в массиве: число 1, оператор, число 2
                double a = Double.parseDouble(operators[0]);
                String operator = operators[1];
                double b = Double.parseDouble(operators[2]);

                // Выполнение операции в зависимости от оператора
                switch (operator) {
                    case "+":
                        System.out.println("Результат: " + sum(a, b));
                        break;
                    case "-":
                        System.out.println("Результат: " + subtract(a, b));
                        break;
                    case "*":
                        System.out.println("Результат: " + multiply(a, b));
                        break;
                    case "/":
                        if (b == 0) {
                            System.out.println("Ошибка: деление на ноль невозможно.");
                        } else {
                            System.out.println("Результат: " + divide(a, b));
                        }
                        break;
                    case "//":
                        if (b == 0) {
                            System.out.println("Ошибка: целочисленное деление на ноль невозможно.");
                        } else {
                            System.out.println("Результат: " + intDivide((int) a, (int) b));
                        }
                        break;
                    case "^":
                        System.out.println("Результат: " + power(a, b));
                        break;
                    case "%":
                        if (b == 0) {
                            System.out.println("Ошибка: деление на ноль невозможно.");
                        } else {
                            System.out.println("Результат: " + modulus(a, b));
                        }
                        break;
                        //Поддерживаемого оператора нет. Выводим ошибку
                    default:
                        System.out.println("Некорректный оператор. Попробуйте снова.");
                }
                //Исключение выбрасывается при ошибки парсинга (допустим букв в число)
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введены некорректные числа. Попробуйте снова.");
            }
        }

    }

    // Проверка на корректность выражения
    public static boolean isValidExpression(String[] operators) {
        return operators.length == 3 && "+-*/%^//".contains(operators[1]);
    }

    // Операция сложения
    public static double sum(double a, double b) {
        return a + b;
    }

    // Операция вычитания
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Операция умножения
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Операция деления
    public static double divide(double a, double b) {
        return a / b;
    }

    // Операция целочисленного деления
    public static int intDivide(int a, int b) {
        return a / b;
    }

    // Операция возведения в степень
    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Операция остатка от деления
    public static double modulus(double a, double b) {
        return a % b;
    }
}