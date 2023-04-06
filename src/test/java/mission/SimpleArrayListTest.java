package mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    private SimpleArrayList<Integer> arrayList;

    @BeforeEach
    void setUp() {
        this.arrayList = new SimpleArrayList<>();
    }

    @Test
    @DisplayName("값 자체를 넣는 add() 테스트")
    void addTest_withOutIndex() {
        arrayList.add(1);

        assertThat(arrayList.get(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("인덱스에 값을 넣는 add() 테스트")
    void addTest_withIndex() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.add(1, 3);
        assertAll(
                () -> assertThat(arrayList.get(0)).isEqualTo(1),
                () -> assertThat(arrayList.get(1)).isEqualTo(3),
                () -> assertThat(arrayList.get(2)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("첫번째 인덱스에 값을 넣는 add() 테스트")
    void addTest_withIndex0() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.add(0, 3);
        assertAll(
                () -> assertThat(arrayList.get(0)).isEqualTo(3),
                () -> assertThat(arrayList.get(1)).isEqualTo(1),
                () -> assertThat(arrayList.get(2)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("마지막 인덱스에 값을 넣는 add() 테스트")
    void addTest_withLastIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.add(5, 6);

        assertAll(
                () -> assertThat(arrayList.get(0)).isEqualTo(1),
                () -> assertThat(arrayList.get(1)).isEqualTo(2),
                () -> assertThat(arrayList.get(2)).isEqualTo(3),
                () -> assertThat(arrayList.get(3)).isEqualTo(4),
                () -> assertThat(arrayList.get(4)).isEqualTo(5),
                () -> assertThat(arrayList.get(5)).isEqualTo(6)
        );
    }

    @Test
    void set() {
        arrayList.add(1);

        arrayList.set(0, 10);

        assertThat(arrayList.get(0)).isEqualTo(10);
    }

    @Test
    void contains() {
        arrayList.add(1);

        assertAll(
                () -> assertThat(arrayList.contains(1)).isTrue(),
                () -> assertThat(arrayList.contains(0)).isFalse()
        );
    }

    @Test
    void indexOf() {
        arrayList.add(1);

        assertAll(
                () -> assertThat(arrayList.indexOf(1)).isEqualTo(0),
                () -> assertThat(arrayList.indexOf(2)).isEqualTo(-1)
        );
    }

    @Test
    void size() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        assertThat(arrayList.size()).isEqualTo(6);
    }

    @Test
    void isEmpty_true() {
        assertThat(arrayList.isEmpty()).isTrue();
    }

    @Test
    void isEmpty_false() {
        arrayList.add(1);

        assertThat(arrayList.isEmpty()).isFalse();
    }

    @Test
    void remove_withValue() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.remove((Integer) 2);

        assertAll(
                () -> assertThat(arrayList.size()).isEqualTo(1),
                () -> assertThat(arrayList.contains(2)).isFalse()
        );
    }

    @Test
    void remove_withIndex() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.remove(1);

        assertAll(
                () -> assertThat(arrayList.size()).isEqualTo(1),
                () -> assertThat(arrayList.contains(2)).isFalse()
        );
    }

    @Test
    void validate_remove_outOfIndex() {
        arrayList.add(1);
        arrayList.add(2);

        assertThatThrownBy(() -> arrayList.remove(2))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("[ERROR] 인덱스가 범위를 벗어났습니다.");
    }

    @Test
    void clear() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.clear();

        assertThat(arrayList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("배열을 받아 SimpleList로 변환한다")
    void 배열을_받아_SimpleList로_변환한다() {
        final String[] arrays = {"first", "second"};

        final SimpleList<String> values = SimpleList.fromArrayToList(arrays);

        assertAll(
                () -> assertThat(values.get(0)).isEqualTo("first"),
                () -> assertThat(values.get(1)).isEqualTo("second")
        );
    }

    @Test
    @DisplayName("빈 배열을 받아 SimpleList로 변환한다")
    void 빈_배열을_받아_SimpleList로_변환한다() {
        final Integer[] arrays = {};

        final SimpleList<Integer> values = SimpleList.fromArrayToList(arrays);

        assertThat(values.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 타입의 SimpleList를 받아 총합을 더한다")
    void 숫자_타입의_SimpleList를_받아_총합을_더한다() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<>(1, 2);

        final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
        final double intTotal = SimpleList.sum(intValues);  // 3

        assertAll(
                () -> assertThat(doubleTotal).isEqualTo(1.2),
                () -> assertThat(intTotal).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("숫자 타입의 SimpleList를 받아 음수를 제외하고 반환한다")
    void 숫자_타입의_SimpleList를_받아_음수를_제외하고_반환한다() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<>(-0.1, 0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<>(-10, 1, 2);

        final SimpleList<Double> filteredDoubleValues = SimpleList.filterNegative(doubleValues);
        final SimpleList<Integer> filteredIntValues = SimpleList.filterNegative(intValues);

        assertAll(
                () -> assertThat(filteredDoubleValues.get(0)).isEqualTo(0.5),
                () -> assertThat(filteredDoubleValues.get(1)).isEqualTo(0.7),
                () -> assertThat(filteredIntValues.get(0)).isEqualTo(1),
                () -> assertThat(filteredIntValues.get(1)).isEqualTo(2)
        );
    }
}
