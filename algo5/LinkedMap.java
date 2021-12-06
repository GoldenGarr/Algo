package com.company.algo5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LinkedMap {
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
        new LinkedMap().run();
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
        String input;
        int length = 5381;
        ArrayList<ArrayList<Custom_Block>> hashMap = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ArrayList<Custom_Block> element = new ArrayList<>();
            hashMap.add(element);
        }
        Custom_Block previously_added_block = null;
        while ((input = br.readLine()) != null) {
            // hash start
            String key_string;
            int index = 0;
            char[] tmp;
            key_string = input.split(" ")[1];
            tmp = key_string.toCharArray();
            for (char c : tmp
            ) {
                index += 47 * index + (c - 'a' + 1);
                index %= length;
            }
            index = Math.abs(index);
            // hash end
            switch (input.split(" ")[0]) {
                case "put":
                    String value_string = input.split(" ")[2];
                    boolean flag = true;
                    for (int i = 0; i < hashMap.get(index).size(); i++) {
                        if (hashMap.get(index).get(i).key.equals(key_string)) {
                            hashMap.get(index).get(i).value = value_string;
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        Custom_Block currently_added_block = new Custom_Block(key_string, value_string);
                        currently_added_block.prev = previously_added_block;
                        hashMap.get(index).add(currently_added_block);

                        if (previously_added_block != null) {
                            previously_added_block.next = currently_added_block;
                        }
                        previously_added_block = currently_added_block;
                    }
                    break;
                case "delete":
                    for (int i = 0; i < hashMap.get(index).size(); i++) {
                        if (hashMap.get(index).get(i).key.equals(key_string)) {
                            if (hashMap.get(index).get(i).next == null) {
                                previously_added_block = hashMap.get(index).get(i).prev;
                            }
                            if (hashMap.get(index).get(i).prev != null) {
                                hashMap.get(index).get(i).prev.next = hashMap.get(index).get(i).next;
                            }

                            if (hashMap.get(index).get(i).next != null) {
                                hashMap.get(index).get(i).next.prev = hashMap.get(index).get(i).prev;
                            }
                            hashMap.get(index).get(i).key = "";
                            hashMap.get(index).get(i).value = "";
                            hashMap.get(index).get(i).prev = null;
                            hashMap.get(index).get(i).next = null;
                            break;
                        }
                    }
                    break;
                case "get":
                    boolean flag2 = true;
                    for (int i = 0; i < hashMap.get(index).size(); i++) {
                        if (hashMap.get(index).get(i).key.equals(key_string)) {
                            flag2 = false;
                            out.println(hashMap.get(index).get(i).value);
                            break;
                        }
                    }
                    if (flag2) {
                        out.println("none");
                    }
                    break;
                case "prev":
                    Custom_Block block_to_find = null;
                    for (int i = 0; i < hashMap.get(index).size(); i++) {
                        if (hashMap.get(index).get(i).key.equals(key_string)) {
                            block_to_find = hashMap.get(index).get(i);
                            break;
                        }
                    }
                    if (block_to_find != null) {
                        if (block_to_find.prev != null) {
                            out.println(block_to_find.prev.value);
                        } else {
                            out.println("none");
                        }
                    } else {
                        out.println("none");
                    }
                    break;
                case "next":
                    Custom_Block block_to_find1 = null;
                    for (int i = 0; i < hashMap.get(index).size(); i++) {
                        if (hashMap.get(index).get(i).key.equals(key_string)) {
                            block_to_find1 = hashMap.get(index).get(i);
                            flag = false;
                            break;
                        }
                    }
                    if (block_to_find1 != null) {
                        if (block_to_find1.next != null) {
                            out.println(block_to_find1.next.value);
                        } else {
                            out.println("none");
                        }
                    } else {
                        out.println("none");
                    }
                    break;
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("linkedmap.in"));
            out = new PrintWriter("linkedmap.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
