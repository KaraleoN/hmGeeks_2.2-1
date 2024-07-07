public class BankAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
        } else {
            System.out.println("Сумма депозита должна быть положительной.");
        }
    }

    public void withDraw(int sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Недостаточно средств на счете.", amount);
        } else {
            amount -= sum;
        }
    }
}