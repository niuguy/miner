/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

// Version1 use Array
class TrieNode {

    public TrieNode[] children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i)
            children[i] = null;
        hasWord = false;
    }
}


public class WordDictionary {
    private TrieNode root;
 
    public WordDictionary(){
        root = new TrieNode();
    }
 
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.hasWord = true;
    }
    
    boolean find(String word, int index, TrieNode now) {
        if(index == word.length()) {
            return now.hasWord;
        }
        
        Character c = word.charAt(index);
        if (c == '.') {
            for(int i = 0; i < 26; ++i) 
            if (now.children[i] != null) {
                if (find(word, index+1, now.children[i]))
                    return true;
            }
            return false;
        } else if (now.children[c - 'a'] != null) {
            return find(word, index+1, now.children[c - 'a']);  
        } else {
            return false;
        }
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");



// Version 2 use HashMap
class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
    }
}


public class WordDictionary {
    private TrieNode root;
 
    public WordDictionary(){
        root = new TrieNode();
    }
 
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }
    
    boolean find(String word, int index, TrieNode now) {
        if(index == word.length()){
            if(now.children.size()==0) 
                return true; 
            else
                return false;
        }
        
        Character c = word.charAt(index);
        if (now.children.containsKey(c)) {
            if(index == word.length()-1 && now.children.get(c).hasWord){
                return true;
            }
            return find(word, index+1, now.children.get(c)) ;  
        }else if(c == '.'){
            boolean result = false;
            for(Map.Entry<Character, TrieNode> child: now.children.entrySet()){
                if(index == word.length()-1 && child.getValue().hasWord){
                    return true;
                } 
 
                //if any path is true, set result to be true; 
                if(find(word, index+1, child.getValue()) ){
                    result = true;
                }
            }
 
            return result;
        }else{
            return false;
        }
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
