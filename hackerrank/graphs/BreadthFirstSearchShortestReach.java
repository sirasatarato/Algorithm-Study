package hackerrank.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s) {
        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>(adj.size());

        for (int i = 0; i < adj.size(); i++) {
            result.add(0);
        }

        q.addFirst(s);

        while (q.size() > 0) {
            int current = q.pollLast();
            ArrayList<Integer> tmp = adj.get(current);

            for (int v : tmp) {
                if (result.get(v) == 0) {
                    q.addFirst(v);
                    result.set(v, result.get(current) + 6);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){

            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;

                ArrayList<Integer> tmp = adj.get(u);
                tmp.add(v);
                adj.set(u, tmp);

                tmp = adj.get(v);
                tmp.add(u);
                adj.set(v, tmp);
            }

            int s = in.nextInt() - 1;

            ArrayList<Integer> result = BreadthFirstSearchShortestReach.bfs(adj, s);

            for (int i = 0; i < n; i++) {
                if (i != s) {
                    if (result.get(i) == 0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(result.get(i) + " ");
                    }
                }
            }

            System.out.print("\n");
        }

        in.close();
    }
}