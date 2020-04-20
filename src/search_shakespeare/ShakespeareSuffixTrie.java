package search_shakespeare;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.FileUtility;

/**
 *
 * @author stanislavnovitski
 */
public class ShakespeareSuffixTrie implements Iterable<Pair<Key, Integer>> {

    public ShakespeareSuffixTrie() {
    }

    Trie<Integer> trie = null;

    public void add(ShakespeareSuffixKey key) {
        if (trie == null) {
            trie = new KeyTrie(key, key.getPosition());
        } else {
            trie = trie.add(key, key.getPosition());
        }
    }

    public void load(String path) throws IOException {
        String[] words = FileUtility.toStringArray(path, "[^a-zA-Z]");
        String singleString = this.createSingleString(words);
        ShakespeareSuffixKey works = new ShakespeareSuffixKey(singleString);
        while (works.getSize() > 0) {
            this.add(works);
            works = works.getRest();
        }

    }

//    public String getWord(String word) {
//        return this.trie.find(new ShakespeareSuffixKey(word)).toString();
//    }

    private String createSingleString(String[] words) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Pair<Key, Integer>> iterator() {
        return this.trie.iterator();
    }

    public static void main(String[] args) {
        ShakespeareSuffixTrie s = new ShakespeareSuffixTrie();
        try {
            s.load("src/shakespeare_project/data.txt");
        } catch (IOException ex) {
            Logger.getLogger(ShakespeareSuffixTrie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
