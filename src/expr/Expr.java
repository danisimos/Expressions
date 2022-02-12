package expr;

public interface Expr {
    boolean evaluate();
    Variable[] getVariables();
    Expr unitPropagate(Variable x, boolean var);
}
