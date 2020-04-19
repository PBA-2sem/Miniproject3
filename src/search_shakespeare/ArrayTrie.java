package search_shakespeare;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import utilities.ArrayIterator;

/**
 *
 * @author stanislavnovitski
 */
public class ArrayTrie<T> extends Trie<T> {

    Trie[] tries;

    public ArrayTrie(Key key) {
        this.tries = (Trie[]) Array.newInstance(null, key.getMax() + 1);
    }

    public ArrayTrie(Key key, T action) {
        this.tries = (Trie[]) Array.newInstance(null, key.getMax() + 1);
        tries[key.getIndex()] = new KeyTrie(key.getNext(), action);
    }

    @Override
    Trie<T> add(Key key, T action) {
        Trie t = tries[key.getIndex()];
        if (t == null) {
            tries[key.getIndex()] = new KeyTrie(key.getNext(), action);
        } else {
            tries[key.getIndex()] = t.add(key.getNext(), action);
        }
        return this;
    }

    @Override
    T find(Key key) {
        if (tries[key.getIndex()] != null) {
            return (T) tries[key.getIndex()].find(key.getNext());
        }
        return null;
    }

    @Override
    Trie<T> locate(Key key) {
        if (key.getLength() == 0) {
            return this;
        } else {
            return tries[key.getIndex()].locate(key.getNext());
        }
    }

    @Override
    public Iterator<Pair<Key, T>> iterator() {
        // remove possible null values
        Trie[] withoutNullArray = Arrays.stream(this.tries).filter(Objects::nonNull).toArray(Trie[]::new);
        return new ArrayIterator(withoutNullArray, 0, withoutNullArray.length);
    }

}
