package com.tarasik.alex.interfaces;

/**
 * @author Alex Tarasik on 21.07.2019.
 * @project ATM
 */
public interface IClient {

    int getBalance();
    boolean removeBalance(int money);
    boolean addBalance(int money);

}
