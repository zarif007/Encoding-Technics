import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class bfs {
    private int V, NMAX = 100000 + 5;
    private LinkedList<Integer> adj[];
    static int dist[] = new int[100000];

    bfs(int v){
        V = NMAX;
        adj = new LinkedList[v + 1];
        for (int i=0; i<=v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int u, int v){
        adj[v].add(u);
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];

        dist[s] = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0){
            s = queue.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    dist[n] = dist[s] + 1;
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edge = sc.nextInt();

        bfs g = new bfs(edge);

        for(int i=0; i<edge; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            g.addEdge(u, v);
        }

        int lina = sc.nextInt();

        g.BFS(lina);

        int nn = sc.nextInt();
        int nv[] = new int[nn];

        for(int i=0; i<nn; i++)
            nv[i] = sc.nextInt();

        int mn = 1000000000;
        for(int i=0; i<nn; i++){
            mn = Math.min(mn, dist[nv[i]]);
        }

        System.out.println(mn);
    }
}
