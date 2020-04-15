/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.util.*;

public class TrieSort {

    private Node rootNode;
    private int count;
    private String[] sortedArray;

    public TrieSort() {
        rootNode = null;
    }
    
    public String[] sort(String[] array) {
        sortedArray = new String[array.length];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            insert(array[i], i);
        }
        traversePreorder(array);
        return sortedArray;
    }

    // function to insert 
    // a string in trie 
    void insert(String key, int index) {
        // making a new path 
        // if not already 
        if (rootNode == null) {
            rootNode = new Node();
        }

        Node currentNode = rootNode;

        for (int i = 0; i < key.length(); i++) {
            char keyChar = key.charAt(i);

            if (currentNode.getChild(keyChar) == null) {
                currentNode.addChild(keyChar);
            }

            // go to next node 
            currentNode = currentNode.getChild(keyChar);
        }

        // Mark leaf (end of string) 
        // and store index of 'str' 
        // in index[] 
        currentNode.addIndex(index);
    }

    void traversePreorder(String[] array) {
        traversePreorder(rootNode, array);
    }

    // function for preorder 
    // traversal of trie 
    private void traversePreorder(Node node, String[] array) {
        if (node == null) {
            return;
        }

        if (node.getIndices().size() > 0) {
            for (int index : node.getIndices()) {
                sortedArray[count++] = array[index];
                // System.out.print(array[index] + " ");
            }
        }

        for (char index = 'a'; index <= 'z'; index++) {
            traversePreorder(node.getChild(index), array);
        }
    }

    private static class Node {

        private Node[] children;
        private List<Integer> indices;

        Node() {
            children = new Node[26];
            indices = new ArrayList<>(0);
        }

        Node getChild(char index) {
            if (index < 'a' || index > 'z') {
                return null;
            }

            return children[index - 'a'];
        }

        void addChild(char index) {
            if (index < 'a' || index > 'z') {
                return;
            }

            Node node = new Node();
            children[index - 'a'] = node;
        }

        List<Integer> getIndices() {
            return indices;
        }

        void addIndex(int index) {
            indices.add(index);
        }
    }
}
