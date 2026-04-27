public class DynamicStringList implements StringList{
    private String[] data;
    private int size;

    public DynamicStringList() {
        data = new String[10]; 
        size = 0;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
}
