package org.example;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TestAbsolutePath {

    public static void main(String[] args) throws URISyntaxException {
//        URL res = TestAbsolutePath.class.getClassLoader().getResource("helloworld.fxml");
//        //в примере блыо про URL res = getClass().getClassLoader().getResource("helloworld.fxml");
//        File file = Paths.get(res.toURI()).toFile();
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);

        File file = new File("resources/");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
