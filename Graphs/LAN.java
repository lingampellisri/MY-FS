import java.util.*;

class DisjointSet{
    public static int parent[];
    public static int rank[];
    public int n;

    public DisjointSet(int n)
    {
        this.n=n;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
    }

    public int findUParent(int node)
    {
        if(node ==parent[node])
        return node;

        return parent[node]=findUParent(parent[node]);
    }


    public boolean unionByRank(int u,int v)
    {
        int pu=findUParent(u);
        int pv=findUParent(v);

        if(pu==pv)
        {
            return true;
        }

       if(rank[pu]==rank[pv])
       {
        parent[pv]=pu;
        rank[pu]++;
       }
       else if(rank[pv]<rank[pu])
       {
        parent[pv]=pu;
       }
       else{
        parent[pu]=pv;
       }

       return false;
    }

}

class LAN{
     static int u,v;
    public static void main(String args[])
    {
       
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        DisjointSet ds=new DisjointSet(n);
        boolean ans=false;
        for(int i=0;i<n;i++)
        {
            int source=sc.nextInt();
            int destination=sc.nextInt();

            ans=ds.unionByRank(source,destination);
            if(ans)
            {
                u=source;
                v=destination;
            }

        }

        System.out.println(Arrays.toString(new int[] { u, v }));
    }
}