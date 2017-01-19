public class Solution5_2 {

  public static long swapBits(long x, int i, int j) {
    if (((x >>> i) & 1) != ((x >>> j) & 1)) {
      return x ^ ((1L << i) | (1L << j));
    }
      return x;
    }

  public static void main(String[] args) {
    // Tests
    // i = j
    long result = swapBits(0b1110L, 0, 0);
    System.out.println("For test 14, 0, 0, expected: 14. Result: " + result);
    // x[i] = x[j]
    result = swapBits(0b10100L, 1, 6);
    System.out.println("For test 20, 2, 4, expected: 20. Result: " + result);
    // EPI example
    result = swapBits(73L, 1, 6);
    System.out.println("For test 73, 1, 6, expected: 11. Result: " + result);
    // Large number where x[i] != x[j]
    result = swapBits(3213375036854775808L, 2, 29);
    long expected = 3213375036317904900L;
    System.out.println(
      "For test 3213375036854775808L, 2, 29, expected: " + expected + ". " +
      "Result: " + result);
    if (expected == result) {
      System.out.println("Expected matched result.");
    } else {
      System.out.println("Results did not match.");
    }
    //
    // Error cases
    // TODO:
    // i < 0
    // i = 64
    // i = 100
    }

}

