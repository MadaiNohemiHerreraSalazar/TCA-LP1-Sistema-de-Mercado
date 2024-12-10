import java.util.Random;

import java.util.Scanner;

public class Aula_31_outubro_Random {

    public static Scanner tecladoScanner = new Scanner(System.in);

    public static int lerValorInteiro() {
        int valor = tecladoScanner.nextInt();
        return valor;
    }

    public static int[] criarArrayInt(int tamanho, int valorPreenchimento){
        int[] array;
        array = new int[tamanho];

        for (int i = 0; i < array.length; i++){
            array[i] = valorPreenchimento;

        }

        return array;
    }


    public static void imprimirArreyInt (int[] vetor){
        
        for(int i = 0; i < vetor.length;i++){
            System.out.printf("[%d]:  %d\n", i, vetor[i]);
        }
    }


    public static int obterIndice(int[] vetor, int valor){
       
        for(int i = 0; i < vetor.length; i++){

            if(vetor[i] == valor){
                return i;
            }
        }

        return -1;
    }

    public static int[] gerarVetorInteirosAleatorios(int tamanho, int intervalo){
        Random random = new Random();
        int[] vetor = new int[tamanho];

        for(int i=0; i< vetor.length; i++){
            vetor[i] = random.nextInt(intervalo);
        }
        
        return vetor;
    }

    public static int quantidadeNumerosIguaisIndice(int[] vetor, int valor){
        int quantidadeIguais = 0;

        for(int i = 0; i < vetor.length; i++){
            if (vetor[i] == valor) {
                quantidadeIguais ++;
            }
        }

        return quantidadeIguais;
    }


    /*public static int[] obterHistogramaVal_0_9(int[] vetor){

        for(int i = 0; i < vetor.length; i++)
        return null;
    }*/

    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static void ex14(){
        //sorteio

        Random random = new Random(); 

        String[] animais = {"gato", "cachorro", "urso", "cavalo", "ornitorrinco", "pato",
                            "tartaruga", "peixe", "calopsita", "jabuti", "capivara"};

        for(int i = 0; i < 4; i++){
            int posicao = random.nextInt(animais.length);
            System.out.println(animais[posicao]);
        }
    }

    public static void ex15(){
        int[] teste;
        int tamanho, intervalo;

        tamanho = lerValorInteiro();
        intervalo = lerValorInteiro();

        teste = gerarVetorInteirosAleatorios(tamanho, intervalo);

        imprimirArreyInt(teste);
    }

    public static void ex16(){
        int[] array = gerarVetorInteirosAleatorios(4, 6);
        imprimirArreyInt(array);

        int valor = lerValorInteiro();
        int posicao = obterIndice(array, valor);
        System.out.printf("a posição do valor %d é: %d\n", valor, posicao);
    }


    public static void ex17(){
        int[] array = gerarVetorInteirosAleatorios(8, 6);
        imprimirArreyInt(array);

        int valor = lerValorInteiro();
        int quantidade = quantidadeNumerosIguaisIndice(array, valor);
        System.out.printf("a quantidade de %d no vetor é: %d\n", valor, quantidade);

    }


    /*public static void ex18(){
        int[] teste;
        int[] histograma;

        int quantidade = 1000;
        teste = gerarVetorInteirosAleatorios(quantidade, 10);

        imprimirArreyInt(teste);

        histograma = obterHistogramaVal_0_9(teste);

        imprimirArreyInt(histograma);
    }*/


    public static void main(String[] args) {
        //ex14();
        //ex15();
        //ex16();
        //ex17();
        //ex18();
        
    }
}
