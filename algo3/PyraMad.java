package com.company.algo3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PyraMad {
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
        new PyraMad().run();
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        printArr(array);
        arrayToHeap(array);
        printArr(array);
    }

    public static void heapSort() {

    }
    
    public static void arrayToHeap(int[] array){
        for (int i = array.length / 2; i >= 1; i--) {
            heapify(array, i);
        }
    }

    public static void heapify(int[] array, int index) {
        int n = array.length;
        int leftIndex = 2 * index - 1;
        int rightIndex = (2 * index + 1) - 1;
        int largestIndex = index - 1;
        if (leftIndex >= n && rightIndex < n){
            if (array[rightIndex] > array[index - 1]) {
//                int temp = array[rightIndex];
//                array[rightIndex] = array[index - 1];
//                array[index - 1] = temp;
                swap(array, rightIndex, index - 1);
                heapify(array, rightIndex + 1);
            }
            return;
        } else if (leftIndex < n && rightIndex >= n){
            if (array[leftIndex] > array[index - 1]) {
//                int temp = array[leftIndex];
//                array[leftIndex] = array[index - 1];
//                array[index - 1] = temp;
                swap(array, leftIndex, index - 1);
                heapify(array, leftIndex + 1);
            }
            return;
        }
        if (array[leftIndex] > array[index - 1]) {
            largestIndex = leftIndex;
        }
        if (array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index - 1) {
            swap(array, index - 1, largestIndex);
            heapify(array, largestIndex + 1);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArr(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("isheap.in"));
            out = new PrintWriter("isheap.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
