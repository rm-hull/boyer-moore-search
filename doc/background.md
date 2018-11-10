# Background

An implementation of the Boyer-Moore string search algorithm in Clojure.
The Wikipedia entry for this algorithm describes it thusly:

> The Boyer-Moore algorithm searches for occurrences of _P_ in _T_ by
> performing explicit character comparisons at different alignments.
> Instead of a brute-force search of all alignments (of which there are
> _m-n+1_), Boyer-Moore uses information gained by preprocessing _P_ to
> skip as many alignments as possible.
>
> Previous to the introduction of this algorithm, the usual way to search
> within text was to examine each character of the text for the first
> character of the pattern. Once that was found the subsequent characters
> of the text would be compared to the characters of the pattern. If no
> match occurred then the text would again be checked character by
> character in an effort to find a match. Thus almost every character in
> the text needs to be examined.
>
> The key insight in this algorithm is that if the end of the pattern is
> compared to the text, then jumps along the text can be made rather than
> checking every character of the text. The reason that this works is
> that in lining up the pattern against the text, the last character of
> the pattern is compared to the character in the text. If the characters
> do not match there is no need to continue searching backwards along the
> pattern. If the character in the text does not match any of the
> characters in the pattern, then the next character to check in the text
> is located n characters farther along the text, where n is the length
> of the pattern. If the character is in the pattern then a partial shift
> of the pattern along the text is done to line up along the matching
> character and the process is repeated. The movement along the text in
> jumps to make comparisons rather than checking every character in the
> text decreases the number of comparisons that have to be made, which is
> the key to the efficiency of the algorithm.
