import java.io.BufferedReader;
import java.io.InputStreamReader;

//
public class Main {
    public static boolean isNumeric = false;
    public static boolean isRoman = false;


    public static void main(String[] args) {

        String input = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка ввода");
        }

        System.out.println(calc(input));

    }

    public static String calc(String input) {
        String[] members = input.split(" ");
        if (members.length < 3)
            throw new IllegalArgumentException("строка не является математической операцией");
        if (members.length > 3)
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        String answerStr = "";
        try {

            Num1 num1 = new Num1(members[0]);
            Num1 num2 = new Num1(members[2]);


            if (num1.isRoman == num2.isNumber) {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");

            }
            char matAction = members[1].charAt(0);
            int answer = calc(num1.val, num2.val, matAction);


            if (num1.isRoman) answerStr = Num1.convertIntToRom(answer);
            else answerStr = String.valueOf(answer);


        } catch (Exception e) {
            System.out.println(e);
        }
        return answerStr;
    }


    public static int calc(int a, int b, char matAction) {
        int answer = -1;
        switch (matAction) {
            case '+':
                answer = a + b;
                break;
            case '-':
                answer = a - b;
                break;
            case '*':
                answer = a * b;
                break;
            case '/':
                answer = a / b;
                break;
            default:
                System.out.printf("Error! Enter correct operator");
                //return 0;
        }
        return answer;
    }


}



