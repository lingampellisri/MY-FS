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

    public Trie()
    {
        root=new TrieNode();

    }

    public void insert(String key)
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
        curr.isEndOfWord=true;
    }

    public boolean search(String key)
    {
        TrieNode curr=root;

        for(char c:key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            return false;

            curr=curr.children[c-'a'];
        }

        return curr.isEndOfWord;

    }


    public boolean prefix(String key)
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
        Trie trie=new Trie();

        String[] arr
            = {"and", "ant", "do", "dad"};

            for(String s: arr)
            {
                trie.insert(s);

            }

             String[] searchKeys = { "do", "gee", "bat","and","ant" };

             for(String s: searchKeys)
             {
                if(trie.search(s))
                {
                    System.out.println(s+ " : Found");
                }
                else{

                    System.out.println(s+ " : Not Found");

                }
             }

             String[] prefixKeys = { "ge", "ba", "do", "de" ,"and","ant"};

             for(String s: prefixKeys)
             {
                if(trie.prefix(s))
                {
                    System.out.println(s+ " :  prefix Found");
                }
                     else{

                    System.out.println(s+ " : prefix Not Found");

                }
             }
    }
}