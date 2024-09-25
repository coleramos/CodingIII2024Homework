package drive;

public class Main
{
    public static int fibonacci(int n)
    {
        if (n <= 1) return n;
        int a = 0; 
        int b = 1; 
        int c = 0; 
        int steps = 0; 
        
        for (int i = 2; i <= n; i++)
        {
            c = a + b; 
            a = b;     
            b = c;     
            steps++;   
        }
        System.out.println("Steps taken to compute Fibonacci of " + n + ": " + steps);
        return c; 
    }
    public static void main(String[] args) 
    {
        int n = 15; 
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}


