package State_Pattern;

public class ItemSelected implements MachineState {

    VendingDecorator vendingDecorator;
    boolean canDispense;
    FoodItem item;
    int cashBack = 0;
    public ItemSelected(VendingDecorator vendingDecorator) {
        this.vendingDecorator = vendingDecorator;
        canDispense = false;
    }

    public void setPin(int pin)
    {

        item = vendingDecorator.getItem(pin);
        if(item==null) System.out.println("Invalid Pin");
        else{
            cashBack = vendingDecorator.getDepositedAmnt()-item.getPrice();
            if(item.getQnty()<=0)
            {
                System.out.println("Not enough product to dispense.\nPlease select other one or Eject your money");
            }
            else if(item.getPrice()>vendingDecorator.getDepositedAmnt())
            {
                System.out.println("You haven't deposited enough money");
            }
            else if(!vendingDecorator.canMakeChange(cashBack))
            {
                System.out.println("Sorry can't make change\nPlease select other one or Eject your money");

            }
            else{
                canDispense = true;
            }
        }

    }

    @Override
    public void insertCoin(int change) {
        System.out.println("Please wait until current request is finished");
    }

    @Override
    public void selectItem(int pin) {
        setPin(pin);
    }

    @Override
    public void dispenseItem() {
        if(canDispense) {
            System.out.println("Your product is being dispensed  ");
            System.out.println( cashBack + "/= is being returned");
            System.out.println("----Thanks for your purchase---");
            vendingDecorator.setMachineState(vendingDecorator.getNoCoinInsertedState());
        }
    }

    @Override
    public void ejectMoney() {
        System.out.println("Your money is being ejected");
        vendingDecorator.addDepositAmnt(-vendingDecorator.getDepositedAmnt());
        vendingDecorator.setMachineState(vendingDecorator.getNoCoinInsertedState());
    }
}
