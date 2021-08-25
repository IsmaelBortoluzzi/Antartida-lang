public final class Operacoes {
    
    public static Double soma(Variavel[] vect) {
        
        if (vect == null) return null; //vamo deixar um com double 
                                    //e outros com Double
                                    //pra ver qual vai ser melhor
        Double soma = 0.0;
        
        for (Variavel num : vect) {
            soma += (double)num.getValor();
        }

        return soma;
        //new VarDouble("var", soma);

    }

    public static Double subtracao(double[] vect) {
        
        if (vect == null) return null;
        double subtr = vect[0];  
        
        for(int i = 1; i < vect.length; i++) {
            subtr-=vect[i];
        }

        return subtr;

    }

    public static Double multiplicacao(Double[] vect) {
        
        if (vect == null) return null;
        double mult = vect[0];  
        
        for(int i = 0; i < vect.length; i++) {
            mult*=vect[i];
        }

        return mult;

    }

    public static Double divisao(Double[] vect) {
        
        return null;
    }
    public static Double modulo(Double[] vect) {
        
        return null;
    }

}
