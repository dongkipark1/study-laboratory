package ex01.push;

import ex01.push.pub.Costco;
import ex01.push.pub.Emart;
import ex01.push.pub.LotteMart;
import ex01.push.pub.Mart;
import ex01.push.sub.Cus1;
import ex01.push.sub.Cus2;
import ex01.push.sub.Cus3;
import ex01.push.sub.Cus4;

public class App {
    public static void main(String[] args) {

        Mart lotteMart = new LotteMart();
        Mart eMart = new Emart();
        Mart costco = new Costco();
        Cus1 cus1 = new Cus1();
        Cus2 cus2 = new Cus2();
        Cus3 cus3 = new Cus3();
        Cus4 cus4 = new Cus4();

        lotteMart.add(cus1);
        lotteMart.add(cus2);
        lotteMart.add(cus3);
        lotteMart.add(cus4);

        eMart.add(cus1);
        eMart.add(cus2);
        eMart.add(cus3);
        eMart.add(cus4);

        costco.add(cus1);
        costco.add(cus2);
        costco.add(cus3);
        costco.add(cus4);

        new Thread(() -> {
            lotteMart.received();
        }).start();

        new Thread(() -> {
            eMart.received();
        }).start();

        new Thread(() -> {
            costco.received();
        }).start();

    }
}
