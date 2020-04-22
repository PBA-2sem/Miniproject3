package search_shakespeare;

import java.util.Iterator;
import utilities.ArrayIterator;

/**
 *
 * @author stanislavnovitski
 * @param <T>
 */
public class KeyTrie<T> extends Trie<T> {

    private Key key;
    private T value = null;

    public KeyTrie(Key key, T action) {
        this.key = key;
        this.value = action;
    }

    @Override
    Trie<T> add(Key key, T action) {
        if (this.key.equals(key)) {
            this.value = action;
            return this;
        }
        ArrayTrie<T> t = new ArrayTrie<T>(this.key, action);
        return t.add(key, action);
    }

    @Override
    T find(Key key) {
        if (this.key.equals(key)) {
            return this.value;
        }
        return null;
    }

    @Override
    Trie<T> locate(Key key) {
        if (key.getLength() == 0 || this.key.includes(key)) {
            return this;
        }
        return null;
    }

    public String toString() {
        return this.key.toString() + " " + this.value.toString();
    }

    @Override
    public Iterator<Pair<Key, T>> iterator() {
        Pair[] test = new Pair[]{new Pair(this.key, this.value)};
//        List<Pair<Key, T>> test = new ArrayList();
//        test.add(new Pair(this.key, this.value));
        ArrayIterator ai = new ArrayIterator(test, 0, test.length);
        return ai;
    }

}
