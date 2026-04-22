public class CustomHashMapDemo {

    private static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class CustomHashMap {
        private final Node[] buckets;
        private int size;

        public CustomHashMap(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive");
            }
            buckets = new Node[capacity];
            size = 0;
        }

        private int index(String key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public void put(String key, int value) {
            int idx = index(key);
            Node current = buckets[idx];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            Node newNode = new Node(key, value);
            newNode.next = buckets[idx];
            buckets[idx] = newNode;
            size++;
        }

        public Integer get(String key) {
            int idx = index(key);
            Node current = buckets[idx];

            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

            return null;
        }

        public boolean remove(String key) {
            int idx = index(key);
            Node current = buckets[idx];
            Node prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        buckets[idx] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return true;
                }
                prev = current;
                current = current.next;
            }

            return false;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(8);

        map.put("Alice", 95);
        map.put("Bob", 87);
        map.put("Charlie", 91);

        System.out.println("Alice -> " + map.get("Alice"));
        System.out.println("Bob -> " + map.get("Bob"));
        System.out.println("Remove Bob: " + map.remove("Bob"));
        System.out.println("Bob (after remove) -> " + map.get("Bob"));
        System.out.println("Map size: " + map.size());
    }
}
