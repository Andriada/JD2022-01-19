package by.it.burov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] array = {};


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Я][А-Яа-яёЁ\\s-,:]+(\\.{3})?[А-Яа-яёЁ\\s-,:]+[.!?]\\s?");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String sentence = matcher.group();
            addSentence(sentence);
        }
        sortSentence(array);
        printResult(array);
    }

    private static void addSentence(String sentence) {
        sentence = sentence.replaceAll("[\\,\\.{3,}\\!\\?\\:\\;\\-\n]", "\s");
        String[] tempArray = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : tempArray) {
            if (!s.isEmpty()) {
                builder.append(s + " ");
            }
        }
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = builder.toString().trim();
    }

    private static void sortSentence(String[] array) {
     Arrays.sort(array,((o1, o2) -> o1.length()-o2.length()));
    }


        private static void printResult (String[] array){
            for (int i = 0; i < TaskB2.array.length; i++) {
                System.out.printf("%s%n", TaskB2.array[i]);
            }
        }
}

