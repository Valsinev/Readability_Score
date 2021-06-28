package readability;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] sentences = sentenceConverter(text);
        int allWordsCounter = 0;
        for (String sentence: sentences
             ) {
            allWordsCounter += wordsCounter(sentence);
        }
        if ((double)allWordsCounter / sentences.length <= 10) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }

    public static int wordsCounter(String sentence) {
        Pattern wordsPattern = Pattern.compile("[\\w]+");
        Matcher wordsCounter = wordsPattern.matcher(sentence);
        int count = 0;
        while (wordsCounter.find()) {
            count++;
        }
        return count;
    }

    public static String[] sentenceConverter(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences;
    }
}
