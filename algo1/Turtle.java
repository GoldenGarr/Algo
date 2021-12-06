package com.company.algo1;


import java.io.*;
import java.util.*;

public class Turtle {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new Turtle().run();
    }

    public void solve() throws IOException {
        String[] sizesInput = br.readLine().split(" ");
        int h = Integer.parseInt(sizesInput[0]);
        int w = Integer.parseInt(sizesInput[1]);
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] input = br.readLine().split(" ");
            for (int k = 0; k < w; k++) {
                matrix[i][k] = Integer.parseInt(input[k]);
            }
        }
        for (int i = 1; i < w; i++) {
            matrix[h - 1][i] += matrix[h - 1][i - 1];
        }
        for (int i = h - 2; i >= 0; i--) {
            matrix[i][0] += matrix[i + 1][0];
        }
        //printM(matrix);
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 1; j < w; j++) {
                matrix[i][j] += Math.max(matrix[i + 1][j], matrix[i][j - 1]);
            }
        }
        out.print(matrix[0][w - 1]);
    }

    public void printM(int[][] mtrx) {
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[0].length; j++) {
                System.out.print(mtrx[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void run() {
        try {
            //Files

            br = new BufferedReader(new FileReader("aplusb.txt"));
            out = new PrintWriter("aplusbresult.txt");

            /* br = new BufferedReader(new FileReader("aplusb.in"));
            out = new PrintWriter("aplusb.out");*/

            //Console

            //br = new BufferedReader(new InputStreamReader(System.in));
            //out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
