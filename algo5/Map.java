package com.company.algo5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Map {
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
        new Map().run();
    }


    public static void insert(int element) {

    }


    public static void solve() throws IOException {
        String input;
        int length = 5381;
        ArrayList<ArrayList<ArrayList<String>>> hashMap = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ArrayList<ArrayList<String>> element = new ArrayList<>();
            hashMap.add(element);
        }

        while ((input = br.readLine()) != null) {
            //System.out.println(hashSet);
            String key_string;
            int value = 0;
            char[] tmp;
            key_string = input.split(" ")[1];
            tmp = key_string.toCharArray();
            int counter = 1;
            for (char c : tmp
            ) {
                value += counter * (c - 'a' + 1);
                counter++;
            }
            int index = Math.abs(value % (length));

            switch (input.split(" ")[0]) {
                case "put":
                    boolean flag = true;
                    String value_string = input.split(" ")[2];
                    if (hashMap.get(index).size() != 0) {
                        for (int i = 0; i < hashMap.get(index).size(); i++) {
                            if (hashMap.get(index).get(i).get(0).equals(key_string)) {
                                hashMap.get(index).get(i).remove(1);
                                hashMap.get(index).get(i).add(value_string);
                                flag = false;
                                break;
                            }
                        }

                        //System.out.println();
                        //System.out.println("KEY: " + key_string + " VALUE: " + value_string + " INDEX: " + index);
                    }
                    if (flag) {
                        ArrayList<String> new_pair = new ArrayList<>();
                        new_pair.add(key_string);
                        new_pair.add(value_string);
                        hashMap.get(index).add(new_pair);
                    }
                    break;
                case "delete":
                    if (hashMap.get(index).size() != 0) {
                        for (int i = 0; i < hashMap.get(index).size(); i++) {
                            if (hashMap.get(index).get(i).get(0).equals(key_string)) {
                                // hashMap.get(index).remove(i);
                                // hashMap.get(index).remove(i);
                                hashMap.get(index).remove(i);
                                break;
                            }
                        }
                    }
                    break;
                case "get":
                    boolean flag2 = true;
                    if (hashMap.get(index).size() != 0) {
                        for (int i = 0; i < hashMap.get(index).size(); i++) {
                            if (hashMap.get(index).get(i).get(0).equals(key_string)) {
                                out.println(hashMap.get(index).get(i).get(1));
                                flag2 = false;
                                break;
                            }
                        }
                    }
                    if (flag2) {
                        out.println("none");
                    }
                    break;
            }
            //System.out.println(hashMap);
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("map.in"));
            out = new PrintWriter("map.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
