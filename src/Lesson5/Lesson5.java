package Lesson5;

import java.text.SimpleDateFormat;

public class Lesson5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public  float[] computation(float[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         return arr;
    }

    public  void OneMethod(){
        //1) Создают одномерный длинный массив, например:
        float[] arr = new float[size];
        //2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;
        //3) Засекают время выполнения:
        long a = System.currentTimeMillis();
        //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        computation(arr);
        //5) Проверяется время окончания метода System.currentTimeMillis();
        System.out.printf("Время окончания метода: %d\n", System.currentTimeMillis());
        //6)В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
        System.out.printf("Время работы первого метода: %d\n", (System.currentTimeMillis() - a));


    }
    public  void TwoMethod() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr.length ; i++)
            arr[i] = 1;
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread task1 = new Thread(new MyRunnable(a1));
        Thread task2 = new Thread(new MyRunnable(a2));

        task1.run();
        task2.run();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Время работы второго метода: %d\n", (System.currentTimeMillis() - a));
    }

    public static void main(String[] args) {
        Lesson5 task = new Lesson5();
        task.OneMethod();
        task.TwoMethod();
    }
}
