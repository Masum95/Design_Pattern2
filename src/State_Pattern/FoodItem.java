package State_Pattern;

public class FoodItem {

    private String name;
    private int price,qnty;

    public String getName() {
        return name;
    }

    public FoodItem setName(String name) {
        this.name = name;
        return  this;
    }

    public int getPrice() {
        return price;
    }

    public FoodItem setPrice(int price) {
        this.price = price;
        return  this;
    }

    public int getQnty() {
        return qnty;
    }

    public FoodItem setQnty(int qnty) {
        this.qnty = qnty;
        return  this;
    }

    public void addQnty(int qnty)
    {
        this.qnty += qnty;
    }
}
