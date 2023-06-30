
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class homeWork2 {
    private final static Logger logger = Logger.getLogger(homeWork2.class.getName());

    public static String Freader(String fName) throws IOException
    {
        int ch;

        // check if File exists or not
        FileReader fr=null;
        try
        {
            String path = System.getProperty("user.dir");
            fr = new FileReader(fName);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
            logger.log(Level.WARNING, String.format("File not found Freader file = %s", fName));
        }
        StringBuilder stJ = new StringBuilder();
        while ((ch=fr.read())!=-1)
            stJ.append((char)ch);
        String stJs = stJ.toString();
        fr.close();
        return stJs;
    }


    public static String findSymb(String stArr, int n){
        char stToArr[] = stArr.toCharArray();
        StringBuilder valueNew = new StringBuilder();
        for (int i = n; i < stToArr.length; i++){
            if (stToArr[i] == ',' || stToArr[i] == '}'){
                return valueNew.toString();
            }
            valueNew.append(stToArr[i]);
        }
        return valueNew.toString();
    }


    public static void problem1() throws IOException{
//        Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        logger.log(Level.INFO, "problem 1 - START");
        String studentsJ = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String requestStart = "select * from students where (";
        String [] studentsS = studentsJ.replaceAll("\\{|\\ |\\}", "").split(",");
//        Stream.of(studentsS).forEach(System.out::println);
        StringBuilder requestFull= new StringBuilder(requestStart);
        for (String i:studentsS){
            int a = i.indexOf(":");
            String i1 = i.substring(0, a);
            String i2 = i.substring(a+1).replaceAll("","");
            if (!(Objects.equals(i2,"\"null\""))){
                requestFull.append(i1.replaceAll("\\\"","")).append(" = ");
                requestFull.append(i2).append(") AND (");
            }


        }
        System.out.println(requestFull.toString().replaceAll("[ AND (]+$",""));
        logger.log(Level.INFO, "problem 1 - END");
    }


    public static void problem2() throws IOException {
        int size = 20;
        int upperBound = 100;
        int[] array = new int[size];
        Random random = new Random();
        IntStream.range(0, size)
                .forEach(index -> array[index] = random.nextInt(upperBound));
        System.out.println(Arrays.toString(array));
        logger.log(Level.INFO, "an array of random numbers has been created");
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                    logger.log(Level.INFO, "bubble sorting: the next iteration has been completed!");
                }
            }
        }
        System.out.println(Arrays.toString(array));


    }


    public static void problem3() throws IOException {
//        3.** Дана json строка (можно сохранить в файл и читать из файла)
//   [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//                Студент Петрова получил 4 по предмету Информатика.
//                Студент Краснов получил 5 по предмету Физика.
        logger.log(Level.INFO, "start running problem 3");
        String fileName = "src/file1.json";
        String obJson = Freader(fileName).replaceAll("\\[|\\]|\\\"", "");
        String arrObJson[] = obJson.split("},");
        String [] arrMessages  = new String[arrObJson.length];
        String sur = "surname";
        String gr = "grade";
        String sub = "subject";
        for (int i = 0; i < arrObJson.length; i++){
            StringBuilder strOut = new StringBuilder("Student ");
            int a = arrObJson[i].indexOf(sur)+sur.length()+1;
            strOut.append(findSymb(arrObJson[i], a)).append(" received a grade of ");
            int b = arrObJson[i].indexOf(gr)+gr.length()+1;
            strOut.append(findSymb(arrObJson[i], b)).append(" in the subject of ");
            int c = arrObJson[i].indexOf(sub)+sub.length()+1;
            strOut.append(findSymb(arrObJson[i], c));
            arrMessages[i] = strOut.toString();
        }
        Stream.of(arrMessages).forEach(System.out::println);
        logger.log(Level.INFO, "problem 3 - successfully");
    }


    public static void problem4(){
//        4*. К калькулятору из предыдущего дз добавить логирование.
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
                logger.log(Level.INFO, String.format("running CALC:     %.2f %c %.2f = %.2f", a,action,b,(a+b)));
                break;
            case '-':
                System.out.printf("%.2f %c %.2f = %.2f", a,action, b,(a-b));
                logger.log(Level.INFO, String.format("running CALC:     %.2f %c %.2f = %.2f", a,action, b,(a-b)));
                break;
            case '*':
                System.out.printf("%.2f %c %.2f = %.2f", a,action,b,(a*b));
                logger.log(Level.INFO, String.format("running CALC:     %.2f %c %.2f = %.2f", a,action,b,(a*b)));
                break;
            case '/':
                System.out.printf("%.2f %c %.2f = %.2f", a,action,b, a/b);
                logger.log(Level.INFO, String.format("running CALC:     %.2f %c %.2f = %.2f", a,action,b, a/b));
                break;
            default:
                logger.log(Level.WARNING, String.format("running CALC:     %.2f %c %.2f = Invalid action!", a,action,b));
                System.out.printf("%.2f %c %.2f = Invalid action!", a,action,b);
        }

    }

    public static void main(String[] args) throws IOException {

//        private final static Logger logger = Logger.getLogger(classroomWork2.class.getName());
        FileHandler fh = new FileHandler("log.txt", 100 * 1024, 1, true);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.log(Level.INFO, "Testing LOG 1");

//        problem3();
//        problem4();
//        problem2();
        problem1();
    }
}

