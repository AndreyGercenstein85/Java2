package Lesson1;

public class Team {
    private String name;
    private Competitor[] competitors;
    private StringBuilder results;

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
        this.results = new StringBuilder();
    }

    public void setResults(String result){
        results.append(result).append("\n");
    }

    public String getName(){
        return name;
    }

    public Competitor[] getCompetitors(){
        return competitors;
    }

    public void getRuslts(){
        System.out.println();
        System.out.println("Result Marathon " + name );
        System.out.println(String.format("%40s", " ").replace(" ","*"));
        System.out.println(results);
    }
}
