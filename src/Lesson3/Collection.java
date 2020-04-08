package Lesson3;

import java.util.*;

public class Collection {

    static  String[] words = new String[20];

    public static void main(String[] args) {

        for (int i = 0; i < words.length; i=i+2) {
            words[i] = generateRandomWord(10);
            if (i < words.length-1){
                words[i+1] = words[i];
            }
        }
        ShuffleRandomWord(words);
        printWord(words);

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words){
            Integer cnt =  map.get(s);
            cnt = cnt == null ? 1 : ++cnt;
            map.put(s, cnt);
        }
        System.out.println("1 task");
        System.out.println(map);
        System.out.println(String.format("%40s", " ").replace(" ","*"));
        System.out.println("2 task");
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Test", "+799999999");
        phoneBook.add("Test", "+799999991");
        phoneBook.add("Test2", "+799999998");

        System.out.println(phoneBook.get("Test"));
        System.out.println(phoneBook.get("Test2"));


    }

    private static String generateRandomWord(int wordLength) { //Генерация слов
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) {
            char tmp = (char)('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }
      static void printWord(String[] words){
        for(String s : words){
            System.out.println(s);
        }
    }
    private static String[] ShuffleRandomWord(String[] word){
        String[] Literals =  word;
        List<String> shuffle = Arrays.asList(Literals);
        Collections.shuffle(shuffle);
        shuffle.toArray(Literals);
        return Literals;
    }

}
