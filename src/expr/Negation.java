package expr;

public class Negation implements Expr{
    Expr e1;

    public Negation(Expr e1) {
        this.e1 = e1;
    }

    @Override
    public boolean evaluate() {
        return !e1.evaluate();
    }

    @Override
    public Variable[] getVariables() {
        return e1.getVariables();
    }

    @Override
    public Expr unitPropagate(Variable x, boolean var) {
        e1.unitPropagate(x, var);

        return this;
    }

    @Override
    public String toString() {
        return "¬" + e1;
    }
}
