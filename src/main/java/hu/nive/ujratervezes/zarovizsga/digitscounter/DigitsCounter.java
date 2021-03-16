package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;

public class DigitsCounter {

    public int getCountOfDigits(String inputString) {
        HashSet<Character> numberSet = new HashSet<>();

        if (isEmpty(inputString)) {
            return 0;
        }

        for (int i = 0; i < inputString.length(); i++) {
            char actualChar = inputString.charAt(i);

            if (Character.isDigit(actualChar)) {
                numberSet.add(actualChar);
            }
        }

        return numberSet.size();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
