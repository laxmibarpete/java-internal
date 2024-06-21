package CollectionExam;

import java.util.ArrayList;

public class CustomeHashMap <K,V>{

    private class HmNode<K,V>{
        private K key;
        private V value;

        public HmNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private ArrayList<HmNode> [] buckets;
    private int size;


    public CustomeHashMap(){
            initBuckets();
            size = 0;
    }

    private void initBuckets(){
       if(buckets == null){
           buckets = new ArrayList[4];
       }else{
           buckets = new ArrayList[buckets.length*2];
       }

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList <HmNode> ();
        }
    }

    private int hash(K key) {
        int hc = key.hashCode();
        int bi = Math.abs(hc) % buckets.length;
        return bi;
    }

    private int getIndexinsideBucket(int bucketId,K key){
        ArrayList<HmNode> bucket = buckets[bucketId];
        for (int i = 0; i < bucket.size(); i++) {
            HmNode hmNode = bucket.get(i);
            if(hmNode.key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    private void rehash(){
        ArrayList < HmNode > [] oldBuckets = buckets;
        initBuckets();
        size = 0;

        for (ArrayList < HmNode > bucket: oldBuckets) {
            for (HmNode node: bucket) {
                put((K) node.key, (V) node.value);
            }
        }
    }

    public void put(K key, V value){
        int bucketId = hash(key);
        int listIndex = getIndexinsideBucket(bucketId,key);

        if(listIndex != -1){
            buckets[bucketId].get(listIndex).value = value;
        }else{
            buckets[bucketId].add(new HmNode(key,value));
            size++;
        }
        double loadFactor = size * 1.0 / buckets.length;
        if (loadFactor > 2.0) {
            rehash();
        }
    }

    public V get(K key){
        int bucketId = hash(key);
        int listIndex = getIndexinsideBucket(bucketId, key);

        if (listIndex != -1) {
            return (V)buckets[bucketId].get(listIndex).value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bucketId = hash(key);
        int listIndex = getIndexinsideBucket(bucketId, key);

        return listIndex != -1;
    }

    public V remove(K key) {
        int bucketId = hash(key);
        int listIndex = getIndexinsideBucket(bucketId, key);

        if (listIndex != -1) {
            // Key found, remove and return value
            size--;
            return (V)buckets[bucketId].remove(listIndex).value;
        } else {
            return null; // Key not found
        }
    }

    public int size() {
        return size;
    }


}
