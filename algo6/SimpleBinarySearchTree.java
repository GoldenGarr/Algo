package com.company.algo6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleBinarySearchTree {
    static BufferedReader br;
    static StringTokenizer in;
    static PrintWriter out;

    public static String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }


    public static class Node {
        int key;
        Node left, right;
        Node parent;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }


    static Node root = null;


    public static void insert_P(int insert_key) {
        Node z = new Node(insert_key);
        Node x = root;
        if (x == null) {
            root = z;
        }
        while (x != null) {
            if (z.key > x.key) {
                if (x.right != null) {
                    x = x.right;
                } else {
                    z.parent = x;
                    x.right = z;
                    break;
                }
            } else if (z.key < x.key) {
                if (x.left != null)
                    x = x.left;
                else {
                    z.parent = x;
                    x.left = z;
                    break;
                }
            } else {
                return;
            }
        }
    }


    public static Node exists(int key) {
        Node current_node = root;
        while (current_node != null) {
            if (current_node.key < key) {
                current_node = current_node.right;
            } else if (current_node.key > key) {
                current_node = current_node.left;
            } else {
                return current_node;
            }
        }
        return null;
    }


    public static void prev(int key) {
        Node current_node = root;
        Node predecessor = null;
        while (current_node != null) {
            if (current_node.key < key) {
                predecessor = current_node;
                current_node = current_node.right;
            } else {
                current_node = current_node.left;
            }
        }
        if (predecessor == null)
            out.println("none");
        else
            out.println(predecessor.key);
    }


    public static Node next(int key) {
        Node current_node = root;
        Node successor = null;
        while (current_node != null) {
            if (current_node.key > key) {
                successor = current_node;
                current_node = current_node.left;
            } else {
                current_node = current_node.right;
            }
        }
        return successor;
    }


    public static void delete(int delete_key) {
        Node v = root;
        if (root == null) {
            return;
        }
        if (root.key == delete_key) {
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            if (root.left == null) {
                root = root.right;
                return;
            }
            if (root.right == null) {
                root = root.left;
                return;
            }
        }
        while (v != null) {
            if (v.key < delete_key) {
                v = v.right;
            } else if (v.key > delete_key) {
                v = v.left;
            } else {
                break;
            }
        }
        if (v == null) {
            return;
        } else {
            Node p = v.parent;
            if (v.left == null && v.right == null) {
                if (p.left == v) {
                    p.left = null;
                } else {
                    p.right = null;
                }
            } else if (v.left == null || v.right == null) {
                if (v.left == null) {
                    if (p.left == v) {
                        p.left = v.right;
                    } else {
                        p.right = v.right;
                    }
                    v.right.parent = p;
                } else {
                    if (p.left == v) {
                        p.left = v.left;
                    } else {
                        p.right = v.left;
                    }
                    v.left.parent = p;
                }
            } else {
                Node successor = next(delete_key);
                v.key = successor.key;
                if (successor.parent.left == successor) {
                    successor.parent.left = successor.right;
                    if (successor.right != null) {
                        successor.right.parent = successor.parent;
                    }
                } else {
                    successor.parent.right = successor.right;
                    if (successor.right != null) {
                        successor.right.parent = successor.parent;
                    }
                }
            }
        }
    }


    static void centred_print(Node root) {
        if (root == null) {
            System.out.println("EMPTY TREE");
            return;
        }
        if (root.left != null) {
            centred_print(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            centred_print(root.right);
        }
    }


    public static void main(String[] args) throws IOException {
        new SimpleBinarySearchTree().run();
    }


    public static void solve() throws IOException {
        String input;
        while ((input = br.readLine()) != null) {
            String command = input.split(" ")[0];
            int digit = Integer.parseInt(input.split(" ")[1]);
            switch (command) {
                case "insert":
                    insert_P(digit);
                    break;
                case "delete":
                    delete(digit);
                    break;
                case "exists":
                    if (exists(digit) == null) {
                        out.println(false);
                    } else {
                        out.println(true);
                    }
                    break;
                case "next":
                    if (next(digit) == null) {
                        out.println("none");
                    } else {
                        out.println(next(digit).key);
                    }
                    break;
                case "prev":
                    prev(digit);
                    break;
            }
        }
    }

    /*insert 5
insert 3
insert 2
insert 4
insert 7
insert 8
insert 6
insert 5

             5
           /   \
          3     7
         / \   / \
        2   4 6   8

             6
           /   \
          3     7
         / \     \
        2   4     8
                   \
                    12
                   /  \
                  11   13
    * */


    public void run() {
        try {
            br = new BufferedReader(new FileReader("bstsimple.in"));
            out = new PrintWriter("bstsimple.out");
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
