package modulo01;

public class Palindrome {

	public static boolean isPalindrome(String text) {
		if (text == null || text.trim().length() == 0) return false; // Exit first

		text = text.replaceAll(" ", "").toLowerCase();
		
		int counterAsc = 0;
		int counterDesc = text.length() -1;
		
		while(counterDesc >= counterAsc) {
			char characterDesc = text.charAt(counterDesc);
			char characterAsc = text.charAt(counterAsc);
			
			if (characterDesc != characterAsc) {
				return false;
			}

			counterDesc--;
			counterAsc++;
		}
		return true;
	}
}
