package expr;

public class Negation implements Expr{
    Expr e1;
    int nestedLevel = 0;

    public Negation(Expr e1) {
        this.e1 = e1;
        e1.setNestedLevel();
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
    public void prettyPrint() {
        for(int i = 0; i < nestedLevel; i++) {
            System.out.print("  ");
        }
        System.out.println("-");

        e1.prettyPrint();
    }

    @Override
    public int getNestedLevel() {
        return nestedLevel;
    }

    @Override
    public void setNestedLevel() {
        this.nestedLevel++;
        e1.setNestedLevel();
    }

    @Override
    public String toString() {
        return "¬" + e1;
    }
}
