import Validate.Validate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {
    Validate vd = new Validate();

    @Test
    void idxTest() {
        // 인덱스가 0 이하인 경우
        boolean idxResult1 = vd.checkIdx(-1, 10);
        assertTrue(idxResult1);

        // 인덱스가 배열 길이보다 같거나 클 경우
        boolean idxResult2 = vd.checkIdx(7, 7);
        assertTrue(idxResult2);
    }

    @Test
    void quantityTest() {
        // 수량이 0 이하인 경우
        boolean quantityResult1 = vd.checkQuantity(-10);
        assertTrue(quantityResult1);

        // 수량이 100보다 큰 경우
        boolean quantityResult2 = vd.checkQuantity(101);
        assertTrue(quantityResult2);
    }

    @Test
    void isBuyTest() {
        // 아무것도 사지 않았을 경우
        boolean isBuyResult = vd.isBuyProduct(0);
        assertTrue(isBuyResult);
    }

    @Test
    void emptyStrTest() {
        boolean emptyStrResult = vd.isEmptyStr("");
        assertTrue(emptyStrResult);
    }
}
