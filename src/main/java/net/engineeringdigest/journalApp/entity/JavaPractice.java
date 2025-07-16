package net.engineeringdigest.journalApp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaPractice {
    public static void main(String[] args) {
//                int a[] = {10,20,30,40};
//             int b= Arrays.stream(a).sum();
//        System.out.println(b);

//                List<Integer> list = Arrays.asList(100,20,40,50);
//        int[] b = list.stream().mapToInt((Integer a) -> a * a).peek(System.out::println).map((int a)->a*2).toArray();
//        for (int x: b){
//            System.out.println(x);
//        }


//                List<Integer> list1 = Arrays.sort(a);
//        Stream<Integer> stream =  list.stream().peek(System.out::println).filter((Integer val)->val>20).peek(System.out::println).sorted((Integer a, Integer b)->b-a);
//        List<Integer> collect = stream.collect(Collectors.toList());
//        System.out.println(collect);


//        Stream<Integer> stream3 = Stream.of(10, 20, 30);
//          Integer total = Arrays.stream(arr).reduce(0, Integer::sum);
//        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
//
//        System.out.println(sorted);

//       ++List<String> result = lines.stream()       // convert list to stream
//                .filter((String a) -> !"c".equals(a)) // we dont like c
//                .collect(Collectors.toList());     // collect the output and convert streams to a List
//
//        result.forEach(System.out::println);

//    /   System.out.println(products.toString());                                                                                }
//    private static List < Product > getProducts() {
//        List<Product> productsList = new ArrayList<Product>();
//        productsList.add(new Product(1, "HP Laptop", 25000));
//        productsList.add(new Product(2, "Dell Laptop", 30000));
//        productsList.add(new Product(3, "Lenevo Laptop", 28000));
//        productsList.add(new Product(4, "Sony Laptop", 28000));
//        productsList.add(new Product(5, "Apple Laptop", 90000));
//        return productsList;
//    }
}
class Product {
    public Product(int i, String hpLaptop, int i1) {
        id =i;
        name = hpLaptop;
        price = i1;
    }


    private int id;
    private String name;
    private int price;
    // getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public   int  getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}}