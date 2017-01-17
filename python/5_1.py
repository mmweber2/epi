# Questions:
# Does the parity of a very large number of 64 bit words mean that we will
#   be asked to check the invidividual parity of many words, or will we
#   be asked to check the combined parity of a large number of words?
#   How large is "very large"?

# Assumption: Word is given in binary format as in the problem example.

# First, check parity of a single word.
def get_parity(word):
    return word.count('1') % 2

# Since the hint says to make a lookup table, I'm guessing that it wants us to
# pre-calculate the values for many 64 bit words.

# How about breaking each 64 bit word into 4 16 bit words, then comparing those
# parities?

def get_parities(words):
    table = [get_parity(bin(num)) for x in xrange(65536)]
    parities = []
    mask1 = 65535  # 2**16 - 1
    mask2 = mask1 << 16
    mask3 = mask1 << 32
    mask4 = mask1 << 48
    for word in words:
        parity = table[word & mask1]
        parity = parity ^ table[(word & mask2) >> 16]
        parity = parity ^ table[(word & mask3) >> 32]
        parities.append(parity ^ table[(word & mask4) >> 48])
    return parities
