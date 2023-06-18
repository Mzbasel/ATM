public class Coin extends Money{
    public Coin(int value) {
        super(value);
    }

    @Override
    public String type(int quantity) {
        if(quantity > 1)
            return "coins";
        return "coin";
    }
}
