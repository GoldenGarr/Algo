package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stack {
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
        new Stack().run();
    }

    public static void solve() throws IOException {
        int[] stack = new int[(int) Math.pow(10, 6)];
        int n = Integer.parseInt(br.readLine());
        int top = -1;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "-" -> out.println(stack[top--]);
                case "+" -> stack[++top] = Integer.parseInt(input[1]);
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("stack.in"));
            out = new PrintWriter("stack.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}