package testingcode;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        String a = "";
        String test = new String(Base64.getDecoder().decode(a));
        System.out.println(test);
    }

}
