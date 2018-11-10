(defproject rm-hull/boyer-moore-search "0.1.0"
  :description "Boyer-Moore string search library in Clojure"
  :url "https://github.com/rm-hull/boyer-moore-search"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :scm {:url "git@github.com:rm-hull/boyer-moore-search"}
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :source-paths ["src"]
    :doc-files [
      "doc/background.md"
      "doc/basic-usage.md"
      "doc/references.md"
      "LICENSE.md"
    ]
    :output-path "doc/api"
    :source-uri "http://github.com/rm-hull/boyer-moore-search/blob/master/{filepath}#L{line}" }
  :min-lein-version "2.8.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
    :dependencies [
      [org.clojure/clojure "1.9.0"]]
    :plugins [
      [lein-codox "0.10.3"]
      [lein-cljfmt "0.5.7"]
      [lein-cloverage "1.0.10"]]}})
