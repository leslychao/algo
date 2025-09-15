import java.util.Arrays;

public class ArraysTasks {

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 8};
    int[] arr2 = {7, 9, 10, 11};
    int[] arr3 = {2, 1, 5, 1, 3, 2};

    System.out.println(maxSumSlidingWindow(arr3));
  }

  public static int maxSumSlidingWindow(int[] arr) {
    int k = 3;
    int n = arr.length;

    int windowsSum = 0;
    int maxWindowSum = 0;

    for (int i = 0; i<n; i++) {
      windowsSum += arr[i];
      if (i>= k-1) {
        maxWindowSum = Math.max(windowsSum, maxWindowSum);
        windowsSum -= arr[i-(k-1)];
      }
    }
    return maxWindowSum;
  }

  public static int binarySearch(int[] arr, int v) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int midIdx = left + (right - left) / 2;
      int midVal = arr[midIdx];
      if (v < midVal) {
        right = midIdx - 1;
      } else if (v > midVal) {
        left = midIdx + 1;
      } else {
        return midIdx;
      }
    }

    return -1;
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

    return s.substring(bestLeft, bestLen);
  }
}
