package main;

import java.util.LinkedList;
import java.util.Queue;

public class Spfa {
    public Spfa() {

    }

    public void spfa(int s, int n, int a[][]) {   //一共n个点，源点是s, 0<s<n-1, a[n][n]是邻接矩阵
        int[] dis = new int[n]; //源点到每个点的距离，初始化
        int[] vis = new int[n]; //每个点是否已经加入队列
        Queue<Integer> q = new LinkedList<Integer>(); //推算队列
        int[] path = new int[n]; //记录路径的元素
        for (int i = 0; i < n; i++)
            dis[i] = 99999999;

        dis[s] = 0;
        vis[s] = 1;
        int i = 0, v = 0;
        path[0] = -1;
        q.add(s);

        while (!q.isEmpty()) {
            v = q.remove();  //队列下一个头部的点
            vis[v] = 0;
            for (i = 0; i < n; i++)//对于每一个点，计算从v到每个点的松弛
            {
                if (a[v][i] > 0 && dis[i] > dis[v] + a[v][i]) // 松弛条件 - 三角不等式
                {
                    dis[i] = dis[v] + a[v][i];  //更新dis【i】源点到i点的距离
                    path[i] = v;
                    if (vis[i] == 0) {
                        q.add(i);
                        vis[i] = 1;
                    }
                }
            }
        }

        for (int pathi = 0; pathi < n; pathi++) {
            printPath(pathi, path);
            System.out.println("");
        }

        System.out.println("shortest Distance from 0 to n is :");
        for (int disi = 0; disi < n; disi++) {
            System.out.print(dis[disi] + " ");
        }
    }

    public void printPath(int k, int path[]) {
        if (path[k] != -1) printPath(path[k], path);
        System.out.print(k + " ");
    }

    public static void main(String[] args) {
        int s = 0;
        int n = 10;
        int a[][] = new int[10][10];
        Spfa sp = new Spfa();

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
        sp.spfa(s, n, a);
    }
}
