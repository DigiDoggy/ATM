import java.util.ArrayList;

public class Account {
    //The name of the account
    private String name;
    //The current balance of the account.
    private double balance;
    //The account id number
    private String uuid;
    //The user object that owns this account
    private User holder;
    //The list of transactions for this account
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {
        //set the account name and holder
        this.name = name;
        this.holder = holder;

        // get new account UUID
        this.uuid = theBank.getNewAccountUUID();
    }
}
