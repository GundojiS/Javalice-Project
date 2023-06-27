import static java.lang.Math.*;
import java.util.*;

/**
* Utility class which integrates with the main class to perform probability calculations
*
*/
public class ProbMod
{
    /**
    * Default constructor which creates the object of the class ProbMod.
    *
    */
    public ProbMod()
    {
        
    }

    /**
    * Iterates a given probability by either increasing or decreasing between 1% to 5% flat.
    *
    * @param probability    Accepts a probability as a double which is to be iterated.
    * @return               The iterated probability as a double.
    */
    public double iterateProb(double probability) 
    {
        Random random = new Random();
        if (random.nextBoolean()) 
        {
            probability = probability + ((Math.random() * (5 - (1))) + (1));
        } 
        else 
        {
            probability = probability - ((Math.random() * (5 - (1))) + (1));
        }
        
        if (probability > 100)
        {
            probability = 100;
        }
        else if (probability < 0)
        {
            probability = 0;
        }
        
        return probability;
    }

    /**
    * Decides whether to proceed or not based on a given probability.
    *
    * @param chance     Accepts a double called chance which represents the chance to proceed as a probability.
    * @return           Return a boolean which is true if rolled a pass to proceed, or false upon failing the roll.
    */
    public boolean decideBasedOnProb(double chance)
    {
        boolean decision = true;
        if ((chance / 100) < (Math.random()))
        {
            decision = false;
        }
        return decision;
    }

    /**
    * Rolls a new item as a String which is returned.
    *
    * @return           The item which is rolled as a String.
    */
    public String iterateItemState() 
    {
        String currentItem = "Coal";
        double randomNumber = Math.random();
        if (randomNumber > 0.7)
        {
            currentItem = "Coins";
        }
        else if (randomNumber > 0.45)
        {
            currentItem = "MagicPoliceAlarm";
        }
        else if (randomNumber > 0.30)
        {
            currentItem = "InvisibilityCloak";
        }
        else
        {
            currentItem = "Coal";
        }
        return currentItem;
    }

    /**
    * Accepts two integers and rolls an integer between the numbers.
    *
    * @param min        The lower bound of the roll as an integer.
    * @param max        The upper bound of the roll as an integer.
    * @return           The number rolled within the bounds as an integer.
    */
    public int getIntBetweenLimits(int min, int max)
    {
        Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }

    /**
    * Iterates the probability of a police encounter by a flat percentage.
    *
    * @param probability    Accepts the current probability of encountering police as a double.
    * @return               The iterated probability as a double.
    */
    public double policeAlarmProbMod(double probability) 
    {
        probability = probability + 3;
        if (probability > 100)
        {
            probability = 100;
        }
        return probability;
    }
}
