import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random(0);
        System.out.println("������� ������ ������: ");
        int n = kb.nextInt();
        List list = new List();
        for (int i = 0; i < n; i++) {
            list.push_front(rand.nextInt(100));
            //list.push_back(rand.nextInt(100));
        }
        list.print();
        /*list.reverse_print();
        list.pop_front();
        list.pop_back();
        list.print();
        list.reverse_print();*/
        /*System.out.println("������� ����������� ��������: ");
        int value = kb.nextInt();
        System.out.println("������� ������ ������������ ��������: ");
        int index = kb.nextInt();
        list.insert(value, index);*/
        System.out.println("������� ��������� ��������: ");
        int index = kb.nextInt();
        list.erase(index);
        list.print();
    }
}