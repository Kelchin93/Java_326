public class List {

    public class Element {
        private int Data;
        private Element Next;
        private Element Prev;
        private static int count = 0;

        public int getData() {
            return Data;
        }

        public void setData(int data) {
            Data = data;
        }

        public Element getNext() {
            return Next;
        }

        public void setNext(Element next) {
            Next = next;
        }

        public Element getPrev() {
            return Prev;
        }

        public void setPrev(Element prev) {
            Prev = prev;
        }

        public Element(int Data) {
            this.Data = Data;
            count++;
            System.out.println("EConstructor:\t" + Integer.toHexString(hashCode()));
        }

        public Element(int Data, Element Next) {
            this.Data = Data;
            this.Next = Next;
            count++;
            System.out.println("EConstructor:\t" + Integer.toHexString(hashCode()));
        }

        @Override
        protected void finalize() {
            //super.finalize();
            count--;
            System.out.println("EDestructor:\t" + Integer.toHexString(hashCode()));
        }
    }


    private Element Head, Tail;
    private int size;

    public Element getHead() {
        return Head;
    }

    public Element getTail() {
        return Tail;
    }

    public int getSize() {
        return size;
    }

    public List() {
        Head = Tail = null;
        size = 0;
        System.out.println("LConstructor:\t" + Integer.toHexString(hashCode()));
    }

    List(List other) {
        System.out.println("CopyConstructor: " + Integer.toHexString(hashCode()));
        for (Element Temp = other.Head; Temp != null; Temp = Temp.getNext())
            this.push_front(Temp.getData());
    }

    //                  Adding elements:
    public void push_front(int Data) {
        if (Head == null && Tail == null) {
            Head = Tail = new Element(Data);
        } else {
            /*Element New = new Element(Data);
            New.setNext(Head);
            Head.setPrev(New);
            Head = New;*/
            Head = Head.Prev = new Element(Data, Head);
        }

        size++;
    }

    public void push_back(int Data) {
        if (Head == null && Tail == null) {
            Head = Tail = new Element(Data);
        } else {
            Element New = new Element(Data);
            New.setPrev(Tail);
            Tail.setNext(New);
            Tail = New;
        }
        size++;
    }

    //                      Removing elements
    public void pop_front() {
        if (Head == null && Tail == null) return;
        else if (Head == Tail) {
            Head.finalize();
            Head = Tail = null;
        } else {
            Head = Head.Next;
            Head.Prev.finalize();
            Head.Prev = null;
        }
        size--;
    }

    public void pop_back() {
        if (Head == null && Tail == null) return;
        if (Head == Tail) {
            Tail.finalize();
            Head = Tail = null;
        } else {
            Tail = Tail.Prev;
            Tail.Next.finalize();
            Tail.Next = null;
        }
        size--;
    }

    public void insert(int Data, int Index) {
        if (Index == 0) {
            push_front(Data);
        }
        if (Index > size) return;
        Element Temp = Head;
        for (int i = 0; i < Index - 1; i++) Temp = Temp.getNext();
        Temp.setNext(new Element(Data, Temp.getNext()));
        /*if (Head == null && Tail == null) {
            Head = Tail = new Element(Data);
        }else {
            Element New= new Element(Data);
            New.setNext(Head);
            Head.setPrev(New);
            Head=New;
        }*/
        size++;
    }

    public void erase(int Index) {
        if (Head == null && Tail == null) return;
        if (Head == Tail) {
            Tail.finalize();
            Head = Tail = null;
        } else if (Index == 0) {
            pop_front();
        } else if (Index < 0) System.out.println("Index < List, Element not deleted: ");
        if (Index == size) {
            pop_back();
        } else if (Index > 0) System.out.println("Index > List, Element not deleted: ");
        if (Index > 1 && Index < size) {
            Element Temp = Head;
            for (int i = 0; i < Index - 1; i++) {
                Temp = Temp.getNext();
            }
            Temp.setNext(Temp.getNext().getNext());
            size++;
        }
    }

    //                      Methods
    public void clear() {
        while (Head != null) pop_front();
        //Head = Tail = null;
    }

    public void print() {
        for (Element Temp = Head; Temp != null; Temp = Temp.getNext())
            System.out.print(Temp.Data + "\t");
       /* Element Temp = Head; //Temp - Итератор
        while (Temp != null) {
            System.out.print(Temp.Data + "\t");
            Temp = Temp.getNext();
        }*/
        //for(Counter; Condition; Expression)
        //for(Iterator, Condition, Expression)
        System.out.println("\nКоличество элементов списка: " + size);
        System.out.println("\nОбщее количество элментов: " + Element.count);
    }

    public void reverse_print() {
        for (Element Temp = Tail; Temp != null; Temp = Temp.Prev)
            System.out.print(Temp.Data + "\t");
        System.out.println("\nКоличество элементов списка: " + size);
        System.out.println("\nОбщее количество элментов: " + Element.count);
    }
}
