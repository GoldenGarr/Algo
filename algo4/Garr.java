package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Garr {
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
        new Garr().run();
    }

    public static void solve() throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        double h0 = Double.parseDouble(input[1]);
        double left = 0;
        double right = h0;
        double mid, prevPrev, prev, next;
        double res = Double.POSITIVE_INFINITY;
        boolean flag;
        while ((right - left) > 0.001 / (n - 1)) {
            mid = (left + right) / 2;
            prevPrev = h0;
            prev = mid;
            flag = prev > 0;
            for (int i = 3; i <= n; i++) {
                next = 2 * prev - prevPrev + 2;
                if (!(next >= 0)) {
                    flag = false;
                }
                prevPrev = prev;
                prev = next;
            }
            if (flag) {
                right = mid;
                res = Math.min(res, prev);
            } else
                left = mid;
        }
        out.printf("%.2f", res);
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("garland.in"));
            out = new PrintWriter("garland.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
