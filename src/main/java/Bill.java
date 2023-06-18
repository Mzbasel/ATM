
public class Bill extends Money{
    public Bill(int value) {
        super(value);
    }

    @Override
    public String type(int quantity) {
        if(quantity > 1)
            return "bills";
        return "bill";
    }
}
