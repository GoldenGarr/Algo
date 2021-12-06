package com.company.algo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class KOrderStatistic {
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
        new KOrderStatistic().run();
    }

    public void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int a1 = nextInt();
        int a2 = nextInt();
        int[] array = new int[n];

        arrayFill(array, n, a, b, c, a1, a2);
        modifiedQuickSort(array, 0, array.length - 1, k);

        out.println(array[k - 1]);
    }

    public void modifiedQuickSort(int[] array, int left, int right, int k) {
        Random rd = new Random();
        //int key = array[rd.nextInt(left + right) / 2];
        int key = array[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < key) {
                ++i;
            }
            while (key < array[j]) {
                --j;
            }
            if (i <= j) {
                swapElements(array, i++, j--);
            }
        }
        if (left < j && k - 1 <= j) {
            modifiedQuickSort(array, left, j, k);
        }
        if (i < right && k - 1 >= j) {
            modifiedQuickSort(array, ++j, right, k);
        }
    }

    public void swapElements(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    public void arrayFill(int[] array, int n, int a, int b, int c, int a1, int a2) {
        int i = 2;
        int prevPrevious = a1;
        int previous = a2;
        if (n >= 2) {
            array[0] = prevPrevious;
            array[1] = previous;
        } else {
            array[0] = prevPrevious;
        }
        int current;
        while (i < n) {
            current = a * prevPrevious + b * previous + c;
            array[i++] = current;
            prevPrevious = previous;
            previous = current;
        }
    }

    public void printArr(int[] array) {
        for (int elem :
                array) {
            System.out.print(elem + " ");
        }
        System.out.println();

    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("kth.in"));
            out = new PrintWriter("kth.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}