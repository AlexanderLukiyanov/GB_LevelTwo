import java.util.*;

public class LessonTreeHomeWork {
    public static void main(String[] args) {
        String[] arrayWords = new String[]{"Java", "GeekBrains", "Java", "HomeWork",
                "Laptop", "HomeWork", "Glass", "Laptop", "Mouse", "Dog", "Cat", "Laptop"};

        System.out.println("Список слов в масииве " +(Arrays.toString(arrayWords)));

        Set<String> arrayWordsUnique = new HashSet<>(Arrays.asList(arrayWords));
        System.out.println("Список уникальных слов в массиве " + (arrayWordsUnique));

        ArrayList<String> setArrayWords = new ArrayList<String>(Arrays.asList(arrayWords));

        int count = 0;
        String name;
        for (int i = 0; i < setArrayWords.size();) {
            name = setArrayWords.get(i);
            for (int j = 0; j < setArrayWords.size(); j++) {
                if (name == setArrayWords.get(j)) {
                    count++;
                }
            }
            System.out.println("Слово " + name + " встречается " + count + " раз.");
            count = 0;
            for (int j = 0; j < setArrayWords.size(); j++) {
                if (name.equals(setArrayWords.get(j))) {
                    setArrayWords.remove(j);
                }
            }
        }
    }
}
