package ru.specialist.java.pattern.observer;

public class ObserverExample {

    public static void main(String[] args) {

        User vasya = new User("Vasya");
        User masha = new User("Masha");

        String phone = "phone";
        String book = "book";
        String headphones = "headphones";

        ProductService productService = new ProductServiceImpl();

        productService.subscribe(vasya, phone);

        productService.addProduct(phone);
        productService.addProduct(phone);

        productService.subscribe(masha, phone);
        productService.subscribe(masha, book);

        productService.addProduct(phone);
        productService.addProduct(book);
        productService.addProduct(headphones);

        productService.sellProduct(phone);
        productService.sellProduct(phone);
        productService.sellProduct(phone);

        productService.subscribe(vasya, headphones);
        productService.unsubscribe(masha, book);

        productService.sellProduct(book);
        productService.sellProduct(headphones);


    }
}
