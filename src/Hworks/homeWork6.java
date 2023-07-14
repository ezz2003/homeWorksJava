package Hworks;
import java.util.*;
import java.util.stream.IntStream;
public class homeWork6 {
    public static List listOfRandomNumbers(int size, int upperBound){
        List<Integer> list = new ArrayList<>(Arrays.asList());
        Random random = new Random();
        IntStream.range(0, size)
                .forEach(index -> list.add(random.nextInt(upperBound)));
        return list;
    }
    static void ex0(){
        HashSet<Integer> hashSet= new HashSet<>(Arrays.asList(4,1,2,2,5,6,3));
        System.out.println(hashSet);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(4,1,2,2,5,6,3));
        System.out.println(linkedHashSet);
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(4,1,2,2,5,6,3));
        System.out.println(treeSet);
    }

    static void ex1(){
        List list = listOfRandomNumbers(1000, 25);
        HashSet<Integer> hashSet= new HashSet<>(list);
        float x = (float) hashSet.size()*100/list.size();
        System.out.println(list);
        System.out.println(hashSet);
        System.out.println(x);
    }

    public static void cats(){
        Cat cat1 = new Cat("Barsic", 2010, 12);
        Cat cat2 = new Cat("Tom", 2015, 7);
        Cat cat3 = new Cat("Tom", 2015, 7);
        Cat cat4 = new Cat();
        cat4.nameCat = "Garfield"; cat4.yearOfBirth = 2017; cat4.weight = 8;
        var cats = new HashSet<>(Arrays.asList(cat1,cat2,cat3,cat4));

        System.out.print(cat1);
        System.out.println("\t" + cat1.hashCode());
        System.out.print(cat2);
        System.out.println("\t" + cat2.hashCode());
        System.out.print(cat3);
        System.out.println("\t" + cat3.hashCode());
        System.out.print(cat4);
        System.out.println("\t" + cat4.hashCode());

        System.out.println(cats);
    }


    public static void main(String[] args) {
//        ex0();
//        ex1();
        cats();

    }
}
