package BirthdayProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * The BirthdayProgram class calculates the probability of at least
 * two people sharing the same birthday in a specified group size
 * over multiple simulation runs.
 */
public class BirthdayProgram {
    private int classSize;
    private int runs;
    /**
     * Constructs a BirthdayProgram with a given class size and number of runs.
     * @param classSize The number of people in the group (e.g., 30).
     * @param runs The number of simulation runs to calculate probability.
     */
    public BirthdayProgram(int classSize, int runs) {
        this.classSize = classSize;
        this.runs = runs;
    }

    /**
     * Calculates the probability of at least two people sharing the same birthday.
     * @return The probability as a double (e.g., 0.7 for 70%).
     */

    public double calculateProbability() {
        int sharedBirthdayCount = 0;
        
        for (int i = 0; i < runs; i++) {
            ArrayList<Person> people = generatePeople();
            if (hasSharedBirthday(people)) {
                sharedBirthdayCount++;
            }
        }
        
        return (double) sharedBirthdayCount / runs;
    }

    /**
     * Generates a list of Person objects with random birthdays.
     * @return An ArrayList of Person objects, each with a random birthday.
     */

    private ArrayList<Person> generatePeople() {
        ArrayList<Person> people = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < classSize; i++) {
            int randomBirthday = rand.nextInt(365) + 1; // Generate a random day (1-365)
            people.add(new Person(randomBirthday));
        }
        
        return people;
    }
    /**
     * Checks if there is a shared birthday among a list of people.
     * @param people The list of Person objects to check for shared birthdays.
     * @return True if at least two people share a birthday; false otherwise.
     */

    private boolean hasSharedBirthday(ArrayList<Person> people) {
        HashSet<Integer> birthdays = new HashSet<>();
        
        for (Person person : people) {
            if (birthdays.contains(person.getBirthday())) {
                return true; // Found a shared birthday
            }
            birthdays.add(person.getBirthday());
        }
        
        return false; // No shared birthdays found
    }
}
