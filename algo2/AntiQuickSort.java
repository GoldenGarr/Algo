package com.company.algo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AntiQuickSort {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        if (true) {
            System.out.println();
        } else {
            System.out.println();
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
        new AntiQuickSort().run();
    }

    public void solve() throws IOException {
        long m = System.currentTimeMillis();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        array = antiQuickSort(array);
        for (int elem :
                array) {
            out.print(elem + " ");
        }
        //System.out.println((double) (System.currentTimeMillis() - m) / 1000);
    }

    public void printArr(int[] array) {
        for (int elem :
                array) {
            System.out.print(elem + " ");
        }
        System.out.println();

    }

    //1 -> 1 2 -> 1 3 2 -> 1 4 3 2 -> 1 4 5 3 2 - > 1 4 6 5 3 2  -> 1 4 6 7 5 3 2 -> 1 4 6 8 7 5 3 2
    // -> 1 4 6 8 9 7 5 3 2 -> 1 4 6 8 10 9 7 5 3 2 -> 1 4 6 8 10 11 9 7 5 3 2

    public int[] antiQuickSort(int[] n) {
        if (n.length == 1) {
            return new int[]{1};
        }
        if (n.length == 2) {
            return new int[]{1, 2};
        }
        if (n.length == 3) {
            return new int[]{1, 3, 2};
        }
        if (n.length == 4) {
            return new int[]{1, 4, 3, 2};
        }
        int[] resultArray = new int[]{1, 4, 3, 2};
        int insertionIndex = 2;
        int counter = 1;
        for (int i = 5; i <= n.length; i++) {
            resultArray = insertElem(resultArray, insertionIndex, i);
            if (counter++ % 2 == 0) {
                insertionIndex++;
            }
        }
        return resultArray;
    }

    public int[] insertElem(int[] array, int insertionIndex, int insert) {
        int[] resultArray = new int[array.length + 1];
        for (int i = 0; i < insertionIndex; i++) {
            resultArray[i] = array[i];
        }
        resultArray[insertionIndex] = insert;
        for (int i = insertionIndex + 1; i < array.length + 1; i++) {
            resultArray[i] = array[i - 1];
        }
        return resultArray;
    }

    public void swapElements(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }


    public void run() {
        try {
            br = new BufferedReader(new FileReader("antiqs.in"));
            out = new PrintWriter("antiqs.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}