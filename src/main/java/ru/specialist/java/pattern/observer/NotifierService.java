package ru.specialist.java.pattern.observer;

public interface NotifierService {

    public void subscribe(User user, String product);

    public void unsubscribe(User user, String product);

    public void notifyUsers(String productName, int productCountBefore, int productCountAfter);
}
