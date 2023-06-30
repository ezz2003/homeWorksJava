
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
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


    public static void problem3() throws IOException {
//        3.** Дана json строка (можно сохранить в файл и читать из файла)
//   [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//                Студент Петрова получил 4 по предмету Информатика.
//                Студент Краснов получил 5 по предмету Физика.
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

    }

    public static void main(String[] args) throws IOException {

//        private final static Logger logger = Logger.getLogger(classroomWork2.class.getName());
        FileHandler fh = new FileHandler("log.txt", 100 * 1024, 3, true);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.log(Level.INFO, "Testing LOG 1");

        problem3();
    }
}
