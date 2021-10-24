package Bank;

public class Account {

    int AccountNumber;
    int Balance;

    public Account(int AccountNumber, int Balance) {
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
    }

    public void fundTransfer(Account DestinationAccount, int Amount){
        ensureSufficientFundsAreAvailable(this, Amount);

        this.debit(Amount);
        DestinationAccount.credit(Amount);

        System.out.println("Source account balance : " + this.Balance);
        System.out.println("Destination account balance : " + DestinationAccount.Balance);
    }

    private void debit(int Amount) {
        this.Balance -= Amount;
    }

    private void credit(int Amount){
        this.Balance += Amount;
    }

    private void ensureSufficientFundsAreAvailable(Account SourceAccount, int amount){
        if(SourceAccount.Balance <= 0){
            throw new RuntimeException("Oops Your source account has no money please credit some amount to it. ");
        }else if(SourceAccount.Balance < amount){
            throw new RuntimeException("Sorry ! your source account wont have " + amount + " RS please retry with lesser amount than that");
        }
    }


    public static void main(String[] args) {

        Account FirstAccount = new Account(12345,700);
        Account SecondAccount = new Account(54321,1300);

        SecondAccount.fundTransfer(FirstAccount, 300);
        FirstAccount.fundTransfer(SecondAccount, 300);

    }
}
