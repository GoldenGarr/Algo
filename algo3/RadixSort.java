package com.company.algo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RadixSort {
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
        new RadixSort().run();
    }

    public static void solve() throws IOException {
        String[] digits = br.readLine().split(" ");
        int n = Integer.parseInt(digits[0]);
        size = Integer.parseInt(digits[1]);
        int steps = Integer.parseInt(digits[2]);
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            array[i] = input.replace(" ", "");
        }
        while (counter <= steps) {
            modifiedCountingSort(array, n, size, counter);
            ++counter;
        }
        for (int i = 0; i < n; i++) {
            out.println(array[i]);
        }
        //System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(array));
    }

    public static void modifiedCountingSort(String[] array, int n, int m, int k) {
        String[][] c = new String[26][n + 1];
        for (int i = 0; i < 26; i++) {
            c[i][0] = "0";
        }
        for (int i = 0; i < n; i++) {
            c[array[i].charAt(m - k) - 'a'][0] = String
                    .valueOf(Integer.parseInt(c[array[i].charAt(m - k) - 'a'][0]) + 1);
            c[array[i].charAt(m - k) - 'a']
                    [Integer.parseInt(c[array[i].charAt(m - k) - 'a'][0])] = array[i];
        }
        String[] result = new String[n];
        int index = 0;
        while (index < n) {
            for (int i = 0; i < 26; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (c[i][j] != null) {
                        result[index++] = c[i][j];
                    } else {
                        break;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(result));
        //array = result;
        for (int i = 0; i < n; i++) {
            array[i] = result[i];
        }
        //System.out.println(Arrays.toString(array));
    }

    public static void countingSort(char[] array) {
        int[] c = new int[26];
        for (char elem : array
        ) {
            c[elem - 'a'] += 1;
        }
        int[] temp = new int[26];
        //System.out.println(Arrays.toString(c));
        temp[0] = c[0];
        for (int i = 1; i < 26; i++) {
            temp[i] = c[i] + temp[i - 1];
        }
        //System.out.println(Arrays.toString(temp));

        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < temp[0]; i++) {
            result.add('a');
        }

        char[] dic = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
                , 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 1; i < 26; i++) {
            int amount = temp[i] - temp[i - 1];
            //System.out.println(amount);
            while (amount > 0) {
                result.add(dic[i]);
                --amount;
            }
        }
        System.out.println(result);
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArr(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("radixsort.in"));
            out = new PrintWriter("radixsort.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}