def fullJustify( words, maxWidth):
    res, cur, num_of_letters = [], [], 0
    words_arr = words.split()
    for w in words_arr:
        if num_of_letters + len(w) + len(cur) > maxWidth:
            for i in range(maxWidth - num_of_letters):
                cur[i%(len(cur)-1 or 1)] += ' '
            res.append(''.join(cur))
            cur, num_of_letters = [], 0
        cur += [w]
        num_of_letters += len(w)
        outcome = res + [' '.join(cur).ljust(maxWidth)]
    return outcome

fullJustify('Jeremy likes to code', 10)