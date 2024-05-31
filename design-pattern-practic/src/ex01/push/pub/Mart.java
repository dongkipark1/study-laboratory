package ex01.push.pub;

import ex01.push.sub.Customer;

public interface Mart {

    // 1. 등록
    void add(Customer customer);

    // 2. 알림
    void notify(String msg);

    // 3. 출판
    void received();
}
