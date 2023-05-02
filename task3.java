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
        System.out.println(myArithmetic(mathematicalOperationsList(array), numberList(array)));
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
    public static int myArithmetic (LinkedList<String> mathematic, LinkedList<Integer> numbers){
        int sum = 0;
//        int i = 0;
//        while (i < mathematic.size()) {
//            switch (mathematic.get(i)){
//                case"+":
//                    if (i ==0) sum = numbers.get(i) + numbers.get(i+1);
//                    else sum = sum + numbers.get(i+1);
//                    break;
//                case"-":
//                    if (i ==0) sum = numbers.get(i) - numbers.get(i+1);
//                    else sum = sum - numbers.get(i+1);
//                    break;
//                case"*":
//                    if (i ==0) sum = numbers.get(i) * numbers.get(i+1);
//                    else sum = sum * numbers.get(i+1);
//                    break;
//                case"/":
//                    if (i ==0) sum = numbers.get(i) / numbers.get(i+1);
//                    else sum = sum / numbers.get(i+1);
//            }
                int i = mathematic.size() + 1;
                int count = -1;
        while (i > 1 ) {
            i--;
            count++;
            switch (mathematic.get(count)){
                case"+":
                    if (i == mathematic.size() - 1) {sum = numbers.get(i) + numbers.get(i-1);}
                    else {sum = sum + numbers.get(i-1);}
                    System.out.println(sum + " +" + numbers.get(i-1) + " " + sum);
                    break;
                case"-":
                    if (i ==mathematic.size() - 1) {sum = numbers.get(i) - numbers.get(i-1);}
                    else {sum = sum - numbers.get(i-1);}
                    System.out.println(numbers.get(i) + " - " + numbers.get(i-1) + " " + sum);
                    break;
                case"*":
                    if (i ==mathematic.size() - 1) sum = numbers.get(i) * numbers.get(i-1);
                    else sum = sum * numbers.get(i-1);
                    break;
                case"/":
                    if (i ==mathematic.size() - 1) sum = numbers.get(i) / numbers.get(i-1);
                    else sum = sum / numbers.get(i-1);
            }
            System.out.println(sum);

        }
        return sum;
    }
}
