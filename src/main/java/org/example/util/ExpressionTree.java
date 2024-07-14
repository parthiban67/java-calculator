package org.example.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ExpressionTree {

    private static class Node{
        public boolean isOperator;
        public double value;
        public char operator;
        public Node left;
        public Node right;

        Node(double value){
            this.isOperator = false;
            this.value = value;
        }

        Node(char operator){
            this.operator = operator;
            this.isOperator = true;
        }
    }

    private final Map<Character,Integer> operators;

    public ExpressionTree(){
        operators = Map.of('(',1,')',1,'/',2,'*',3,'-',4,'+',5);
    }

    private boolean isOperator(final char c){
        return operators.containsKey(c);
    }

    private Node build(final String postfix){
        Deque<Node> tree = new ArrayDeque<>();
        final char sep = ' ';
        StringBuilder buffer = new StringBuilder();
        for(Character ch: postfix.toCharArray()){
            if(ch == sep){
                if(!buffer.isEmpty()){
                    double val = Double.parseDouble(buffer.toString());
                    tree.push(new Node(val));
                    buffer.setLength(0);
                }
            }else if(isOperator(ch)){
                if(!buffer.isEmpty()){
                    double val = Double.parseDouble(buffer.toString());
                    tree.push(new Node(val));
                    buffer.setLength(0);
                }
                if(tree.size() >= 2){
                    Node right = tree.pop();
                    Node left = tree.pop();
                    Node parent = new Node(ch);
                    parent.left = left;
                    parent.right = right;
                    tree.push(parent);
                }else{
                    throw new EvaluationException("Tree should have at least two nodes");
                }
            }else{
                buffer.append(ch);
            }
        }
        if(tree.size() == 1){
            return tree.pop();
        }
        throw new EvaluationException("Malformed tree");
    }

    private double apply(final double l,final double r,final char op){
        if(op == '+'){
            return l + r;
        }else if(op == '-'){
            return l - r;
        }else if(op == '*'){
            return  l * r;
        }else if(op == '/'){
            return l / r;
        }else{
            throw new EvaluationException("Bad operator");
        }
    }

    private double eval(Node node){
        if(!node.isOperator){
            return node.value;
        }
        double l = eval(node.left);
        double r = eval(node.right);
        return apply(l,r,node.operator);
    }

    public String buildAndEval(final String postfix){
        try {
            Node root = build(postfix);
            return String.valueOf(eval(root));
        }catch (NumberFormatException | EvaluationException ex){
            return "Error";
        }
    }
}
