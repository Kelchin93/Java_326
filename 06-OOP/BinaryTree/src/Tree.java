import jdk.jfr.DataAmount;

public class Tree {
    class Element {
        protected int Data;
        protected Element Left;
        protected Element Right;

        public Element(int data) {
            Data = data;
            Left = null;
            Right = null;
            //System.out.println("EConstructor:\t" + Integer.toHexString(hashCode()));
        }

        @Override
        protected void finalize() {
            //super.finalize();
            //System.out.println("EDestructor:" + Integer.toHexString(hashCode()));
        }
    }

    protected Element Root;

    public Element getRoot() {
        return Root;
    }

    public Tree() {
        Root = null;
        System.out.println("TConstructor:\t" + Integer.toHexString(hashCode()));
    }
    public Tree(int[] arr)
    {
        for (int i : arr)
        {
            insert(i, Root);
        }
        System.out.println("Constructor:\t" + Integer.toHexString(hashCode()));
    }
    public void insert(int Data)
    {
        insert(Data, Root);
    }

    private void insert(int Data, Element Root) {
        if (this.Root == null) this.Root = new Element(Data);
        if (Root == null) return;
        if (Data < Root.Data)
        {    //Добавляем значение в левую ветку
            if (Root.Left == null) Root.Left = new Element(Data);
            else insert(Data, Root.Left);
        } else
        {    //Добавляем в правую ветку
            if (Root.Right == null) Root.Right = new Element(Data);
            else insert(Data, Root.Right);
        }
    }
    public void erase(int Data)
    {
        erase(Data, Root, null);
    }
    private void erase(int Data, Element Root, Element Parent)
    {
        if (Root == null)return;
        erase(Data, Root.Left, Root);
        erase(Data, Root.Right, Root);
        if (Data == Root.Data)
        {
            if (Root.Left == Root.Right)
            {
                Root = null;
                if (Parent!=null)
                {
                    if (Data == Parent.Left.Data)Parent.Left = null;
                    if (Data == Parent.Right.Data)Parent.Right = null;
                }
                System.gc();
            }
            else
            {
                if (count(Root.Left)>count(Root.Right))
                {
                    Root.Data = maxValue(Root.Left);
                    erase(maxValue(Root.Left), Root.Left, Root);
                }
                else
                {
                    Root.Data = minValue(Root.Right);
                    erase(minValue(Root.Right), Root.Right, Root);
                }
            }
        }
    }
    public void clear()
    {
        Root = null;
        System.gc();    //Garbage Collector - сборщик мусора
    }

    public int minValue() {
        return minValue(Root);
    }

    private int minValue(Element Root) {
        /*if (Root.Left == null) return Root.Data;
        else return minValue(Root.Left);*/
        if (Root == null) return 0;
        return Root.Left == null ? Root.Data : minValue(Root.Left);
    }

    public int maxValue() {
        return maxValue(Root);
    }

    private int maxValue(Element Root) {
        /*if (Root.Right == null) return Root.Data;
        else return maxValue(Root.Right);*/
        if (Root == null) return 0;
        return Root.Right == null ? Root.Data : maxValue(Root.Right);
    }

    public int sum() {
        return sum(Root);
    }

    private int sum(Element Root) {
       /* if (Root == null) return 0;
        else return sum(Root.Left) + sum(Root.Right) + Root.Data;*/
        return Root == null ? 0 : sum(Root.Left) + sum(Root.Right) + Root.Data;
    }

    public int count() {
        return count(Root);
    }

    private int count(Element Root) {
        /*if (Root == null) return 0;
        else return count(Root.Left) + count(Root.Right) + 1;*/
        return Root == null ? 0 : count(Root.Left) + count(Root.Right) + 1;
    }
    public double avg()
    {
        return (double) sum(Root)/count(Root);
    }
    public int depth()
    {
        return depth(Root);
    }
    private int depth(Element Root)
    {
        if (Root == null) return 0;
        /*if (depth(Root.Left) + 1 > depth(Root.Right) + 1)
            return depth(Root.Left) +1;
        else
            return depth(Root.Right) + 1;*/ //метод не рекомендуется
        int l_depth = depth(Root.Left) +1;
        int r_depth = depth(Root.Right) + 1;
        return l_depth>r_depth ? l_depth : r_depth;
    }

    public void print() {
        print(Root);
        System.out.println();
    }

    public void print(Element Root) {
        if (Root == null) return;
        print(Root.Left);
        System.out.print(Root.Data + "\t");
        print(Root.Right);
    }
}
