package org.example.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class PostfixConverter {

    private final Map<Character,Integer> operators;

    public PostfixConverter(){
        operators = Map.of('(',1,')',1,'/',2,'*',3,'-',4,'+',5);
    }

    private boolean isOperator(final char c){
        return operators.containsKey(c);
    }

    private boolean hasHighPrecedence(final char l, final char r){
        return (operators.get(l) > operators.get(r));
    }

    private boolean isLeftParen(final char c){
        return c == '(';
    }

    private boolean isRightParen(final char c){
        return c == ')';
    }

    public String infixToPostfix(final String infix){
        Deque<Character> operatorStack = new ArrayDeque<>();
        StringBuilder buffer = new StringBuilder();
        boolean visitedOperator = false;
        for(Character ch: infix.toCharArray()){
            if(isOperator(ch)){
                if(isLeftParen(ch)){
                    operatorStack.push(ch);
                }else if(isRightParen(ch)){
                    while (!operatorStack.isEmpty() && !isLeftParen(operatorStack.peekLast())) {
                        buffer.append(operatorStack.pollLast());
                    }
                    operatorStack.pollLast();
                }else {
                    while (!operatorStack.isEmpty() && hasHighPrecedence(operatorStack.peekLast(), ch)) {
                        buffer.append(operatorStack.pollLast());
                    }
                    operatorStack.push(ch);
                }
                visitedOperator = true;
            }else{
                if(visitedOperator){
                    buffer.append(" ");
                    visitedOperator = false;
                }
                buffer.append(ch);
            }
        }
        while (!operatorStack.isEmpty()){
            buffer.append(operatorStack.pollLast());
        }
        return buffer.toString();
    }
}
