import java.util.*;

public class Prims{
    static int findMSTCost(int[][] graph,int numNodes){
        StringBuilder mst = new StringBuilder();
        boolean[] visited = new boolean[numNodes];
        int[] minEdgeWeight = new int[numNodes];
        Arrays.fill(minEdgeWeight,Integer.MAX_VALUE);

        minEdgeWeight[2] = 0;
        int cost = 0;

        for(int i=0;i<numNodes;i++){
            int curr = -1;

            for(int j=0;j<numNodes;j++){
                if(!visited[j] && (curr == -1 || minEdgeWeight[j] < minEdgeWeight[curr])){
                    curr = j;
                }
            }

            if(i < numNodes-1){
                System.out.print(curr + " - ");
            }
            else{
                System.out.print(curr);
            }
            visited[curr] = true;
            cost += minEdgeWeight[curr];

            for(int neb = 0;neb<numNodes;neb++){
                if(!visited[neb] && graph[curr][neb] != 0 && graph[curr][neb] < minEdgeWeight[neb]){
                    minEdgeWeight[neb] = graph[curr][neb];
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int graph[][] = {
             { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        int numNodes = graph.length;
        int minCost = findMSTCost(graph,numNodes);
        System.out.println();
        System.out.println(minCost);
    }
}