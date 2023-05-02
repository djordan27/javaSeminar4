import java.util.LinkedList;
import java.util.List;

/*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
*/
public class task1 {
    public static void main(String[] args) {
        System.out.println(flippedOverList(myList()));
    }
public static LinkedList<Integer> myList() {
    List newMyList = new LinkedList<Integer>();
    newMyList.add(2);
    newMyList.add(3);
    newMyList.add(4);
    newMyList.add(5);
    newMyList.add(6);
    System.out.println(newMyList);
    return (LinkedList<Integer>) newMyList;
}
public static LinkedList<Integer> flippedOverList(LinkedList<Integer> newMyList){
   int count = newMyList.size();
   LinkedList<Integer> myList = new LinkedList<Integer>();
   int value1;
   for (int i = 0; i < count; i++) {

    value1 = newMyList.getLast();
//    newMyList.addFirst(value1);
//    newMyList.removeLast();
       myList.add(value1);
       newMyList.removeLast();
       System.out.println("i = " + i + " value 1 = " + value1);
        //System.out.println(i);
    }
    //System.out.println(myList);
    return myList;
}
}

