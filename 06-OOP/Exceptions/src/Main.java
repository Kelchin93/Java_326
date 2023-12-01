import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        try {
            factorial(13);
            load(" ");
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("The end");
    }

    static int factorial(int n) throws RuntimeException {
        if (n > 12) throw new RuntimeException("Test Exception");
        return 0;
    }
    static String load(String filename) throws FileNotFoundException
    {
        if (filename == null) throw new FileNotFoundException("File not Found");
        return "OK";
    }
    catch(IndexOutOfBoundsException)
}