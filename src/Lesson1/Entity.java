package Lesson1;

public class Entity implements Competitor{
    private  String name;

    private int maxRunDistance;
    private int maxJumpHeigth;
    private boolean onDistance;


    public Entity(String name, int maxRunDistance, int maxJumpHeigth) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeigth = maxJumpHeigth;
        this.onDistance = true;
    }


    @Override
    public String run(int dist) {
        if(dist <= maxRunDistance) {
            return info(this.name, "run", this, onDistance);
        } else {
            onDistance = false;
            return info(this.name, "run", this, onDistance);
        }
    }


    @Override
    public String jump(int height) {
        if(height <= maxJumpHeigth){
            return info(this.name,"jump", this, onDistance);
        } else {
            onDistance = false;
            return info(this.name,"jump", this, onDistance);
        }

    }

    @Override
    public boolean isOnDistance() {
        return false;
    }

    @Override
    public String info(String name, String methodName, Object obj, boolean result)  {
        return name + ": " + obj.getClass().getName() + " : " + methodName + " : " + result;
    }

}
