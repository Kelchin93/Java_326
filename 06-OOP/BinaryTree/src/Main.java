import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random(0);
        System.out.print("������� ������ ������: ");
        int n = kb.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(rand.nextInt(100));
        }
        //tree.print();
        System.out.println();
        Long start_time, end_time;
        start_time = System.nanoTime();
        System.out.print("����������� �������� � ������: " + tree.minValue());
        end_time = System.nanoTime();
        System.out.println("\t���������� �� " +(end_time-start_time)*1e-9);

        System.out.println("������������ �������� � ������: " + tree.maxValue());
        System.out.println("����� ��������� ������: " + tree.sum());
        System.out.println("���������� ��������� ������: " + tree.count());
        System.out.println("������-�������������� ��������� ������: " + tree.avg());
        System.out.println("������� ������: " + tree.depth());

        UniqueTree u_tree = new UniqueTree();
        for (int i = 0; i < n; i++) {
            u_tree.insert(rand.nextInt(100));
        }
        //u_tree.clear();
        //u_tree.print();
        System.out.println();
        System.out.println("����������� �������� � ������: " + u_tree.minValue());
        System.out.println("������������ �������� � ������: " + u_tree.maxValue());
        System.out.println("����� ��������� ������: " + u_tree.sum());
        System.out.println("���������� ��������� ������: " + u_tree.count());
        System.out.println("������-�������������� ��������� ������: " + u_tree.avg());
        System.out.println("������� ������: " + u_tree.depth());

       /* Tree tree = new Tree(new int[]{50,25,75,16,32,64,80, 33});
        tree.print();
        System.out.println("������� ������: " + u_tree.depth());*/
        /*System.out.println("������� �������� ���������� ��������: ");
        int value = kb.nextInt();
        tree.erase(value);
        tree.print();*/
    }
}