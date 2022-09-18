package interview.autocomplete;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Autocomplete {

    private final Trie trie = new Trie();

    public Autocomplete() {

    }

    public void addWords(List<String> words) {
        words.forEach(trie::addWord);
    }

    public Set<String> autocomplete(String prefix) {
        return trie.search(prefix);
    }

    public static void main(String[] args) {
        Autocomplete auto = new Autocomplete();
        auto.addWords(Arrays.asList("abc", "abcd", "am"));
        System.out.println(auto.autocomplete("ab"));
    }
}
