package Model;

import Constant.Data;
import Validate.Validate;
import View.Input;
import View.Output;

public class Customer {
    public String[] buyProduct = new String[Data.SIZE];
    int[] buyPrice = new int[Data.SIZE];
    int[] buyQuantity = new int[Data.SIZE];
    int[] buyTotalPrice = new int[Data.SIZE];
    int csLength = 0;

    Input in = new Input();
    Output out = new Output();
    Validate vd = new Validate();

    public void setInput(Input input) {
        this.in = input;
    }

    public void setOutput(Output output) {
        this.out = output;
    }

    public void buyProduct(Product[] productList, int idx, int quantity) {
        if (vd.checkIdx(idx, productList.length) || vd.checkQuantity(quantity)) return;
        this.buyProduct[csLength] = productList[idx].productName;
        this.buyPrice[csLength] = productList[idx].productPrice;
        this.buyQuantity[csLength] = quantity;
        this.buyTotalPrice[csLength] = productList[idx].productPrice * quantity;
        this.csLength++;
        in.finishBuy();
    }

    public void checkProduct() {
        if (vd.isBuyProduct(this.csLength)) return;
        in.buyList(this.buyProduct, this.buyPrice, this.buyQuantity, this.csLength);
    }

    public void deleteProduct() {
        if (vd.isBuyProduct(this.csLength)) return;
        checkProduct();
        in.inputIdx();
        int idx = out.outputNumber() - 1;
        if (idx == -1 || vd.checkIdx(idx, this.csLength)) return;

        int cnt = 0;
        for (int i = 0; i < this.csLength; i++) {
            if (idx == i) continue;
            this.buyProduct[cnt] = this.buyProduct[i];
            this.buyPrice[cnt] = this.buyPrice[i];
            this.buyQuantity[cnt] = this.buyQuantity[i];
            this.buyTotalPrice[cnt] = this.buyTotalPrice[i];
            cnt++;
        }

        this.buyProduct[csLength] = null;
        this.buyPrice[csLength] = 0;
        this.buyQuantity[csLength] = 0;
        this.buyTotalPrice[csLength] = 0;

        this.csLength--;
        in.finishDelete();
    }

    public void finalBuyList() {
        if (this.csLength == 0) return;

        in.inputPhoneNumber();
        String phoneNumber = out.outputString();
        in.inputAddress();
        String address = out.outputString();
        int totalPrice = calcTotalPrice();

        in.finalBuyList(this.buyProduct, this.buyPrice, this.buyQuantity, this.buyTotalPrice, this.csLength,
                phoneNumber, address, totalPrice);
    }

    private int calcTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < this.csLength; i++) {
            totalPrice += this.buyTotalPrice[i];
        }
        return totalPrice;
    }
}
