package expr;

public class Disjunction implements Expr{
    Expr e1;
    Expr e2;

    public Disjunction(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean evaluate() {
        return e1.evaluate() && e2.evaluate();
    }

    @Override
    public Variable[] getVariables() {
        Variable[] e1v = e1.getVariables();
        Variable[] e2v = e2.getVariables();

        Variable[] result = new Variable[e1v.length + e2v.length];
        int i = 0;

        //записываем в ответ все переменные из e1
        for(Variable variable: e1v) {
            result[i] = variable;
            i++;
        }

        //записываем в ответ все переменные из e2, которых нет в e1
        for(Variable variable: e2v) {
            boolean contains = false;
            for(Variable variable1: result) {
                if(variable1.getName().equals(variable.getName())) {
                    contains = true;
                }
            }

            if(!contains) {
                result[i] = variable;
            }
        }

        //обрезаем пустые значения
        Variable[] answer = new Variable[i + 1];
        i = 0;
        for(Variable variable: result) {
            answer[i] = variable;
        }

        return e1.getVariables();
    }
}
