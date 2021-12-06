package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PolishCow {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    static class Stack {

        String[] stack;
        int top;

        public Stack() {
            stack = new String[(int) Math.pow(10, 6)];
            top = -1;
        }

        public String watchTop() {
            return stack[top];
        }

        public String takeOut() {
            return stack[top--];
        }

        public void put(String str) {
            stack[++top] = str;
        }

        public String[] getStack() {
            return stack;
        }

        public int getTop() {
            return top;
        }
    }

    public static void main(String[] args) throws IOException {
        new PolishCow().run();
    }

    public static void solve() throws IOException {
        String[] input = br.readLine().split(" ");
        Stack stack = new Stack();
        int tmp;
        String res;
        for (String element : input
        ) {
            switch (element) {
                case "+" -> {
                    tmp = Integer.parseInt(stack.watchTop()) + Integer.parseInt(stack.stack[stack.getTop() - 1]);
                    res = String.valueOf(tmp);
                    stack.takeOut();
                    stack.takeOut();
                    stack.put(res);
                }
                case "-" -> {
                    tmp = -Integer.parseInt(stack.watchTop()) + Integer.parseInt(stack.stack[stack.getTop() - 1]);
                    res = String.valueOf(tmp);
                    stack.takeOut();
                    stack.takeOut();
                    stack.put(res);
                }
                case "*" -> {
                    tmp = Integer.parseInt(stack.watchTop()) * Integer.parseInt(stack.stack[stack.getTop() - 1]);
                    res = String.valueOf(tmp);
                    stack.takeOut();
                    stack.takeOut();
                    stack.put(res);
                }
                default -> stack.put(element);
            }
        }
        out.println(stack.takeOut());
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("postfix.in"));
            out = new PrintWriter("postfix.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
