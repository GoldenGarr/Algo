package com.company.algo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Races {
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
        new Races().run();
    }


    public void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input;
        ArrayList<ArrayList<String>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            ArrayList<String> lst = new ArrayList<>();
            lst.add(input[0]);
            lst.add(input[1]);
            map.add(lst);
        }
        //System.out.println(map);
        String[][] dict = new String[map.size()][];
        for (int i = 0; i < map.size(); i++) {
            dict[i] = map.get(i).toArray(new String[0]);
        }
        postMergeSort(dict);
        //System.out.println(Arrays.deepToString(dict));
        String prevCountry = "";
        for (String[] elem : dict
        ) {
            if (!elem[0].equals(prevCountry))
                out.println("=== " + elem[0] + " ===");
            for (int j = 1; j < elem.length; j++) {
                out.println(elem[j]);
            }
            prevCountry = elem[0];
        }

    }

    public static void postMergeSort(String[][] array) {
        if (array.length <= 1) {
            return;
        } else {
            int border = array.length / 2;
            String[][] left = new String[border][];
            String[][] right = new String[array.length - border][];
            for (int i = 0; i < border; i++) {
                left[i] = array[i];
            }
            for (int i = border; i < array.length; i++) {
                right[i - border] = array[i];
                //System.out.println(array2.length);
            }
            postMergeSort(left);
            postMergeSort(right);
            merge(array, left, right);
        }
    }

    public static void merge(String[][] origin, String[][] left, String[][] right) {
        int i = 0;
        int j = 0;
        int m = left.length;
        int k = right.length;
        int originIndex = 0;

        while (i < m && j < k) {
            if (left[i][0].compareTo(right[j][0]) > 0) {
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
            br = new BufferedReader(new FileReader("race.in"));
            out = new PrintWriter("race.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


}