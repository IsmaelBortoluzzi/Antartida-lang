public class Contas {

    public static String evaluateParentesis(String s) {

        char[] ca = s.toCharArray();
        String resul = "";

        for(int i = 0; i<ca.length; i++) {

            if(ca[i] == '(') {


            } else {
                resul = resul+ca[i];
            }

        }

        return "a";
    }

    public static double eval(String expression) {

      //if (expression.contains("(")) {

      //    String subst = expression.substring(expression.indexOf("(")+1, expression.lastIndexOf(")"));
      //    System.out.println(subst);
      //    System.out.println(expression.replaceAll("("+subst+")", Double.toString(eval(subst))));
      //    //expression = expression.replaceAll(subst, Double.toString(eval(subst)));
      //}

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
