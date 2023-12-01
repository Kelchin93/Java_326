import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello world!");
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
        System.out.println("The end");*/
       /* try
        {
            FileWriter fileWriter = new FileWriter("File.txt");
            fileWriter.write("IO Exception check");
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }*/
        try {
            FileReader fileReader = new FileReader("C:\\File.txt");
            char[] buffer = new char[100];
            fileReader.read(buffer);
            System.out.println(buffer);
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        /*catch (IOException e)
        {
            System.out.println(e.getMessage());
        }*/
    }

    static int factorial(int n) throws RuntimeException, FileNotFoundException
    {
        if (n > 12) throw new RuntimeException("Test Exception");
        return 0;
    }
    static String load(String filename) throws FileNotFoundException
    {
        if (filename == null) throw new FileNotFoundException("File not Found");
        return "OK";
    }
    catch (IndexOutOfBoundsException)
}