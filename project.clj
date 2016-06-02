(defproject rm-hull/boyer-moore-search "0.0.1"
  :description "A parser-combinator library in Clojure"
  :url "https://github.com/rm-hull/boyer-moore-search"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]]
  :scm {:url "git@github.com:rm-hull/boyer-moore-search"}
  :plugins [
    [lein-codox "0.9.5"] ]
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :source-paths ["src"]
    :output-path "doc/api"
    :source-uri "http://github.com/rm-hull/boyer-moore-search/blob/master/{filepath}#L{line}" }
  :min-lein-version "2.6.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :plugins [
        [lein-cloverage "1.0.6"]]}})
