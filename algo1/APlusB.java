package com.company.algo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class APlusB {
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
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int sum = a + b;
        out.println(sum);
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