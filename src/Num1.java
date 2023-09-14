import java.util.Arrays;

import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;
//
class Num1 {
    boolean isNumber = false;
    boolean isRoman = false;
    int val = -1;

    //private static String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    // I - 1
    // V - 5
    // X - 10
    // L - 50
    // C - 100
    // D - 500
    // M - 1000
    static Map<String, Integer> keyRomIntUnits = Map.ofEntries(
            entry("I", 1),
            entry("II", 2),
            entry("III", 3),
            entry("IV", 4),
            entry("V", 5),
            entry("VI", 6),
            entry("VII", 7),
            entry("VIII", 8),
            entry("IX", 9),
            entry("X", 10)
    );

    static Map<Integer, String> keyIntRomeTens = Map.ofEntries(
            entry(0, ""),
            entry(1, "X"),
            entry(2, "XX"),
            entry(3, "XXX"),
            entry(4, "XL"),
            entry(5, "L"),
            entry(6, "LX"),
            entry(7, "LXX"),
            entry(8, "LXXX"),
            entry(9, "XC")
    );
    static Map<Integer, String> keyIntRomeHundreds = Map.ofEntries(
            entry(0, ""),
            entry(1, "C")

    );

    public Num1(String str) {

        //if (Arrays.asList(rome).contains(str)) {
        if (keyRomIntUnits.containsKey(String.valueOf(str.charAt(0)))) {

            isRoman = true;
            try {
                val = convertRomToInt(str);

            } catch (Exception e) {

                throw new IllegalArgumentException("Введите число от I до X");
            }
        } else {
            try {

                val = Integer.parseInt(str);
                if (val > 10 || val < 1)
                    throw new IllegalArgumentException("Введите число от 1 до 10");
                isNumber = true;

            } catch (Exception e) {

                throw new IllegalArgumentException("Не верный формат");
            }
        }
    }

    protected static int convertRomToInt(String val) {

        return keyRomIntUnits.get(val);

    }

    protected static String convertIntToRom(int val) {
        //int dec = 0;
        int units = val % 10;
        int tens = (val % 100) / 10;
        int hundreds = (val % 1000) / 100;

        String strUnits = getRomeUnits(units);
        String strTens = getRomeTens(tens);
        String strHundreds = getRomeHundreds(hundreds);

        String res = strHundreds + strTens + strUnits;
        return res;
    }

    private static String getRomeUnits(int val) {
        String s_units = "";

        for (Map.Entry<String, Integer> entry : keyRomIntUnits.entrySet()) {
            if (Objects.equals(val, entry.getValue())) {
                s_units = entry.getKey();
            }
        }
        return s_units;
    }

    private static String getRomeTens(int val) {
        String res = keyIntRomeTens.get(val);
//        if (res == null)
//            res = "";
        return res;
    }

    private static String getRomeHundreds(int val) {
        String res = keyIntRomeHundreds.get(val);
//        if (res == null)
//            res = "";
        return res;

    }

}

