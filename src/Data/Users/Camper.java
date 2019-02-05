package Data.Users;

import Data.DataBaseManager;

import java.sql.SQLException;

/**
 * @Author Aidan Stewart
 * @Year 2018
 * Copyright (c)
 * All rights reserved.
 */
public class Camper {
    private int id;
    private String name;
    private int balance;
    private DataBaseManager databaseManager = new DataBaseManager();


    public Camper(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) throws SQLException {
        if (!name.isEmpty() && !this.name.equals(name)) {
            databaseManager.update("UPDATE camper SET name = '" + name + "' WHERE id =" + id + ";");
            this.name = name;
        }
    }

    public void setBalanceWithString(int balance) throws SQLException {
        if (balance > -1 && this.balance != balance) {
            databaseManager.update("UPDATE camper SET balance = '" + balance + "' WHERE id =" + id + ";");
            this.balance = balance;
        }
    }
}
