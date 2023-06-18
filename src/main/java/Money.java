public abstract class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public abstract String type(int quantity);

    public int value() {
        return value;
    }
}
