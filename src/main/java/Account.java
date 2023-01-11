import java.util.ArrayList;

public class Account {
    //The name of the account
    private String name;
    //The account id number
    private String uuid;
    //The user object that owns this account
    private User holder;
    //The list of transactions for this account
    private ArrayList<Transaction> transactions;

    /**
     * @param name
     * @param holder
     * @param theBank
     */

    public Account(String name, User holder, Bank theBank) {
        //set the account name and holder
        this.name = name;
        this.holder = holder;

        // get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //init transactions
        this.transactions = new ArrayList<Transaction>();

    }

    /**
     * Get the account ID
     *
     * @return the UUID
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Get summary line for the account
     * @return  the string summary
     */
    public String getSummaryLine() {
        //get the account`s balance
        double balance = this.getBalance();
        // format the summary line, depending on the whether the balance is negative
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        }else{
            return String.format("%s : $(%,02f) : %s", this.uuid, balance, this.name);
        }

    }

    private double getBalance() {
        double balance = 0;
        for(Transaction t : this.transactions){
            balance+= t.getAmount();
        }
        return balance;
    }
}
