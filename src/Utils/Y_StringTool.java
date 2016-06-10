package Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class Y_StringTool {

	private static HashMap<Character, String> replacement;//init on use only

	/*
	 * returns a String, with replacements for invisible chars like " " -> "[space]"
	 * not all chars yet.... adding some more.
	 */
	public static String show_invisible(String str) {
		for(Entry<Character, String> entry : getReplacement().entrySet()) {
			str = str.replace(entry.getKey() + "", entry.getValue());
		}
		return str;
	}

	public static String replace_char(String s, char ch, int place) {
		char[] array = s.toCharArray();
		array[place] = ch;
		return new String(array);
	}

	public static String insert_char(String s, char ch, int place) {
		return s.substring(0, place) + ch + s.substring(place);
	}

	/*
	 * *Generates a "Random" String with the given source, and the given length
	 * chars, maybe tow times in output String.
	 */
	public static String randomString(int length, String src) {
		char[] srcarray = src.toCharArray();
		String out = "";
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < length; i++) {
			out = out + srcarray[rand.nextInt(srcarray.length -1)];
		}
		return out;
	}

	/*
	 * Returns a "Random" String with the given length, and the standart set.
	 * Chars, can be tow times in the result.
	 */
	public static String randomString(int length) {
		return randomString(length, "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVXYZ-_+");
	}

	public static String removeKomma(String s) {
		if(s.endsWith(",")) s = s.substring(0, s.length() -1);
		return s;
	}

	public static class IteratingString implements Iterable<Character>, Iterator<Character> {

		String s;
		int place = -1;

		@Override
		public boolean hasNext() {
			return (s.length() >= place);
		}

		@Override
		public Character next() {
			place = place+1;
			return s.charAt(place);
		}

		@Override
		public void remove() {
			place = place +1;
		}

		public IteratingString(String src) {
			s = src;
		}


		@Override
		public Iterator<Character> iterator() {
			return this;
		}
	}

	public static int levenshteinDistance(String a, String b) {
		if(a.length() == 0 | b.length() == 0)
			return 0;

		int[] costsPrev = new int[a.length() + 1];
		int[] costs = new int[a.length() + 1];

		for (int aIndex = 0; aIndex <= a.length(); aIndex++)
			costsPrev[aIndex] = aIndex;

		for (int bIndex = 1; bIndex <= b.length(); bIndex++) {
			char bIndexChar = b.charAt(bIndex - 1);
			costs[0] = bIndex;

			for (int aIndex = 1; aIndex <= a.length(); aIndex++) {
				int cost = (a.charAt(aIndex - 1) == bIndexChar) ? 0 : 1;
				costs[aIndex] = Math.min(Math.min(costs[aIndex - 1] + 1,
						costsPrev[aIndex] + 1),
						costsPrev[aIndex - 1] + cost);
			}
			int[] tmpArr = costsPrev;
			costsPrev = costs;
			costs = tmpArr;
		}
		return costsPrev[a.length()];
	}

	/**
	 * Cuts out an String
	 * example: cutout("My name is: Johny and i like trains.", "name is: "," "); would return "Johnny" because its between.
	 * @param source The String
	 * @param bevore a String contained by the Source and bevore the first cut
	 * @param after a String after the Second cut
	 * @return the piece of source between bevore and after
	 */
	public static String cutout(String source, String bevore, String after) {
		source = source.substring(source.indexOf(bevore) + bevore.length());
		source = source.substring(0,source.indexOf(after));
		
		return source;
	}

	//================private
	private static HashMap<Character, String> getReplacement() {
		if(replacement == null) {//init on empty -> save recources!
			replacement = new HashMap<Character, String>();
			replacement.put((char) 0 , "[null]");
			replacement.put((char) 7, "[bell]");
			replacement.put(' ' , "[space]");
			//TODO add more
		}
		return replacement;
	}
}