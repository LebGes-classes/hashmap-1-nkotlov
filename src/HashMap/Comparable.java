package HashMap;
// Интерфейс Comparable позволяет объектам быть сравнимыми и использоваться в сортировке данных
public interface Comparable<E> {
    // Метод compareTo сравнивает объект типа E и возвращает целочисленное значение
    int compareTo(E e);
}
