import java.util.LinkedHashMap;
import java.util.Map;

public class AtmImp implements Atm{

    private final Printer printer;
    private final Map<Money, Integer> availableUnits;
    private Map<Money, Integer> withdrawnMoney;

    public AtmImp(Printer printer) {
        this.printer = printer;
        availableUnits = new LinkedHashMap<>();
        withdrawnMoney = new LinkedHashMap<>();
        initializeAtm();
    }

    @Override
    public void withdraw(int withdrawRequestMoney) {
        int REQUEST_COMPLETE = 0;
        while(withdrawRequestMoney > REQUEST_COMPLETE) {
            for (Money money : availableUnits.keySet()) {
                int ZERO = 0;
                if (withdrawRequestMoney >= money.value() && quantity(money) > ZERO) {
                    withdrawnMoney.put(money, countUnits(money));
                    withdrawRequestMoney -= money.value();
                    reduceQuantityOfAvailableUnits(money);
                    break;
                }
            }
        }

        for (Map.Entry<Money, Integer> money : withdrawnMoney.entrySet()) {
            printer.execute(money.getValue() + " " + money.getKey().type(money.getValue()) + " of " + money.getKey().value() + ".");
        }
    }

    private void reduceQuantityOfAvailableUnits(Money money) {
        availableUnits.put(money, availableUnits.get(money) - 1);
    }

    private int countUnits(Money money) {
        if(!withdrawnMoney.containsKey(money)){
            return 1;
        }
        return withdrawnMoney.get(money) + 1;
    }

    private Integer quantity(Money money) {
        return availableUnits.get(money);
    }

    private void initializeAtm() {
        availableUnits.put(new Bill(500), 2);
        availableUnits.put(new Bill(200), 3);
        availableUnits.put(new Bill(100), 5);
        availableUnits.put(new Bill(50), 12);
        availableUnits.put(new Bill(20), 20);
        availableUnits.put(new Bill(10), 50);
        availableUnits.put(new Bill(5), 100);
        availableUnits.put(new Coin(2), 250);
        availableUnits.put(new Coin(1), 500);
    }
}
