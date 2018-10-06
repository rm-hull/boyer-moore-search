# Boyer-Moore String Search
[![Build Status](https://travis-ci.org/rm-hull/boyer-moore-search.svg?branch=master)](http://travis-ci.org/rm-hull/boyer-moore-search) 
[![Coverage Status](https://coveralls.io/repos/rm-hull/boyer-moore-search/badge.svg?branch=master)](https://coveralls.io/r/rm-hull/boyer-moore-search?branch=master) 
[![Dependencies Status](https://versions.deps.co/rm-hull/boyer-moore-search/status.svg)](https://versions.deps.co/rm-hull/boyer-moore-search) 
[![Downloads](https://versions.deps.co/rm-hull/boyer-moore-search/downloads.svg)](https://versions.deps.co/rm-hull/boyer-moore-search) 
[![Clojars Project](https://img.shields.io/clojars/v/rm-hull/boyer-moore-search.svg)](https://clojars.org/rm-hull/boyer-moore-search)
[![Maintenance](https://img.shields.io/maintenance/yes/2018.svg?maxAge=2592000)]()

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

This clojure implementation is designed to work on strings, sequences, vectors,
and `java.io.InputStream`. Ported from the original:
https://github.com/rm-hull/cljs-dataview/blob/master/src/dataview/boyer_moore.cljs.

### Pre-requisites

You will need [Leiningen](https://github.com/technomancy/leiningen) 2.8.1 or above installed.

### Building

To build and install the library locally, run:

    $ cd boyer-moore-search
    $ lein test
    $ lein install

### Including in your project

There is a version hosted at [Clojars](https://clojars.org/rm-hull/boyer-moore-search).
For leiningen include a dependency:

```clojure
[rm-hull/boyer-moore-search "0.1.0"]
```

For maven-based projects, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>rm-hull</groupId>
  <artifactId>boyer-moore-search</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Basic Usage

> TODO

## References

* https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string_search_algorithm#Implementations

## License

### The MIT License (MIT)

Copyright (c) 2016 Richard Hull

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
