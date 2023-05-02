import java.io.BufferedReader ;
import java.io.FileReader ;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;

/** Deduplication.java - Remove duplications
 * <p>Problem Statement: write a program that reads a file of numbers of type int and outputs all of 
 * those numbers to another file,but without any duplicate numbers.
 * </p>
 * 
 * <p>Algorithm: <br />
 * 1. Create main class <br/>
 * 2. Import all classes
 * 3. Create variables
 * 4. Get user input and put it into string variables
 * 5. Create objects for reader and writer
 * 6. Get int from infile, and make another variable and subtract it by 1 from the previous
 * 7. Make a for loop, count the number of inputs, have an if statement to write to 
 *    outfile if character is not a duplicate, have lastInt = newInt and count the number
 *    of outputs
 * 8. Have another if statement to see if it's the end of the file, if it isn't grab 
 *    the line.
 * 9. Get the dupes by subtracted numRead - num Written and then print out the total
 *    number of inputs, the amount of outputs, and the number of duplicates.
 * </p>
 * 
 *   @author Ethan Grant
 *   @version Module 12, Hw 2
 */
public class Deduplication
{
    public static void main(String[] args) throws java.io.IOException, java.io.FileNotFoundException {
        // Create variables
        int lastInt = 0, newInt = 0, numRead = 0, numWritten = 0, numDupe = 0;
        String inFile, outFile, temp;
        
        // get user input 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        // Put it into string variable 
        inFile = input.nextLine();
        
         // get user output 
        Scanner output = new Scanner(System.in);
        System.out.print("Enter output file name: "); 
        // Put it into string variable 
        outFile = output.nextLine();
        
        //  Creating object for reader and writer 
        BufferedReader inBuf = new BufferedReader(new FileReader(inFile));
        BufferedWriter outBuf = new BufferedWriter(new FileWriter(outFile));
        
        // Get int from infile
        temp = inBuf.readLine();
        newInt = Integer.valueOf(temp);
        
        
        // To make it false
        lastInt = newInt - 1;
        
        // Enter loop to read from file
        while(temp != null) {
            // Counts number of inputs 
            numRead++;
            // Writes to outfile if character is not a duplicate 
            if (newInt != lastInt) {
                newInt = Integer.valueOf(temp);
                outBuf.write(String.valueOf(newInt),0, String.valueOf(newInt).length());
                
                lastInt = newInt;
                // count outputs
                numWritten++;
            }
            // Check to see if its the end of the file, if not grab line 
            if(inBuf.ready())
            {
                temp = inBuf.readLine().stripTrailing();
                newInt = Integer.valueOf(temp);
            }
            else
                temp = null;
        }
        // get dupes
        numDupe = numRead - numWritten;
        // print out info
        System.out.print("There were " + numRead + " numbers input, " +
                        numWritten + " output, and " + numDupe + " duplicates");
    }
}
