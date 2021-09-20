public class Expressions {

    public static Boolean evaluate_Expression(String expression){
    
        if(expression.contains("and")){

            String[] splitted = expression.split("and");
            return evaluate_Expression(splitted[0]) && evaluate_Expression(splitted[1]);
        }
        else if(expression.contains("or")){

            String[] splitted = expression.split("or");
            return evaluate_Expression(splitted[0]) || evaluate_Expression(splitted[1]);
        }
        else if(expression.contains(">=")){

            String[] splitted = expression.split(">=");
            return (Double.parseDouble(splitted[0]) >= Double.parseDouble(splitted[1]));
        }
        else if(expression.contains("<=")){

            String[] splitted = expression.split("<=");
            return (Double.parseDouble(splitted[0]) <= Double.parseDouble(splitted[1]));
        }
        else if(expression.contains("==")){

            String[] splitted = expression.split("==");
            return (Double.parseDouble(splitted[0]) == Double.parseDouble(splitted[1]));
        }
        else if(expression.contains(">")){
            
            String[] splitted = expression.split(">");
            return (Double.parseDouble(splitted[0]) > Double.parseDouble(splitted[1]));
        }
        else if(expression.contains("<")){
            
            String[] splitted = expression.split("<");
            return (Double.parseDouble(splitted[0]) < Double.parseDouble(splitted[1]));
        }

        else return false;

    
    }

}
