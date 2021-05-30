package main.trie;

public interface Trie<T> {

    void put(String word, T value);

    T get(String word);

    boolean delete(String word);

    boolean containsWord(String word);

    boolean containsPrefix(String prefix);

    Iterable<String> keys();

    Iterable<String> keysWithPrefix(String prefix);

    String longestPrefixOf(String word);

}
