package org.example.util;

public class Evaluator {

    private final PostfixConverter postfixConverter;

    public Evaluator(){
        this.postfixConverter = new PostfixConverter();
    }

    public String evaluate(String infix){
        return this.postfixConverter.infixToPostfix(infix);
    }
}
