public class Bank {
    private Account[] accountList;
    private int numAccounts;
    private int maxAccount;
    public Bank(){
        maxAccount = 1000;
        numAccounts = 0;
        accountList = new Account[1000];
    }
    public Boolean addAccount(long accNum, double bal, String own){
        //It should check the condition first before completing the work
        if(numAccounts > maxAccount) return false;
        Account a = new Account(accNum, bal, own);
        accountList[numAccounts] = a;
        numAccounts++;
        return true;
    }
    public String printAccounts(){
        String s = "";
        for(int i=0; i<numAccounts; i++){
            s += accountList[i].toString() + "\n";
        }
        return s;
    }
    public int findAccount(long accNum){
        for(int i=0; i < numAccounts; i++){
            if(accountList[i].getAccountNum() == accNum)
                return i;
        }
        return -1;
    }
    public void depositAccount(long accNum, double amt){
        int loc = findAccount(accNum);
        accountList[loc].deposit(amt);
    }
    public Boolean withdrawAccount(long accNum, double amt){
        int loc = findAccount(accNum);
        //It already check the amt vs. balance at the withdraw function
        // No need this condition: amt > accountList[loc].getBalance()
        if(loc == -1)
            return false;
        accountList[loc].withdraw(amt);
        return true;
    }
    public Boolean transfer(long accNumFrom, long accNumTo, double amt){
        int locFrom = findAccount(accNumFrom);
        int locTo = findAccount(accNumTo);
        if(locFrom == -1 || locTo == -1) return false;
        withdrawAccount(accNumFrom,amt);
        accountList[locFrom].transfer(accountList[locTo],amt);
        return true;
    }
}
