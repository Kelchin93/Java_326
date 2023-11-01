public class ForwardList {
    Element Head;
    Element End;

    public ForwardList() {
        this.Head = null;
        this.End = null; 
        System.out.println("LConstructor:\t" + Integer.toHexString(hashCode()));
    }

    public void push_front(int Data) {
        Element New = new Element(Data);
        New.setNext(Head);
        Head = New;
    }

    public void push_back(int Data) {
        Element New = new Element(Data);
        End.setNext(New);
        New = End;
    }

    public void print() {
        Element Temp = Head;
        while (Temp != null) {
            System.out.print(Temp.getData() + "\t");
            Temp = Temp.getNext();
        }
    }
}
