import java.math.*;

/**
* Server class which integrates with the main class to hold room parameters in a certain direction.
*
*/
public class Room
{
    /** Name of the portal direction */
    private String direction;
    /** Probability of an open portal */
    private Double openChance;
    /** Probability of an exit portal */
    private Double exitChance;
    /** Probability of encountering magic police */
    private Double policeChance;
    /** Current state of the portal being open */
    private boolean portalState;

    /**
    * Default constructor which creates the object of the class Room.
    *
    */
    public Room()
    {
        direction = "North";
        openChance = 50.00;
        exitChance = 3.00;
        policeChance = 3.00;
        portalState = true;
    }

    /**
    * Non-Default constructor which creates the object of the class Room.
    *
    * @param direction      Accept the direction of the portal as a String.
    * @param openChance     Accepts the probability of an open portal as a double.
    * @param exitChance     Accepts the probability of an exit portal as a double.
    * @param policeChance   Accepts the probability of encountering the magic police as a double.
    * @param portalState    Accepts the state of the portal being open as a boolean.
    */
    public Room(String direction, Double openChance, Double exitChance, Double policeChance, boolean portalState)
    {
        this.direction = direction;
        this.openChance = openChance;
        this.exitChance = exitChance;
        this.policeChance = policeChance;
        this.portalState = portalState;
    }

    /**
    * Display method to print all probabilities associated with the portal.
    *
    * @return       The direction of the current portal as well as all associated probabilities as a String.
    */
    public String displayDirectionProb()
    {
        return direction + ":\t" + "Probability of open portal: " + Math.round(openChance) + "%  " + 
        "Probability of exit portal: " + Math.round(exitChance) + "%  " + "Probability of encountering magic police: " + Math.round(policeChance) + "%";
    }

    /**
    * Accessor method to get the name of the current direction.
    *
    * @return       The name of the current direction as a String.
    */
    public String getDirection()
    {
        return direction;
    }

    /**
    * Accessor method to get the probability of an open portal in the current direction.
    *
    * @return       The probability of an open portal as a double.
    */
    public Double getOpenChance()
    {
        return openChance;
    }

    /**
    * Accessor method to get the probability of an exit portal in the current direction.
    *
    * @return       The probability of an exit portal as a double.
    */
    public Double getExitChance()
    {
        return exitChance;
    }

    /**
    * Accessor method to get the probability of encounter magic police in the current direction.
    *
    * @return       The probability of encountering magic police as a double.
    */
    public Double getPoliceChance()
    {
        return policeChance;
    }

    /**
    * Accessor method to the state of the portal being open.
    *
    * @return       The state of the portal being open as a boolean.
    */
    public boolean getPortalState()
    {
        return portalState;
    }

    /**
    * Mutator method to set name of the direction.
    *
    * @param direction      Name of the direction as a String.
    */
    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    /**
    * Mutator method to set the probability of an open portal in the current direction.
    *
    * @param openChance     The probability of an open portal as a double.
    */
    public void setOpenChance(Double openChance)
    {
        this.openChance = openChance;
    }

    /**
    * Mutator method to set the probability of an exit portal in the current direction.
    *
    * @param exitChance     The probability of an exit portal as a double.
    */
    public void setExitChance(Double exitChance)
    {
        this.exitChance = exitChance;
    }

    /**
    * Mutator method to set the probability of encountering magic police in the current direction.
    *
    * @param policeChance   The probability of encountering magic police as a double.
    */
    public void setPoliceChance(Double policeChance)
    {
        this.policeChance = policeChance;
    }

    /**
    * Mutator method to set the state of the portal being open.
    *
    * @param portalState    The state of the portal being open as a boolean.
    */
    public void setPortalState(boolean portalState)
    {
        this.portalState = portalState;
    }
}  
