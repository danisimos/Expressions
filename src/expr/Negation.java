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
}
