package HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Класс HashMap<K, V> реализует интерфейсы Iterator<K, V> и Comparable<HashMap<K, V>>
public class HashMap<K, V> implements Iterator<K, V>, Comparable<HashMap<K, V>> {
    private final List<Node<K, V>> buckets;
    private Node<K, V> currentNode;
    private int currentBucketIndex;

    // Конструктор класса инициализирует список buckets и устанавливает текущий узел currentNode
    HashMap(){
        int CAPACITY = 16;
        buckets = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            buckets.add(null);
        }
        currentBucketIndex = 0;
        currentNode = buckets.get(currentBucketIndex);
    }
    // Метод put(K key, V value) добавляет элемент в HashMap или обновляет значение, если ключ уже существует
    @SuppressWarnings("all")
    public V put(K key, V value){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<>(hash, key, value, buckets.get(index));
        buckets.set(index, newNode);
        return null;
    }
    // Метод get(K key) возвращает значение по ключу или null, если ключ не найден
    public V get(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());

        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    // Метод containsKey(K key) проверяет наличие ключа в HashMap
    public boolean containsKey(K key){
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        while (current != null){
            if (current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Метод containsValue(V value) проверяет наличие значения в HashMap
    public boolean containsValue(V value){
        for (Node<K, V> node : buckets){
            Node<K, V> current = node;
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    // Метод size() возвращает количество элементов в HashMap
    public int size() {
        int size = 0;
        for (Node<K, V> node : buckets) {
            Node<K, V> current = node;
            while (current != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }
    // Метод hasNext() проверяет наличие следующего элемента при итерации
    @Override
    public boolean hasNext() {
        while (currentNode == null && currentBucketIndex < buckets.size() - 1) {
            currentBucketIndex++;
            currentNode = buckets.get(currentBucketIndex);
        }
        return currentNode != null;
    }
    // Метод next() возвращает следующее значение при итерации и перемещает указатель на следующий узел
    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        V value = currentNode.value;
        currentNode = currentNode.next;
        return value;

    }

    // Метод remove(K key) удаляет элемент из HashMap по ключу
    @Override
    public void remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % buckets.size());
        Node<K, V> current = buckets.get(index);
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, current.next);
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    // Метод compareTo(HashMap<K, V> otherMap) сравнивает размер текущего HashMap с другим HashMap
    @Override
    public int compareTo(HashMap<K, V> otherMap) {
        return this.size() - otherMap.size();
    }
}
