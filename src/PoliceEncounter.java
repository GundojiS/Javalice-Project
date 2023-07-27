/**
* Server class which integrates with the main class to hold police encounter parameters
*
*/
public class PoliceEncounter
{
    /** State of the police encounter */
    private boolean policeEncounterState;
    /** Number of coins for a successful bribe */
    private int bribeAmount;

    /**
    * Default constructor which creates the object of the class PoliceEncounter.
    *
    */
    public PoliceEncounter()
    {
        policeEncounterState = false;
        bribeAmount = 0;
    }

    /**
    * Non-Default constructor which creates the object of the class PoliceEncounter.
    *
    * @param policeEncounterState   Accepts the existance of the police encoutner as a boolean.
    * @param bribeAmount            Accepts the number of coins required for a bribe as an integer.
    */
    public PoliceEncounter(boolean policeEncounterState, int bribeAmount)
    {
        this.policeEncounterState = policeEncounterState;
        this.bribeAmount = bribeAmount;
    }

    /**
    * Display method to print the existance of the police encounter and the number of coins required for the bribe.
    *
    */
    public void display()
    {
        System.out.println("Police encounter state is: " + policeEncounterState + ". The current bribe is " + bribeAmount + " coin/s.");
    }

    /**
    * Accessor method to get the existance of the police encounter.
    *
    * @return       The existance of the police encounter as a boolean.
    */
    public boolean getPoliceEncounterState()
    {
        return policeEncounterState;
    }

    /**
    * Accessor method to get the number of coins required for the bribe.
    *
    * @return       The number of coins required for the bribe as an integer.
    */
    public int getBribeAmount()
    {
        return bribeAmount;
    }

    /**
    * Mutator method to set the status of the police encounter.
    *
    * @param policeEncounterState  Existance of the police encounter as a boolean.
    */
    public void setPoliceEncounterState(boolean policeEncounterState)
    {
        this.policeEncounterState = policeEncounterState;
    }

    /**
    * Mutator method to set the number of coins for the bribe.
    *
    * @param bribeAmount            Number of coins for the bribe as an integer.
    */
    public void setBribeAmount(int bribeAmount)
    {
        this.bribeAmount = bribeAmount;
    }
}
