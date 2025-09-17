import java.util.Arrays;

public class StringTasks {

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(longestSubstringASCII(s));
  }

  public static String longestSubstringASCII(String s) {
    int[] charIdx = new int[256];
    Arrays.fill(charIdx, -1);

    int bestLen = 0;
    int left = 0;
    int bestLeft = 0;

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      if (charIdx[c] >= left) {
        left = charIdx[c] + 1;
      }
      int len = i - left + 1;
      charIdx[c] = i;
      if (len > bestLen) {
        bestLen = len;
        bestLeft = left;
      }
    }

    return s.substring(bestLeft, bestLeft + bestLen);
  }
}
