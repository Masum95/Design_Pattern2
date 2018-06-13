package State_Pattern;

public class VendingMachine {

    protected MachineState machineState;

    protected MachineState hasMoney;
    protected MachineState itemSelected;
    protected MachineState noCoinInserted;
    protected VendingDecorator vendingDecorator;

    public VendingMachine() {
        vendingDecorator = new VendingDecorator(this);
        hasMoney = new HasMoney(vendingDecorator);
        itemSelected = new ItemSelected(vendingDecorator);
        noCoinInserted = new NoCoinInserted(vendingDecorator);

        machineState = noCoinInserted;
    }


    public void insertCoin(int change) {
        machineState.insertCoin(change);
    }

    public void enterPin(int pin)
    {
        machineState.selectItem(pin);
        machineState.dispenseItem();
    }

    public void ejectMoney(){
        machineState.ejectMoney();
    }





}
