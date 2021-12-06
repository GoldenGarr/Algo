package com.company.algo6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IsBSTree {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;
    static int current_element = (int) Double.NEGATIVE_INFINITY;
    static boolean result = true;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static void main(String[] args) throws IOException {
        new SimpleBinarySearchTree().run();
    }

     static void treeCheck(int[][] tree, int index) {
        if (tree[index - 1][1] != 0){
            treeCheck(tree, tree[index - 1][1]);
        }

        int temp = current_element;
        current_element = tree[index - 1][0];
        if (temp >= current_element){
            result = false;
        }

        if (tree[index - 1][2] != 0){
            treeCheck(tree, tree[index - 1][2]);
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            out.println("YES");
            return;
        }
        String[] input;
        int[][] tree = new int[n][3];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            tree[i][0] = Integer.parseInt(input[0]);
            tree[i][1] = Integer.parseInt(input[1]);
            tree[i][2] = Integer.parseInt(input[2]);
        }
        treeCheck(tree, 1);
        if (result)
            out.println("YES");
        else
            out.println("NO");
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("check.in"));
            out = new PrintWriter("check.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
