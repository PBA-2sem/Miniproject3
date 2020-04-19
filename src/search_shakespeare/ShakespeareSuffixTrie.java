package search_shakespeare;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import utilities.FileUtility;

/**
 *
 * @author stanislavnovitski
 */
public class ShakespeareSuffixTrie implements Iterable<Pair<Key, Integer>> {

    Trie<Integer> trie;

    public void add(ShakespeareSuffixKey key) {
        if (trie == null) {
            trie = new KeyTrie(key, key.getPosition());
        } else {
            trie = trie.add(key, key.getPosition());
        }
    }

    public void load(Path path) throws IOException {
        // WTF IS .rest FUCKIN KOTLIN...
//         = ShakespeareSuffixKey(FileUtility.toStringArray(path.toString(), "[A-Za-z']+"));
    }

    @Override
    public Iterator<Pair<Key, Integer>> iterator() {
        return this.trie.iterator();
    }

}
