public class Calc {
    String[] romanNumbers = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static String calc(String input) throws Exception {
        String[] inputArray = input.split(" ");
        String result = null;

        if (inputArray.length != 3) {
            throw new Exception();
        }

        isRoman(inputArray[0]);
        isRoman(inputArray[2]);

        if (!isRoman(inputArray[0]) && (!isRoman(inputArray[2]))) {
            if ((Integer.parseInt(inputArray[0]) > 10) || (Integer.parseInt(inputArray[2]) > 10) ||
                    (Integer.parseInt(inputArray[2]) <= 0) || (Integer.parseInt(inputArray[0]) <= 0)) {
                throw new Exception();
            }
            if (inputArray[1].equalsIgnoreCase("+")) {
                result = Integer.toString((Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[2])));
            } else if (inputArray[1].equalsIgnoreCase("-")) {
                result = Integer.toString(Integer.parseInt(inputArray[0]) - Integer.parseInt(inputArray[2]));
            } else if (inputArray[1].equalsIgnoreCase("/")) {
                result = Integer.toString(Integer.parseInt(inputArray[0]) / Integer.parseInt(inputArray[2]));
            } else if (inputArray[1].equalsIgnoreCase("*")) {
                result = Integer.toString(Integer.parseInt(inputArray[0]) * Integer.parseInt(inputArray[2]));
            } else {
                throw new Exception();
            }
        }

        if (isRoman(inputArray[0]) && (isRoman(inputArray[2]))) {
            if (((indexOfRomanNumber(inputArray[0])) > 10)  || ((indexOfRomanNumber(inputArray[2])) > 10)){
                throw new Exception();
            }
            Calc calc = new Calc();
            if (inputArray[1].equalsIgnoreCase("+")) {
                result = calc.romanNumbers[indexOfRomanNumber(inputArray[0]) + indexOfRomanNumber(inputArray[2])];
            } else if (inputArray[1].equalsIgnoreCase("-")) {
                result = calc.romanNumbers[indexOfRomanNumber(inputArray[0]) - indexOfRomanNumber(inputArray[2])];
                if (indexOfRomanNumber(result) < 0) {
                    throw new Exception();
                }
            } else if (inputArray[1].equalsIgnoreCase("/")) {
                result = calc.romanNumbers[indexOfRomanNumber(inputArray[0]) / indexOfRomanNumber(inputArray[2])];
            } else if (inputArray[1].equalsIgnoreCase("*")) {
                result = calc.romanNumbers[indexOfRomanNumber(inputArray[0]) * indexOfRomanNumber(inputArray[2])];
            } else {
                throw new Exception();
            }
        }

        if ((!isRoman(inputArray[0]) && (isRoman(inputArray[2]))) || (isRoman(inputArray[0]) && (!isRoman(inputArray[2])))) {
            throw new Exception();
        }
        return result;
    }

    public static boolean isRoman(String number) {
        Calc calc = new Calc();
        boolean result = false;
        for (int i = 0; i < calc.romanNumbers.length; i++) {
            if (calc.romanNumbers[i].equals(number)) {
                result = true;
            }
        }
        return result;
    }

    public static int indexOfRomanNumber(String number) {
        Calc calc = new Calc();
        int index = 0;
        for (int i = 0; i < calc.romanNumbers.length; i++) {
            if (calc.romanNumbers[i].equals(number)) {
                index = i;
            }
        }
        return index;
    }
}