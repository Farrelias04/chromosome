import java.util.Random;

public class Week5
{
    public static void main(String[] args)
    {
        Random generator = new Random();
        Chromosome x = new Chromosome(10, generator);

        System.out.println(x);
        System.out.println(x.fitness());
        for(int i = 0; i < 100; i++)
        {
            Chromosome y = x.copy();
            y.mutate();
            if(y.fitness() > x.fitness());
            {
                x = y;
            }
        }
        System.out.println(x);
        System.out.println(x.fitness());
    }
}

