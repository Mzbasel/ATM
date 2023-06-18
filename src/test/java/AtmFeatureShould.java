import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.verify;
@ExtendWith(MockitoExtension.class)
public class AtmFeatureShould {

    @Mock
    private Printer printer;
    @Test
    public void withdraw_money(){
        Atm atm = new AtmImp(printer);
        atm.withdraw(434);

        verify(printer).execute("2 bills of 200.");
        verify(printer).execute("1 bill of 20.");
        verify(printer).execute("1 bill of 10.");
        verify(printer).execute("2 coins of 2.");

    }
}
