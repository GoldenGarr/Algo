package com.company.algo1;


import java.io.*;
import java.util.*;

public class Sorter {
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
        new Sorter().run();
    }

    public void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        out.println(n);
        int[] array = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(array[i] + " ");
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