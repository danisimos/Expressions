package expr;

public class Main {
    public static void main(String[] args) {
        Variable x = new Variable("X", false);
        Variable y = new Variable("Y", false);
        Variable z   = new Variable("Z", false);

        System.out.println(getAnswer(x, y, z));

        x.setVariable(false);
        y.setVariable(true);
        z.setVariable(true);

        System.out.println(getAnswer(x, y, z));
    }

    public static boolean getAnswer(Variable x, Variable y, Variable z) {
        Negation e1 = new Negation(y);
        Disjunction e2 = new Disjunction(e1, z);
        Disjunction e3 = new Disjunction(z, e2);

        Disjunction e4 = new Disjunction(x, y);
        Negation e5 = new Negation(z);
        Disjunction e6 = new Disjunction(e4, e5);

        Conjuction e7 = new Conjuction(e3, e6);

        Negation e8 = new Negation(z);
        Conjuction e9 = new Conjuction(e7, e8);

        return e9.evaluate();
    }
}
