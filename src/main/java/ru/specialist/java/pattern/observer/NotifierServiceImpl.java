package ru.specialist.java.pattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierServiceImpl implements NotifierService {

    private Map<String, List<User>> userMap = new HashMap<>();

    @Override
    public void subscribe(User user, String product) {
        List<User> userList = null;
        if ((userList = userMap.get(product)) == null)
            userMap.put(product, new ArrayList<>(List.of(user)));
        else
            userList.add(user);
    }

    @Override
    public void unsubscribe(User user, String product) {
        List<User> userList = null;
        if ((userList = userMap.get(product)) != null)
            userList.remove(user);
    }

    @Override
    public void notifyUsers(String productName, int productCountBefore, int productCountAfter) {
        String message;
        if (productCountBefore == 0 && productCountAfter == 1)
            message = String.format("product '%s' arrived", productName);
        else if (productCountBefore == 1 && productCountAfter == 0)
            message = String.format("product '%s' is out", productName);
        else
            message = null;

        if (message != null){
            List<User> users = userMap.get(productName);
            if (users != null)
                users.forEach(u -> System.out.printf("Notifiying user '%s' that %s\n", u.getUsername(), message));
        }
    }

}
