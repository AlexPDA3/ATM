package com.tarasik.alex;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.tarasik.alex.Database.*;

/**
 * @author Alex Tarasik on 20.07.2019.
 * @project ATM
 */
public class ATM {

    public static String cardNumber;
    private static boolean loginMenuIndicator = false;
    private static String password;
    public static int aTMBalance = 10000000;

    static int option;

    public static Client client;

    public static void main(String[] args) throws FileNotFoundException {

        readingFile();
        loginMenu();
        if (loginMenuIndicator) {
            ATM.menu();
        }
        inputMenu();
    }

    private static void loginMenu(){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер вашей карты в виде: XXXX-XXXX-XXXX-XXXX:"+"\n");
        cardNumber = in.next();

        while (!cardNumber.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")){
            System.out.print("Введите номер карты в соответствии с шаблоном:" + "\n");
            cardNumber = in.next();
        };

        Validation.validation();
        conditions();
    }

    //поиск строки, содержащей переменную cardNumber, проверка на валидность
    private static void conditions(){
        Scanner in = new Scanner(System.in);

        int blockVar = 0;

        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).contains(cardNumber) && Validation.validity) {
                System.out.print("Введите пин-код:" + "\n");
                password = in.next();

                while(!database.get(i).contains(password)){
                    System.out.println("Неверный пин-код! Повторите вашу попытку");
                    password = in.next();
                    blockVar ++;
                    if (blockVar==2) System.out.println("Вы ввели неправильный пин-код 3 раза!");
                }

                loginMenuIndicator = true;
                break;
            }
        }
    }

    private static void menu(){

        //user menu
        do {
            System.out.print("\n");
            System.out.print("1. Проверить баланс карты"+"\n");
            System.out.print("2. Снять средства со счета"+"\n");
            System.out.print("3. Пополнить баланс"+"\n");
            System.out.print("4. Выход из программы"+"\n");
            System.out.print("\n");
            System.out.print("Введите номер выбранного пункта: "+"\n");

            Scanner in = new Scanner(System.in);
            option = in.nextInt();

            if (option<1||option >3){
                System.out.print("Выберите существующий пункт меню!"+"\n");
            }
        } while (option <1 || option >3);
    }

    //Не успел написать класс, достающий баланс из ArrayList и записывающий новые данные
    private static void inputMenu(){

        Scanner in = new Scanner(System.in);

        switch (option) {
            case 1: {
                System.out.println("Баланс карты: " + client.getBalance());
                break;
            }
            case 2: {
                System.out.print("Введите сумму: ");
                try {
                    int b = in.nextInt();
                    if (client.removeBalance(b)) {
                        System.out.println("Вывод произошел успешно");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Введите корректную сумму");
                }

                break;
            }
            case 3: {
                System.out.print("Введите сумму: ");
                try {
                    int b = in.nextInt();
                    if (client.addBalance(b)) System.out.println("Баланс успешно пополнен");
                } catch (NumberFormatException e) {
                    System.out.println("Введите корректную сумму");
                }
                break;
            }
            case 4: {
                writingFile();
                System.exit(0);
                break;
            }
        }
    }
}
