package org.example.option1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество элементов в массиве: ");
        int sizeArray = inputSizeArray(in);

        System.out.println("Введите два числа, задающие диапазон генерации элементов массива:");
        int startRange = 0;
        int endRange = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите первое число: ");
            startRange = inputNumber(in);

            System.out.print("Введите второе число: ");
            endRange = inputNumber(in);

            if (startRange >= endRange) {
                System.out.println("Неверный ввод. Первое число должно быть меньше или равно второму.");
            } else {
                isValid = true;
            }
        }

        int[] array = generateArray(sizeArray, startRange, endRange);
        System.out.print("Сгенерированный массив: ");
        printArray(array);

        int maxNumber = getMaxNumber(array);
        System.out.println("Максимальный элемент: " + maxNumber);

        int minNumber = getMinNumber(array);
        System.out.println("Минимальный элемент: " + minNumber);

        double averageNumber = getAverageNumber(array);
        System.out.println("Средний элемент: " + averageNumber);

        System.out.println("Сортируем массив по возрастанию...");
        sortAscending(array);
        System.out.print("Отсортированный массив по возрастанию: ");
        printArray(array);

        System.out.println("Сортируем массив по убыванию...");
        sortDescending(array);
        System.out.print("Отсортированный массив по убыванию: ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static double getAverageNumber(int[] array) {
        double average = 0;
        for (int j : array) {
            average += j;
        }
        return average / array.length;
    }

    private static double getAverageNumber(double[] array) {
        double average = 0;
        for (double v : array) {
            average += v;
        }
        return average / array.length;
    }

    private static double getMinNumber(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int getMinNumber(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int getMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static double getMaxNumber(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int[] generateArray(int sizeArray, int startRange, int endRange) {
        int[] array = new int[sizeArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (endRange - startRange + 1) + startRange);
        }
        return array;
    }

    private static int inputNumber(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.println("Неверный ввод. Введите целое число.");
            in.next();
        }
        ;
        return in.nextInt();
    }

    private static int inputSizeArray(Scanner in) {
        int sizeArray = 0;
        while (!in.hasNextInt() || (sizeArray = in.nextInt()) <= 0) {
            System.out.println("Неверный ввод. Введите целое число больше нуля.");
            in.next();
        }
        return sizeArray;
    }

    public static void sortAscending(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            while (i >= 0 && array[i] > value) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
    }

    public static void sortDescending(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            while (i >= 0 && array[i] < value) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
    }

    public static void sortAscending(double[] array) {
        for (int left = 0; left < array.length; left++) {
            double value = array[left];
            int i = left - 1;
            while (i >= 0 && array[i] > value) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
    }

    public static void sortDescending(double[] array) {
        for (int left = 0; left < array.length; left++) {
            double value = array[left];
            int i = left - 1;
            while (i >= 0 && array[i] < value) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
    }

    //DRY курит в сторонке
}