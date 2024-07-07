public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000); // Положить 15 000 сом на счет

        while (true) {
            try {
                account.withDraw(6000); // Снять 6000 сом
                System.out.println("Успешно снято: 6000 сом. Остаток: " + account.getAmount() + " сом.");
            } catch (LimitException e) {
                System.out.println("Исключение: " + e.getMessage());
                double remainingAmount = e.getRemainingAmount();
                try {
                    account.withDraw((int) remainingAmount); // Снять оставшуюся сумму
                    System.out.println("Снято: " + remainingAmount + " сом. Остаток: " + account.getAmount() + " сом.");
                } catch (LimitException ex) {
                    System.out.println("Ошибка: " + ex.getMessage());
                }
                break; // Завершить цикл
            }
        }
    }
}