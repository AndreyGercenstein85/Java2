package Lesson1;


public class Lesson1 {
    public static void main(String[] args) {

        Human human = new Human("Hum1", 10, 20);
        System.out.println(human.run(1));
        System.out.println(human.jump(100));
        Cat cat = new Cat("Cat1", 10, 30);
        System.out.println(cat.run(10));
        System.out.println(cat.jump(22));
        Robot robot = new Robot("Robot1", 10, 40);
        System.out.println(robot.run(10));
        System.out.println(robot.jump(20));
        System.out.print(String.format("%40s", " ").replace(" ","*"));
        Marathon m = new Marathon(new Cross(20), new Wall(5));
       // Team team =  new Team("team", new Human("Hum2", 30, 2));
        Team team =  new Team("First team", new Human("Hum2", 30, 2),
                         new Robot("Robot2", 10, 2),
                         new Cat("Cat2",30,10));
        m.doIt(team);
        team.getRuslts();


    }
}
