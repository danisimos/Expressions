package expr;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Variable x = new Variable("X", false);
        Variable y = new Variable("Y", false);
        Variable z   = new Variable("Z", false);

        Expr example1 = exprExample1(x, y, z);

        System.out.println("Example 1: ");
        System.out.println("variables: " + Arrays.toString(example1.getVariables()));
        System.out.println("variable x: false");
        System.out.println("variable y: false");
        System.out.println("variable z: false");
        System.out.println(example1);
        System.out.println("answer: " + example1.evaluate());
        System.out.println();

        Expr example2 = example1.unitPropagate(x, true);
        System.out.println("Example 2: ");
        System.out.println("variables: " + Arrays.toString(example2.getVariables()));
        System.out.println("variable x: true");
        System.out.println("variable y: false");
        System.out.println("variable z: false");
        System.out.println(example2);
        System.out.println("answer: " + example2.evaluate());
        System.out.println();

    }

    public static Expr exprExample1(Variable x, Variable y, Variable z) {
        Negation e1 = new Negation(y);
        Disjunction e2 = new Disjunction(e1, z);
        Disjunction e3 = new Disjunction(z, e2);

        Disjunction e4 = new Disjunction(x, y);
        Negation e5 = new Negation(z);
        Disjunction e6 = new Disjunction(e4, e5);

        Conjuction e7 = new Conjuction(e3, e6);

        Negation e8 = new Negation(z);
        Conjuction e9 = new Conjuction(e7, e8);

        return e9;
    }
}
