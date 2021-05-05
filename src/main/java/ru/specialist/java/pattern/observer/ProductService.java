package ru.specialist.java.pattern.observer;

public interface ProductService {

    void addProduct(String product);

    void sellProduct(String product);

    void subscribe(User user, String product);

    void unsubscribe(User user, String product);

}
