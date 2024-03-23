package HashMap;

public class Comparator<E> implements Comparable<E>{
    // Метод compareTo(E e) переопределен из интерфейса Comparable и всегда возвращает 0
    @Override
    public int compareTo(E e) {
        return 0;
    }
    // Метод compare(E e1, E e2) сравнивает хэш-коды объектов e1 и e2 и возвращает результат сравнения
    public int compare(E e1, E e2){
        return Integer.compare(e1.hashCode(), e2.hashCode());
    }
}