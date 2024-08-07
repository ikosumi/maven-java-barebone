package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Represents the main application class.
 * This class manages the application lifecycle, configuration, and event handling.
 */
public class App {
    private final AppConfig config;
    private final List<AppEventListener> listeners = new ArrayList<>();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    /**
     * Constructs a new App instance with the given configuration.
     *
     * @param config The configuration for the application.
     */
    public App(AppConfig config) {
        this.config = config;
    }

    /**
     * Starts the application.
     * This method initializes the application, logs the start message, notifies listeners,
     * and schedules the initial task.
     */
    public void start() {
        System.out.printf("Starting %s v%s in %s mode%n",
                config.name(), config.version(), config.environment());
        notifyListeners("started");
        executorService.schedule(this::runTask, 0, TimeUnit.SECONDS);
    }

    /**
     * Runs a task asynchronously.
     * This private method is called by the start method and schedules the task completion.
     */
    private void runTask() {
        System.out.println("Running task...");
        executorService.schedule(() -> {
            System.out.println("Task completed");
            notifyListeners("taskCompleted");
        }, 1, TimeUnit.SECONDS);
    }

    /**
     * Retrieves the current configuration of the app.
     *
     * @return A copy of the current configuration.
     */
    public AppConfig getInfo() {
        return new AppConfig(config.name(), config.version(), config.environment());
    }

    /**
     * Adds an event listener to the application.
     *
     * @param listener The listener to add.
     */
    public void addEventListener(AppEventListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes an event listener from the application.
     *
     * @param listener The listener to remove.
     */
    public void removeEventListener(AppEventListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all registered listeners of an event.
     *
     * @param event The event to notify listeners about.
     */
    private void notifyListeners(String event) {
        listeners.forEach(listener -> listener.onEvent(event));
    }

    /**
     * Shuts down the application's executor service.
     * This method should be called when the application is no longer needed.
     */
    public void shutdown() {
        executorService.shutdown();
    }
}