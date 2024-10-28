package BirthdayProject;
/**
 * The Person class represents an individual with a birthday.
 */
public class Person {
    private int birthday;
    /**
     * Constructs a Person with a specified birthday.
     * @param birthday An integer representing the day of the year (1-365).
     */
    public Person(int birthday) {
        this.birthday = birthday;
    }
     /**
      * Gets the birthday of this person.
      * @return The birthday as an integer (1-365).
      */

    public int getBirthday() {
        return birthday;
    }
}
