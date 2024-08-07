package com.example;

/**
 * Represents the configuration for the application.
 * This record holds the name, version, and environment of the application.
 *
 * @param name The name of the application.
 * @param version The version of the application.
 * @param environment The environment in which the application is running.
 */
public record AppConfig(String name, String version, Environment environment) {
}

/**
 * Represents the possible environments for the application.
 */
enum Environment {
    /** Development environment */
    DEVELOPMENT,
    /** Production environment */
    PRODUCTION,
    /** Test environment */
    TEST
}