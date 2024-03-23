package HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashmap = new HashMap<>();
        // Добавляем элементы в хэш-таблицу
        hashmap.put(29230, "A");
        hashmap.put(2412124, "B");
        hashmap.put(33909231, "C");
        hashmap.put(609231, "D");
        hashmap.put(231, "E");
        hashmap.put(111131, "F");


        System.out.println("Size: " + hashmap.size());
        System.out.println("Содержит ключ '29230': " + hashmap.containsKey(29230));
        System.out.println("Содержит значение 'D': " + hashmap.containsValue("D"));
        System.out.println("Значение для '231': " + hashmap.get(231));
        System.out.println("Значение для '33909231': " + hashmap.get(33909231));
        System.out.println("Удаляем ключ '609231': ");
        hashmap.remove(609231);
        System.out.println("Размер после удаления: " + hashmap.size());

        System.out.println(hashmap.hasNext());
        System.out.println(hashmap.next());
//Сравниваем два размера двух хэшмапов
        HashMap<Integer, String> hashmap2 = new HashMap<>();
        hashmap2.put(99112, "G");
        System.out.println(hashmap.compareTo(hashmap2));
        Comparator<HashMap<Integer, String>> c = new Comparator<>();
        System.out.println(c.compare(hashmap, hashmap2));
        System.out.println(hashmap.hashCode() + " " +  hashmap2.hashCode());
    }
}
