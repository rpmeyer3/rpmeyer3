public class HashMap <K, V>{

    private static class MapEntry <K, V> {
        private K key;
        private V val;

        /*
         * Creates an entry representing a mapping from a key to a value
         */
        public MapEntry(K k, V v) {
            key = k;
            val = v;
        }

        /*
            Returns the key corresponding to the entry
         */
        public K getKey() {
            return key;
        }

        /*
         * Returns the value corresponding to this entry.
         */
        public V getValue() {
            return val;
        }

        /*
         * Replaces the value corresponding to this entry with new value
         */
        public V setValue(V v) {
            V oldVal = val;
            val = v;
            return oldVal;
        }
    }

    private MapEntry<K, V>[]    table;
    private int                 count;
    private int                 maxCount;
    private MapEntry<K,V>       DUMMY;

    /*
     * Constructs  an empty HashMap with the Default inital capacity
     * (7) and the default load factor (0.67).
     */
    @SuppressWarnings("unchcked")
    public HashMap(){
        table = new MapEntry[7];
        count = 0;
        maxCount = table.length - table.length/3;
        DUMMY = new MapEntry<>(null, null);
    }
    /*
     * Returns the number of key-value mappings in this map.
     */
    public int size(){return count;}

    /*
     * returns true if this map contains no key-value mappings
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /*
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key){
        int slot = findSlot(key, false);
        return slot >=0;
    }

    /*
     * Returns the vallue to which the specified key is mapped, or
     * null if this map contains no mapping for the key.
     */
    public V getValue(K key){
        int slot = findSlot(key, false);

        if(slot < 0) return null;

        MapEntry<K, V> e = table[slot];
        return e.getValue();
    }

    /*
     * Depending on whether it is for adding a new entry or not,
     * returns a slot number to indicate where you can add a new
     * entry with the specified ket or where an entry with the
     * specified key is found.
     */
    private int findSlot(K key, boolean forAdd){
        int slot = hash1(key);
        int step = hash2(key);
        int M = table.length;

        if(forAdd){
            //fix potential infinite loop
            while(true){
                MapEntry<K, V> e = table[slot];
                if(e==null||e==DUMMY){
                    return slot;
                } else {
                    slot = (slot + step) % M;
                }
            }
        } else {
            while (table[slot] != null){
                MapEntry<K,V> e = table[slot];
                if(e==DUMMY || !e.getKey().equals(key))
                    slot = (slot + step) % M;
                else
                    return slot;
            }
        }
        return -1;
    }
    private int hash1(K key){
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key){
        return 1 + Math.abs(key.hashCode()) % (table.length - 2);
    }

    /*
     * Expands the hash table
     */
    @SuppressWarnings("unchecked")
    private void rehash(){
        int M = table.length;
        MapEntry<K, V>[] origTable = table;  //original table

        //new table
        table = new MapEntry[2*M + 1];
        count = 0;
        maxCount = table.length - table.length/3;

        for(MapEntry<K,V> oe : origTable){
            MapEntry<K,V> e = oe;
            if(e != null && e != DUMMY) {
                int slot = findSlot(e.getKey(), true);
                table[slot] = e;
                count++;
            }
        }

    }
    public V add(K key, V value) {
        int slot = findSlot(key, false);
        V oldVal = null;

        if (slot >= 0) {
            MapEntry<K, V> e = table[slot];
            oldVal = e.setValue(value);
        } else {
            slot = findSlot(key, true);
            table[slot] = new MapEntry<>(key, value);
            count ++;
            if(count >= maxCount)
                rehash();
        }

        return oldVal;
    }

    public V remove(K key){
        int slot = findSlot(key, false);
        V oldVal = null;

        if(slot >= 0){
            MapEntry<K, V> e = table[slot];
            oldVal = e.getValue();
            table[slot] = DUMMY;
            count --;
        }

        return oldVal;
    }

}