package cn.com.lioan.collection;

import java.util.List;
import java.util.Map;

public class TestCollectionBasic {

    public TestCollectionBasic() {
    }

    void collectBasic() {
        List<Map<String, Object>> listMaps = null;
        System.out.println("listMaps size is: " + listMaps.size());
    }

    public static void main(String[] args) {
        TestCollectionBasic testCollectionBasic = new TestCollectionBasic();
        testCollectionBasic.collectBasic();
    }

}
