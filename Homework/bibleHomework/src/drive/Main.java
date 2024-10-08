package drive;

public class Main 
{
    public static void main(String[] args) 
    {
        long totalHumans = 7_700_000_000L;
        int initialDisciples = 13;
        int yearsToConvertAll = convertDisciples(totalHumans, initialDisciples);
        int disciplesToTrain = calculateTraining(50);

        System.out.println((yearsToConvertAll) + " years to convert all humans to be disciples.");
        System.out.println((disciplesToTrain) + " should be trained together to make 50 years");
    }

    public static int convertDisciples(long totalHumans, int initialDisciples) 
    {
        int years = 0;
        double disciples = initialDisciples;

        while (disciples < totalHumans) 
        {
            disciples = disciples * 2;
            years = years + 3;
        }

        return years;
    }

    public static int calculateTraining(int years) 
    {
        int disciplesToTrain = 13;
        int yearsTrained = 3;

        while (yearsTrained < years) 
        {
            disciplesToTrain = disciplesToTrain * 2;
            yearsTrained = yearsTrained + 3;
        }

        return disciplesToTrain;
    }
}