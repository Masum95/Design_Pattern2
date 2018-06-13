package State_Pattern;

public class StateDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(98);
        vendingMachine.ejectMoney();
        vendingMachine.enterPin(12);
        vendingMachine.enterPin(11);

    }
}
