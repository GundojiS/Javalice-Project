import java.util.Scanner;
import java.util.ArrayList;

/**
* Main class of the program which interacts with the server and utility classes
*
* @author Swapnil Gundoji
* @version ver1.0.0
*/
public class Game
{
    /** Arraylist of objects in the class Room */
    private ArrayList<Room> room;
    /** Object of the class Player */
    private Player player;
    /** Object of the class Items */
    private Items items;
    /** Object of the class PoliceEncounter */
    private PoliceEncounter policeEncounter;
    /** Constant of the file name to be read */
    private final String inputFile = "exits.txt";
    /** Constant of the file name to write to */
    private final String outputFile = "output.txt";

    /**
    * Default constructor which creates the object of the class Game.
    *
    */
    public Game()
    {
        player = new Player();
        items = new Items();
        policeEncounter = new PoliceEncounter();
        room = new ArrayList<Room>();
    }

    /**
    * Non-Default constructor which creates the object of the class Game.
    *
    * @param player            Accepts the default or non-default constructor as the parameter of Player.
    * @param items             Accepts the default or non-default constructor as the parameter of Items.
    * @param policeEncounter   Accepts the default or non-default constructor as the parameter of Items.
    */
    public Game(Player player, Items items, PoliceEncounter policeEncounter)
    {
        this.player = player;
        this.items = items;
        this.policeEncounter = policeEncounter;
        room = new ArrayList<Room>();
    }

    /**
    * Mutator method to input the player's name.
    *
    */
    public void inputPlayerDetails()
    {
        Input input = new Input();
        Validation valid = new Validation();
        String name = "Unknown";
        while (player.getName() == "Unknown")
        {
            name = input.acceptStringInput("Please enter the player's name.");
            if (valid.isBlank(name))
            {
                System.out.println("Name can't be blank.");
            }
            else if (valid.lengthNotWithinRange(name, 3, 12))
            {
                System.out.println("Name must be between 3 and 12 characters.");
            }
            else
            {
                player.setName(name);
                System.out.println("Player details set");
            }
        }
    }

    /**
    * Accessor method to get the portal direction.
    *
    * @param location      An integer used to index the required portal direction.
    * @return              The portal direction as a String.
    */
    public String getDirection(int location)
    {
        return (room.get(location)).getDirection();
    }

    /**
    * Accessor method to check if a portal is open or closed.
    *
    * @param location      An integer used to index the required portal direction.
    * @return              The state of the portal as a boolean. True is an open portal, false is a closed portal.
    */
    public boolean getDirectionPortalState(int location)
    {
        return (room.get(location)).getPortalState();
    }

    /**
    * Mutator method to set a portal open or closed.
    *
    * @param location      An integer used to index the required portal direction.
    * @param portalState   The state of the portal as a boolean. True is an open portal, false is a closed portal.
    */
    public void setDirectionPortalState(int location, boolean portalState)
    {
        (room.get(location)).setPortalState(portalState);
    }

    /**
    * Prompts user to press enter to proceed.
    *
    * @param message       Message to the user before they proceed, as a String.
    */
    public void promptEnterKey(String message)
    {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    /**
    * Mutator method to read exits.txt file to initialize values for the room.
    *
    */
    private void readFile()
    {
        FileIO io = new FileIO(inputFile);
        
        String[] input = io.readFile().split("\\n");
        if (input.length <= 0)
        {
            promptEnterKey("The file exits.txt may not be blank. Press \"ENTER\" to exit...");
            System.exit(0);
        }
        for (int i = 0; i < input.length; i++)
        {
            String[] userInput = input[i].split(",");
            
            if (userInput.length != 4)
            {
                promptEnterKey("The file exits.txt must consist of a Direction as a String and 3 percentages written as numbers between " +
                    "0 and 100, all delimited by commas.\ne.g. North, 60, 3, 3 Press \"ENTER\" to exit...");
                System.exit(0);
            }
            for (int y = 0; y <= 3; y++)
            {
                if (userInput[y].trim().equals(""))
                {
                    promptEnterKey("Direction or percentage values in exits.txt file cannot be blank. Press \"ENTER\" to exit...");
                    System.exit(0);
                }
            }
            
            for (int x = 1; x <= 3; x++)
            {
                if (Double.parseDouble(userInput[x]) > 100 || Double.parseDouble(userInput[x]) < 0)
                {
                    promptEnterKey("Percentages within exits.txt must be a number between 0 and 100. Press \"ENTER\" to exit...");
                    System.exit(0);
                }
            }
            Room cardinalDirection = new Room(userInput[0], Double.parseDouble(userInput[1]), Double.parseDouble(userInput[2]),
                Double.parseDouble(userInput[3]), true);
            room.add(cardinalDirection);
        }
    }

    /**
    * Writes the outcome of the game with player information into a file, output.txt
    *
    */
    private void writeFile()
    {
        String temp = "";
        StringBuffer buffer = new StringBuffer(temp);
        buffer.append("Name: " + player.getName() + "\tResult: " + player.getResult() + "\n\nInventory\nCoins: " + player.getCoins() + 
            "\nCloaks: " + player.getCloaks() + "\nJumps: " + player.getJumps() + "\nCoal: " + player.getCoal());
        FileIO io = new FileIO(outputFile);
        io.writeFile(buffer.toString());
    }

    /**
    * Display method to print the player's current status.
    *
    */
    public void display()
    {
        System.out.println("--------------------\nPlayer Name: " + player.getName() + "  Coins: " + player.getCoins() 
            + "  Invisibility cloaks: " + player.getCloaks() + "  Jumps available: " + player.getJumps());
    }

    /**
    * Mutator method to iterate the portal status of a new room.
    *
    */
    public void randomisePortals()
    {
        ProbMod probMod = new ProbMod();
        for (int i = 0; i < room.size(); i++) 
        {
            setDirectionPortalState(i, true);
        } 
        player.setPortalOptions("");
        player.setCurrentDirection(-1);
        for (int cardinalPoint = 0; cardinalPoint < room.size(); cardinalPoint++)
        {
            if (probMod.decideBasedOnProb((room.get(cardinalPoint)).getOpenChance()))
            {
                player.setPortalOptions((player.getPortalOptions() + (room.get(cardinalPoint)).displayDirectionProb()) + "\n");
            }
            else
            {
                setDirectionPortalState(cardinalPoint, false);
            }
        }
    }

    /**
    * Mutator method to accept player input to move in a valid direction.
    *
    */
    public void playerChoosesDirection()
    {
        System.out.println("\nPortal options are:\n" + player.getPortalOptions());
        while (player.getCurrentDirection() == -1)
        {
            System.out.println("\nChoose which direction to go!");
            Scanner console = new Scanner(System.in);
            String userDirection = console.nextLine();
            userDirection = userDirection.trim().toLowerCase();
            for (int i = 0; i < room.size(); i++)
            {
                if (userDirection.equals(getDirection(i).trim().toLowerCase()))
                {
                    if (getDirectionPortalState(i))
                    {
                        player.setCurrentDirection(i);
                    }
                    else 
                    {
                        System.out.println(getDirection(i) + " portal is closed.");
                    }
                }
            }
            if (player.getCurrentDirection() == -1)
            {
                System.out.println("\nInvalid Direction. Please try again.");
            }
        }
    }

    /**
    * Mutator method prepare encounters for a chosen room.
    *
    */
    public void prepareChosenRoom()
    {
        ProbMod probMod = new ProbMod();
        Input input = new Input();
        System.out.println("\nGoing " + (room.get(player.getCurrentDirection())).getDirection() + "!");
        policeEncounter.setPoliceEncounterState(probMod.decideBasedOnProb((room.get(player.getCurrentDirection())).getPoliceChance()));
        items.setMagicBoxState(probMod.decideBasedOnProb(50));
        items.setItemState(probMod.iterateItemState());
        input.promptEnterKey();
    }

    /**
    * Performs an encounter with the magic box.
    *
    */
    public void checkMagicBox()
    {
        Input userInput = new Input();
        ProbMod probMod = new ProbMod();
        int newcoins = 0;
        if (items.getMagicBoxState())
        {
            if (userInput.yesOrNo("You found a magic box! Would you like to open it Yes / No?")) //////HERE
            {
                switch (items.getItemState())
                {
                    case "Coins":
                        if (userInput.yesOrNo("\nYou found coins! Would you like to take them? Yes / No"))
                        {
                            newcoins = probMod.getIntBetweenLimits(10, 35);
                            player.setCoins(player.getCoins() + newcoins);
                            System.out.println("\nThe box contained " + newcoins + " coins!");
                            System.out.println("You now have a total of " + player.getCoins() + " coins.");
                        }
                        break;
                    case "MagicPoliceAlarm":
                        System.out.println("\nIt's a trap! Alarm raised!" + 
                            " The chance of meeting magic police is increasing in all directions!");
                        for (int i = 0; i < room.size(); i++)
                        {
                            (room.get(i)).setPoliceChance(probMod.policeAlarmProbMod((room.get(i)).getPoliceChance()));
                        }
                        break;
                    case "InvisibilityCloak":
                        if (userInput.yesOrNo("\nYou found an invisibility cloak! Would you like to take it? Yes / No"))
                        {
                            player.setCloaks(player.getCloaks() + 1);
                            if (player.getCloaks() > 3)
                            {
                                player.setCloaks(3);
                            }
                            System.out.println("\nYou now have " + player.getCloaks() + " cloak/s.");  
                        }     
                        break;
                    case "Coal":
                        if (userInput.yesOrNo("\nYou found coal! It does nothing! Would you like to take it? Yes / No"))
                        {
                            player.setCoal(player.getCoal() + 1);
                        }
                        break;
                }
            }
            userInput.promptEnterKey();
        }
        else
        {
        System.out.println("You don't find anything inside...");
        userInput.promptEnterKey(); 
        }
    }

    /**
    * Performs an encounter with the Magic Police.
    *
    */
    public void checkPoliceEncounter()
    {
        ProbMod probMod = new ProbMod();
        if (policeEncounter.getPoliceEncounterState())
        {
            Input encounterInput = new Input();
            Boolean cloakUsage = false;
            Boolean successfulBribe = false;
            System.out.println("You run into the magic police!");
            if (player.getCloaks() > 0)
            {
                if (encounterInput.yesOrNo("\nYou have " + player.getCloaks() + " cloak/s. Would you like to use one to escape? Yes / No"))
                {
                    player.setCloaks(player.getCloaks() - 1);
                    System.out.println("You escape the magic police and have " + player.getCloaks() + " cloak/s remaining!");
                    cloakUsage = true;
                    encounterInput.promptEnterKey();
                }
                else
                {
                    System.out.println("Cloak isn't used. Let's risk it!");
                    encounterInput.promptEnterKey();
                }
            }
            if (cloakUsage == false)
            {
                if (encounterInput.yesOrNo("\nYou currently have " + player.getCoins() + " coins." 
                    + " Will you attempt to bribe the police? Yes / No"))
                {
                    if (player.getCoins() % 2 == 0)
                    {
                        policeEncounter.setBribeAmount(probMod.getIntBetweenLimits(player.getCoins() / 2, player.getCoins() 
                            + (player.getCoins() / 2)));
                    }
                    else
                    {
                        policeEncounter.setBribeAmount(probMod.getIntBetweenLimits((player.getCoins() + 1) / 2, player.getCoins() + 
                            ((player.getCoins() + 1) / 2)));
                    }

                    if (player.getCoins() > 0 && player.getCoins() >= policeEncounter.getBribeAmount())
                    {
                        player.setCoins(player.getCoins() - policeEncounter.getBribeAmount());
                        System.out.println("\nThe police requested " + policeEncounter.getBribeAmount() + 
                            " coins and you paid it successfully. \nYou currently have " + player.getCoins() + " coins remaining.");
                        encounterInput.promptEnterKey();
                        successfulBribe = true;
                    }
                    else
                    {
                        System.out.println("\nThe police requested a bribe that you couldn't afford.\nYou've been thrown into jail...");
                        player.setInJail(true);
                        encounterInput.promptEnterKey();
                    }
                }
                else
                {
                    System.out.println("You chose not to pay the bribe and have been thrown into jail...");
                    player.setInJail(true);
                    encounterInput.promptEnterKey();
                }
            }                        
        }
    }

    /**
    * Iterates the exit and police chance probabilities of current room.
    *
    */
    public void iterateCurrentPortalProb()
    {
        ProbMod probMod = new ProbMod();
        (room.get(player.getCurrentDirection())).setExitChance(probMod.iterateProb((room.get(player.getCurrentDirection())).getExitChance()));
        (room.get(player.getCurrentDirection())).setPoliceChance(probMod.iterateProb((room.get(player.getCurrentDirection())).getPoliceChance()));
    }

    /**
    * Performs an encounter in Jail
    *
    */
    public void checkJail()
    {
        Input input = new Input();
        if (player.getInJail() == true)
        {
            if (player.getJumps() > 0)
            {
                if (input.yesOrNo("Would you like use a jump to get out of jail?  Yes / No"))
                {
                    player.setJumps(player.getJumps() - 1);
                    System.out.println("\nYou have " + player.getJumps() + " jump/s remaining!");
                    player.setInJail(false);
                    input.promptEnterKey();
                }
                else
                { 
                    player.setResult("Loss");
                }
            }
            else
            {       
                player.setResult("Loss");
            }
        }
    }

    /**
    * Display method to print the outcome of the game.
    *
    */
    public void printOutcome()
    {
        if (player.getResult() == "Win")
        {
            System.out.println("You found the exit! " + player.getName() + " wins!");
        }
        else if (player.getResult() == "Loss")
        {
            System.out.println("You're stuck in jail! You lose!");
        }
    }

    /**
    * Accessor method to decide whether a room holds an exit portal to win.
    *
    * @return              The exit portal state of the current room as a boolean.
    */
    public boolean winCondition()
    {
        ProbMod probMod = new ProbMod();
        return probMod.decideBasedOnProb((room.get(player.getCurrentDirection())).getExitChance());
    }

    /**
    * Method to wrap other methods sequentially to run the gameplay loop.
    *
    */
    public void startProgram()
    {
        readFile();
        inputPlayerDetails();
        do
        {
            randomisePortals();
            display();
            if (player.getPortalOptions() == "")
            {
                System.out.println("\nNo portals to jump to! You find yourself in jail!");
                player.setInJail(true);
            }
            else
            {
                playerChoosesDirection();
                prepareChosenRoom();
                if (winCondition())
                {
                    player.setResult("Win");
                }
                else
                {
                    checkMagicBox();
                    checkPoliceEncounter();
                }
                iterateCurrentPortalProb();
            }
            checkJail();
        } while ((player.getResult()).equals("Unknown"));
        printOutcome();
        writeFile();
    }

    /**
    * Method to start the program.
    *
    * @param args          An array of Strings representing command line arguments.
    */
    public static void main(String[] args)
    {
        Game objGame = new Game();
        objGame.startProgram();
    }
}
