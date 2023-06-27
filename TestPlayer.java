/**
* Testing class which is a duplicate of Player.java to run a test strategy on and document results.  
*
*/
public class TestPlayer
{
    /** Player's name */
    private String name;
    /** Number of coins */
    private int coins;
    /** Number of cloaks */
    private int cloaks;
    /** Number of pieces of coal*/
    private int coal;
    /** Number of jumps */
    private int jumps;
    /** Result of the game */
    private String result;
    /** Status of being in jail */
    private boolean inJail;
    /** Option of portals available */
    private String portalOptions;
    /** Index of current direction */
    private int currentDirection;

    /**
    * Default constructor which creates the object of the class Player.
    *
    */
    public TestPlayer()
    {
        name = "Unknown";
        coins = 10;
        cloaks = 0;
        coal = 0;
        jumps = 3;
        result = "Unknown";
        inJail = false;
        portalOptions = "";
        currentDirection = 0;
    }

    /**
    * Non-Default constructor which creates the object of the class Player.
    *
    * @param name               Accepts the name of the player as a String.
    * @param coins              Accepts the number of coins as an integer.
    * @param cloaks             Accepts the number of cloaks as an integer.
    * @param coal               Accepts the number of coal as an integer.
    * @param jumps              Accepts the number of jumps as an integer.
    * @param result             Accepts the result of the game as a String.
    * @param inJail             Accepts the state of being in jail as a boolean.
    * @param portalOptions      Accepts the range of portal options as a String.
    * @param currentDirection   Accepts the index of the current direction as an integer.
    */
    public TestPlayer(String name, int coins, int cloaks, int coal, int jumps, String result, boolean inJail, String portalOptions, int currentDirection)
    {
        this.name = name;
        this.coins = coins;
        this.cloaks = cloaks;
        this.coal = coal;
        this.jumps = jumps;
        this.result = result;
        this.inJail = inJail;
        this.portalOptions = portalOptions;
        this.currentDirection = currentDirection;
    }

    /**
    * Display method to print outcome of the match including player details and final inventory.
    *
    */
    public void display()
    {
        System.out.println("Name: " + name + "\tResult: " + result + "\n\nInventory\nCoins: " + coins + "\nCloaks: "
            + cloaks + "\nJumps: " + jumps + "\nCoal: " + coal + "\nResult: " + result + "\nIn jail: " + inJail 
            + "\nPortal Options: " + portalOptions + "\nIndex of current direction: " + currentDirection + "\n");
    }

    /**
    * Accessor method to get the name of the player.
    *
    * @return       The name of the player as a String 
    */
    public String getName()
    {
        return name;
    }

    /**
    * Accessor method to get the number of coins.
    *
    * @return       The number of coins as an integer. 
    */
    public int getCoins()
    {
        return coins;
    }

    /**
    * Accessor method to get the number of cloaks.
    *
    * @return       The number of cloaks as an integer. 
    */
    public int getCloaks()
    {
        return cloaks;
    }
    
    /**
    * Accessor method to get the number of coal pieces.
    *
    * @return       The number of coal pieces as an integer. 
    */
    public int getCoal()
    {
        return coal;
    }

    /**
    * Accessor method to get the number of jumps.
    *
    * @return       The number of jumps as an integer. 
    */
    public int getJumps()
    {
        return jumps;
    }

    /**
    * Accessor method to get the result of the game.
    *
    * @return       The outcome of the game as a String. 
    */
    public String getResult()
    {
        return result;
    }

    /**
    * Accessor method to get the status of being in jail.
    *
    * @return       The status of being in jail or not with a boolean i.e. true is in jail, false is not in jail. 
    */
    public boolean getInJail()
    {
        return inJail;
    }

    /**
    * Accessor method to get choice of portals available to the user.
    *
    * @return       A list of portals available to the user as a String. 
    */
    public String getPortalOptions()
    {
        return portalOptions;
    }

    /**
    * Accessor method to get the index of the current direction.
    *
    * @return       The index of the current direction represented as an integer.
    */
    public int getCurrentDirection()
    {
        return currentDirection;
    }

    /**
    * Mutator method to set the player's name.
    *
    * @param name               The player's name as a String.
    */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
    * Mutator method to set the number of coins.
    *
    * @param coins              The number of coins as an integer.
    */
    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    /**
    * Mutator method to set the number of cloaks.
    *
    * @param cloaks             The number of cloaks as an integer.
    */
    public void setCloaks(int cloaks)
    {
        this.cloaks = cloaks;
    }

    /**
    * Mutator method to set the number of coal pieces.
    *
    * @param coal               The number of coal pieces as an integer.
    */
    public void setCoal(int coal)
    {
        this.coal = coal;
    }

    /**
    * Mutator method to set the number of jumps.
    *
    * @param jumps              The number of jumps as an integer.
    */
    public void setJumps(int jumps)
    {
        this.jumps = jumps;
    }

    /**
    * Mutator method to set the result of the game.
    *
    * @param result             The result of the game as a String.
    */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
    * Mutator method to status of being in jail.
    *
    * @param inJail             The status of being in jail as a boolean where true is in jail and false is not.
    */
    public void setInJail(boolean inJail)
    {
        this.inJail = inJail;
    }

    /**
    * Mutator method to set the option of portals available to the user.
    *
    * @param portalOptions      The option of portals avaliable as a String.
    */
    public void setPortalOptions(String portalOptions)
    {
        this.portalOptions = portalOptions;
    }

    /**
    * Mutator method to set the index of the current direction.
    *
    * @param currentDirection   The index of the current direction as an integer.
    */
    public void setCurrentDirection(int currentDirection)
    {
        this.currentDirection = currentDirection;
    }

    /**
    * Method to start the testing program.
    *
    * @param args          An array of Strings representing command line arguments.
    */
    public static void main(String[] args)
    {
        TestPlayer player = new TestPlayer();
        TestPlayer validPlayer = new TestPlayer("Doji", 10, 0, 0, 3, "Win", false, "No Options", 0);
        TestPlayer invalidPlayer = new TestPlayer("This name here is too long", -10, -1, -1, -1, "Draw", false, "", -1);

        /*player.display();
        validPlayer.display();
        invalidPlayer.display();
        
        System.out.println(validPlayer.getName());
        System.out.println(invalidPlayer.getName());

        System.out.println(validPlayer.getCloaks());
        System.out.println(invalidPlayer.getCloaks());

        System.out.println(validPlayer.getCoal());
        System.out.println(invalidPlayer.getCoal());

        System.out.println(validPlayer.getJumps());
        System.out.println(invalidPlayer.getJumps());

        System.out.println(validPlayer.getResult());
        System.out.println(invalidPlayer.getResult());

        System.out.println(validPlayer.getInJail());
        System.out.println(invalidPlayer.getInJail());

        System.out.println(validPlayer.getPortalOptions());
        System.out.println(invalidPlayer.getPortalOptions());

        System.out.println(validPlayer.getCurrentDirection());
        System.out.println(invalidPlayer.getCurrentDirection());*/

        //player.setName(1001);
        //player.setCoins("three");
        //player.setCloaks("three");
        //player.setCoal("three");
        //player.setJumps("three");
        //player.setInJail(false);
        //player.setPortalOptions("Negative Options")
        //player.setCurrentDirection(-1);
    }
}
