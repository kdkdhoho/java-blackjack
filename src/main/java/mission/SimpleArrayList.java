package mission;

public class SimpleArrayList<T> implements SimpleList<T> {

    private static final int DEFAULT_SIZE = 5;

    private T[] arrayList;
    private int size = 0;

    public SimpleArrayList() {
        this.arrayList = (T[]) new Object[DEFAULT_SIZE];
    }

    @SafeVarargs
    public SimpleArrayList(final T... values) {
        this.arrayList = values;
        size = values.length;
    }

    @Override
    public boolean add(final T value) {
        if (size == arrayList.length) {
            T[] newList = (T[]) new Object[DEFAULT_SIZE + size];
            System.arraycopy(arrayList, 0, newList, 0, size);
            arrayList = newList;
        }
        arrayList[size] = value;
        size++;

        return true;
    }

    @Override
    public void add(final int index, final T value) {
        if (size >= arrayList.length) {
            T[] newList = (T[]) new Object[DEFAULT_SIZE + size];
            System.arraycopy(arrayList, 0, newList, 0, size);
            newList[index] = value;
            arrayList = newList;
        }

        if (size < arrayList.length) {
            for (int i = size - 1; i >= index; i--) {
                arrayList[i + 1] = arrayList[i];
            }
            arrayList[index] = value;
        }

        size++;
    }

    @Override
    public boolean contains(final T value) {
        for (int index = 0; index < size; index++) {
            if (arrayList[index].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final T value) {
        for (int index = 0; index < size; index++) {
            if (arrayList[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(final T value) {
        if (contains(value)) {
            int index = indexOf(value);
            remove(index);

            return true;
        }
        return false;
    }

    @Override
    public T remove(final int index) {
        T removeValue = get(index);

        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;

        return removeValue;
    }

    @Override
    public void clear() {
        arrayList = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public T set(final int index, final T value) {
        validateIndex(index);
        arrayList[index] = value;

        return value;
    }

    @Override
    public T get(final int index) {
        validateIndex(index);
        return arrayList[index];
    }

    private void validateIndex(final int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("[ERROR] 인덱스가 범위를 벗어났습니다.");
        }
    }
}
