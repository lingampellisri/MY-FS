import java.util.*;

class TrieNode
{
    TrieNode []children;
    boolean isEndOfWord;

   public  TrieNode(){

    children =new TrieNode[26];
    isEndOfWord=false;

    }
}

class Trie
{

    TrieNode root;
    int count;

    public Trie()
    {
        root=new TrieNode();
        count=0;
    }


    public void insert(String key)
    {
        TrieNode curr=root;

        for(char c:key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']=new TrieNode();
                count++;
            }
            curr=curr.children[c-'a'];
        }
        curr.isEndOfWord=true;
    }

   public int countValidSubStrings(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            insert(s.substring(i));

        }
        return count+1;
    }


    public static void main(String args[])
    {
        // System.out.println("Hello World");

        Trie trie=new Trie();

            String input = "ab";

           System.out.println( "Number of Distinct SubStrings is : "+trie.countValidSubStrings(input));


    }


}
