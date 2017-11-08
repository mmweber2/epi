def find_most_frequent(words, k):
    freqs = {}
    for word in words:
        if word in freqs:
            freqs[word] += 1
        else:
            freqs[word] = 1
            if len(freqs) == k:
                # keys() makes a copy of the keys, so we can delete them as needed 
                for seen_word in freqs.keys():
                    if freqs[seen_word] == 1:
                        del freqs[seen_word]
                    else:
                        freqs[seen_word] -= 1

    # Iterated through all words, now reset the dict for counting
    freqs = {word:0 for word in freqs}

    # Count occurrences of chosen candidate words
    for word in words:
        if word in freqs:
            freqs[word] += 1

    # len() is 0(1), or count words in O(n)
    n = len(words)
    return [w for w in freqs if freqs[w] > (float(n) / k)]
