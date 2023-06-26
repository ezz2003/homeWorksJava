import java.util.Scanner;

public class homeWork1 {
    static void TriangularNumber(){
//        1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("\nHello! Enter the number of the triangular number: ");
        int number = iScanner.nextInt();
        System.out.println(number*(number+1)/2);
        System.out.printf("Print the whole row? [Y/N] ");
        char answer = iScanner.next().charAt(0);
        if (answer == 'y'){
            for (int i = 1; i <= number; i++){
                System.out.printf("%d ",i*(i+1)/2);
            }
        }
        System.out.println("\n BYE");
        iScanner.close();
    }

    private static boolean isSimple(int num){
        if (num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i < (Math.sqrt(num)+1); i++){
            if (num%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void SimpleNumbers(){

//        2. Вывести все простые числа от 1 до 1000
        int n = 1000;
        for (int i = 1; i <= n; i++){
            if(isSimple(i)){
                System.out.printf(" %d", i);
            }
            }
        }

    public static void Calc(){
//        3. Реализовать простой калькулятор

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter first number: ");
        float a = iScanner.nextFloat();
        System.out.printf("Enter second number: ");
        float b = iScanner.nextFloat();
        System.out.printf("Enter an action: ");
        char action = iScanner.next().charAt(0);
        iScanner.close();
        switch (action){
            case '+':
                System.out.printf("%.2f %c %.2f = %.2f", a,action,b,(a+b));
                break;
            case '-':
                System.out.printf("%.2f %c %.2f = %.2f", a,action, b,(a-b));
                break;
            case '*':
                System.out.printf("%.2f %c %.2f = %.2f", a,action,b,(a*b));
                break;
            case '/':
                System.out.printf("%.2f %c %.2f = %.2f", a,action,b, a/b);
                break;
            default:
                System.out.printf("%.2f %c %.2f = Invalid action!", a,action,b);
        }
    }

    public static void TheEquation(){
//        4. *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
//                например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
//        Предложить хотя бы одно решение или сообщить, что его нет.

        System.out.println("q + w = e");
        String q = "2*";
        String w = "?5";
        int e = 69;
        System.out.printf("%s + %s = %d\n", q,w,e);
        short qIndex = 0;
        short wIndex = 0;
        if (Character.isDigit(q.charAt(0))){
            qIndex = 0;
        } else if (Character.isDigit(q.charAt(1))) {
            qIndex = 1;
        }
        if (Character.isDigit(w.charAt(0))){
            wIndex = 0;
        } else if (Character.isDigit(w.charAt(1))) {
            wIndex = 1;
        }
        boolean flag = true;
        for (int i = 0; i<10; i++){
            for (int j = 0; j < 10; j++){
                if (qIndex == 0){
                    q = q.charAt(qIndex)+String.format("%d",i);
                } else if (qIndex ==1) {
                    q = String.format("%d",i)+q.charAt(qIndex);
                }
                if (wIndex == 0){
                    w = w.charAt(wIndex)+String.format("%d",j);
                } else if (wIndex ==1) {
                    w = String.format("%d",j)+w.charAt(wIndex);
                }
//                int qI = Integer.valueOf(q);
//                System.out.println(qI+5);
//                System.out.printf("%s + %s = %d\n", qI,w,e);
                if (Integer.valueOf(q) + Integer.valueOf(w) == e){
                    System.out.printf("%s + %s = %d\n", q,w,e);
                    flag = false;
                }
            }
        }
        if (flag) System.out.println("There are no options");
    }



    public static void main(String[] args) {

//        TriangularNumber();
//        SimpleNumbers();
//        Calc();
        TheEquation();
    }
}