package MyArrayList;

import java.util.Comparator;

public class MyArrayListTest {
    public static void main(String[] args) {
        // Создание списка
        MyArrayList<String> list = new MyArrayList<String>();

        // Добавление элементов в список
        System.out.println("Добавление элементов:");
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Pineapple");

        // Проверка размера списка
        System.out.println("Размер списка после добавления: " + list.size());

        // Использование метода get для получения элементов
        System.out.println("\nПолучение элементов:");
        System.out.println("Element at index 0: " + list.get(0)); // Apple
        System.out.println("Element at index 2: " + list.get(2)); // Orange

        // Использование forEach для вывода всех элементов
        System.out.println("\nВсе элементы в списке:");
        list.forEach(System.out::println); // Apple, Banana, Orange, Pineapple

        // Добавление элемента по индексу
        System.out.println("\nДобавление элемента по индексу 1:");
        list.add(1, "Mango");
        list.forEach(System.out::println); // Apple, Mango, Banana, Orange, Pineapple

        // Удаление элемента по индексу
        System.out.println("\nУдаление элемента с индекса 2:");
        list.remove(2); // Удаляем элемент "Banana"
        list.forEach(System.out::println); // Apple, Mango, Orange, Pineapple

        // Обновление элемента по индексу
        System.out.println("\nОбновление элемента с индекса 1:");
        list.update(1, "Grapes");
        list.forEach(System.out::println); // Apple, Grapes, Orange, Pineapple

        // Очистка списка
        System.out.println("\nОчистка списка:");
        list.clear();
        System.out.println("Размер списка после очистки: " + list.size()); // 0

        // Сортировка списка
        System.out.println("\nДобавление и сортировка элементов:");
        list.add("Pineapple");
        list.add("Apple");
        list.add("Grapes");
        list.add("Banana");

        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println); // Apple, Banana, Grapes, Pineapple
    }
}