// See 5_1.py for questions.

public class Solution5_1 {

    private static final byte[] cache = new byte[1 << 16];

    static {
        for (int i = 0; i < 1 << 16; i++) {
            cache[i] = get_parity(i);
        }
    }

    // The EPI solution returns a short, but since it will be a 1 or 0,
    //   I'll return a byte instead.
    public static byte get_parity(long word) {
        // 0 has a parity of 0 (false)
        boolean odd_ones = false;
        while (word != 0) {
            word &= (word - 1);
            odd_ones = !odd_ones;
        }
        return odd_ones ? (byte)1 : (byte)0;
    }

    public static byte get_parity_cached(long word) {
        final int mask = 0xFFFF;
        byte parity = cache[(int)(word & mask)];
        // Since the result of word & mask must be within the size of the cache,
        //   the word has to get smaller instead of the mask getting larger.
        parity ^= cache[(int)((word >>> 16) & mask)];
        parity ^= cache[(int)((word >>> 32) & mask)];
        return parity ^= cache[(int)((word >>> 48) & mask)];
    }

    public static void main(String[] args) {
        /* Instead of a single long, I would expect some kind of sequence or
         *   input containing many longs, but we're not given the form of that
         *   for this problem.
         */
        // Tests
        byte result = get_parity_cached(0L);
        System.out.println("0: Expected: 0. Result: " + result);
        result = get_parity_cached(1L);
        System.out.println("1: Expected: 1. Result: " + result);
        result = get_parity_cached(0b11L);
        System.out.println("3: Expected: 0. Result: " + result);
        result = get_parity_cached(0b1011L);
        System.out.println("11: Expected: 1. Result: " + result);
        result = get_parity_cached(0b100010L);
        System.out.println("34: Expected: 0. Result: " + result);
        // Test large number near the upper bound of long (48 1s)
        result = get_parity_cached(9223372016854725808L);
        System.out.println("9223372016854725808L: Expected: 0. Result: " + result);
        // Test large number near the upper bound of long (27 1s)
        result = get_parity_cached(3223342036854705808L);
        System.out.println("3223342036854705808L: Expected: 1. Result: " + result);
    }
}
