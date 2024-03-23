package HashMap;

public class Node<K, V> {
    int hashmap; // Хэш-код ключа
    K key; // Ключ
    V value; // Значение
    Node<K, V> next; // Ссылка на следующий узел

    // Конструктор класса Node инициализирует поля узла с заданными значениями
    Node(int hash, K key, V value, Node<K, V> next){
        this.hashmap = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
