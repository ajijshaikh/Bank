package Bank;

public class Bank {

    int AccountNumber;
    int Balance;
    String AccountName;

    public Bank(String AccountName, int AccountNumber, int Balance) {
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
        this.AccountName = AccountName;
    }

    public void fundTransfer(Bank SecondAccount, int Amount){
        ensureSufficientFundsAreAvailable(this);
        ensureSufficientFundsAreAvailable(SecondAccount);

        SecondAccount.Balance += Amount;
        this.Balance -= Amount;

        System.out.println("First account balance : " + this.Balance);
        System.out.println("Second account balance : " + SecondAccount.Balance);
    }

    private void ensureSufficientFundsAreAvailable(Bank Account){
        if(Account.Balance <= 0){
            throw new RuntimeException("Oops Your " + Account.AccountName +" has no money please credit some amount to it. ");
        }
    }


    public static void main(String[] args) {

        Bank FirstAccount = new Bank("FirstAccount",12345,700);
        Bank SecondAccount = new Bank("SecondAccount",54321,300);

        FirstAccount.fundTransfer(SecondAccount,100);
    }
}