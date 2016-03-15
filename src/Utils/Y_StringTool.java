package Utils;

import java.util.Iterator;
import java.util.Random;

public class Y_StringTool {

	public static String replace(String s, char ch, int place) {
		char[] array = s.toCharArray();
		array[place] = ch;
		return new String(array);
	}

	public static String insert(String s, char ch, int place) {
		return s.substring(0, place) + ch + s.substring(place);
	}

	public static String randomString(int length) {
		String src = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVXYZ-_+";
		char[] srcarray = src.toCharArray();
		String out = "";
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < length; i++) {
			out = out + srcarray[rand.nextInt(srcarray.length -1)];
		}
		return out;
	}

	public static String removeKomma(String s) {
		if(s.endsWith(",")) s = s.substring(0, s.length() -1);
		return s;
	}

	@SuppressWarnings("rawtypes")
	public class IteratingString implements Iterator {

		String s;
		int place = -1;

		@Override
		public boolean hasNext() {
			return (s.length() >= place);
		}

		@Override
		public Object next() {
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
}