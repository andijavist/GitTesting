package ru.specialist.java.pattern.observer;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private final NotifierService notifierService = new NotifierServiceImpl();

    private final Map<String, Integer> products = new HashMap<>();

    public void addProduct(String productName){
        Integer productCount;
        if ((productCount = products.get(productName)) == null)
            products.put(productName, (productCount = 0) + 1);
        else
            products.put(productName, productCount + 1);

        notifierService.notifyUsers(productName, productCount, productCount + 1);
        System.out.printf("Product '%s' count: %d\n", productName, productCount + 1);
    }

    public void sellProduct(String productName){
        Integer productCount;
        if ((productCount = products.get(productName)) == null || productCount <= 0)
            throw new UnsupportedOperationException(String.format("Can't sell because product %s is out", productName));
        else
            products.put(productName, productCount - 1);

        notifierService.notifyUsers(productName, productCount, productCount - 1);
        System.out.printf("Product '%s' count: %d\n", productName, productCount - 1);
    }

    @Override
    public void subscribe(User user, String product) {
        notifierService.subscribe(user, product);
    }

    @Override
    public void unsubscribe(User user, String product) {
        notifierService.unsubscribe(user, product);
    }


}
