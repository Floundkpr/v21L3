import java.util.Random;
import java.util.Scanner;

public class MyArrays {
    /** * Заполнение массива целыми числами */
    static void FillArray(int[] array){
        Random R = new Random();
        Scanner S = new Scanner(System.in);
        System.out.println("Выберите способ заполнения массива");
        System.out.println("1. Вручную");
        System.out.println("2. Автоматически");
        int x = S.nextInt();
        switch (x) {
            case 1:
                System.out.println("Начните заполнять массив...");
                for (int i = 0; i < array.length; i++) {
                    array[i] = S.nextInt(); }
                break;
            case 2:
                for (int i = 0; i < array.length;i++){
                    array[i] = R.nextInt(10); }
                break;
            default: System.exit(1); }
    }

    /** * Заполнение массива вещественнными числами */
    static void FillArray(double[] array){
        Random R = new Random();
        Scanner S = new Scanner(System.in);
        System.out.println("Выберите способ заполнения массива");
        System.out.println("1. Вручную");
        System.out.println("2. Автоматически");
        int x = S.nextInt();
        switch (x) {
            case 1: System.out.println("Начните заполнять массив...");
                for (int i = 0; i < array.length; i++) {
                    array[i] = S.nextDouble(); }
                break;
            case 2:
                for (int i = 0; i < array.length;i++){
                    array[i] = R.nextDouble() * 10; }
                break;
            default: System.exit(1); }
    }
    /** * Заполнение двумерного массива */
    static void FillArray(int[][] array) {
        Random R = new Random();
        Scanner S = new Scanner(System.in);
        System.out.println("Выберите способ заполнения массива");
        System.out.println("1. Вручную");
        System.out.println("2. Автоматически");
        int x = S.nextInt();
        switch (x) {
            case 1:
                for (int i = 0; i < array.length;i++) {
                    System.out.println("Заполнение " + i + " строки");
                    for(int j = 0; j < array[i].length;j++) {
                        array[i][j] = S.nextInt();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < array.length;i++) {
                    for(int j = 0; j < array[i].length;j++) {
                        array[i][j] = R.nextInt(10);
                    }
                }
                break;
            default: System.exit(1);
        }
    }

    static void PrintArray(int[][] array) {
        for (int i = 0;i < array.length;i++) {
            for (int j = 0;j < array[i].length;j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void PrintArray(int[] array){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    static void PrintArray(double[] array){
        for (int i = 0;i < array.length;i++){
            System.out.printf("%.2f ", array[i]);
        }
        System.out.println();
    }

    //Рекурсивное заполнение массива
    static void RekFillArray(int[] array, int i) {
        Random R = new Random();
        if (i < array.length) {
            array[i] = R.nextInt(10); i++; RekFillArray(array, i);
        }
    }

    //Рекурсивный вывод массива
    static void RekPrintArray(int[] array, int i){
        if (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
            RekPrintArray(array,i);
        }
        else System.out.println();
    }
}