package mission;

public class SimpleImmutableList {

    private static abstract class SimpleAbstractImmutableList<T> implements SimpleList<T> {

        private final T[] values;
        private final int size;

        public SimpleAbstractImmutableList(final T[] values) {
            this.values = values;
            size = values.length;
        }

        @Override
        public boolean add(final T value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(final int index, final T value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T set(final int index, final T value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public T get(final int index) {
            validateRange(index);
            return values[index];
        }

        private void validateRange(final int index) {
            if (index < 0 || index >= values.length) {
                throw new IndexOutOfBoundsException();
            }
        }

        @Override
        public boolean contains(final T value) {
            for (final T peekValue : values) {
                if (peekValue.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int indexOf(final T value) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals(value)) {
                    return i;
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
            throw new UnsupportedOperationException();
        }

        @Override
        public T remove(final int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class SimpleListN<T> extends SimpleAbstractImmutableList<T> {
        public SimpleListN(final T[] values) {
            super(values);
        }
    }

    public static <T> SimpleList<T> fromArrayToList(final T[] values) {
        return new SimpleListN<>(values);
    }

    public static double sum(final SimpleList<? extends Number> values) {
        double result = 0.0;
        for (int i = 0; i < values.size(); i++) {
            result += values.get(i).doubleValue();
        }

        return result;
    }
}
