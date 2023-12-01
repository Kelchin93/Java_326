public class Car extends GroundVehile
{
    public void move()
    {
        System.out.println("Машина ехала, колеса терлися.....");
    }
    public String toString(){
        move();
        return super.toString();
    }
}
