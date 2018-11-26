public class Account {
    private long accountNum;
    private double balance;
    private String owner;
    public Account(long accNo, double b, String info){
        accountNum = accNo;
        balance = b;
        owner = info;
    }
    public void deposit(double amt){
        balance += amt;
    }
    public Boolean withdraw(double amt){
        if(amt<0 || amt>balance) return false;
        balance -= amt;
        return true;
    }
    public Boolean transfer(Account accountReceive, double amt){
        if(balance < amt) return false;
        withdraw(amt);
        accountReceive.deposit(amt);
        return true;
    }
    public String toString(){
        String s = "Account number: " + accountNum +
                "\tBalance: " + balance + "\tOwner information: " + owner;
        return s;
    }
    public long getAccountNum(){return accountNum;}
    public double getBalance(){return balance;}
    public String getOwner(){return owner;}
}
