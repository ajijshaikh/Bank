package Bank;

public class Bank {

    int AccountNumber;
    int Balance;

    public Bank(int AccountNumber, int Balance) {
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
    }

    public void fundTransfer(Bank DestinationAccount, int Amount){
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

    private void ensureSufficientFundsAreAvailable(Bank SourceAccount, int amount){
        if(SourceAccount.Balance <= 0){
            throw new RuntimeException("Oops Your source account has no money please credit some amount to it. ");
        }else if(SourceAccount.Balance < amount){
            throw new RuntimeException("Sorry ! your source account wont have " + amount + " RS please retry with lesser amount than that");
        }
    }


    public static void main(String[] args) {

        Bank SourceAccount = new Bank(12345,700);
        Bank DestinationAccount = new Bank(54321,300);

        SourceAccount.fundTransfer(DestinationAccount,500);
    }
}
