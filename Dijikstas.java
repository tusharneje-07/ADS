import java.util.*;

public class Dijikstas{
    static int[] solveDijikstras(int[][] graph,int src, int num){
        int shortDistance[] = new int[num];
        boolean[] visited = new boolean[num];
        Arrays.fill(shortDistance, Integer.MAX_VALUE);
        shortDistance[src] = 0;

        for(int i=0;i<num;i++){
            int curr = -1;

            for(int j=0;j<num;j++){
                if(!visited[j] && (curr == -1 || shortDistance[j] < shortDistance[curr])){
                    curr = j;
                }
            }
            visited[curr] = true;
            System.out.println("Visited Node : " + curr);

            for(int neb=0;neb<num;neb++){
                if(!visited[neb] && graph[curr][neb] != 0 && shortDistance[curr] + graph[curr][neb] < shortDistance[neb]){
                    shortDistance[neb] = shortDistance[curr] + graph[curr][neb];
                }
            }
        }
        return shortDistance;
    }

    public static void main(String[] args) {
        int graph[][] = {
            {0,2,5,2,0,0},
            {2,0,6,0,0,4},
            {5,6,0,3,0,8},
            {2,0,3,0,1,0},
            {0,0,2,1,0,0},
            {0,4,8,0,0,0},
        };

        int[] shortDIstance = solveDijikstras(graph, 0, graph.length);
        for(int i=0;i<graph.length;i++){
            System.out.println("0 to "+i+" : "+shortDIstance[i]);
        }
    }
}