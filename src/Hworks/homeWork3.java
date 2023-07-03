package Hworks;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;


public class homeWork3 {


    public static List listOfRandomNumbers(int size, int upperBound){
        List<Integer> list = new ArrayList<>(Arrays.asList());
        Random random = new Random();
        IntStream.range(0, size)
                .forEach(index -> list.add(random.nextInt(upperBound)));
        return list;
    }

    public static List<Integer> deleteEvenNumbers(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next()%2 == 0){
                iterator.remove();
            }
        }
        return list;
    }


    public static Object getMin(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        int min = iterator.next();
        int tmp;
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (tmp < min){
                min = tmp;
            }
        }
        return min;
    }


    public static int getMax(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        int max = iterator.next();
        int tmp;
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (tmp > max){
                max = tmp;
            }
        }
        return max;
    }


    public static int getMiddle(List<Integer> list, int min, int max){
        int middleMath = (max + min)/2;
        int itemTemp = max;
        int dif = max - middleMath;
        int tmp;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (Math.abs(tmp - middleMath) < dif){
                dif = Math.abs(tmp - middleMath);
                itemTemp = tmp;
            }
        }
        return itemTemp;
    }



    public static List<Integer> mergeSort(List<Integer> list){
        int listSize = list.size();
        if (listSize > 1){
            int middle = listSize / 2;
            ArrayList<Integer> listLeft = new ArrayList<Integer> (list.subList(0, middle));
            ArrayList<Integer> listRight = new ArrayList<Integer> (list.subList(middle, listSize));
            mergeSort(listLeft);
            mergeSort(listRight);
            int listLeftSize = listLeft.size();
            int listRightSize = listRight.size();
            int i, j, k; i = j = k = 0;
            while (i < listLeftSize && j < listRightSize){
                if (listLeft.get(i) < listRight.get(j)){
                    list.set(k, listLeft.get(i));
                    i++;
                } else {
                    list.set(k, listRight.get(j));
                    j++;
                }
                k++;
            }
            while (i < listLeftSize){
                list.set(k, listLeft.get(i));
                i++;
                k++;
            }
            while (j < listRightSize){
                list.set(k, listRight.get(j));
                j++;
                k++;
            }
        }
        return list;
    }



    public static void main(String[] args) throws IOException {
        List<Integer> list = listOfRandomNumbers(55, 100);  // Создаём список
        System.out.println(list);                                          // Печатаем список
        int min = (int) getMin(list);                                      // получаем минимальное(для не сортированного)
        int max = (int) getMax(list);                                      // получаем максимальное
        System.out.printf("\nmin = %d,   max = %d, middle = %d\n\n", min, max, getMiddle(list, min, max)); // печатаем
                                                            // минимальное, максимальное, получаем и печатаем
                                                            // среднее(максимально близкое к среднему из списка)
                                                            // для не сортированного.
        System.out.println(mergeSort(list));                               // Сортируем список слиянием и печатаем
        System.out.println(deleteEvenNumbers(list));                       // Удаляем чётные. Печатаем, что осталось

    }
}
