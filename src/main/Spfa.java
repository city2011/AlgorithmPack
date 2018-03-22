package main;

import java.util.LinkedList;
import java.util.Queue;

public class Spfa {
    public Spfa() {

    }

    public static void spfa(int s, int n, int a[][]) {   //一共n个点，源点是s, 0<s<n-1, a[n][n]是邻接矩阵
        int[] dis = new int[n]; //源点到每个点的距离，初始化
        int[] vis = new int[n]; //每个点是否已经加入队列
        Queue<Integer> q = new LinkedList<Integer>(); //推算队列
        String[] path = new String[n]; //记录路径的元素
        for (int i = 0; i < n; i++)
            dis[i] = 99999999;

        dis[s] = 0;
        vis[s] = 1;
        int i = 0, v = 0;
        path[0] = s + "";
        q.add(s);

        while (!q.isEmpty()) {
            v = q.remove();  //队列下一个头部的点
            vis[v] = 0;
            for (i = 0; i < n; i++)//对于每一个点，计算从v到每个点的松弛
            {
                if (a[v][i] > 0 && dis[i] > dis[v] + a[v][i]) // 松弛条件 - 三角不等式
                {
                    dis[i] = dis[v] + a[v][i];  //更新dis【i】源点到i点的距离
                    path[i] = path[i - 1] + i;
                    if (vis[i] == 0) {
                        q.add(i);
                        vis[i] = 1;
                    }
                }
            }
        }

        for (int end = 0; end < n; end++) {
            System.out.println(path[end]);
        }

    }

    public static void main(String[] args) {
        int s = 0;
        int n = 10;
        int a[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++) {
                a[i][j] = j + i;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
        spfa(s, n, a);
    }
}
