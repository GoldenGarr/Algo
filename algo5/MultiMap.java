package com.company.algo5;

import jdk.jshell.execution.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MultiMap {
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
        new MultiMap().run();
    }


    public static class Custom_Block {
        String key, value;
        Custom_Block prev, next;


        public Custom_Block(String key, String value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


    public static void solve() throws IOException {
        String input = "";

        int length = 10000;
        ArrayList<ArrayList<Custom_Block>> map = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ArrayList<Custom_Block> element = new ArrayList<>();
            map.add(element);
        }

        while ((input = br.readLine()) != null) {

            String key_string;
            int index = 0;
            char[] tmp;
            key_string = input.split(" ")[1];
            tmp = key_string.toCharArray();
            int counter = 1;
            int a = 3;
            int b = 7;
            int p = 9009;
            long hashCode = 5381;
            for (char c : tmp
            ) {
                hashCode += (long) counter++ * (c - 'a');
            }
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            index = (int) hashCode % length;

            String value_string;
            Custom_Block current_block;

            switch (input.split(" ")[0]) {
                case "put":
                    value_string = input.split(" ")[2];
                    boolean flag = true;
                    Custom_Block new_block = new Custom_Block(key_string, value_string);
                    Custom_Block last_block = new Custom_Block("", "");

                    for (int i = 0; i < map.get(index).size(); i++) {
                        if (map.get(index).get(i).key.equals(key_string)) {
                            current_block = map.get(index).get(i);
                            while (current_block != null) {
                                if (current_block.value.equals(value_string)) {
                                    flag = false;
                                    break;
                                }
                                if (current_block.next == null) {
                                    last_block = current_block;
                                }
                                current_block = current_block.next;
                            }
                            if (flag) {
                                last_block.next = new_block;
                                new_block.prev = last_block;
                            }
                            flag = false;
                        }
                    }
                    if (flag) {
                        map.get(index).add(new_block);
                    }
                    break;
                case "delete":
                    value_string = input.split(" ")[2];
                    for (int i = 0; i < map.get(index).size(); i++) {
                        if (map.get(index).get(i).key.equals(key_string)) {
                            current_block = map.get(index).get(i);
                            while (current_block != null) {
                                if (current_block.value.equals(value_string)) {
                                    // deleting first element
                                    if (current_block.prev == null) {
                                        // single first element with such key
                                        if (current_block.next == null) {
                                            current_block.key = "";
                                            current_block.value = "";
                                        } else {
                                            current_block.value = current_block.next.value;
                                            if (current_block.next.next != null) {
                                                current_block.next.next.prev = current_block;
                                            }
                                            current_block.next = current_block.next.next;

                                        }
                                    } else {
                                        current_block.prev.next = current_block.next;
                                        if (current_block.next != null)
                                            current_block.next.prev = current_block.prev;
                                    }
                                    break;
                                }
                                current_block = current_block.next;
                            }
                            break;
                        }
                    }
                    break;
                case "deleteall":
                    for (int i = 0; i < map.get(index).size(); i++) {
                        if (map.get(index).get(i).key.equals(key_string)) {
                            map.get(index).get(i).next = null;
                            map.get(index).get(i).key = "";
                            map.get(index).get(i).value = "";
                            break;
                        }
                    }
                    break;
                case "get":
                    StringBuilder result = new StringBuilder();
                    int amount = 0;
                    for (int i = 0; i < map.get(index).size(); i++) {
                        if (map.get(index).get(i).key.equals(key_string)) {
                            current_block = map.get(index).get(i);
                            while (current_block != null) {
                                result.append(current_block.value).append(" ");
                                amount++;
                                current_block = current_block.next;
                            }
                        }
                    }
                    out.println(amount + " " + result);
                    break;
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("multimap.in"));
            out = new PrintWriter("multimap.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
