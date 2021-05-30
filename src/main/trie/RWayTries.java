package main.trie;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTries<T> implements Trie<T> {

    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        Object value;
        Node[] next = new Node[R];
    }

    @Override
    public void put(String word, T value) {
        root = put(root, word, 0, value);
    }

    private Node put(Node node, String word, int d, T value) {

        if(node==null){
            node = new Node();
        }

        if(d==word.length()){
            node.value=value;
            return node;
        }
        char c = word.charAt(d);
        node.next[c] = put(node.next[c],word,d+1,value);
        return node;
    }

    @Override
    public T get(String word) {
        Node node = get(root, word, 0);
        if(node==null){
            return null;
        }
        return (T) node.value;
    }

    private Node get(Node node, String word, int d) {

        if(node==null){
            return null;
        }
        if(d==word.length()){
            return node;
        }

        char c = word.charAt(d);
        return get(node.next[c],word,d+1);
    }

    @Override
    public boolean delete(String word) {
        Node node = get(root, word,0);
        if(node==null || node.value==null){
            return false;
        }

        node.value=null;
        return true;
    }

    @Override
    public boolean containsWord(String word) {
        return null!=get(word);
    }

    @Override
    public boolean containsPrefix(String prefix) {
        Node node  = get(root,prefix,0);
        return node!=null;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> keys = new LinkedList<>();
        collect(root,"",keys);
        return keys;
    }



    private void collect(Node node, String prefix, Queue<String> keys) {
        if(node==null){
            return ;
        }

        if(node.value!=null){
            keys.add(prefix);
        }

        for(char c=0; c<R;c++){
            collect(node.next[c],prefix+c,keys);
        }
    }


    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> keys = new LinkedList<>();
        Node node = get(root,prefix,0);
        collect(node,prefix,keys);
        return keys;
    }

    @Override
    public String longestPrefixOf(String word) {
        int length = search(root, word, 0,0);
        return word.substring(0,length);
    }

    private int search(Node node, String word, int d, int length) {
        if(node==null){
            return length;
        }
        if(node.value!=null){
            length = d;
        }

        if(d==word.length()){
            return length;
        }
        char c = word.charAt(d);
        return search(node.next[c],word,d+1,length);

    }


}
