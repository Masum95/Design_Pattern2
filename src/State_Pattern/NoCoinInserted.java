package State_Pattern;

public class NoCoinInserted implements MachineState {

    VendingDecorator vendingDecorator;

    public NoCoinInserted(VendingDecorator vendingDecorator) {
        this.vendingDecorator = vendingDecorator;
    }

    @Override
    public void insertCoin(int change) {
        vendingDecorator.setMachineState(vendingDecorator.getHasMoneyState());
        vendingDecorator.addDepositAmnt(change);
    }

    @Override
    public void selectItem(int pin) {
        System.out.println("Please Insert Money First");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please Insert Money First");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Sorry no coin there to eject . Nice try anyway ;)");
    }
}
