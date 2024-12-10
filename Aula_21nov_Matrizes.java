import java.util.Scanner;

public class Aula_21nov_Matrizes {

    public static Scanner tecladoScanner = new Scanner(System.in);

    public static void imprimirArreyInt (int[] vetor){
        
        for(int i = 0; i < vetor.length;i++){
            System.out.printf("[%d]:  %d\n", i, vetor[i]);
        }
    }

    public static void imprimirResultadoEx11 (int[] vetor){
        
        for(int i = 0; i < vetor.length;i++){
            if(i == 0){
                System.out.printf("[linha]:  %d\n", vetor[i]);
            }
            if(i==1){
                System.out.printf("[coluna]:  %d\n", vetor[i]);
            }
        }
    }

    public static int lerValorInteiro() {
        int valor = tecladoScanner.nextInt();
        return valor;
    }


    public static void imprimirMatrizInt (int[][] matriz){

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for(int i = 0; i < linhas; i++){

            System.out.printf("LINHA: [ %d ]\t", i);

            //for COLUNAS
            for(int j = 0; j < colunas; j++){
                System.out.printf("COLUNA: [ %d ]\t",matriz[i][j]);
            }

            System.out.println();
        }

    }


    public static int[][] criarMatrizIntPreenchida (int linhas, int colunas, int valorPreenchimento){
        if (linhas > 0 && colunas > 0) {

            int[][] matriz = new int[linhas][colunas];

                for(int i = 0; i<linhas; i++){
                    for (int j = 0; j < colunas; j++){
                        matriz [i][j] = valorPreenchimento;
                    }
                }

            return matriz;
        }
        
        return null;
    }

    
    public static int[][] lerMatrizInteiros (int linhas, int colunas){
        if (linhas > 0 && colunas > 0) {

            int[][] matriz = new int[linhas][colunas];

                for(int i = 0; i<linhas; i++){
                    for (int j = 0; j < colunas; j++){
                        matriz [i][j] = tecladoScanner.nextInt();
                    }
                }

            return matriz;
        }
        
        return null;
    }


    public static int somarMatrizInt (int[][]matriz){
        int soma = 0;

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                soma += matriz[i][j];

            }

           
        }


        return soma;
    }



    public static int[] somarLinhasMatrizInt(int[][] matriz){
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int soma[] = new int[linhas];

        for(int i = 0; i < linhas; i++){

           
            for(int j = 0; j < colunas; j++){
               soma[i] += matriz[i][j];
            }

           
        }

        return soma;

    }



    public static int[] somarColunasColunasInt(int[][] matriz){
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int[] soma = new int[colunas];

        for(int i = 0; i < linhas; i++){

           
            for(int j = 0; j < colunas; j++){
                soma[j] += matriz[i][j];
            }

           
        }

        return soma;
    }

    public static int[] obterLinha(int[][] matriz, int linha) {
        int[] saidaLinha = new int[matriz.length];

        
        for(int j = 0; j < matriz[0].length; j++){
            
            saidaLinha[j] = matriz[linha][j];
            

            

        
        }

        return saidaLinha;
    }

    public static int[] obterColuna(int[][] matriz, int coluna) {
        int[] saidaColuna = new int[matriz.length];

        for(int i = 0; i < matriz.length; i++){

           
            for(int j = 0; j < matriz[0].length; j++){
                if(j==coluna){
                    saidaColuna[i] = matriz[i][j];
                }
            }

           
        }

        return saidaColuna;
    }


    public static int[][] multiplicarMatrizConstante(int[][] matriz, int valor) {

        int[][] matrizMultiplicada = new int[matriz.length][matriz[0].length];

        for(int i = 0; i < matriz.length; i++){

           
            for(int j = 0; j < matriz[0].length; j++){
                matrizMultiplicada[i][j] =  (matriz[i][j] * 2);
            }

           
        }

        return matrizMultiplicada;
    }


    public static int[] obterDiagonalPrincipal(int[][] matriz, int coluna) {
        int[] diagonal = new int[matriz.length];

        
        for(int i = 0; i < matriz.length; i++){

           
            for(int j = 0; j < matriz[0].length; j++){
                if(i == j){
                    diagonal[i] = matriz[i][j];
                }
            }

           
        }

        return diagonal;
    }

    public static int[] obterPosMaiorValor(int[][] matriz) {
        int[] posicao = new int[2];

        int maiorValor = 0;
        
        for(int i = 0; i < matriz.length; i++){

           
            for(int j = 0; j < matriz[0].length; j++){
                if (matriz[i][j] > maiorValor || i==0) {
                    maiorValor = matriz[i][j];
                    posicao[0] = i;
                    posicao[1] = j;
                }
            }

           
        }

        return posicao;
    }

    public static int[][] criarCampoMinado(int linhas, int colunas, int qntBombas) {

        return null;
    }



    /////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////




    public static void exemplo0(){
        int [][] matriz;

        // matriz = new int [ linha: 4 ] [ coluna: 3 ];
        // matriz = new int [ i ] [ j ];

        matriz = new int [4] [3];


        int [][] matrizQuadrada = new int[5][5];
        //matriz quadrada = [linha] = [coluna];

        /*
            [1 2 3
             3 2 1
             0 1 2] 

            diagonal 122 = diagonaL primcipal
            dia 320 = diagonal secundaria 
        */


        // matrizes podem ter MUITAS dimensoes, 3D, 5D, 15D e por ai vai
        
    }


    public static void exemplo1(){

        int [][] matriz = {{ 1,  2, 3},
                           { 4,  5, 6},
                           { 7,  8, 9},
                           {10, 11, 12}};

        


        System.out.println(matriz[1][2]);

        //retorna o tamanho da PRIMEIRA dimenesão
        //no nosso caso numero de linhas
        matriz[1][2] = 12;
        System.out.println("tamanho: " + matriz[1][2]);


        int colunas = matriz[0].length;
        System.out.println("colunas: " + colunas);
    }

    

    public static void exemplo2(){
        int[][] matriz = {{1,2,3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        imprimirMatrizInt(matriz);
    }



    public static void exemplo3(){
        int linhas = lerValorInteiro();
        int coluna = lerValorInteiro();
        int valor = lerValorInteiro();

        int[][] matriz = criarMatrizIntPreenchida(linhas, coluna, valor);
        
        imprimirMatrizInt(matriz);

    }

    public static void exemplo4(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        imprimirMatrizInt(matriz);

    }



    public static void exemplo5(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int soma = somarMatrizInt(matriz);

        
        System.out.println(soma);
    }



    public static void exemplo6(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int[] somaLinhas = somarLinhasMatrizInt(matriz);

        imprimirArreyInt(somaLinhas);
    }


    public static void exemplo7(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int[] somaColunas = somarColunasColunasInt(matriz);

        imprimirArreyInt(somaColunas);
    }


    public static void exemplo8(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int linhaPedida = lerValorInteiro();

        int[] linhaDesejada = obterLinha(matriz, linhaPedida);

        imprimirArreyInt(linhaDesejada);
    }


    public static void exemplo9(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int colunaPedida = lerValorInteiro();

        int[] colunaSaida = obterColuna(matriz, colunaPedida);

        imprimirArreyInt(colunaSaida);
    }


    public static void exemplo10(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int valorConstante = lerValorInteiro();

        int[][] matrizMult = multiplicarMatrizConstante(matriz, valorConstante);

        imprimirMatrizInt(matrizMult);
    }


    public static void exemplo11(){
        int linha = lerValorInteiro();
        int coluna = lerValorInteiro();

        int[][] matriz = lerMatrizInteiros(linha, coluna);

        int [] posicaoMaior = obterPosMaiorValor(matriz);

        imprimirResultadoEx11(posicaoMaior);
    }


    public static void main(String[] args) {
        //exemplo1();

        //exemplo2();

        //exemplo3();

        //exemplo4();

        //exemplo5();

        //exemplo6();

        //exemplo7();

        //exemplo8();

        //exemplo9();

        //exemplo10();

        exemplo11();




    }


    
}
