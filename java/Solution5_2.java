public class Solution5_2 {

    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            return x ^ ((1L << i) | (1L << j));
        }
        return x;
    }

}

// Note: In Python, I compared the two set bits by doing (1 << i) & x.
// This also works in Java, but it's possible that it would shift out
// of the range of an int, so the right shifting is safer.
// However, it might work just as well if I used 1L instead of 1.
