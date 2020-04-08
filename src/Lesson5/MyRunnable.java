package Lesson5;
//
public class MyRunnable extends Lesson5 implements Runnable{
    float[] arr;

    public MyRunnable(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        computation(arr);
    }
}
