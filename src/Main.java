import CollectionExam.CustomIterable;
import CollectionExam.CustomeHashMap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



//        CustomIterable<Integer> collection = new CustomIterable(10);
//        collection.add(1);
//        collection.add(2);
//        collection.add(3);
//
//        for (Object item : collection) {
//            System.out.println(item);
//        }

        CustomeHashMap<String,String> map = new CustomeHashMap<>();

        System.out.println("Size "+map.size());

        map.put("1","PK");
        map.put("2","BG");
        map.put("3","pu");
        map.put("4","sa");
        map.put("5","BE");

        System.out.println(map.get("3"));
        System.out.println(map.get("5"));
        System.out.println("Size "+map.size());


    }
}