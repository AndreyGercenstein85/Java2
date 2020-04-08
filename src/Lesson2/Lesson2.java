package Lesson2;

import java.util.Random;

public class Lesson2 {
   // private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //int size = in.nextInt();
        Object[][] map = new Object[4][4];
        try{
            InitArray(map);

        } catch (MyArraySizeException e){
            e.printStackTrace();
            return;
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
            return;
        }

}

    public static void InitArray(Object[][] map) throws MyArraySizeException, MyArrayDataException {
        Random rnd = new Random();
        int sum = 0;
        if (map.length != 4 || map[0].length != 4){
            throw new MyArraySizeException("Массив должен быть размером 4х4");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = (rnd.nextInt(26) + 1); //TRUE
            }
        }
        //map[0][1] = 'a'; FALSE
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                try{
                    sum += (int)(map[i][j]);
                } catch (RuntimeException e){
                    throw new MyArrayDataException("На позиции " + i + "," + j + " тип не int, т.к." + map[i][j]);
                }
            }
        }
        System.out.println("Матрица");
        printArr(map);
        System.out.println("Сумма элементов:" + sum);

    }
    public static void printArr(Object[][] map){
        for (int i = 0; i < map.length; i++, System.out.print("\n")) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print((int)map[i][j]+" ");
            }
        }
    }
}
