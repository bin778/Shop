package Controller;

import Constant.Data;
import Model.Customer;
import Model.Product;
import View.Input;
import View.Output;

public class ShopController {
    Product[] productList = Data.product;
    Input in = new Input();
    Output out = new Output();
    Customer cs = new Customer();

    public void run() {
        while (true) {
            in.inputMenu();
            int selectNumber = out.outputNumber();
            if (selectNumber == 0) break;
            else if (selectNumber == 1) buy();
            else if (selectNumber == 2) check();
            else if (selectNumber == 3) delete();
            else in.wrongNumber();
        }
        exit();
    }

    private void buy() {
        in.inputList(productList);
        int listNumber = out.outputNumber();

        in.inputQuantity();
        int selectQuantity = out.outputNumber();

        cs.buyProduct(productList, listNumber - 1, selectQuantity);
    }

    private void check() {
        cs.checkProduct();
    }

    private void delete() {
        cs.deleteProduct();
    }

    private void exit() {
        cs.finalBuyList();
    }
}
