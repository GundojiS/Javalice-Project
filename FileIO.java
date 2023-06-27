import java.util.*;
import java.io.*;

/**
* Server class which integrates with the main class to perform File IO actions
*
*/
public class FileIO
{
    /** Name of the file */
    private String fileName;

    /**
    * Default constructor which creates the object of the class FileIO.
    *
    */
    public FileIO()
    {
        fileName = "";
    }

    /**
    * Non-Default constructor which creates the object of the class FileIO.
    *
    * @param newFileName   Accepts the name of the file as a String.
    */
    public FileIO(String newFileName)
    {
        fileName = newFileName;
    }

    /**
    * Accessor method to get file name.
    *
    * @return              The file name as a String.
    */
    public String getFileName()
    {
        return fileName;
    }

    /**
    * Mutator method to set the file name.
    *
    * @param newFileName   The new file name as a String.
    */
    public void setFileName(String newFileName)
    {
        fileName = newFileName;
    }

    /**
    * Accessor method to read the contents of a file.
    *
    * @return              A String representing the contents of a file.
    */
    public String readFile()
    {
        String contents = "";
        if(fileName.trim().length() > 0)
        {
            try
            {
                FileReader inputFile = new FileReader(fileName);
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNextLine())
                {
                    contents += parser.nextLine() + "\n";
                }
                inputFile.close();
            }
            catch(IOException exception)
            {
                System.out.println("An unexpected I/O error was encountered!");
            }
            catch(Exception exception)
            {
                System.out.println("An exception among I/O error was encountered!");
            }
        }
        else
            System.out.println("Please Enter a FileName");
        return contents;
    }

    /**
    * Method to write contents into a new file.
    *
    * @param contents      A String representing the contents to write to a file. 
    */
    public void writeFile(String contents)
    {
        try
        {
            if(fileName.trim().length() > 0)
            {
                PrintWriter outputFile = new PrintWriter(fileName);
                outputFile.println(contents);
                outputFile.close();
            }
            else
                System.out.println("Please enter a FileName");
        }
        catch(IOException exception)
        {
            System.out.println("An error was encountered while trying to write the data to the " + fileName + " file.");
        }
    }
}
