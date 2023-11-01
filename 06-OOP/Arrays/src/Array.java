public class Array {
    public static int[] push_back(int[] arr, int value)
    {
        int[] buffer = new int[arr.length+1];
                for (int i = 0; i < arr.length; i++)
        {
            buffer[i] = arr[i];
        }
                buffer[arr.length] = value;
                arr = buffer;
                return arr;
    }
}
