package Validate;

import View.Input;

public class Validate {
    Input in = new Input();

    public boolean checkIdx(int idx, int length) {
        if (idx < 0 || idx >= length) {
            in.wrongNumber();
            return true;
        }
        return false;
    }

    public boolean checkQuantity(int quantity) {
        if (quantity < 1 || quantity > 100) {
            in.wrongQuantity();
            return true;
        }
        return false;
    }

    public boolean isBuyProduct(int length) {
        if (length == 0) {
            in.nonBuyProduct();
            return true;
        }
        return false;
    }

    public boolean isEmptyStr(String str) {
        if (str.isEmpty()) {
            in.emptyInput();
            return true;
        }
        return false;
    }
}
