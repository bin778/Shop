package View;

import Validate.Validate;

import java.util.Scanner;

public class Output {
    Scanner sc = new Scanner(System.in);
    Validate vd = new Validate();

    public int outputNumber() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String outputString() {
        while (true) {
            String str = sc.nextLine();
            if (vd.isEmptyStr(str)) continue;
            return str;
        }
    }
}
