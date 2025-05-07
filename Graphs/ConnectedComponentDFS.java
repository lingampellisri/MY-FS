
/*
Mr. Balu is interested in solving puzzles. 
One puzzle involves a given number of nodes and undirected paths between these nodes. 

He needs to determine whether he can exit from path loop or not. 
If at least one cycle can be formed with the given paths, then he cannot exit.

Input Format:
-------------
Line-1: Two integers n and e, n, number of nodes and e number of edges
Line-2 to e: e number of integer pairs, space separated

Output Format:
--------------
Line-1: A string, Cycle_found or No_Cycle_Found

Sample Input-1:
---------------
5 5
0 1
1 2
2 3
3 4
4 0

Sample Output-1:
----------------
Cycle_Found

Sample Input-2:
---------------
5 4
0 1
1 2
2 3
3 4

Sample Output-2:
----------------
No_Cycle_Found
 */

import java.util.*;

class ConnectedComponentsDFS
{
    static List<List<Integer>>adList=new LinkedList<>();

    public static void buildAdjacentList(int n,int edges[][])
    {
        for(int i=0;i<n;i++)
        adList.add(new ArrayList<>());

        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];

            adList.get(u).add(v);
             adList.get(v).add(u);
        }

    }

    public static void dfs(int start,boolean visited[], ArrayList<Integer> res)
    {
        visited[start]=true;

        // System.out.print(start+" ");
        res.add(start);

        for(int nbr:adList.get(start))
        {
            if(!visited[nbr])
            {
                dfs(nbr,visited,res);
            }
        }
    }

    public static int ConnectedComponent(int n,int edges[][],ArrayList<ArrayList<Integer>>connected)
    {
        buildAdjacentList(n,edges);

       

        int count=0;
        boolean visited[]=new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                 ArrayList<Integer> res=new ArrayList<>();
                dfs(i,visited,res);
                //   System.out.println();
                  connected.add(res);
                count++;
            }
        }
        return count;

    }

    public static  void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();

        ArrayList<ArrayList<Integer>>connected=new ArrayList<>();

        int edges[][]=new int[e][2];

        for(int i=0;i<e;i++)
        {
            for(int j=0;j<2;j++)
            {
                edges[i][j]=sc.nextInt();
            }
        }

        System.out.println( ConnectedComponent(n,edges,connected));

        System.out.println(connected);
    }


}