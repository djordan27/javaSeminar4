import javax.swing.text.html.parser.Parser;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*
* Напишите постфиксный калькулятор.
* Пользователь вводит данные и операции в
* обратной польской записи. Калькулятор вычисляет результат и
* проверяет, что в стэке получилось единственное число.
Например:
5 4 3 - + => 5 1 + => 6*/
public class task3 {
    public static void main(String[] args) {
        String array[] = myScan();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
          System.out.println("\n" + numberList(array));
          System.out.println(mathematicalOperationsList(array));
          if(numberList(array).size() != mathematicalOperationsList(array).size() + 1){
              System.out.println("Вы ввели неверное количество математических операций");
              return;
          }
        System.out.println(myArithmetic(mathematicalOperationsList(array), flippedOverListInteger(numberList(array))));
        System.out.println(flippedOverListInteger(numberList(array)));
    }
    public static String [] myScan(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String [] array = line.split(" ");
        return array;
    }
    public static LinkedList<Integer> numberList (String [] numbers){
        LinkedList<Integer> numbersList = new LinkedList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            try {
               //int value = parseInt(Arrays.toString(numbers.split(" ")));
                numbersList.add(parseInt(numbers[i]));
            } catch (Exception io){
                return numbersList;
            }

        }
        return numbersList;
    }
    public static  LinkedList<String> mathematicalOperationsList(String []operations){
        int i = 0;
        LinkedList<String> stringList = new LinkedList<String>();
        while (i < operations.length) {
            if(operations[i].equals("+") || operations[i].equals("-")
            || operations[i].equals("*") || operations[i].equals("/")){
                stringList.add(operations[i]);
            }
            i++;
        }
        return stringList;
    }
    public static int myArithmetic (LinkedList<String> mathematic, LinkedList<Integer> numbers) {
        int sum = 0;
        int number1 = 0;
        int number2 = 0;

        int i = -1;
        while (i < mathematic.size() - 1) {
            i++;
            switch (mathematic.get(i)) {
                case "+":
                    if (i == 0){
                        number1 = numbers.get(i);
                        number2 = numbers.get(i + 1);
                        sum = number1 + number2;
                        System.out.println("Сработал + " + sum + "i = " + i + "number1 = " + number1 + "number2 = " + number2);
                    } else if (i > 0){
                        number1 = numbers.get(i + 1);
                        sum = sum + numbers.get(i + 1);
                        System.out.println(number1 + " +" + sum);
                    }
                    System.out.println("Сработал + " + sum);
                    break;
                case "-":
                    if (i == 0){
                        number1 = numbers.get(i);
                        number2 = numbers.get(i + 1);
                        sum = number1 - number2;
                        System.out.println("a");
                    } else if (i > 0){
                        number1 = numbers.get(i + 1);
                        sum = sum - numbers.get(i + 1);
                        System.out.println("b");
                    }
                    System.out.println("Сработал -" + sum);
                    break;
                case "*":
                    if (i == 0) sum = numbers.get(i) * numbers.get(i + 1);
                    else sum = sum * numbers.get(i + 1);
                    break;
                case "/":
                    if (i == 0) sum = numbers.get(i) / numbers.get(i + 1);
                    else sum = sum / numbers.get(i + 1);
            }
//                int i = mathematic.size() + 1;
//                int count = -1;
//        while (i > 1 ) {
//            i--;
//            count++;
//            switch (mathematic.get(count)){
//                case"+":
//                    if (i == mathematic.size() - 1) {sum = numbers.get(i) + numbers.get(i-1);}
//                    else {sum = sum + numbers.get(i-1);}
//                    System.out.println(sum + " +" + numbers.get(i-1) + " " + sum);
//                    break;
//                case"-":
//                    if (i ==mathematic.size() - 1) {sum = numbers.get(i) - numbers.get(i-1);}
//                    else {sum = sum - numbers.get(i-1);}
//                    System.out.println(numbers.get(i) + " - " + numbers.get(i-1) + " " + sum);
//                    break;
//                case"*":
//                    if (i ==mathematic.size() - 1) sum = numbers.get(i) * numbers.get(i-1);
//                    else sum = sum * numbers.get(i-1);
//                    break;
//                case"/":
//                    if (i ==mathematic.size() - 1) sum = numbers.get(i) / numbers.get(i-1);
//                    else sum = sum / numbers.get(i-1);
//            }
//            System.out.println(sum);
//
//        }

        }
        return sum;
    }
    public static LinkedList<Integer> flippedOverListInteger (LinkedList<Integer> newMyList){
        int count = newMyList.size();

        for (int i = 1; i <= count; i++) {
            newMyList.offerFirst(i);
            newMyList.removeLast();
            //System.out.println(i);
        }
        return newMyList;
    }
//    public static LinkedList<String> flippedOverListString (LinkedList<String> newMyList){
//        int count = newMyList.size();
//
//        for (int i = 1; i <= count; i++) {
//            newMyList.offerFirst(i);
//            newMyList.removeLast();
//            //System.out.println(i);
//        }
//        return newMyList;
//    }
}
