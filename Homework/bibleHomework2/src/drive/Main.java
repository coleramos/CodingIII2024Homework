package drive;

public class Main 
{

    public static void main(String[] args) 
    {
        
        long initialDisciples = 13;
        long worldPopulation = 7_700_000_000L;
        int yearsPerGeneration = 30;
        double growthFactor = 2;

        long disciples = initialDisciples;
        int years = 0;

        while (disciples < worldPopulation) 
        {
            disciples *= growthFactor;
            years += yearsPerGeneration;
        }

        System.out.println("It will take " + years + " years for " + initialDisciples + " disciples to make the entire population disciples.");
    }
}

