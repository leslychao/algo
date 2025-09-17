import java.util.Arrays;

public class ArraysTasks {

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 8};
    int[] arr2 = {7, 9, 10, 11};
    int[] arr3 = {2, 1, 5, 1, 3, 2};

    System.out.println(Arrays.toString(mergeTwoSortedArrays(arr2, arr1)));
  }

  public static double mediansOfTwoArrays(int[] arr1, int[] arr2) {
    if (arr2.length < arr1.length) {
      return mediansOfTwoArrays(arr2, arr1);
    }

    int n1 = arr1.length;
    int n2 = arr2.length;

    int total = n1 + n2;
    int half = (total + 1) / 2;

    int left = 0;
    int right = n1;

    while (left <= right) {
      int i = (left + right) >>> 1;
      int j = half - i;

      int maxLeftA = i == 0 ? Integer.MIN_VALUE : arr1[i - 1];
      int minRightA = i == n1 ? Integer.MAX_VALUE : arr1[i];
      int maxLeftB = j == 0 ? Integer.MIN_VALUE : arr2[j - 1];
      int minRightB = j == n2 ? Integer.MAX_VALUE : arr2[j];

      if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
        if (total % 2 == 0) {
          return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
        }
        return Math.max(maxLeftA, maxLeftB) + 0.0;
      }

      if (maxLeftA > minRightB) {
        right = i - 1;
      } else {
        left = i + 1;
      }
    }

    return -1;
  }

  public static int maxSumSlidingWindow(int[] arr) {
    int k = 3;
    int n = arr.length;

    int windowsSum = 0;
    int maxWindowSum = 0;

    for (int i = 0; i < n; i++) {
      windowsSum += arr[i];
      if (i >= k - 1) {
        maxWindowSum = Math.max(windowsSum, maxWindowSum);
        windowsSum -= arr[i - (k - 1)];
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

  public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    int i = 0;
    int j = 0;
    int k = 0;
    int[] result = new int[n1 + n2];

    while (i < n1 && j < n2) {
      if (arr1[i] <= arr2[j]) {
        result[k++] = arr1[i++];
      } else {
        result[k++] = arr2[j++];
      }
    }

    while (i < n1) {
      result[k++] = arr1[i++];
    }

    while (j < n2) {
      result[k++] = arr2[j++];
    }

    return result;
  }
}
