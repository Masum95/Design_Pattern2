package State_Pattern;

public class HasMoney implements MachineState {

    VendingDecorator vendingDecorator;

    public HasMoney(VendingDecorator vendingDecorator) {
        this.vendingDecorator = vendingDecorator;
    }

    @Override
    public void insertCoin(int change) {
        vendingDecorator.addDepositAmnt(change);
    }

    @Override
    public void selectItem(int pin) {
        ((ItemSelected)vendingDecorator.getItemSelectedState()).setPin(pin);
        vendingDecorator.setMachineState(vendingDecorator.getItemSelectedState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select item first");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Your money is being ejected");
        vendingDecorator.addDepositAmnt(-vendingDecorator.getDepositedAmnt());
        vendingDecorator.setMachineState(vendingDecorator.getNoCoinInsertedState());
    }
}
