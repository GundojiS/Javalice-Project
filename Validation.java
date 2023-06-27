/**
* Utility class which integrates with the main class to perform input validation
*
*/
public class Validation
{
    /**
    * Default constructor which creates the object of the class Validation.
    *
    */
    public Validation()
    {
        
    }

    /**
    * Method to assess whether a String input is blank or not.
    *
    * @param value      Input to be assessed as a String.
    * @return           Return a true boolean if value is blank, and false if it isn't blank.
    */
    public boolean isBlank(String value)
    {
        boolean blank = false;
        if (value.trim().length() == 0)
        {
            blank = true;
        }
        return blank;
    }

    /**
    * Method to assess whether a string failed to fall within a given character range.
    *
    * @param value      Input to be assessed as a String.
    * @param min        Lower bound of the character range.
    * @param max        Upper bound of the character range.
    * @return           Return a true boolean if value doesn't fall within range, and false if it does.
    */
    public boolean lengthNotWithinRange(String value, int min, int max)
    {
        boolean range = true;
        if ((value.trim().length() >= min) && (value.trim().length() <= max))
        {
            range = false;
        }
        return range;
    }
}
