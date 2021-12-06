package com.company.algo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PriorityQueue {

    private static int[][] heap;
    private static int size = 0;
    private static int counter = 0;

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
        new PriorityQueue().run();
    }

    public static void solve() throws IOException {
        heap = new int[(int) Math.pow(10, 6)][2];
        String line, command;
        ArrayList<String> inputLines = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            inputLines.add(line);
        }
        for (String inputLine : inputLines) {
            counter++;
            String[] parsed = inputLine.split(" ");
            command = parsed[0];
            switch (command) {
                case ("push"):
                    int element = Integer.parseInt(parsed[1]);
                    push(element);
                    break;
                case ("extract-min"):
                    extractMin();
                    break;
                case ("decrease-key"):
                    int x = Integer.parseInt(parsed[1]);
                    int y = Integer.parseInt(parsed[2]);
                    decreaseKey(x, y);
                    break;
            }
        }
    }

    private static void extractMin() {
        if (size != 0) {
            out.println(heap[0][0]);
            heap[0] = heap[--size];
            heap[size] = new int[]{0, 0};

            minHeapify(heap, 1);
        } else {
            out.println("*");
        }
    }

    private static void decreaseKey(int x, int y) {
        int index = 0;

        for (int i = size - 1; i >= 0; i--) {
            if (heap[i][1] == x) {
                heap[i][0] = y;
                index = ++i;
                break;
            }
        }

        int parentIndex = (index) / 2;

        while (index > 1 && heap[index - 1][0] < heap[parentIndex - 1][0]) {

            swap(heap, index - 1, parentIndex - 1);
            index = parentIndex;
            parentIndex /= 2;

        }
    }

    private static void push(int element) {
        heap[size][0] = 0;
        heap[size++][1] = counter;
        decreaseKey(counter, element);
    }

    public static void minHeapify(int[][] array, int index) {
        int left = index * 2 - 1;
        int right = (index * 2 + 1) - 1;
        int min = index - 1;

        if (min < size && left < size && array[min][0] > array[left][0]) {
            min = left;
        }

        if (min < size && right < size && array[min][0] > array[right][0]) {
            min = right;
        }

        if (min != index - 1) {
            swap(array, index - 1, min);
            minHeapify(array, min + 1);
        }

    }

    public static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("priorityqueue.in"));
            out = new PrintWriter("priorityqueue.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
