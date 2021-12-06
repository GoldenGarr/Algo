package com.company.algo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
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
        new BinarySearch().run();
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] requests = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //System.out.println(Arrays.toString(array));
        // System.out.println(Arrays.toString(requests));
        for (int elem : requests
        ) {
            binSearch(array, elem);
        }
    }

    public static void binSearch(int[] array, int element) {
        int n = array.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == element) {
                //System.out.println(mid);
                break;
            } else if (array[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[mid] != element) {
            out.println("-1 -1");
            return;
        }

        int first = 0;
        int last = 0;
        for (int i = mid; i < n - 1; i++) {
            if (array[i + 1] != element) {
                last = i + 1;
                break;
            }
        }

        for (int i = mid; i > 0; i--) {
            if (array[i - 1] != element) {
                first = i + 1;
                break;
            }
        }

        if (array[n - 1] == element) {
            last = n;
        }

        if (array[0] == element) {
            first = 1;
        }

        //System.out.println(mid);
        out.println(first + " " + last);
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("binsearch.in"));
            out = new PrintWriter("binsearch.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
