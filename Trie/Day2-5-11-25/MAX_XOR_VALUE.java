
class TrieNode
{
    TrieNode []children;

   public  TrieNode(){

    children =new TrieNode[2];
   
    }
}
public class MAX_XOR_VALUE {

    TrieNode root;

   public MAX_XOR_VALUE()
    {
        root=new TrieNode();

    }

    public void insert(int num)
    {
        TrieNode curr=root;

        for(int i=31;i>=0;i--)
        {
            int bit=((num>>i) & 1);
            if(curr.children[bit]==null)
            {
                curr.children[bit]=new TrieNode();
            }

            curr=curr.children[bit];

        }
    }

    public int find_max(int num)
    {
        TrieNode curr=root;
        int max=0;

        for(int i=31;i>=0;i--)
        {
            int bit=((num>>i) & 1);
            if(curr.children[1-bit]!=null)
            {
                max=(max | (1<<i));
                curr=curr.children[1-bit];
            }
            else
             curr=curr.children[bit];
        }
        return max;
    }

    public static void main(String[] args) {

        MAX_XOR_VALUE m=new MAX_XOR_VALUE();

        // System.out.println("Hello");

       int [] nums = {14,70,53,83,49,91,36,80,92,51,66,70};

       for(int num:nums)
       m.insert(num);

            int max=0;

            for(int num:nums)
            {
                max=Math.max(max,m.find_max(num));
            }

            System.out.println("Max Xor value is :"+ max);

    }
    
}
