/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.io.IOException;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.FileUtility;

/**
 *
 * @author stanislavnovitski
 */
public class SortingTests {

    static String[] words = null;

    public SortingTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            // Retrieving and sanitizing data
            words = FileUtility.toStringArray("src/shakespeare_project/data.txt", "[^a-zA-Z]");
            System.out.println("WORDCOUNT :" + words.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testTrieSort() {
        String[] wordsCopy = words.clone();
        TrieSort ts = new TrieSort();
        long before = System.currentTimeMillis();
        String[] wordsSorted = ts.sort(wordsCopy);
        long after = System.currentTimeMillis();
        System.out.println("TRIESORT execution time: " + (after - before) + " ms");
//        System.out.println("TRIESORT execution time: " + (after - before) + " ms ** OBS! ONLY 20k of (930k) elements");
        assertTrue(this.isSorted(wordsSorted));
    }

    private boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
