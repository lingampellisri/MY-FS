
/**
 * 
 * ✅ Sample Input and Output
Input:
Copy
Edit
6 4
0 1
1 2
3 4
4 5
Output:
lua
Copy
Edit
Count of Connected Components : 2
Connected Components: [[0, 1, 2], [3, 4, 5]]

 */

package Labs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountConnectedCom {

static List<List<Integer>> Adjacency = new ArrayList<>();

public static  void buildAdjacentList(int n, int edges[][]) {

    for (int i = 0; i < n; i++) {
        Adjacency.add(new ArrayList<>());
    }

    for (int edge[] : edges) {
        int u = edge[0];
        int v = edge[1];

        Adjacency.get(u).add(v);
        Adjacency.get(v).add(u);
    }
}

public static void ConnectedComponent(int n, int edges[][], ArrayList<ArrayList<Integer>> connected) {
    buildAdjacentList(n, edges);

    int count=0;
    boolean visited[] = new boolean[n];

    for(int i=0;i<n;i++)
    {
        if(!visited[i])
        {
            ArrayList<Integer> res = new ArrayList<>();
            dfs(i, visited, res);
            connected.add(res);
            count++;
        }
    }

    System.out.println("Count of Connected Components : "+count);

}

public static void dfs(int start,boolean visited[],ArrayList<Integer>res)
{
    visited[start]=true;
    res.add(start);

    for(int nbr :Adjacency.get(start)  )
    {
        if(!visited[nbr])
        {
            dfs(nbr,visited,res);
        }

    }
  

}


    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
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

    ConnectedComponent(n, edges, connected);

    System.out.println(connected);



        
    }
    
}
