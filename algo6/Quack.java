package com.company.algo6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Quack {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    static int modulo = 65536 - 1;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] registers = new int[26];
    static HashMap<String, Integer> lines_labels = new HashMap<>();
    static String[] command_lines = new String[100000];


    public static void main(String[] args) throws IOException {
        new Quack().run();
    }


    public static void solve() throws IOException {
        String input;
        String command;
        int x, y, result;
        int register, register2;
        int command_line_counter = 0;
        String label;
        while ((input = br.readLine()) != null) {
            command_lines[command_line_counter++] = input;
            command = input.split("")[0];
            if (command.equals(":")) {
                lines_labels.put(input.split(":")[1], command_line_counter - 1);
            }
        }
        int current_line_number = 0;
        while (current_line_number < command_line_counter) {
            command = String.valueOf(command_lines[current_line_number++].charAt(0));
            switch (command) {
                case "+":
                    x = queue.remove();
                    y = queue.remove();
                    result = (x + y) & modulo;
                    // = 65536 - 1
                    queue.add(result);
                    break;
                case "-":
                    x = queue.remove();
                    y = queue.remove();
                    result = (x - y) & modulo;
                    queue.add(result);
                    break;
                case "*":
                    x = queue.remove();
                    y = queue.remove();
                    result = (x * y) & modulo;
                    queue.add(result);
                    break;
                case "/":
                    x = queue.remove();
                    y = queue.remove();
                    if (y == 0)
                        result = 0 & modulo;
                    else
                        result = (x / y) & modulo;
                    queue.add(result);
                    break;
                case "%":
                    x = queue.remove();
                    y = queue.remove();
                    if (y == 0)
                        result = 0 & modulo;
                    else
                        result = (x % y) & modulo;
                    queue.add(result);
                    break;
                case ">":
                    register = command_lines[current_line_number - 1].charAt(1) - 'a';
                    x = queue.remove();
                    registers[register] = x;
                    break;
                case "<":
                    register = command_lines[current_line_number - 1].charAt(1) - 'a';
                    x = registers[register];
                    queue.add(x);
                    break;
                case "P":
                    if (command_lines[current_line_number - 1].split("").length == 1) {
                        out.println(queue.remove());
                    } else {
                        register = command_lines[current_line_number - 1].charAt(1) - 'a';
                        out.println(registers[register]);
                    }
                    break;
                case "C":
                    if (command_lines[current_line_number - 1].split("").length == 1) {
                        x = queue.remove();
                    } else {
                        register = command_lines[current_line_number - 1].charAt(1) - 'a';
                        x = registers[register];
                    }
                    out.print((char) (x % 256));

                    break;
                case ":":
                    //have already assigned all of the strings' labels
                    break;
                case "J":
                    //TODO
                    current_line_number = lines_labels
                            .get(command_lines[current_line_number - 1].split("J")[1]);
                    break;
                case "Z":
                    register = command_lines[current_line_number - 1].charAt(1) - 'a';
                    label = command_lines[current_line_number - 1].substring(2);
                    if (registers[register] == 0)
                        current_line_number = lines_labels.get(label);
                    break;
                case "E":
                    register = command_lines[current_line_number - 1].charAt(1) - 'a';
                    register2 = command_lines[current_line_number - 1].charAt(2) - 'a';
                    label = command_lines[current_line_number - 1].substring(3);
                    if (registers[register] == registers[register2])
                        current_line_number = lines_labels.get(label);
                    break;
                case "G":
                    register = command_lines[current_line_number - 1].charAt(1) - 'a';
                    register2 = command_lines[current_line_number - 1].charAt(2) - 'a';
                    label = command_lines[current_line_number - 1].substring(3);
                    if (registers[register] > registers[register2])
                        current_line_number = lines_labels.get(label);
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    x = Integer.parseInt(command_lines[current_line_number - 1]);
                    queue.add(x);
                    break;
            }
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("quack.in"));
            out = new PrintWriter("quack.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
