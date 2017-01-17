# Questions:
# What if i and/or j are invalid?
# How many times will this operation be performed? (Should we precalculate?)
# What should the form of the return value be?
# Is the integer signed or unsigned?

# Observations:
# If the bits at i and j are both 0 or 1, nothing will change.
# This also includes the case where i = j.
# Is it worth checking for this case, or will it be handled naturally?
# It seems like we should be able to XOR these two positions.

def swap_bits(int_array, i, j):
    if not (int_array & (1 << i)) ^ (int_array & (1 << j)):
        # Both bits are the same value
        return int_array
    i_value = (1 << i) & int_array
    j_value = (1 << j) & int_array
    return int_array ^ i_value ^ j_value

# Test cases:
# Error cases (this will not work if i/j are invalid)
# i = j
# i and j are both 0
# i and j are both 1

# If i = j:

01001001
i = 3, j = 3
i_value = j_value = 00001000
int_array = 01001001
returns 01001001

# When we XOR the two bits, they will be 0, and XORing that will leave
# the input unchanged. That works as desired.

# i and j are both 1:

01001001
i = 6, j = 0
j_value = 00000001
i_value = j_value = 01000000
i_value ^ j_value = 01000001
int_array = 01001001
returns 00001000

# This is not what we want, so we need to special case this.

# Book solution (in Python):

def swap_bits(x, i, j):
    if ((x >> i) & 1) != ((x >> j) & 1):
        return x ^ ((1 << i) | (1 << j))
