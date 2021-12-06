package com.company.algo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeapSort {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    static int counter = 1;
    static int size;

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
        new HeapSort().run();
    }

    public static void solve() throws IOException {
        int n = nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        arrayToHeap(array);
        System.out.println(Arrays.toString(array));

        int size = array.length;
        for (int i = array.length / 2 + 2; i >= 1; i--) {
                swap(array, array[i], array[0]);
                maxHeapify(array, --size, 1);
        }

    }

    public static void arrayToHeap(int[] array) {
        for (int i = array.length / 2 + 2; i >= 0; i--) {
            maxHeapify(array, array.length, i + 1);
        }
    }


    public static void maxHeapify(int[] array, int size, int index) {
        int left = index * 2 - 1;
        int right = (index * 2 + 1) - 1;
        int mx = index - 1;

        if (mx < array.length && left < array.length && array[mx] < array[left]) {
            mx = left;
        }

        if (mx < array.length && right < array.length && array[mx] < array[right]) {
            mx = right;
        }

        if (mx != index - 1) {
            swap(array, index - 1, mx);
            //   System.out.println(Arrays.toString(array));
            maxHeapify(array, size, mx + 1);
        }
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
