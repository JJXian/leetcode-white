package T208实现Trie前缀树;

import javax.swing.tree.TreeNode;

/**
 * @Author: jjxian
 */
public class Trie{
    private TrieNode root ;

    public Trie() {
        root = new TrieNode();
    }

//    向前缀树中加入字典
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

//    如果在前缀树中 就返回true 否则返回false
    public boolean search(String word) {
        TrieNode node =  searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }


//    辅助方法 查找前缀对应的节点
    public TrieNode searchPrefix(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.containsKey(c)){
                node = node.get(c);
            }else{
                return null;
            }
        }
        return node;
    }

}
class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}