package Lesson1;

public interface Competitor {
    String run(int dist);

    String jump(int height);

    boolean isOnDistance();

    String info(String name, String methodName, Object obj, boolean result);
}
