package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BracketsSequence {
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
        new BracketsSequence().run();
    }

    public static void solve() throws IOException {
        int counter = 0;
        String[] input = new String[500];
        String line = br.readLine();
        while (line != null) {
            input[counter++] = line;
            line = br.readLine();
        }

        for (int i = 0; i < counter; i++) {
            Stack stack = new Stack();
            isSequenceCorrect(input[i].split(""), stack);
        }
    }

    public static void isSequenceCorrect(String[] brackets, Stack stack) {
        for (String brkt : brackets) {
            switch (brkt) {
                case "(" -> stack.put("(");
                case "[" -> stack.put("[");
                case ")" -> {
                    if (stack.top == -1) {
                        out.println("NO");
                        return;
                    }
                    if (!stack.watchTop().equals("(")) {
                        out.println("NO");
                        return;
                    } else {
                        stack.takeOut();
                    }
                }
                case "]" -> {
                    if (stack.top == -1) {
                        out.println("NO");
                        return;
                    }
                    if (!stack.watchTop().equals("[")) {
                        out.println("NO");
                        return;
                    } else {
                        stack.takeOut();
                    }
                }
            }
        }
        if (stack.getTop() == -1) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("brackets.in"));
            out = new PrintWriter("brackets.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
