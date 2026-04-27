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

    // add() 
    @Override
    public void add(String value) {
        if (size == data.length) {
            String[] newData = new String[data.length * 2];         
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            } 
            data = newData;
        }

        data[size] = value;
        size++;
    }


    // remove 
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        String removed = data[index];
        
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
        return removed;
    }
}
