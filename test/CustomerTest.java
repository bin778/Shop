import Model.*;
import View.*;
import Constant.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CustomerTest {
    private Customer customer;
    private Input mockInput;
    private Output mockOutput;

    @BeforeEach
    void setUp() {
        mockInput = mock(Input.class);
        mockOutput = mock(Output.class);
        customer = new Customer();

        customer.setInput(mockInput);
        customer.setOutput(mockOutput);

        customer.buyProduct(Data.product, 0, 1);
        customer.buyProduct(Data.product, 2, 2);
        customer.buyProduct(Data.product, 6, 1);
    }

    @Test
    void testFinalBuyList() {
        when(mockOutput.outputString()).thenReturn("010-1234-5678").thenReturn("강원도 원주시");

        customer.finalBuyList();

        verify(mockInput).finalBuyList(
                any(String[].class),
                any(int[].class),
                any(int[].class),
                any(int[].class),
                eq(3),
                eq("010-1234-5678"),
                eq("강원도 원주시"),
                eq(20800)
        );
    }
}
