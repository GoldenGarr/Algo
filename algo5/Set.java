package com.company.algo5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Set {
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
        new Set().run();
    }


    public static void insert(int element) {

    }


    public static void solve() throws IOException {
        String input;
        int length = 5381;
        ArrayList<ArrayList<Integer>> hashSet = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            hashSet.add(new ArrayList<Integer>());
        }

        while ((input = br.readLine()) != null) {
            //System.out.println(hashSet);
            int digit = Integer.parseInt(input.split(" ")[1]);
            int index = Math.abs(digit % (length));

            switch (input.split(" ")[0]) {
                case "insert":
                    if (!hashSet.get(index).contains(digit)) {
                        hashSet.get(index).add(digit);
                    }
                    break;
                case "delete":
                    for (int i = 0; i < hashSet.get(index).size(); i++) {
                        if (hashSet.get(index).get(i) == digit) {
                            hashSet.get(index).remove(i);
                            break;
                        }
                    }
                    break;
                case "exists":
                    if (hashSet.get(index).contains(digit)) {
                        out.println(true);
                    } else {
                        out.println(false);
                    }
                    break;
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("set.in"));
            out = new PrintWriter("set.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
