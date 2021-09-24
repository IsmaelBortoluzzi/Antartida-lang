public class Contas {

    public static double eval(String expression) {
        
        if (expression.contains("-")) {

            String[] splitted = expression.split(Character.toString(expression.charAt(expression.indexOf("-"))));
            return eval(splitted[0]) - eval(splitted[1]);
        }
        else if (expression.contains("+")) {

            String[] splitted = expression.split("\\"+Character.toString(expression.charAt(expression.indexOf("+"))));
            return eval(splitted[0]) + eval(splitted[1]);
        }
        else if (expression.contains("%")) {

            String[] splitted = expression.split(Character.toString(expression.charAt(expression.indexOf("%"))));
            return eval(splitted[0]) % eval(splitted[1]);
        }
         else if (expression.contains("/")) {

            String[] splitted = expression.split(Character.toString(expression.charAt(expression.indexOf("/"))));
            return eval(splitted[0]) / eval(splitted[1]);
        }
        else if (expression.contains("*")) {
        
            String[] splitted = expression.split("\\"+Character.toString(expression.charAt(expression.indexOf("*"))));
            return eval(splitted[0]) * eval(splitted[1]);
        }
        else {
            if(expression.contains(".")) {
                return Double.parseDouble(expression);
            } else {
                expression = expression + ".0";
                return Double.parseDouble(expression);
            }
        }
    }
}
