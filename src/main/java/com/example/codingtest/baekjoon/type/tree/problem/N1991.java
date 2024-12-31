package com.example.codingtest.baekjoon.type.tree.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N1991 {
    public static void main(String[] args) {
        N1991 n1991 = new N1991();
        n1991.initializeTree();
        n1991.printSearch();
    }

    private int numNode;
    private Map<String, Node> nodeMap;

    public void initializeTree() {
        nodeMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            numNode = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < numNode; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                if (st.countTokens() != 3) {
                    throw new RuntimeException("Invalid input Format");
                }
                String middle = st.nextToken();
                Node middleNode = getOrCreateNode(middle);

                if (middleNode == null) {
                    throw new RuntimeException("Invalid input Format : first input can not be .");
                }
                String left = st.nextToken();
                middleNode.left = getOrCreateNode(left);

                String right = st.nextToken();
                middleNode.right = getOrCreateNode(right);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printSearch() {
        Node nodeA = nodeMap.get("A");

        printPreOrder(nodeA);
        System.out.println();

        printInOrder(nodeA);
        System.out.println();

        printPostOrder(nodeA);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.middle);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.middle);
        printInOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.middle);
    }

    private Node getOrCreateNode(String middle) {
        if (middle.equals(".")) {
            return null;
        }
        return nodeMap.computeIfAbsent(middle, Node::new);
    }

    static class Node {
        String middle;
        Node left;
        Node right;

        public Node(String middle) {
            this.middle = middle;
        }

        @Override
        public String toString() {
            return "middle : " + middle + "\n left : " + left + "\n right : " + right;
        }
    }
}
