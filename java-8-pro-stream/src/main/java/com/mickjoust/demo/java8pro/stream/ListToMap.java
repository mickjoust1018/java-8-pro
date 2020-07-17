package com.mickjoust.demo.java8pro.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mickjoust
 * @since 2020/6/24
 * xxx
 **/
public class ListToMap {

    static class TestMan{
        private Integer id;
        private String name;
        private Long phone;
        private Double salar;

        public TestMan(Integer id, String name, Long phone, Double salar) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.salar = salar;
        }

        public TestMan() {
        }

        @Override
        public String toString() {
            return "TestMan{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone=" + phone +
                    ", salar=" + salar +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPhone() {
            return phone;
        }

        public void setPhone(Long phone) {
            this.phone = phone;
        }

        public Double getSalar() {
            return salar;
        }

        public void setSalar(Double salar) {
            this.salar = salar;
        }
    }

    /**
     * List 转 Map
     */
    private static void listToMap(){
        List<TestMan> pidObjList = new ArrayList<>();
        pidObjList.add(new TestMan(1,"mickjoust1",1111L,11111d));
        pidObjList.add(new TestMan(2,"mickjoust2",2222L,22222d));
        pidObjList.add(new TestMan(3,"mickjoust3",3333L,33333d));
        pidObjList.add(new TestMan(4,"mickjoust4",4444L,44444d));
        pidObjList.add(new TestMan(5,"mickjoust5",5555L,55555d));
        //name作为key，对象最为value的Map
        Map<String,TestMan> pidsMap = pidObjList.stream().collect(Collectors.toMap(TestMan::getName, a -> a));
        pidsMap.forEach((k,v) -> System.out.println(k+" === "+v.toString()));
    }

    /**
     * list 转 List -> 不同类型转换
     */
    private static void listToList() {
        List<Long> pidList = new ArrayList<>();
        pidList.add(1L);
        pidList.add(2L);
        pidList.add(3L);
        pidList.add(4L);
        pidList.add(5L);
        pidList.add(6L);
        pidList.forEach(System.out::print);
        System.out.println();

        List<String> pidStringList = pidList.stream().map(String::valueOf).collect(Collectors.toList());
        pidStringList.forEach(System.out::print);
        System.out.println();
    }

    /**
     * array数组 转 list
     */
    private static void arrayToList(){
        String[] testarray = new String[5];
        testarray[0]= "0";
        testarray[1]= "1";
        testarray[2]= "2";
        testarray[3]= "3";
        testarray[4]= "4";
        //不转换类型
        List<String> outtestarray = Arrays.stream(testarray).collect(Collectors.toList());
        outtestarray.forEach(System.out::print);
        System.out.println();
        //转换类型
        List<Long> outtestarray2 = Arrays.stream(testarray).map(Long::valueOf).collect(Collectors.toList());
        outtestarray2.forEach(System.out::print);
        System.out.println();
    }

    /**
     * list 转 set
     */
    private static void listToSet(){
        List<Long> testid = new ArrayList<>();
        testid.add(1L);
        testid.add(1L);
        testid.add(1L);
        testid.add(1L);
        testid.add(2L);

        Set<Long> filterSkuId0 = testid.stream().collect(Collectors.toSet());
        filterSkuId0.forEach(System.out::print);
        System.out.println();
        //或者直接hasset
        Set<Long> filterSkuId1 = new HashSet<>(testid);
        filterSkuId1.forEach(System.out::print);
        System.out.println();
        //转换类型
        Set<String> filterSkuId2 = testid.stream().map(String::valueOf).collect(Collectors.toSet());
        filterSkuId2.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        listToList();
        listToMap();
        arrayToList();
        listToSet();
    }
}
