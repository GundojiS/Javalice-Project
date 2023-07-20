/**
* Server class which integrates with the main class to hold magic box parameters
*
*/
public class Items
{
    /** State of the magic box */
    private boolean magicBoxState;
    /** Name of the item inside */
    private String itemState;

    /**
    * Default constructor which creates the object of the class Items.
    *
    */
    public Items()
    {
        magicBoxState = false;
        itemState = "Coal";
    }

    /**
    * Non-Default constructor which creates the object of the class Items.
    *
    * @param magicBoxState      Accepts the state of the magic box as a boolean. True is open, false is closed.
    * @param itemState          Accepts the item within the box as a String.
    */
    public Items(boolean magicBoxState, String itemState)
    {
        this.magicBoxState = magicBoxState;
        this.itemState = itemState;
    }

    /**
    * Display method to print the magic box state and item inside.
    *
    */
    public void display()
    {
        System.out.println("Magic Box State is: " + magicBoxState + ".  Item inside is: " + itemState);
    }

    /**
    * Accessor method to get the state of the magic box.
    *
    * @return               The state of the magic box as a boolean where true is open, and false is closed.
    */
    public boolean getMagicBoxState()
    {
        return magicBoxState;
    }

    /**
    * Accessor method to get the state of the item inside the box.
    *
    * @return               The item inside the magic box as a String.
    */
    public String getItemState()
    {
        return itemState;
    }

    /**
    * Mutator method to set the magic box state.
    *
    * @param magicBoxState  Boolean representing the state of the magic box.
    */
    public void setMagicBoxState(boolean magicBoxState)
    {
        this.magicBoxState = magicBoxState;
    }

    /**
    * Mutator method to set the type of item inside.
    *
    * @param itemState      String representing the item inside the box.
    */
    public void setItemState(String itemState)
    {
        this.itemState = itemState;
    }
}
