public class DynamicStringList implements StringList{
    private String[] data;
    private int size;

    public DynamicStringList() {
        data = new String[10]; 
        size = 0;
    }
    // get() interface
    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    //set() interface
    @Override
    public void set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    
}
