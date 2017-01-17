// See 5_1.py for questions.

public class Solution5_1 {

    public static int get_parity(long word) {
        // 0 has a parity of 0 (false)
        boolean odd_ones = false;
        while (word != 0) {
            word &= (word - 1);
            odd_ones = !odd_ones;
        }
        return (odd_ones == true) ? 1 : 0;
    }

    public static int get_parity_cached(long word, int[] cache) {
        long mask = 65535;
        int parity = cache[(int)(word & mask)];
        parity ^= cache[(int)(word & (mask << 16))];
        parity ^= cache[(int)(word & (mask << 32))];
        return parity ^= cache[(int)(word & (mask << 48))];
    }

    public static void main(String[] args) {
        /* Instead of a single long, I would expect some kind of sequence or
         *   input containing many longs, but I don't know the form of that
         *   for this problem. The book seems to assume access to an array
         *   somewhere outside of the function with the precomputed parities.
         */
        long word = 34;
        int[] cache = new int[65536];
        for (int i = 0; i < 65536; i++) {
            cache[i] = get_parity(i);
        }
        int result = get_parity_cached(word, cache);
        System.out.println(result);
    }
}
