package com.example;

/**
 * The entry point of the application.
 * This class demonstrates how to use the App class.
 */
public class Main {
    /**
     * The main method that starts the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        AppConfig config = new AppConfig("MyApp", "1.0.0", Environment.DEVELOPMENT);
        App app = new App(config);

        app.addEventListener(event -> System.out.println(event + " event received"));

        app.start();

        // Keep the application running for a while
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        app.shutdown();
    }
}