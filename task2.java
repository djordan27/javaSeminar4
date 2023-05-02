/*Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class task2 {
    public static int value, index, myChoise;
    //public static int myChoise;
    public static void main(String[] args) {
        List mainList = myList();
        decstopPrint();
        System.out.println("Ваш список " + myList());
        myChoise = -1;
        while(myChoise != 0) {
            myChoise = myScan();
            if(myChoise == 1) {
                System.out.print("Введите индекс перемещаемого элемента\n");
                index = myScan();
                while (index > mainList.size() - 1 || index < 0) {
                    int size = mainList.size() - 1;
                    System.out.println("Вы ввели недопустимое значение, вы можете ввести число от 0 до "
                            + size);
                    index = myScan();
                    //continue;
                }
                mainList = enqueue(index, (LinkedList<Integer>) mainList);
                System.out.println(mainList);
            } else if (myChoise == 2) {
                mainList = dequeue((LinkedList<Integer>)mainList);
                System.out.println("Первый элемент очереди, был удален " + value +
                        "\nВаша текущая очередь" + mainList);
            } else if (myChoise == 3) {
                System.out.println("Ваш первый элемент "+ first((LinkedList<Integer>)mainList));
            } else {
                System.out.println("Вы ввели недопустимое значение поробуйте еще раз ");
                decstopPrint();
            }
        }
    }
    public static LinkedList<Integer> myList() {
        List newMyList = new LinkedList<Integer>();
        newMyList.add(1);
        newMyList.add(2);
        newMyList.add(3);
        newMyList.add(4);
        newMyList.add(5);
//        if(myChoise == 1) {
//            //System.out.print("Введите индекс перемещаемого элемента\n");
//            //int index = myScan();
//            //System.out.println(
//            enqueue(index,myList(myChoise));
//        } else if (myChoise == 2) {
//            //System.out.println("Первый элемент очереди, был удален " + value +
//                    //"Ваша текущая очередь" +
//            dequeue(myList(myChoise));
//        }
        return (LinkedList<Integer>) newMyList;
    }
    public static int myScan(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static LinkedList<Integer> enqueue(int index, LinkedList<Integer> newMyList){
        newMyList.addLast(index);
        newMyList.remove(index - 1);
        return  newMyList;
    }
    public  static LinkedList<Integer> dequeue(LinkedList<Integer> newMyList){
        value = newMyList.getFirst();
        newMyList.pollFirst();
        return newMyList;
    }
    public static int first(LinkedList<Integer> myList){
        return myList.getFirst();
    }
    public static void decstopPrint(){
        System.out.println("Введите значение для работы со списком:\n" +
                "0 - завершение работы\n" +
                "1- помещает указанный элемент в конец очереди\n" +
                "2 - возвращает первый элемент из очереди и удаляет его\n" +
                "3 - возвращает первый элемент из очереди, не удаляя.\n");
    }
}
