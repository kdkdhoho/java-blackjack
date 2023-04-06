package mission;

public interface SimpleList<T> {

    @SafeVarargs
    static <T> SimpleList<T> fromArrayToList(final T... values) {
        return SimpleImmutableList.fromArrayToList(values);
    }

    static <T extends Number> double sum(final SimpleList<T> values) {
        double result = 0.0;
        for (int i = 0; i < values.size(); i++) {
            result += values.get(i).doubleValue();
        }

        return result;
    }

    static <T extends Number> SimpleList<T> filterNegative(final SimpleList<T> values) {
        for (int i = 0; i < values.size(); i++) {
            double value = values.get(i).doubleValue();

            if (value < 0) {
                values.remove(i);
            }
        }

        return values;
    }

    static <T> void copy(final SimpleList<T> source, final SimpleList<? super T> destination) {
        destination.clear();

        for (int i = 0; i < source.size(); i++) {
            T value = source.get(i);
            destination.add(value);
        }
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
