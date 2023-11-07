public class ForwardList {
    Element Head;
    int size;
    //Element End;

    public ForwardList() {
        this.Head = null;
        size = 0;
        //this.End = null;
        System.out.println("LConstructor:\t" + Integer.toHexString(hashCode()));
    }

    ForwardList(ForwardList other) {
        System.out.println("LCopyConstructor: " + Integer.toHexString(hashCode()));
        //Shallow copy - Поверхностное копирование
        //this.Head = other.Head;
        //this.size = other.size;
        for (Element Temp = other.Head; Temp != null; Temp = Temp.getNext())
            //this.push_back(Temp.getData());
            this.push_front(Temp.getData());
        reverse();
    }

    public void reverse() {
        ForwardList reverse = new ForwardList();
        while (Head != null) {
            reverse.push_front(Head.Data);
            pop_front();
        }
        this.Head = reverse.Head;
        reverse.Head = null;
    }

    public void push_front(int Data) {
        Head = new Element(Data, Head);
        /*Element New = new Element(Data);
        New.setNext(Head);
        Head = New;*/
        size++;
    }

    public void push_back(int Data) {
        if (Head == null) {
            push_front(Data);
            return;
        }
        Element Temp = Head;
        //Доходит до конца списка
        while (Temp.getNext() != null) Temp = Temp.getNext();
        //Добавляем элемент в конец списка:
        Temp.setNext(new Element(Data));
        size++;
    }

    void insert(int Data, int Index) {
        if (Index == 0) {
            push_front(Data);
            return;
        }
        if (Index > size) return;
        Element Temp = Head;
        for (int i = 0; i < Index - 1; i++) Temp = Temp.getNext();
        /*Element New = new Element(Data);
        New.setNext(Temp.getNext());
        Temp.setNext(New);*/
        Temp.setNext(new Element(Data, Temp.getNext()));
        size++;
    }

    void erase(int Index) {
        if (Index == 1) {
            pop_front();
        } else if (Index < 1) System.out.println("Index < List, Element not deleted: ");
        if (Index == size) {
            pop_back();
        } else if (Index > size) System.out.println("Index > List, Element not deleted: ");
        if (Index > 1 && Index < size) {
            Element Temp = Head;
            for (int i = 1; i < Index - 1; i++) {
                Temp = Temp.getNext();
            }
            Temp.setNext(Temp.getNext().getNext());
            size++;
        }
    }
    /*Element revers(Element Head){
        if (Head == null){
            return null;
        }
        if (Head.getNext() == null){
            return Head;
        }
        Element Temp = revers(Head.getNext());
        Head.getNext().setNext(Head);
        Head.setNext(null);
        return Head;
    }*/

    void clear() {
        Head = null;
        System.out.println("List clear");
    }

    public void pop_front() {
        Head = Head.getNext();
        size--;
    }

    public void pop_back() {
        Element Temp = Head;
        while (Temp.getNext().getNext() != null) Temp = Temp.getNext();
        Temp.setNext(null);
        size--;
    }

    public void print() {
        Element Temp = Head;    //Temp - итератор.
        //Итератор - указатель, при помощи которого можно получить доступ к элементам структуры данных
        while (Temp != null) {
            System.out.print(Temp.getData() + "\t");
            Temp = Temp.getNext();
        }
        System.out.println();
    }
}
