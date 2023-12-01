public class Plane extends AirVehicle
{
    public void move()
    {
        System.out.println("������� �� �����");
    }

    @Override
    public void fly() {
        System.out.println("����� �� ������� ������ � ������� ���������");
    }

    @Override
    public void top_up() {
        System.out.println("����������� �� �������� ������ � ��������");
    }

    @Override
    public void land() {
        System.out.println("������� �� �������");
    }

    @Override
    public String toString() {
        move();
        top_up();
        fly();
        land();
        return super.toString();
    }
}
