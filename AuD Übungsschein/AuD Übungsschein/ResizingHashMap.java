
public class ResizingHashMap <K, V> extends AbstractHashMap<K, V>{

    public ResizingHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void insertMapping(int idx, Mapping<K, V> mapping) {
        Mapping m;
        for (m = buckets[idx]; m!= null; m=m.next) {
            if(m.next == null){
                break;
            }
        }
        if (m==null){
            buckets[idx] = mapping;
        } else {
            m.next = mapping;
        }
        size++;
    }

    @Override
    protected int getBucketIndex(K key) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }
        int hash = key.hashCode();
        int index =   hash  % buckets.length;
        return index;
    }

    @Override
    protected Mapping<K, V> getMapping(K key) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }

        for (Mapping m = buckets[getBucketIndex(key)]; m!= null; m=m.next) {
            if (key.equals(m.getKey())){
                return m;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }
        Mapping<K, V> m;
        int index = getBucketIndex(key);

        if (containsKey(key)){
            for (m = buckets[index]; m!= null; m=m.next) {
                if (key.equals(m.getKey())){
                    return m.value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }
        Mapping m;
        int index = getBucketIndex(key);
        for (m = buckets[index]; m!= null; m=m.next) {
            if (key.equals(m.getKey())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }
        Mapping m;
        int index = getBucketIndex(key);

        if (containsKey(key)){
            for (m = buckets[index]; m!= null; m=m.next) {
                if (key.equals(m.getKey())){
                    m.value = value;
                }
            }
            return false;
        }

        Mapping newMapping = new Mapping<>(key, value, null);
        insertMapping(index, newMapping);
        return true;
    }

    @Override
    public boolean remove(K key) {
        if (key==null){
            throw new IllegalArgumentException("specified key is null!");
        }
        Mapping<K, V> m, prev = null;
        int index = getBucketIndex(key);

        if (containsKey(key)){
            for (m = buckets[index]; m!= null; m=m.next) {
                if (key.equals(m.getKey())){
                   if (prev == null){
                       buckets[index] = m.next;
                   } else {
                       prev.next = m.next;
                   }
                   size--;
                }
                prev = m;
            }
            return false;
        }
        return false;
    }

    @Override
    public void resize(int newCapacity) {
        if (buckets.length > newCapacity){
            throw new IllegalArgumentException("current capacity is bigger than desired new capacity");
        }
        Mapping<K, V>[] old = this.buckets;
        initialize(newCapacity);
        for (Mapping<K, V> m : old) {
            while (m!=null){
                this.put(m.key, m.value);
                m=m.next;
            }
        }
    }
}
