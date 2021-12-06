package com.company.algo1;


import java.io.*;
import java.util.*;

public class Sortland {
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
        int n = Integer.parseInt(br.readLine());
        float[] array = new float[n];
        float[] values = new float[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Float.parseFloat(input[i]);
            values[i] = Float.parseFloat(input[i]);

        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (array[i] > array[j]) {
                    float temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        float min = array[0];
        float mid = array[array.length / 2];
        float max = array[array.length - 1];

        int minIndex = 0;
        int midIndex = 0;
        int maxIndex = 1;
        for (int i = 0; i < n; i++) {
            if (values[i] == min) {
                minIndex = i + 1;
            } else if (values[i] == mid) {
                midIndex = i + 1;
            } else if (values[i] == max) {
                maxIndex = i + 1;
            }
        }
        out.print(minIndex + " " + midIndex + " " + maxIndex);
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