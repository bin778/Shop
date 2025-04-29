package View;

import Model.Product;

public class Input {
    public void inputMenu() {
        System.out.println("\n안녕하세요. CHOI 카페입니다.");
        System.out.println("1. 구매하기");
        System.out.println("2. 조회하기");
        System.out.println("3. 삭제하기");
        System.out.println("0. 종료");
        System.out.print("원하는 항목을 입력하세요: ");
    }

    public void inputList(Product[] productList) {
        System.out.println("\n현재 주문할 수 있는 메뉴입니다.");
        for (Product product : productList)
            System.out.printf("%d. %s %d원\n", product.productID, product.productName, product.productPrice);
        System.out.print("구매하고 싶은 메뉴의 번호를 입력하세요: ");
    }

    public void inputQuantity() {
        System.out.print("\n구매하고 싶은 수량을 입력하세요: ");
    }

    public void finishBuy() {
        System.out.println("\n구매가 완료되었습니다.");
    }

    public void buyList(String[] buyProduct, int[] buyPrice, int[] buyQuantity, int csLength) {;
        System.out.println("\n=======구매 목록=======");
        for (int i = 0; i < csLength; i++)
            System.out.printf("%d. %s %d원 %d개\n", i + 1, buyProduct[i], buyPrice[i], buyQuantity[i]);
    }

    public void inputIdx() {
        System.out.print("\n삭제하고 싶은 메뉴의 번호를 입력하세요(0을 입력하면 삭제 취소): ");
    }

    public void finishDelete() {
        System.out.println("\n상품 삭제가 완료되었습니다!");
    }

    public void inputPhoneNumber() {
        System.out.print("\n연락처를 입력하세요: ");
    }

    public void inputAddress() {
        System.out.print("배송지를 입력하세요: ");
    }

    public void finalBuyList(String[] buyProduct, int[] buyPrice, int[] buyQuantity, int[] buyTotalPrice, int csLength,
                             String phoneNumber, String address, int totalPrice) {
        System.out.println("\n연락처: " + phoneNumber);
        System.out.println("배송지: " + address);
        System.out.println("\n==========영수증==========");
        for (int i = 0; i < csLength; i++)
            System.out.printf("%s %d원 %d개 %d원\n", buyProduct[i], buyPrice[i], buyQuantity[i], buyTotalPrice[i]);
        System.out.println("=======총 구매 가격=======");
        System.out.printf("%d원\n", totalPrice);
    }

    public void nonBuyProduct() {
        System.out.println("\n구매한 상품 목록이 없습니다.");
    }

    public void wrongNumber() {
        System.out.println("\n입력이 적절하지 않습니다. 다시 입력하세요!");
    }

    public void wrongQuantity() {
        System.out.println("\n수량이 잘못되었습니다. 다시 입력하세요!");
    }

    public void emptyInput() {
        System.out.print("입력이 누락되었습니다. 다시 입력하세요: ");
    }
}
