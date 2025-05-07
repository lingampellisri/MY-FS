import java.util.*;

class ConnectedComponentsBFS
{
    public static ArrayList<ArrayList<Integer>> adList;



        public static void buildAdjList(int n,int [][]edges)
        {
            adList=new ArrayList<>();

            for(int i=0;i<n;i++)
            adList.add(new ArrayList<>());

            for(int []edge: edges)
            {
                int u=edge[0];
                int v=edge[1];

                adList.get(u).add(v);
                adList.get(v).add(u);

            }
        }


        public static void bfs(int start,boolean[]visited)
        {
            Queue<Integer>q=new LinkedList<>();

            q.offer(start);

            visited[start]=true;


            while(!q.isEmpty())
            {
                int node=q.poll();
            


                for(int nbr:adList.get(node))
                {
                    if(!visited[nbr])
                    {
                        q.offer(nbr);
                        visited[nbr]=true;
                    }
                }
            }

        }



    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();

        int [][]edges=new int[e][2];

        for(int i=0;i<e;i++)
        {
            for(int j=0;j<2;j++)
            {
                edges[i][j]=sc.nextInt();

            }
        }
    }
}