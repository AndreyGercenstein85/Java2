package Lesson1;

public class Marathon {
    private Obstacle[] obstacles;

    public Marathon(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    void doIt(Team team){
        Competitor[] competitors = team.getCompetitors();
        if(competitors.length == 0){
            System.out.println("Team is empty");
        } else{
            for ( Competitor c: competitors) {
                for(Obstacle o : obstacles){
                    team.setResults(o.doit(c));
                    if(c.isOnDistance()){
                        break;
                    }
                }
            }
        }
    }


}
