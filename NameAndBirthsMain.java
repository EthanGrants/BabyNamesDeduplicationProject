import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
/** NamesAndBirthsMain.java - Popular Baby Names
 * <p>Problem Statement: Read text files containing lists of popular girl and boy names
 * into two arrays of objects, then prompt for a name and see if that name is in either list.
 * </p>
 * 
 * <p>Algorithm: <br />
 * 1. Create main class <br/>
 * 2. Create two arrays of 1000 objects <br/>
 * 3. Create a readUsingScanner method, its parameters are a source file name and the
 *    array name to load, read the data from the file, have a counter,create a while loop, 
 *    and split the line into two parts, update object, and close file.
 * 4. Populate the arrays
 * 5. Create a searchNames method, parameters being the gender and name(strings),
 *    and the array, have a boolean set to false,
 * 6. Have a for loop, if loop inside where found is set to true, print to system what
 *    the baby name is ranked, then in another if loop, when the boolean is false, print
 *    out saying its not ranked.
 * 7. Have a string to store user input, have a while loop, that asks for user input,
 *    allow user to exit if quit is entered with an if statement, then invoke the method
 *    for each gender.
 * 8. Compile and test.
 * </p>
 * 
 *   @author Ethan Grant
 *   @version Module 12, Hw 1
 */
public class NameAndBirthsMain
{
    public static void main(String[] args) throws Exception {
        // two arrays of 1000 objects
        NameAndBirths[] boyNames = new NameAndBirths[1000];
        NameAndBirths[] girlNames = new NameAndBirths[1000];

        // populate arrays 
        readUsingScanner("BoyNames2021.txt", boyNames);
        readUsingScanner("Girlnames2021.txt", girlNames);

        // Store user's input
        String name;
        // get input from user
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a name, or quit to stop");
            // prevent any white space being entered
            name = input.nextLine().trim();
            //error trap and allow user to stop
            if(name.equalsIgnoreCase("quit")) {
                break;
            }
            searchNames("boys",name,boyNames);
            searchNames("girls",name,girlNames);
        }

    }
    // Read data from file
    /**
     * Reads from file
     * @param txt represents name of file where object will write
     * @param NameAndBirths[] gender array that holds the names and births
     */
    public static void readUsingScanner(String txt, NameAndBirths[] gender) throws Exception {
        // Scanner object to read data from the file
        Scanner inputFile = new Scanner(new FileInputStream(txt));
        // counter
        int i = 0;
        while(inputFile.hasNextLine()) {
            // enter line we grab
            String line = inputFile.nextLine();
            // Splits at the space into the array
            String[] splitLine = line.split(" ");
            // Pulls name
            String name = splitLine[0];
            // Pulls number
            String births = splitLine[1];
            // object
            gender[i] = new NameAndBirths(name, Integer.valueOf(births));
            i++;
        }
        // close file
        inputFile.close();
    }
    /**
     * Searches for names
     * @param maleOrFemale gender of baby
     * @param name name of baby
     * @param NameAndBirths[] gender array that holds the names and births
     */
    public static void searchNames(String maleOrFemale, String name, NameAndBirths[] gender) throws Exception {
        // for if name is not found
        boolean found = false;
        for (int i = 0; i < gender.length; i++) {
            if(gender[i].getName().equalsIgnoreCase(name)) {
                // set true since name is found
                found = true;
                // print to system
                System.out.println(name + " is ranked " + (i+1) + " among " + maleOrFemale +
                    " with " + String.format("%,d",gender[i].getBirths()) + " registered births");
                // runs faster
                break;
            }
        }
        // If name was not found
        if (!found) { 
            System.out.println(name + " is not ranked among the top 1,000 " + maleOrFemale
                            + " names");              
        }
    }
}
