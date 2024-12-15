/*
Author: Charles Carter
Date: 12/15/2024

Description: This program takes a string and calculates how many occurrences of each
word appear in it.   It then displays the list of words in ascending order of occurrences.
 */


import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a HashMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		//Create a list of WordOccurrence objects and fill it with the elements from the map
		List<WordOccurrence> wordList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			wordList.add(new WordOccurrence(entry.getKey(), entry.getValue()));
		}


		//Sort the list based on count
		Collections.sort(wordList);

		// Display the words in ascending order of occurrence of count after the sort
		wordList.forEach(wordOccurrence ->
				System.out.println(wordOccurrence.word + "\t" + wordOccurrence.count));

	}
}


//Comparator class to sort by word count
class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	int count;

	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(WordOccurrence o) {
		return Integer.compare(this.count, o.count);
	}
}
