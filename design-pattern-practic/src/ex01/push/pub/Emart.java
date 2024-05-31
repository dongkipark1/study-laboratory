package ex01.push.pub;

import ex01.push.sub.Customer;

import java.util.ArrayList;
import java.util.List;

public class Emart implements Mart{
    List<Customer> customerList = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void notify(String msg) {
        customerList.forEach(customer -> {
            customer.update(msg);
        });
    }

    @Override
    public void received() {
        for (int i = 0; i < 15; i++) {
            System.out.println(".");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify("식기세척기");
        }
    }
}
