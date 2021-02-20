class Calculator {
    public static int calculation(int operand1, int operand2, char operator) {
        int result;
        if ((operand1>0 && operand1<11) && (operand2>0 && operand2<11)) {
            result = switch (operator) {
                case '+' -> operand1 + operand2;
                case '*' -> operand1 * operand2;
                case '-' -> operand1 - operand2;
                case '/' -> operand1 / operand2;
                default -> throw new IllegalArgumentException();
            };
        } else throw new IllegalArgumentException();
        return result;
    }

    public static String arabicToRoman(int result) {
        StringBuilder roman = new StringBuilder();
        if (result == 100) {
            roman.append("C");
            result -= 100;
        }
        while (result >= 90) {
            roman.append("XC");
            result -= 90;
        }
        while (result >= 50) {
            roman.append("L");
            result -= 50;
        }
        while (result >= 40) {
            roman.append("XL");
            result -= 40;
        }
        while (result >= 10) {
            roman.append("X");
            result -= 10;
        }
        while (result >= 9) {
            roman.append("IX");
            result -= 9;
        }
        while (result >= 5) {
            roman.append("V");
            result -= 5;
        }
        while (result >= 4) {
            roman.append("IV");
            result -= 4;
        }
        while (result >= 1) {
            roman.append("I");
            result -= 1;
        }
        return roman.toString();
    }
}
