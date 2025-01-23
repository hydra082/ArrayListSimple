package MyArrayList;

import java.util.Comparator;

public class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<String>();


        System.out.println("Добавление элементов:");
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Pineapple");


        System.out.println("Размер списка после добавления: " + list.size());


        System.out.println("\nПолучение элементов:");
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 2: " + list.get(2));


        System.out.println("\nВсе элементы в списке:");
        list.forEach(System.out::println);


        System.out.println("\nДобавление элемента по индексу 1:");
        list.add(1, "Mango");
        list.forEach(System.out::println);


        System.out.println("\nУдаление элемента с индекса 2:");
        list.remove(2);
        list.forEach(System.out::println);


        System.out.println("\nОбновление элемента с индекса 1:");
        list.update(1, "Grapes");
        list.forEach(System.out::println);


        System.out.println("\nОчистка списка:");
        list.clear();
        System.out.println("Размер списка после очистки: " + list.size());


        System.out.println("\nДобавление и сортировка элементов:");
        list.add("Pineapple");
        list.add("Apple");
        list.add("Grapes");
        list.add("Banana");

        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);
    }
}