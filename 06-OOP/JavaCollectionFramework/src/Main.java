import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello world!");
        ArrayList al = new ArrayList();
        al.add(3);
        al.add(5);
        al.add(8);
        al.add(13);
        al.add(21);
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + "\t");
        }
        System.out.println();
        al.remove(2);
        for (Object i : al) System.out.print(i + "\t");
        System.out.println();*/

        LinkedList<Integer> list = new LinkedList();
        Collections.addAll(list, 3, 5, 8, 13, 21);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
        list.addFirst(2);
        list.addLast(34);
        for (Integer i:list) System.out.print(i+"\t");
        System.out.println();
        for (Iterator it = list.descendingIterator(); it.hasNext();)
            System.out.print(it.next() + "\t");
        System.out.println();
    }
}