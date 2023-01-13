import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {

        correctOperation(input);
        String[] line = input.trim().split(" ");
        int sign = line[1].codePointAt(0);

        if (isRoman(line[0], line[2], sign) == "rome") {
            RomanNumeral line0 = RomanNumeral.valueOf(line[0]), line2 = RomanNumeral.valueOf(line[2]);
            int a = line0.getRomanValue(), b = line2.getRomanValue();
            switch (line[1]) {
                case "+":
                    return getRomanNumber(a + b);
                case "-":
                    return getRomanNumber(a - b);
                case "*":
                    return getRomanNumber(a * b);
                case "/":
                    return getRomanNumber(a / b);
            }
        }
        int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[2]);

        switch (line[1]) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return String.valueOf(a / b);
        }
        return "";
    }

    public static boolean correctOperation(String line) throws ArrayIndexOutOfBoundsException, InputException {
        try {
            String[] line1 = line.trim().split(" ");
            String line0 = line1[1];
            if (line1.length > 3) {
                throw new InputException("Операция не может быть произведена, так как калькулятор принимает только два числа.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Операция неправильно введена.");
        }
        return true;
    }

    public static String isRoman(String a1, String b1, int sign) throws IllegalArgumentException, InputException {
        try {
            RomanNumeral line0 = RomanNumeral.valueOf(a1);
            RomanNumeral line2 = RomanNumeral.valueOf(b1);
            int a = line0.getRomanValue();
            int b = line2.getRomanValue();
            if ((0 > a) | (a > 10) | (0 > b) | (b > 10)) {
                throw new InputException("Операция не может быть произведена, так как калькулятор принимает числа от 1 до 10 включительно.");
            }
            if ((a <= b) & (sign == 45)) {
                throw new InputException("Операция не может быть произведена, так как результат вычислений меньше единицы");
            }
            return "rome";
        } catch (IllegalArgumentException e) {
            return isArab(a1, b1);
        }
    }

    public static String isArab(String a1, String b1) throws NumberFormatException, InputException {
        try {
            int a = Integer.parseInt(a1), b = Integer.parseInt(b1);
            if ((0 >= a) | (a > 10) | (0 >= b) | (b > 10)) {
                throw new InputException("Операция не может быть произведена, так как калькулятор принимает числа от 1 до 10 включительно.");
            }
            return "arab";
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Операция не может быть произведена, так как введены неверные числа." +
                    "\nВозможно используются одновременно разные системы счисления.");
        }
    }

    public static String getRomanNumber(int number) {
        return "I".repeat(number)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
    public static void main(String[] ars) throws Exception {
        System.out.println("Здравствуйте, это калькулятор!");
        System.out.println("Он умеет выполнять четыре арифметические операции с двумя числами в таком формате: a + b, a - b, a * b, a / b.");
        System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.");

        while (true) {
            Scanner input = new Scanner(System.in);
            Main result = new Main();
            System.out.print("Введите вашу операцию: ");
            String line = input.nextLine();
            String answer = result.calc(line);
            System.out.print("Ответ: ");
            System.out.println(answer);
        }
    }
}
