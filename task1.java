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
    newMyList.add(1);
    newMyList.add(2);
    newMyList.add(3);
    newMyList.add(4);
    newMyList.add(5);
    return (LinkedList<Integer>) newMyList;
}
public static LinkedList<Integer> flippedOverList(LinkedList<Integer> newMyList){
   int count = newMyList.size();

   for (int i = 1; i <= count; i++) {
    newMyList.offerFirst(i);
    newMyList.removeLast();
        //System.out.println(i);
    }
    return newMyList;
}
}

