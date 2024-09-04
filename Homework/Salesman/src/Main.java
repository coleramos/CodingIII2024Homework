public class Main { 
    public static void main(String[] args) 
    { 
        Salesman Cole = new Salesman("Blade", 106541);
        Salesman Ben = new Salesman("Ben", 1185600);
        Salesman Abram = new Salesman("Abram", 10944560);
        Salesman Litman = new Salesman("Litman", 3023150);
        Salesman Blade = new Salesman("Blade", 1168401);
        Salesman Locklair = new Salesman("Locklair", 3123450);
        Salesman Wahl = new Salesman("Wahl", 512566700);
        
        Salesman[] Sales = {Cole, Ben, Abram, Litman, Blade, Locklair, Wahl};
        bubbleSort(Sales);
        
        Salesman[] top5 = topFive(Sales);
        
        System.out.println("Top 5 Salesmen:");
        for (Salesman salesman : top5) 
        {
            System.out.println(salesman.display());
        }
    }

    
    public static void bubbleSort(Salesman[] Sales) 
    {
        int S = Sales.length;
        for (int i = 0; i < S - 1; i++) 
        {
            for (int j = 0; j < S - i - 1; j++) 
            {
                if (Sales[j].getRevenue() > Sales[j + 1].getRevenue()) 
                {
                    Salesman temp = Sales[j];
                    Sales[j] = Sales[j + 1];
                    Sales[j + 1] = temp;
                }
            }
        }
    }

    public static Salesman[] topFive(Salesman[] Sales) 
    {
        int topCount = 5; 
        if (Sales.length < 5) 
        {
            topCount = Sales.length; 
        }

        Salesman[] topSalesmen = new Salesman[topCount];
        
        for (int i = 0; i < topCount; i++) 
        {
            topSalesmen[i] = Sales[Sales.length - 1 - i];
        }

        return topSalesmen;
    }
}

class Salesman 
{
    public String Name;
    public int Revenue;

    public Salesman(String n, int r) 
    {
        this.Name = n;
        this.Revenue = r;
    }

    public String getName() 
    {
        return this.Name;
    }

    public int getRevenue() 
    {
        return this.Revenue;
    }

    public String display() 
    {
        return this.Name + ": " + this.Revenue;
    }
}
