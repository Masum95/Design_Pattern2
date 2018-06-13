package State_Pattern;

public interface MachineState {

    void insertCoin(int change);

    void selectItem(int pin);

    void dispenseItem();

    void ejectMoney();
}
