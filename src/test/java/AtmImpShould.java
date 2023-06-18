import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.verify;
@ExtendWith(MockitoExtension.class)
public class AtmImpShould {

    @Mock
    private Printer printer;
    private AtmImp atm;

    @BeforeEach
    public void initialize(){
        atm = new AtmImp(printer);
    }

    @Test
    public void withdraw_five_hundred_bill(){
        atm.withdraw(500);
        verify(printer).execute("1 bill of 500.");
    }

    @Test
    void withdraw_two_hundred_bill() {
        atm.withdraw(200);
        verify(printer).execute("1 bill of 200.");
    }

    @Test
    void withdraw_two_bills_of_two_hundred() {
        atm.withdraw(400);
        verify(printer).execute("2 bills of 200.");
    }

    @Test
    public void run_out_of_500_bills_when_withdraw_1500(){
        atm.withdraw(1500);
        verify(printer).execute("2 bills of 500.");
    }

    @Test
    public void run_out_of_500_bills_when_withdraw_1500_then_complete_the_rest_with_other_bills(){
        atm.withdraw(1500);
        verify(printer).execute("2 bills of 500.");
        verify(printer).execute("2 bills of 200.");
        verify(printer).execute("1 bill of 100.");
    }

    @Test
    public void withdraw_1725(){
        atm.withdraw(1725);
        verify(printer).execute("2 bills of 500.");
        verify(printer).execute("3 bills of 200.");
        verify(printer).execute("1 bill of 100.");
        verify(printer).execute("1 bill of 20.");
        verify(printer).execute("1 bill of 5.");
    }

    @Test
    public void withdraw_434(){
        atm.withdraw(434);
        verify(printer).execute("2 bills of 200.");
        verify(printer).execute("1 bill of 20.");
        verify(printer).execute("1 bill of 10.");
        verify(printer).execute("2 coins of 2.");
    }
}
