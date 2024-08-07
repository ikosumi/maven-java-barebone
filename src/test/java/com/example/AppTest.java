package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private App app;
    private AppConfig config;

    @BeforeEach
    void setUp() {
        config = new AppConfig("TestApp", "1.0.0", Environment.TEST);
        app = new App(config);
    }

    @Test
    void testAppCreation() {
        assertNotNull(app);
    }

    @Test
    void testGetInfo() {
        AppConfig info = app.getInfo();
        assertEquals(config, info);
        assertNotSame(config, info);
    }

    @Test
    void testStartAndEvents() throws InterruptedException {
        CountDownLatch startedLatch = new CountDownLatch(1);
        CountDownLatch completedLatch = new CountDownLatch(1);

        app.addEventListener(event -> {
            if ("started".equals(event)) {
                startedLatch.countDown();
            } else if ("taskCompleted".equals(event)) {
                completedLatch.countDown();
            }
        });

        app.start();

        assertTrue(startedLatch.await(1, TimeUnit.SECONDS));
        assertTrue(completedLatch.await(2, TimeUnit.SECONDS));

        app.shutdown();
    }
}