import java.util.Scanner;

class MyClass {
    private static Scanner scanner = new Scanner(System.in); //Экземпляр класса Scanner для ввода значений

    //Заполнение одномерного целочисленного массива вручную
    private static void fillArrayManual (int[] input){
        System.out.println("Введите элементы массива");
        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }
    }

    //Заполнение одномерного целочисленного массива рандомом
    private static void fillArrayRandom (int[] input){
        System.out.println("Введите элементы массива");
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 100);
        }
    }

    //Вывод одномерного целочисленного массива
    private static void outArray (int[] input){
        for (int i1 : input) {
            System.out.print(i1 + " ");
        }
    }


    static void a1(){
        System.out.println("Даны натуральное число n и массив x вещественных чисел. (n >= 4, n –кратно четырём). \n" +
                "Вычислить сумму y = x(1)*x(2)*x(3)*x(4) + x(5)*x(6)*x(7)*x(8) +...+ x(n-3)*x(n-2)*x(n-1)*x(n).\n" +
                "Среди слагаемых этой суммы найти минимальное слагаемое.");
        System.out.print("Введите n  ");
        int n;
        while (true){
            n = scanner.nextInt();
            if (n % 4 == 0 && n > 3) break;
            System.out.print("Число не соответствует требованиям. Повторите попытку  ");
        }

        double[] array = new double[n];                             //создание массива размером n
        double minProd = Double.POSITIVE_INFINITY;                  // переменная для хранения минимального слагаемого
        double prod = 1;                                            // произведение 4х элементов
        double sum = 0;                                             // общая сумма

        System.out.println("Введите " + n + " элементов массива");
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextDouble();                        // ввод массива
            prod *= array[i];                                       //умножение очередного элемента
            if ((i + 1) % 4 == 0) {                                 //если это элемент, по счёту кратный 4
                if (prod < minProd) {                               //и он меньше записанного минимума
                    minProd = prod;                                 //записать его как минимальный
                }
                sum += prod;                                        //прибавить к общей сумме
                prod = 1;                                           //и обнулить произведение
            }
        }
        System.out.println("Сумма y = x(1)*x(2)*x(3)*x(4) + x(5)*x(6)*x(7)*x(8) +...+ x(n-3)*x(n-2)*x(n-1)*x(n) = " + sum);
        System.out.println("Минимальное слагаеиое = " + minProd);
    }


    static void a2(){
        System.out.println("Даны натуральное число n и вещественный массив из n чисел.\n" +
                "Поместить нулевые элементы в начало массива, затем разместить все остальные элементы, " +
                "изменив порядок следования у ненулевых элементов на обратный.\n" +
                "Вспомогательный массив не использовать.");
        System.out.print("Введите n  ");
        int n = scanner.nextInt();                  //считывние размера массива
        double[] array = new  double[n];            //создание массива размером n
        int numOfZeros = 0;                         //счётчик нулей

        System.out.println("Введите " + n + " элементов массива");
        for (int i = 0; i < n; i++){
            array[i] = scanner.nextDouble();        //считывание элементов массива
            if(array[i] == 0)   numOfZeros++;       //посчет 0
        }

        for (int i = 0; i < numOfZeros; i++) {      //цикл для перемещения каждого нуля
            for (int j = 0; j < n; j++) {           //цикл для нахождения нуля и его смещения
                if (array[j] == 0 && j > i) {       //если текущий элемент массива это 0 и он не на своём месте
                    for (int k = j; k > i; k--) {   //переместить его в начало. Цикл проходит он текущего индекса к началу

                        double temp = array[k];     //смена местами двух элементов
                        array[k] = array[k - 1];
                        array[k - 1] = temp;
                    }
                }
            }
        }

        for (int i = numOfZeros, j = 0; j < (n - numOfZeros) / 2; i++, j++) {   //рзаворот элементов начиная с первого ненулевого
            double temp = array[i];                                             //смена местами двух элементов:
            array[i] = array[n - j - 1];                                        //текущий
            array[n - j - 1] = temp;                                            //и симметричный ему с конца
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");       //вывод измененного массива
        }
        System.out.println();
    }


    static void a3(){
        System.out.println("Даны натуральное число n и вещественный массив из n элементов. " +
                "Сдвинуть элементы массива на k позиций влево.\n" +
                "Примечание. При сдвиге элементов массива на " +
                "k позиций влево освободившиеся k последних элемента заполнить нулями.");
        System.out.print("Введите n  ");
        int n = scanner.nextInt();
        System.out.print("Введите значение, на которое необходимо сдвинуть массив  ");
        int k = scanner.nextInt();             //Заданное значение
        double[] array = new double[n];

        System.out.println("Введите " + n + " элементов массива");
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();           //Считывание элементов массива
        }

        for (int i = n - 1; i > -1; i--) {              //если текущее значение маньше смещения заменить его на 0
            array[i] = i < k ? 0 : array[i - k];        //иначе записать значение которое стоит на k позиций раньше
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");       //вывод измененного массива
        }
        System.out.println();
    }


    static void a4() {
        System.out.println("Даны натуральное число n и целочисленный массив a из n элементов. " +
                "Все чётные элементы массива a поместить в массив b, а нечётные – в массив c.\n" +
                "Подсчитать количество тех и других.");
        System.out.print("Введите n  ");
        int n = scanner.nextInt();
        int[] array_a = new int[n];                                   //массив а
        int countOfOdd = 0, countOfEven = 0;

        System.out.println("Введите " + n + " элементов массива");
        for (int i = 0; i < n; i++){
            array_a[i] = scanner.nextInt();      //Заполнение массива
            if (array_a[i] % 2 == 0) countOfEven++; //если чётное то увеличить счётчик четных
            else countOfOdd++;                      //иначе увеличить число нечётных
        }

        int[] array_b = new int[countOfEven];
        int[] array_c = new int[countOfOdd];
        int k = 0, z = 0;

        for (int i = 0; i < n; i++){
            if (array_a[i] % 2 == 0) {      //если чётное
                array_b[k] = array_a[i];    //запись в массив чётных
                k++;                        //и увеличение индекса этого массива
            }
            else {                          //иначе
                array_c[z] = array_a[i];    //запись в массив нечётных
                z++;                        //и увеличение индекса этого массива
            }
        }

        System.out.println("Число чётных = " + countOfEven);
        for (int i = 0; i < countOfEven; i++) System.out.print(array_b[i] + " ");     //Вывод b
        System.out.println();
        System.out.println("Число нечётных = " + countOfOdd);
        for (int i = 0; i < countOfOdd; i++) System.out.print(array_c[i] + " ");     //Вывод c
        System.out.println();
    }


    static void b1(){
        System.out.println("Вычислить среднее арифметическое элементов, " +
                            "расположенных ниже побочной и выше главной диагоналей.");
        System.out.print("Введите n  ");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];                                          //Обьявление двумерного целочисленного массива
        int count = 0;
        int sum = 0;

        System.out.println("Введите " + n*n + " элементов массива");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                array[i][j] = scanner.nextInt();    //Считывание элемента массива
                if (i < j && i + j == n){           //Если елемент на нужной позиции
                    sum += array[i][j];             //Увеличение суммы элементов
                    count++;                        //Увеличение счётчика
                }
            }
        }

        if (count > 0) System.out.println(sum / count);
        else System.out.println("Таких элементов нет.");
    }


    static void b2(){
        System.out.println("Повернуть матрицу на 90 градусов влево.");
        System.out.print("Введите n  ");
        int n = scanner.nextInt();
        int[][] array_a = new int[n][n];
        int[][] array_b = new int[n][n];
        System.out.println("Введите " + n*n + " элементов массива");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                array_a[i][j] = scanner.nextInt();                                            //Заполнение массива
            }
        }
        for (int i = n - 1, z = 0; i > -1; i--, z++){
            for (int j = 0; j < n; j++){
                array_b[z][j] = array_a[j][i];                                                 //Поворот массива
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array_b[i][j] + " ");                    //Вывод массива
            }
            System.out.println();
        }
    }
}