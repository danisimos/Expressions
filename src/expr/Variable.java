package expr;

public class Variable implements Expr{
    boolean variable;
    String name;

    public Variable(String name, boolean v) {
        this.name = name;
        this.variable = v;
    }

    public void setVariable(boolean v) {
        this.variable = v;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean evaluate() {
        return variable;
    }

    @Override
    public Variable[] getVariables() {
        return new Variable[]{this};
    }

    @Override
    public Expr unitPropagate(Variable x, boolean var) {
        if(name.equals(x.getName())) {
            variable = var;
        }

        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
