import java.util.*;

class ConnectedComponentsBFS
{
    public static ArrayList<ArrayList<Integer>> adList;

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