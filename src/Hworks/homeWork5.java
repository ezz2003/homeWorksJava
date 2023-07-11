package Hworks;

import java.util.*;

public class homeWork5 {


    public static void sortBook(Map<String, List<String>> phoneBook) {
        TreeMap<Integer, Map<String, List<String>>> sortByCount = new TreeMap<>(Collections.reverseOrder());
        for (String name : phoneBook.keySet()) {
            if (!sortByCount.containsKey(phoneBook.get(name).size())) {
                Map<String, List<String>> data = new HashMap<>();
                data.put(name, phoneBook.get(name));
                sortByCount.put(phoneBook.get(name).size(), data);
            }
            else {
                Map<String, List<String>> data = sortByCount.get(phoneBook.get(name).size());
                data.put(name, phoneBook.get(name));
                sortByCount.put(phoneBook.get(name).size(), data);
            }
        }
        for (var item: sortByCount.entrySet()){
            for (var i: item.getValue().entrySet()){
                System.out.printf("%s   %s  %s\n", item.getKey(), i.getKey(), i.getValue());
            }

        }
    }


    public static void allBook(Map<String, List<String>> phoneBook) {
        for(String i: phoneBook.keySet()){
            System.out.printf("%s   %s\n", i, phoneBook.get(i));
        }
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.print("enter a name: ");
        String name = input();
        if (phoneBook.get(name) == null){
            System.out.println("Not found");
        } else{
            System.out.printf("%s: %s\n", name, phoneBook.get(name));
        }
    }


    public static String input() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
//         scanner.close();
        return scan;
    }


    public static void menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Enter command: \n1 - print all PHONEBOOK \n2 - find contact \ns - sort by number of phone numbers \nQ - quit");
        boolean x = true;
        while (x) {
            String commands = input();
            if (commands.equals("0")) {
                break;
            } else {
                switch (commands) {
                    case "1":
                        allBook(phoneBook);
                        break;
                    case "2":
                        find(phoneBook);
                        break;
                    case "s":
                        sortBook(phoneBook);
                        break;
                    default:
                        System.out.println("BYE!");
                        x = !x;

                        break;
                }
            }
        }
    }


    public static void problem1(){
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov", List.of("+12944543075", "+12164507628 "));
        phoneBook.put("Petrov", List.of("+8615528772238", "+8613874049971", "+23059767670"));
        phoneBook.put("Sidorov", List.of("+447868150810", "+8618261893257", "+447933449370"));
        phoneBook.put("Vasilyev", List.of("+12612258950", "+12405004446"));
        phoneBook.put("Grishin", List.of("+12326231117"));
        menu(phoneBook);
//        System.out.println(phoneBook);
    }

    static void problem2(){
//        Map<String, Integer> dbN = new HashMap<>();
        TreeMap<String, Integer> dbN =new TreeMap<>();
        TreeMap<String, Map<String, String>> dbSort =new TreeMap<>((Collections.reverseOrder()));
        TreeMap<Integer, Map<String, String>> dbSort2 =new TreeMap<>((Collections.reverseOrder()));

        Map<String, String> db =
                new HashMap<>(Map.of("Ivanov", "Ivan", "Petrova", "Svetlana", "Belova",
                        "Kristina", "Musina","Anna", "Krutova", "Anna", "Jurin", "Ivan",
                        "Likov", "Petr", "Chernov", "Pavel",
                        "Chernishov", "Petr","Fyodorova", "Mariya"));
        db.put("Svetlova", "Marina"); db.put("Savina", "Mariya");
        db.put("Rikova","Mariya"); db.put("Lugova", "Marina");
        db.put("Vladimirova", "Anna"); db.put("Mechnikov", "Ivan");
        db.put("Petin", "Petr"); db.put("Ezov", "Ivan");
        for (var item: db.entrySet()){
            if (dbN.get(item.getValue()) == null){
                dbN.put(item.getValue(), 1);
            } else if (dbN.get(item.getValue()) != null){
                dbN.put(item.getValue(), dbN.get(item.getValue())+1);
            }
        }
//        for(var item:db.keySet()){
//            Map<String,String> person = new HashMap<>();
//            person.put(db.get(item), item);
//            dbSort.put(String.valueOf(dbN.get(db.get(item))) + db.get(item), person);
//        }
        for(var item:db.keySet()){
            if (!dbSort2.containsKey(dbN.get(db.get(item)))){
                Map<String,String> person = new HashMap<>();
                person.put(item, db.get(item));
                dbSort2.put(dbN.get(db.get(item)), person);
            } else {
                Map<String,String> person = dbSort2.get(dbN.get(db.get(item)));
                person.put(item, db.get(item));
                dbSort2.put(dbN.get(db.get(item)), person);
            }
        }


        System.out.println(db);                 // Печать исходного списка
        System.out.println(dbN);                // Печать рейтинга
        for (var item:dbSort2.keySet()){                // Печать
            for (var i: dbSort2.get(item).entrySet()){  // всего
                System.out.printf("%d %s  %s\n",item,   // списка согласно рейтинга
                        i.getValue().toString(), i.getKey().toString()); // в соответствии с убыванием рейтинга
            }

        }
    }




    public static void main(String[] args){
        problem1();
        problem2();

    }
}
