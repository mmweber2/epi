# Questions:
# What format should the return be?
# How should we handle leading zeroes?

# Observations:
# I think we could use our solution to the previous problem here,
# indexing towards the middle of the word. However, I think there
# should be a simpler solution than walking through half the bits.

# 1010 to 0101 : This is just an XOR with all 1s.
# 11 to 11, or 00 to 00: No change here. It's the same when x is a palindrome.
# 111101 to 101111: An all 1s XOR won't work. 

# I don't see a solution for the non-alternating case, so I'm going to try
# the 'walking halfway' solution.

def reverse_bits(x):
    # Python doesn't do fixed size ints, so I'll make a 64-int array.
    array = ["0"] * 64
    for i in xrange(64):
        if x & (1 << i):
            array[i] = "1"
    for j in xrange(32):
        if array[j] != array[63 - j]:
            array[j], array[63 - j] = array[63 - j], array[j]
    return "".join(array)

# I think this works, but it isn't really bit manipulation.

