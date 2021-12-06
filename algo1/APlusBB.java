package com.company.algo1;

import com.company.algo1.Sorter;

import java.io.*;
import java.util.*;

public class APlusBB {
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
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long sum = a + b * b;
        out.println(sum);
    }

    public void run() {
        try {
            //Files

            br = new BufferedReader(new FileReader("aplusbb.txt"));
            out = new PrintWriter("aplusbbresult.txt");

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