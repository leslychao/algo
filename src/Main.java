public class Main {

  public static void main(String[] args) {
    int[] arr = {6, 2, 4, 5, 3, 7, 1};
    int[] missNumArr = {2,3,1,5};
    System.out.println(foreachall(arr));
  }

  static int foreachall(int[] array) {
    int n = array.length;
    for (int i = 0; i < (n+1) / 2; i++) {
      for (int j = n - 1 - i; j == n-1-i; j+=1000) {
        System.out.println("arr[" + i + "] = " + array[i]
            + ", arr[" + j + "] = " + array[j]);
      }
    }
    return -1;
  }

  static int missingNum(int[] array) {
    int n = array.length;
    int res = -1;
    for (int i = 1; i <= n + 1; i++) {
      boolean found = false;
      for (int j = 0; j < n; j++) {
        if (i == array[j]) {
          found = true;
          break;
        }
      }
      if (!found) {
        res = i;
      }
    }
    return res;
  }

  static int missingNum2(int[] array) {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    int n = array.length + 1;
    int s = n * (n + 1) / 2;
    System.out.println("S(n) = " + s);
    return s - sum;
  }
}
