package Hworks;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class homeWork4 {


    public static LinkedList<String> reverseLikedList (LinkedList<String> list){
        for (int i = 0; i < list.size(); i++){
            list.add(i, list.removeLast());
        }
        return list;
    }

    static int priority(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


    static String infixToPostfix(String iExp)
    {
        iExp = iExp.replaceAll ("\\s+", "");
        String pExp = "";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < iExp.length(); ++i) {
            char c = iExp.charAt(i);
            if (Character.isLetterOrDigit(c))
                pExp += c;
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    pExp += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else{
                while (!stack.isEmpty()
                        && priority(c) <= priority(stack.peek())) {
                    pExp += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "illegal expression";
            pExp += stack.peek();
            stack.pop();
        }
        return pExp;
    }


    public static LinkedList<String> enqueue(LinkedList<String> list, String a){
//        enqueue() - помещает элемент в конец очереди
        list.offerLast(a);
        return list;
    }


    public static String dequeue(LinkedList<String> list){
//        dequeue() - возвращает первый элемент из очереди и удаляет его
        return list.pollFirst();
    }


    public static String first(LinkedList<String> list){
//        first() - возвращает первый элемент из очереди, не удаляя.
        return list.peekFirst();
    }


    public static void problem2(){
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(Arrays.toString(list.toArray()));    // печать всего листа
        System.out.println(enqueue(list, "d"));             // печать листа с добавленной в конец "d"
        System.out.println(dequeue(list));                      // печать первого элемента из очереди, который удалён
        System.out.println(Arrays.toString(list.toArray()));    // печать листа после извлечения первого с удалением
        System.out.println(first(list));                        // печать извлеченного перого эл. без удаления
        System.out.println(Arrays.toString(list.toArray()));    // подтверждение, что первый,
                                                                // после его извлечения, не удалён
    }


    public static void problem1(){
        LinkedList<String> list = new LinkedList<>();
        IntStream.range(0, 23).forEach(i -> list.add("Java-" + i));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(reverseLikedList(list).toArray()));
    }


    public static void problem5ClassroomAdditional(){
//        String infixExpression = "(a+b)*(c-d)/f^2 ";
        String infixExpression = "a + b^3*(c-d^2) - j";
        System.out.println(infixExpression);
        System.out.println(infixToPostfix(infixExpression));
    }


    public static void main(String[] args){
//        1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
//        “перевернутый” список.
        problem1();
        System.out.println();
//        2. Реализуйте очередь с помощью LinkedList со следующими методами:
//        enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент
//        из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
        problem2();
        System.out.println();
//        Задание №5 (доп)
//        Реализовать алгоритм перевода из инфиксной записи в постфиксную для
//        арифметического выражения.
//        Вычислить запись если это возможно.
        problem5ClassroomAdditional();
    }
}
