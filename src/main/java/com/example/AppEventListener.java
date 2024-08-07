package com.example;

/**
 * Functional interface for handling application events.
 * Implementors of this interface can be registered with the App class to receive event notifications.
 */
@FunctionalInterface
public interface AppEventListener {
    /**
     * Called when an event occurs in the application.
     *
     * @param event A string representing the event that occurred.
     */
    void onEvent(String event);
}