package ex01.push.sub;

public class Cus1 implements Customer{
    @Override
    public void update(String msg) {
        System.out.println("손님 1의 받은 알림: " + msg);

    }
}
