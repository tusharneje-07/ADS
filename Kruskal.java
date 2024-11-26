import java.util.*;

public class Kruskal{
    static class Edge implements Comparable<Edge>{
        int src,des,wgt;
        Edge(int src,int des,int wgt){
            this.src = src;
            this.des = des;
            this.wgt = wgt;
        }

        public int compareTo(Edge other){
            return this.wgt - other.wgt;
        }
    }

    static class UnionFind{
        int[] parent,rank;

        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                rank[i] = 0;
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x,int y){
            int rx = find(x);
            int ry = find(y);

            if(rx==ry){
                return false;
            }
            if(rank[rx] > rank[ry]){
                parent[ry] = rx;
            }
            else if(rank[ry] > rank[rx]){
                parent[rx] = ry;
            }
            else{
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
    }

    static int findMST(int v,List<Edge> edges){
        Collections.sort(edges);

        int cost = 0;
        int count = 0;
        UnionFind uf = new UnionFind(v);

        for(Edge edge:edges){
            if(uf.union(edge.src, edge.des)){
                cost += edge.wgt;
                count++;
                if(count == (v-1)){
                    break;
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        System.out.println(findMST(5, edges));
    }
}