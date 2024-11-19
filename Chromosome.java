import java.util.Random;

/*

Chromosome class

Attributes:
- the size of the chromosome
- a boolean array to represent the genes
- a random number generator

Constructor
- takes as arguments the size of the chromosome and a random number generator
- initialises these, and then creates the array, filled with random values

toString
- converts the chromosome into a string of 1s and 0s

Mutate
- pick a random gene and change it

Copy
- create a new chromosome and make it a copy of this one

Fitness
- return a count of the number of times "true" appears in the chromosome


*/

public class Chromosome
{
    //Atributes
    private int size;
    private boolean[] gene;
    private Random generator;

    //Constructor
    public Chromosome(int size, Random generator)
    {
        this.size = size;
        this.generator = generator;
        this.gene = new boolean[size];
        for(int i = 0; i < size; i++)
        {
            this.gene[i] = (generator.nextDouble() < 0.5);
        }
    }

    //toString
    public String toString()
    {
        String result = "";

        for(int i = 0; i < size; i++)
        {
            if(gene[i])
            {
                result = result + "1";
            }
            else
            {
                result = result + "0";
            }
        }
        return result;
    }

    //Mutate
    public void mutate()
    {
        int index = generator.nextInt(size);
        gene[index] = !gene[index];
    }

    //Copy
    //we create empty array of the same size, then copy index for index from this.gene
    public Chromosome copy()
    {
        Chromosome chrom = new Chromosome(size, generator);
        for(int i = 0; i < size; i++)
        {
            chrom.gene[i] = this.gene[i];
        }
        return chrom;
    }

    //Fitness
    //counts the number of '1' or True gene in a Chromosome
    public int fitness()
    {
        int count = 0;
        for(int i = 0; i < size; i++)
        {
            if(gene[i])
            {
                count++;
            }
        }
        return count;
    }
}