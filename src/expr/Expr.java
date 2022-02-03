package expr;

public interface Expr {
    boolean evaluate();
    Variable[] getVariables();
}
