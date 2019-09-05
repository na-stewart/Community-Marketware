package main.java.com.traderbobsemporium.model.exceptions;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Customer has insufficient balance!");
    }
}