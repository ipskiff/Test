import java.util.Scanner;

public class ExpressionReader {
    public static boolean flag1;
    public static boolean flag2;
    public static boolean flag3;
    public static boolean flag4;
    private int operand1;
    private int operand2;
    private char operator;
    public String[] ops;
    public String[] opr;

    public void read() {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (text.contains("+") || text.contains("-") || text.contains("/") || text.contains("*")) {
            ops = text.split("[+-/*]"); // для получения операндов
            opr = text.split("[+-/*]"); // для получения оператора
        } else {
            throw new IllegalArgumentException("Неверный оператор");
        }

        for (int i = 0; i < ops.length; i++) {
            ops[i] = ops[i].replaceAll(" ", "");
        }

        for (String s : roman) {
            if (s.equals(ops[0])) {
                flag1 = true;
                break;
            }
        }

        for (String s : roman) {
            if (s.equals(ops[1])) {
                flag2 = true;
                break;
            }
        }

        for (String s : arabic) {
            if (s.equals(ops[1])) {
                flag3 = true;
                break;
            }
        }

        for (String s : arabic) {
            if (s.equals(ops[1])) {
                flag4 = true;
                break;
            }
        }

        operator = text.charAt(opr[0].length());

        if (flag1 && flag2) {
            operand1 = romanToArabic(ops[0]);
            operand2 = romanToArabic(ops[1]);
        } else  if (flag3 && flag4) {
            operand1 = Integer.parseInt(ops[0]);
            operand2 = Integer.parseInt(ops[1]);
        } else  if ((flag1 || flag2) || (flag3 || flag4)) {
            throw new IllegalArgumentException("Введены и римские, и арабские");
        } else throw new IllegalArgumentException("Неверный формат операндов");
    }

    private static int romanToArabic(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public char getOperator() {
        return operator;
    }
}