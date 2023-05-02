
/**
 * NameAndBirths.java - Popular Baby Names
 * 
 * <p>Problem Statement: Read text files containing lists of popular girl and boy names
 * into two arrays of objects, then prompt for a name and see if that name is in either list.
 * </p>
 * <p> Instance variables: <br />
 *     String name - name of baby
 *     int births - number of births
 * </p>
 * 
 *   @author Ethan Grant
 *   @version Module 12, Hw 1
 */
public class NameAndBirths
{
    // instance variables
    private String name = "";
    private int births = 0;

    // Full constructor
    /**
     * Constructs a new NameAndBirths object with name and birth
     * Post-condition - object is created
     * @param name name of baby
     * @param birth number of babies born in 2021
     */
    public NameAndBirths(String name, int births) {
        this.name = name;
        this.births = births;
    }
    // Getters and setters for name
    /**
     * Gets name of baby
     * Pre-condition: name must be initialized
     * Post-condition: returns name of baby
     * @return name of baby
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of baby
     * Pre-condition: name must be initialized
     * Post-condition: Sets name to provided parameter
     * @param name of baby
     */
    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for births
    /**
     * Gets number of births in 2021
     * Pre-condition: births must be initialized
     * Post-condition: returns number of births in 2021
     * @return number of births in 2021
     */
    public int getBirths() {
        return births;
    }

    /**
     * Sets number of births in 2021
     * Pre-condition: births must be initialized
     * Post-condition: Sets births to provided parameter
     * @param number of births in 2021
     */
    public void setBirths(int births) {
        this.births = births;
    }

    //toString
    /**
     * Return a string of NameAndBirths information
     * Post-condition: A string of NameAndBirths information is returned
     * @return the string
     */
    public String toString() {
        return "Name of baby: " + name + " Number of births in 2021: " + births;
    }
    // equals method
    /**
     * Compares NameAndBirths to another NameAndBirths object to see if equals
     * Post-condition - return true if objects are equal
     * @param anObject object being used to compare
     * @return true if objects are equal
     */
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (getClass() != anObject.getClass()) {
            return false;
        }
        NameAndBirths otherNameAndBirths = (NameAndBirths) anObject;
        return (name.equals(otherNameAndBirths.name) &&
            births == otherNameAndBirths.births);
    }
}
