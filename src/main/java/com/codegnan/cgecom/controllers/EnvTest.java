package com.codegnan.cgecom.controllers;
public class EnvTest {
    public static void main(String[] args) {
        System.out.println("Host: " + System.getenv("MYSQL_HOSTNAME"));
        System.out.println("Port: " + System.getenv("MYSQL_PORT"));
        System.out.println("Database: " + System.getenv("MYSQL_DATABASE"));
        System.out.println("Username: " + System.getenv("MYSQL_USERNAME"));
        System.out.println("Password: " + System.getenv("MYSQL_PASSWORD"));
    }
}