public class Main {
    public static void main(String[] args) {
        System.out.println("Input:");
        ExpressionReader reader = new ExpressionReader();
        try {
            reader.read();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        int result = Calculator.calculation(reader.getOperand1(), reader.getOperand2(), reader.getOperator());

        if (ExpressionReader.flag1 && ExpressionReader.flag2) {
            System.out.println("Output:");
            System.out.println(Calculator.arabicToRoman(result));
        } else if (ExpressionReader.flag3 && ExpressionReader.flag4) {
            System.out.println("Output:");
            System.out.println(result);
        } else throw new IllegalArgumentException();



    }
}
