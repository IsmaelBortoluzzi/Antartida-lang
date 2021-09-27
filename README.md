# Antartida-lang

<br>

## Declarar Variável:
<br>

### Existem três classes de variáveis: int, real e str.

    int a = 0
    real b = 0
    str c = "abc"

<br>
<br>

## Trocar Valor De Variável:
<br>

### Trocar Valor De Variável Usando Valor Literal:
<br>

#### _Declarando_
    int a = 0
    real b = 0
    str c = "abc"

<br>

#### _Atualizando_
    int a = 9
    real b = 3.2
    str c = "mno"

<br>
Basta "Redeclarar"
<br>
<br>
<br>
<br>

### Trocar Valor De Variável Usando Outra Variável:

    att var1 = var2
<br>

### Atualizar Variável através de expressões Matemáticas:

    att var1 = $'var2' + 3 / 4 * 5 - 'var3'
    att var1 = $'var1' + 1

<br>

**IMPORTANTE**

#### As expressões matemáticas seguem uma ordem rígida de operação:
<br>

1. multiplicação
2. divisão
3. módulo
4. soma
5. subtração
<br>
<br>
<br>

## Operador de Impressão:
<br>

### Para Imprimir Texto Simples:
<br>

    prints "texto simples"

### Para Imprimir Variável:

    prints $var1

### Para Imprimir Uma Quebra De Linha:

    prints;

<br>
<br>

### Sintaxe de Expressões Booleanas: 

    'var1' > 3
    4 < 5
    'var1' >= 3
    'var1' == 'var2'
    !'var1'
    'var1' <= 9
    'var1' and 'var2'
    'var1' or 'var2'
    5 != 3

    !'var1' > 3 and 'var2' < 4 

#### É possível o uso de múltiplos operandos, **Contanto** Que sejam Diferentes
#### Uso do operando ! está limitado a apenas no início da expressão

<br>
<br>

## Comando Condicional:

    startif _expression_

        // code

    endif
<br>
<br>

## Comando de Loop

    loopsif _expression_

        // code

    endloop





