package State_Pattern;

import java.util.*;

public class VendingDecorator{

    VendingMachine vendingMachine;

    private FoodItem selectedItem;
    private int depositedAmnt;
    private List<FoodItem> foodItemList = new ArrayList<>();
    private Map<Integer,FoodItem> itemMap = new HashMap<>();
    private Map<Integer,Integer> coinMap = new TreeMap<>();
    private List<Integer> coinList = new ArrayList<>();

    public VendingDecorator(VendingMachine machine) {
        this.vendingMachine = machine;

        itemMap.put(11,new FoodItem().setName("Mily Way").setPrice(80).setQnty(5));
        itemMap.put(12,new FoodItem().setName("Snickers").setPrice(90).setQnty(5));
        itemMap.put(13,new FoodItem().setName("Bounty").setPrice(100).setQnty(5));
        itemMap.put(14,new FoodItem().setName("Bournvile").setPrice(120).setQnty(5));
        itemMap.put(15,new FoodItem().setName("Mars").setPrice(70).setQnty(5));
        printItems();

        coinMap.put(5,20);
        coinMap.put(1,100);
        coinMap.put(2,50);

        coinList = new ArrayList<>(coinMap.keySet());

    }

    private void printItems() {
        int i=0;
        System.out.format("%5s","Pin");
        System.out.format("%15s","Item Name");
        System.out.format("%15s","Item Price");
        System.out.println();
        for(Map.Entry<Integer,FoodItem> entry: itemMap.entrySet())
        {
            System.out.format("%5s",entry.getKey());
            System.out.format("%15s",entry.getValue().getName());
            System.out.format("%15s/=",entry.getValue().getPrice());
            System.out.println();
            i = (i+1)%3;
            if(i==0) System.out.println();
        }
        System.out.println();
    }

    public FoodItem getItem(int pin){
        return itemMap.get(pin);
    }

    public void addDepositAmnt(int amnt)
    {

        this.depositedAmnt += amnt;
    }

    public int getDepositedAmnt(){return depositedAmnt;}

    public boolean canMakeChange(int change)
    {
       // System.out.println(change);
        int coinIndx = -1;
        for(int i=0;i<coinList.size()-1;i++)
        {
            if(coinList.get(i)<=change && coinList.get(i+1)>change) {coinIndx = i ;break; }
        }

        if(coinIndx==-1) coinIndx = coinList.size()-1;


        for(int i = coinIndx;i>=0;i--)
        {
            if(change==0) break;
            int coin = coinList.get(i);
            int how = change/coin;
            change -= Math.min(how,coinMap.get(coin)) * coin;
        }

        return  change==0 ? true : false;
    }


    public void setMachineState(MachineState state) { vendingMachine.machineState = state;}

    public MachineState getState()
    {
        return vendingMachine.machineState;
    }
    public MachineState getHasMoneyState()
    {
        return vendingMachine.hasMoney;
    }
    public MachineState getItemSelectedState()
    {
        return vendingMachine.itemSelected;
    }
    public MachineState getNoCoinInsertedState()
    {
        return vendingMachine.noCoinInserted;
    }
}
