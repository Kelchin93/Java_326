import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(0);
        Scanner kb = new Scanner(System.in);
        System.out.println("¬ведите размер списка: ");
        int n = kb.nextInt();

        ForwardList list = new ForwardList();
        for (int i = 0; i < n; i++) {
            list.push_front(rand.nextInt(100));
            //list.push_back(rand.nextInt(100));
        }
        //list.print();

        /*list.push_back(123);
        list.print();
        list.pop_front();
        list.pop_back();*/

        /*System.out.println("¬ведите значение добавл€емого значени€: ");
        int value = kb.nextInt();
        System.out.println("¬ведите индекс добавл€емого значени€: ");
        int index = kb.nextInt();
        list.insert(value, index);
        list.print();*/

        long start_time = System.nanoTime();
        ForwardList list2 = new ForwardList(list);
        Long end_time = System.nanoTime();
        System.out.println("—писок скопировалс€ за %f секунд".formatted((double)(end_time - start_time)*1e-9));
        /*list2.print();
        list.pop_back();
        list.print();
        list2.print();*/

        /*System.out.println("¬ведите индекс удал€емого значени€: ");
        int index = kb.nextInt();
        list.erase(index);
        list.print();
        list.clear();*/

        /*System.out.println("Enter: ");
        int head = kb.nextInt();
        list.revers();*/
    }
}