import com.sun.source.util.DocTreePathScanner;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        Напишите метод, который в качестве параметра пинимает строку в которой записано двоичное число,
        в качестве результата возвращает десятичное представление числа.
        Например: "101" -> 5
        Естественно, в рамкх данной задачи нельзя использовать методы типа Integer.ParseInt и т.п.
        Подсказка: см. код написанный в классе
*/

        String newBinaryNumber = inputBinaryNumber();
        ArrayList<Character> newListChars = creationArrayList(newBinaryNumber);
        ArrayList<Integer> newArrayNumber;
        try{
            newArrayNumber = transformationToInt(newListChars);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println( "Конец программы.");
            return;
        }
        System.out.println("В десятичной системе счисления это число - " +
                creationDecimalNumber(newArrayNumber));


    }

    public static int creationDecimalNumber(ArrayList<Integer> arrayNumber) {
        int newDecimalNumber = 0;
        int pow = 0;
        for (int i = arrayNumber.size() - 1; i >= 0; i--) {
            newDecimalNumber += arrayNumber.get(i) * Math.pow(2, pow);
            pow++;
        }
        return newDecimalNumber;
    }

    public static ArrayList<Integer> transformationToInt(ArrayList<Character> listChars) throws Exception {
        ArrayList<Integer> newArrayNumber = new ArrayList<>(listChars.size());
        for (int i = 0; i < listChars.size(); i++) {
            if (listChars.get(i) == '0') {
                newArrayNumber.add(0);
            } else if (listChars.get(i) == '1') {
                newArrayNumber.add(1);
            }
            else {
                throw new Exception("Число введено не в двоичной системе счисления!!!");
            }
        }
        return newArrayNumber;
    }

    public static ArrayList<Character> creationArrayList(String binaryCodeNumber) {
        ArrayList<Character> newListChars = new ArrayList<>();
        for (int i = 0; i < binaryCodeNumber.length(); i++) {
            newListChars.add(binaryCodeNumber.charAt(i));
        }
        return newListChars;
    }

    public static String inputBinaryNumber() {
        String newBinaryNumber = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите комбинацию чисел из \"0\" и \"1\": ");
        newBinaryNumber = scanner.next();
        return newBinaryNumber;
    }
}