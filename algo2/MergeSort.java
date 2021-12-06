package com.company.algo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MergeSort {
    static int inversions = 0;

    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new MergeSort().run();
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        mergeSort(array);
        for (int elem :
                array) {
            out.print(elem + " ");
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        } else {
            int border = array.length / 2;
            int[] left = new int[border];
            int[] right = new int[array.length - border];
            for (int i = 0; i < border; i++) {
                left[i] = array[i];
            }
            for (int i = border; i < array.length; i++) {
                right[i - border] = array[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public static void merge(int[] origin, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int m = left.length;
        int k = right.length;
        int originIndex = 0;
        while (i < m && j < k) {
            if (left[i] > right[j]) {
                origin[originIndex++] = right[j++];
            } else {
                origin[originIndex++] = left[i++];
            }
        }
        if (i == m) {
            while (j < k) {
                origin[originIndex++] = right[j++];
            }
        } else {
            while (i < m) {
                origin[originIndex++] = left[i++];
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("sort.in"));
            out = new PrintWriter("sort.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
