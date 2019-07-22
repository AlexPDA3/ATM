package com.tarasik.alex;

import java.lang.String;

/**
 * @author Alex Tarasik on 20.07.2019.
 * @project ATM
 */
public class Validation {

    static boolean validity = false;

    public static void validation() {
        validateCreditCardNumber(ATM.cardNumber);
    }

    private static void validateCreditCardNumber(String cardNumber) {

        cardNumber = cardNumber.replace("-", "");

        int[] ints = new int[cardNumber.length()];
        for (int i = 0; i < cardNumber.length(); i++) {
            ints[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 == 0) {
            System.out.println(cardNumber + " - валидный номер кредитной карты");
            validity = true;
        } else {
            System.out.println(cardNumber + " - данного номера кредитной карты не существует, повторите попытку");
        }
    }

}
