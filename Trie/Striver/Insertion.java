
class TrieNode
{
    TrieNode children[];
    boolean isEnd;

    public TrieNode()
    {
        children=new TrieNode[26];
        isEnd=false;
    }

}

class Trie{

    TrieNode root;

    public Trie()
    {
        root=new TrieNode();
    }

    public void insert(String key )
    {
        TrieNode curr=root;

        for(char c:key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
        
    }

    public boolean search(String key)
    {
        TrieNode curr=root;

        for(char c: key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            return false;
            curr=curr.children[c-'a'];
        }

        return curr.isEnd;
    }


    public boolean isPrefix(String  key)
    {
        TrieNode curr=root;

        for(char c:key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            curr=curr.children[c-'a'];
        }

        return true;
    }

    public static void main(String args[])
    {
        // System.out.println("Heyy trie tutorials");

        Trie trie=new Trie();


        String[] arr
            = {"and", "ant", "do", "dad"};

            for(String str:arr)
            {
                trie.insert(str);
            }

System.out.println("Searching the words");

             String[] searchKeys = { "do", "gee", "bat","and","ant" };


             for(String str:searchKeys)
             {
                System.out.println(trie.search(str));
             }


             System.out.println("Prefix the words");


              String[] prefixKeys = { "d","ge", "ba", "do", "de" ,"and","ant","an"};

             for(String s: prefixKeys)
             {
                if(trie.isPrefix(s))
                {
                    System.out.println(s+ " :  prefix Found");
                }
                     else{

                    System.out.println(s+ " : prefix Not Found");

                }
             }



    }
}