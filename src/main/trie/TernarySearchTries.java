package main.trie;

import java.util.LinkedList;
import java.util.Queue;

public class TernarySearchTries<T> implements  Trie<T> {

    private Node root;

    private static class Node{
        char c;
        Object value;
        Node left, mid, right;
    }


    @Override
    public void put(String word, T value) {
        root = put(root, word, 0, value);
    }

    private Node put(Node node, String word, int d, T value) {
        char c = word.charAt(d);

        if(node==null){
            node = new Node();
            node.c = c;
        }

        if(c<node.c){
            node.left = put(node.left,word,d,value);
        }else if(c>node.c){
            node.right = put(node.right,word,d,value);
        }else{

            if(d<word.length()-1){
                node.mid = put(node.mid,word,d+1,value);
            }else{
                node.value=value;
            }
        }

        return node;
    }

    @Override
    public T get(String word) {
        Node node = get(root,word,0);
        if(node==null){
            return null;
        }

        return (T) node.value;
    }

    private Node get(Node node, String word, int d) {
        if(node==null){
            return null;
        }

        char c =word.charAt(d);

        if(c<node.c){
            return get(node.left,word,d);
        }else if(c>node.c){
            return get(node.right,word,d);
        }else{

            if(d<word.length()-1){
                return get(node.mid,word,d+1);
            }else{
                return node;
            }
        }
    }

    @Override
    public boolean delete(String word) {
        Node node = get(root,word,0);
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
            return;
        }

        if(node.left!=null){
            collect(node.left,prefix,keys);
        }

        if(node.value!=null){
            keys.add(prefix+node.c);
        }

        if(node.mid!=null){
            collect(node.mid, prefix+node.c, keys);
        }

        if(node.right!=null){
            collect(node.right, prefix, keys);
        }


    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> keys = new LinkedList<>();
        Node node = get(root,prefix,0);
        collect(node.mid,prefix,keys);
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

        char c = word.charAt(d);
        if(c<node.c){
            return search(node.left,word,d,length);
        }else if(c>node.c){
            return  search(node.right,word,d,length);
        }else{

            if(node.value!=null){
                length=d+1;
            }

            if(d==word.length()-1){
                return length;
            }else{
                return search(node.mid,word,d+1,length);
            }
        }
    }

}
