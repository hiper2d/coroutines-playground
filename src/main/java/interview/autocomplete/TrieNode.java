package interview.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    final boolean isWord;
    final Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
        this.isWord = false;
    }

    public TrieNode(boolean isWord) {
        this.isWord = isWord;
    }
}
