package mission;

public interface SimpleList<T> {

    @SafeVarargs
    static <T> SimpleList<T> fromArrayToList(final T... values) {
        return SimpleImmutableList.fromArrayToList(values);
    }

    static <T extends Number> double sum(final SimpleList<T> values) {
        return SimpleImmutableList.sum(values);
    }

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();
}
