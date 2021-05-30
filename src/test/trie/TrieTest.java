package test.trie;

import main.trie.RWayTries;
import main.trie.TernarySearchTries;
import main.trie.Trie;

import java.util.Queue;

public class TrieTest {

    public static boolean testRWayTrie() {
        Trie<Integer> trie = new RWayTries<>();
        return test(trie);
    }

    public static boolean testTernarySearchTrie() {
        Trie<Integer> trie = new TernarySearchTries<>();
        return test(trie);
    }

    private static boolean test(Trie<Integer> trie) {

        boolean allTestPassed = true;

        trie.put("by", 2);
        trie.put("sea", 3);
        trie.put("sells", 5);
        trie.put("she", 3);
        trie.put("shells", 6);
        trie.put("shore", 5);
        trie.put("the", 3);

        allTestPassed = trie.get("shells") == 6;
        allTestPassed = allTestPassed && trie.get("shell") == null;

        Queue<String> keys = (Queue<String>) trie.keys();
        allTestPassed = allTestPassed && keys.poll().equals("by");
        allTestPassed = allTestPassed && keys.poll().equals("sea");
        allTestPassed = allTestPassed && keys.poll().equals("sells");

        trie.put("bait",4);
        keys = (Queue<String>) trie.keys();
        allTestPassed = allTestPassed && keys.poll().equals("bait");

        allTestPassed = allTestPassed && trie.delete("bait");
        allTestPassed = allTestPassed && trie.containsWord("shells");
        allTestPassed = allTestPassed && !trie.containsWord("bait");

        allTestPassed = allTestPassed && trie.containsPrefix("sho");

        keys = (Queue<String>) trie.keysWithPrefix("se");
        allTestPassed = allTestPassed && keys.poll().equals("sea");
        allTestPassed = allTestPassed && keys.poll().equals("sells");
        allTestPassed = allTestPassed && keys.isEmpty();

        allTestPassed = allTestPassed && trie.longestPrefixOf("shellshort").equals("shells");
        allTestPassed = allTestPassed && trie.longestPrefixOf("shelld").equals("she");

        return allTestPassed;
    }
}
