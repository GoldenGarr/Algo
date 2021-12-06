package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Queue {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static void main(String[] args) throws IOException {
        new Queue().run();
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int head = 0;
        int tail = 1;
        int[] queue = new int[(int) Math.pow(10, 6)];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "+" -> {
                    queue[tail - 1] = Integer.parseInt(input[1]);
                    if (tail++ == queue.length) {
                        tail = 0;

                    }
                }
                case "-" -> {
                    out.println(queue[head]);
                    if (head++ == queue.length) {
                        head = 0;
                    }
                }
            }
            //printQueue(queue);
        }
    }

    public static void printQueue(int[] queue) {
        for (int i = 0; i < 3; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("queue.in"));
            out = new PrintWriter("queue.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
