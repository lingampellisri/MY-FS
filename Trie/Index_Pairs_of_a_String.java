import java.util.*;

class TrieNode {
    TrieNode []children=new TrieNode[26];
    boolean isEnd;
    public TrieNode()
    {
        isEnd=false;

    }
}

class Trie{
    TrieNode root=new TrieNode();
    public void insert(String key)
    {
        TrieNode node=root;
        for(int i=0;i<key.length();i++)
        {
            char idx=key.charAt(i);
            if(node.children[idx-'a']==null)
                {
                    node.children[idx-'a']=new TrieNode();
                }
                node=node.children[idx-'a'];
        }

        node.isEnd=true;
    }


    public boolean search(String key)
    {
        TrieNode curr=root;

        for(int i=0;i<key.length();i++)
        {
            char idx=key.charAt(i);

            if(curr.children[idx-'a']==null)
            {
                // System.out.println("Not Found");
                return false;
            }
            curr=curr.children[idx-'a'];
        }

        return curr.isEnd;
    }

    public  ArrayList<ArrayList<Integer>> indexPair(String key)
    {
       
            int n=key.length();

            ArrayList<ArrayList<Integer>>ans=new ArrayList<>();

            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> res=new ArrayList<>();
                 TrieNode curr=root;
                for(int j=i;j<n;j++)
                {
                    int idx=key.charAt(j);

                    if(curr.children[idx-'a']==null)
                    {
                        break;
                    }
                    curr=curr.children[idx-'a'];

                    if(curr.isEnd)
                    {
                        res.add(i);
                        res.add(j);
                        ans.add(res);
                    }

                }
            }
            return ans;
    }




    public static void main(String args[])
    {
        Trie trie=new Trie();


           String[] arr
            = {"and", "ant", "do", "dad"};

          String text = "thestoryofleetcodeandme";
            String words[] = {"story","fleet","leetcode"};

            for(String s: words)
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

           
            System.out.println(trie.indexPair(text));





    }


}