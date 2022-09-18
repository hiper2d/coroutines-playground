package interview.autocomplete;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode current = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.toCharArray()[i];
            boolean isLastChar = i == word.length() - 1;
            if (!current.children.containsKey(c)) {
                TrieNode newNode = new TrieNode(isLastChar);
                current.children.put(c, newNode);
            }
            current = current.children.get(c);
        }
    }

    Set<String> search(String prefix) {
        TrieNode current = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.toCharArray()[i];
            if (!current.children.containsKey(c)) {
                return Set.of();
            }
            current = current.children.get(c);
        }
        return traverse(current, prefix);
    }

    private Set<String> traverse(TrieNode node, String prefix) {
        Set<String> solution = new HashSet<>();
        for (Character c: node.children.keySet()) {
            if (node.children.get(c).isWord) {
                solution.add(prefix + c.toString());
            }
            solution.addAll(traverse(node.children.get(c), prefix + c.toString()));
        }
        return solution;
    }
}
