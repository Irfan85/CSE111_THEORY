package Assignment03.Task09;

public class Account {
    public static double interestRate = 5.0;
    private String name;
    private double balance;

    public Account() {
        this.name = "Default account";
        this.balance = 0.0;
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String nameKi() {
        return name;
    }

    public void nameBoshao(String name) {
        this.name = name;
    }

    public double balanceKi() {
        return balance;
    }

    public void balanceBoshao(double balance) {
        this.balance = balance;
    }

    public void withdraw(int amount){
        if(balance - amount > 100.0){
            double newBalance = balance - amount;
            this.balance = newBalance;
            System.out.println("Withdraw successful! New balance is: " + this.balance);
        }else{
            System.out.println("The account balance after deducting withdraw amount is equal to or less than minimum. Cannot withdraw");
        }
    }
}
