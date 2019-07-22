package com.tarasik.alex;

import java.util.ArrayList;

import static com.tarasik.alex.ATM.aTMBalance;
import static com.tarasik.alex.Database.database;

/**
 * @author Alex Tarasik on 20.07.2019.
 * @project ATM
 */
public class Client implements com.tarasik.alex.interfaces.IClient{

    private int balance;

    public Client(int balance){
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean removeBalance(int balance) {

        if (aTMBalance < balance) {
            System.out.println("В банкомате нет средств в таком размере");
        }
        if (balance <= this.balance) {
            this.balance -= balance;
            aTMBalance -= balance;
            return true;
        } else{
            System.out.println("Данная сумма превышает количество средств на вашем счете");
            return false;
        }
    }

    @Override
    public boolean addBalance(int balance) {
        return false;
    }
}
