package search_shakespeare;


/**
 *
 * @author stanislavnovitski
 */
abstract class Trie<T> implements Iterable<Pair<Key, T>> {

    
    abstract Trie<T> add(Key key, T action);
    
    abstract T find(Key key);

    abstract Trie<T> locate(Key key);

}
