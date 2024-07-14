package org.example.util;

public class Evaluator {

    private final PostfixConverter postfixConverter;
    private final ExpressionTree expressionTree;

    public Evaluator(){
        this.postfixConverter = new PostfixConverter();
        this.expressionTree = new ExpressionTree();
    }

    public String evaluate(final String infix){
        final String postfix = this.postfixConverter.infixToPostfix(infix);
        return this.expressionTree.buildAndEval(postfix);
    }
}
