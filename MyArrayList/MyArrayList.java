package MyArrayList;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Реализация списка, аналогичного java.util.ArrayList, с использованием массива.
 * Поддерживает основные операции: добавление, удаление, получение, обновление и сортировка элементов.
 *
 * @param <E> тип элементов в списке.
 */
public class MyArrayList<E> implements MyList<E> {

    private E[] values;

    /**
     * Конструктор по умолчанию, создающий пустой список.
     */

    MyArrayList() {
        values = (E[]) new Object[0];
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param e элемент, который нужно добавить в список.
     * @return true, если элемент был успешно добавлен.
     */

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Добавляет элемент в список по указанному индексу.
     *
     * @param index индекс, на который нужно добавить элемент.
     * @param e элемент, который нужно добавить в список.
     * @return true, если элемент был успешно добавлен.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */

    @Override
    public boolean add(int index, E e) {
        try {
            if (index < 0 || index > values.length) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
            }
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, index);
            values[index] = e;
            System.arraycopy(temp, index, values, index + 1, temp.length - index);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Получает элемент из списка по указанному индексу.
     *
     * @param index индекс элемента.
     * @return элемент, находящийся по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */

    @Override
    public E get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }
        return values[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */

    @Override
    public void remove(int index) {
        try {
            if (index < 0 || index >= values.length) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
            }
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElemetsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElemetsAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Очищает список, удаляя все элементы.
     */

    @Override
    public void clear() {
        values = (E[]) new Object[0];
    }

    /**
     * Возвращает размер списка.
     *
     * @return количество элементов в списке.
     */

    @Override
    public int size() {
        return values.length;
    }

    /**
     * Обновляет элемент списка по указанному индексу.
     *
     * @param index индекс элемента, который нужно обновить.
     * @param e новый элемент.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */

    @Override
    public void update(int index, E e) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }
        values[index] = e;
    }

    /**
     * Сортирует список с использованием заданного компаратора.
     *
     * @param comparator компаратор, который определяет порядок сортировки элементов.
     * @throws NullPointerException если компаратор равен null.
     */

    @Override
    public void sort(Comparator<E> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Comparator must not be null");
        }
        boolean swapped;
        for (int i = 0; i < values.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (comparator.compare(values[j], values[j + 1]) > 0) {
                    E temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Выполняет быструю сортировку списка.
     * Используется стандартный порядок сравнения элементов (если компаратор не задан).
     */

    @Override
    public void quickSort() {
        quickSort(values, 0, values.length - 1, null);
    }

    /**
     * Выполняет быструю сортировку массива.
     *
     * @param array массив, который нужно отсортировать.
     * @param low начальный индекс для сортировки.
     * @param high конечный индекс для сортировки.
     * @param comparator компаратор для сравнения элементов.
     */

    private void quickSort(E[] array, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Разделяет массив для быстрой сортировки, выбирая опорный элемент.
     *
     * @param array массив, который нужно разделить.
     * @param low начальный индекс для разделения.
     * @param high конечный индекс для разделения.
     * @param comparator компаратор для сравнения элементов.
     * @return индекс опорного элемента.
     */

    private int partition(E[] array, int low, int high, Comparator<E> comparator) {
        E pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int comparisonResult;
            if (comparator != null) {
                comparisonResult = comparator.compare(array[j], pivot);
            } else {
                // Используем Comparable, если компаратор не задан
                comparisonResult = ((Comparable<E>) array[j]).compareTo(pivot);
            }

            if (comparisonResult <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        E temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Создает и возвращает итератор для этого списка.
     *
     * @return итератор для элементов списка.
     */

    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<>(values);
    }
}
