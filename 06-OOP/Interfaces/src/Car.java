public class Car extends GroundVehile
{
    public void move()
    {
        System.out.println("������ �����, ������ �������.....");
    }
    public String toString(){
        move();
        return super.toString();
    }
}
