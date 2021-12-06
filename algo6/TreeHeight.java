package com.company.algo6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TreeHeight {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;
    static int height = 0;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static void main(String[] args) throws IOException {
        new TreeHeight().run();
    }

    public static void treeDiving(int[][] tree, int index, int current_height) {
        height = Math.max(height, current_height);

        if (tree[index - 1][1] != 0) {
            treeDiving(tree, tree[index - 1][1], current_height + 1);
        }

        if (tree[index - 1][2] != 0) {
            treeDiving(tree, tree[index - 1][2], current_height + 1);
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            out.println(0);
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
        treeDiving(tree, 1, 1);
        out.println(height);
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("height.in"));
            out = new PrintWriter("height.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
