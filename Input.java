import java.util.Scanner;

/**
* Utility class which integrates with the main class to perform input actions
*
*/
public class Input
{
    /**
    * Default constructor which creates the object of the class Input.
    *
    */
    public Input()
    {
        
    }

    /**
    * Method to get user input.
    *
    * @param displayMessage     A String which displays a message instruct user to provide input.
    * @return                   String consisting of the user's input.
    */
    public String acceptStringInput(String displayMessage)
    {
        System.out.println(displayMessage);
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        return input;
    }

    /**
    * Method to get user input and format it for comparison testing.
    *
    * @return               String consisting of the user's input which has been trimmed and make lower case.
    */
    public String trimAndLowerCaseInput()
    {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        System.out.println("Input was: " + input);
        input = input.trim();
        input = input.toLowerCase();
        return input;
    }

    /**
    * Method to get proceed or not based on user input
    *
    * @param message        A String which displays a message where the user can choose yes or no to.
    * @return               A boolean which returns true to a yes response or false to a no response. 
    */
    public boolean yesOrNo(String message)
    {
        boolean userResult = false;
        Input yesNoInput = new Input();
        Validation yesNoValid = new Validation();
        boolean validInput = false;
        do
        {
            System.out.println(message);
            String userChoice = yesNoInput.trimAndLowerCaseInput();
            if (yesNoValid.isBlank(userChoice))
            {
                System.out.println("Choice can't be blank.");
            }
            else
            {
                if (userChoice.equals("yes"))
                {
                    userResult = true;
                    validInput = true;
                }
                else if (userChoice.equals("no"))
                {
                    userResult = false;
                    validInput = true;
                }
                else
                {
                    System.out.println("Choice not recognised! Try again");
                }
            }
            
        } while (validInput == false);

        return userResult;
    }

    /**
    * A generic prompt for the user to proceed in order to break up terminal text.
    *
    */
    public void promptEnterKey()
    {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
