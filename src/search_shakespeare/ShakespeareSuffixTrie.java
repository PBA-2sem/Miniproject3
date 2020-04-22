package search_shakespeare;

import java.io.IOException;
import java.util.ArrayList;
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

    Trie trie = null;

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

    public void tryShakespeareSuffixTrie() {
        try {
            this.load("src/shakespeare_project/data.txt");

            Trie toBeOrNot = this.trie.locate(new ShakespeareSuffixKey("to be or no"));

            Iterator iter = toBeOrNot.iterator();
            ArrayList list = new ArrayList();
            for (int i = 0; i < 20; i++) {
                if (iter.hasNext()) {
                    list.add(iter.next());
                } else {
                    break;
                }
            }
            list.forEach(i -> System.out.println(i.toString()));
//            iter.forEachRemaining(i -> System.out.println(i.toString()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ShakespeareSuffixTrie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ShakespeareSuffixTrie s = new ShakespeareSuffixTrie();

        s.tryShakespeareSuffixTrie();
//        try {
//            s.load("src/shakespeare_project/data.txt");
//        } catch (IOException ex) {
//            Logger.getLogger(ShakespeareSuffixTrie.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
