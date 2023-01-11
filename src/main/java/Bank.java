import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     * Generate a new universally unique ID for user.
     *
     * @return the uuid
     */
    public String getNewUserUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        //continue looping we get a unique ID
        do {
            //generate the number
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check to make sure it`s unique
            nonUnique = false;
            for (User u : this.users) {
                if (uuid.compareTo(u.getUuid()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        //continue looping we get a unique ID
        do {
            //generate the number
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check to make sure it`s unique
            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUuid()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuid;
    }

    /**
     * Create a new of the bank
     * @param firstName the user`s first name
     * @param lastName  the user`s last name
     * @param pin       the user`s pin
     * @return          the new  User object
     */
    public User addUser(String firstName, String lastName, String pin){
        //Create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //Create a savings account for the user and add to User and Bank
        // accounts lusts
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }
}
