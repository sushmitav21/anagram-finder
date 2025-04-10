package main;

import java.nio.file.*;
import java.util.*;

public class AnagramFinder {

    public static void main(String[] args) {
        String filename = "src/main/resources/ordbok-utf8.txt";

        // Read .txt file from resources folder
        List<String> words = readWordsFromFile(filename);
        if (words == null || words.isEmpty()) {
            System.err.println("File is empty, check again!");
            return;
        }

        //creating map for grouping anagrams
        Map<String, List<String>> anagramGroupsMap = new HashMap<>();
        for (String word : words) {
            String sorted = sortChars(word.toLowerCase()); //case-sensitivity
            if (!anagramGroupsMap.containsKey(sorted)) {
                anagramGroupsMap.put(sorted, new ArrayList<>());
            }
            anagramGroupsMap.get(sorted).add(word);
        }
        System.out.println("Words with at least one anagram :");
        boolean foundAnagram = false;

        for (List<String> group : anagramGroupsMap.values()) {
            if (group.size() > 1) {
                foundAnagram = true;
                System.out.println(group);
            }
        }

        if (!foundAnagram) {
            System.out.println("No anagrams found.");
        }
    }

    private static List<String> readWordsFromFile(String filename) {
        try {
            return Files.lines(Paths.get(filename))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();
        } catch (Exception e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
            return List.of();
        }
    }

    //sort characters
    private static String sortChars(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

