import java.util.Scanner;

public class Colinha {

    public static int QUANTIDADE_DIAS_ANO = 365;
    public static int QUANTIDADE_DIAS_MES = 30;

    //////////////////////////////////////////////a

    public static Scanner tecladoScanner = new Scanner(System.in);


    public static int lerValorInteiro() {
        int valor = tecladoScanner.nextInt();
        return valor;
    }

    //////////////////////////////////////////////

    public static float lerValorReal() {
        float valor = tecladoScanner.nextFloat();
        return valor;
    }


    //////////////////////////////////////////////

    public static char lerCaractere() {
        char valor = tecladoScanner.next().charAt(0);
        return valor;
    }

    //////////////////////////////////////////////


    public static String lerString() {
        String texto = " ";
        texto = tecladoScanner.next();
        return texto;
    }

    //////////////////////////////////////////////


    public static void imprimir(String mensagem) {
        System.out.println(mensagem);
    }


    //////////////////////////////////////////////


    public static void main(String[] args) {
        double numero = 567.827;

        for (int count = 10; count <= 200; count ++){
            System.out.printf("contador: %d\nnumero:   %.1f\n", count , numero);

            numero += 0.1;
            if (count >= 20){
                break;
            }
        }
    }

    //////////////////////////////////////////////

    

    //////////////////////////////////////////////


    public static void imprimirArreyInt (int[] vetor){
        
        for(int i =/*  */ 0; i < vetor.length;i++){
            System.out.printf("[%d]:  %d\n", i, vetor[i]);
        }
    }

    //////////////////////////////////////////////

    public static int[] criarArrayInt(int tamanho, int valorPreenchimento){
        int[] array;
        array = new int[tamanho];

        for (int i = 0; i < array.length; i++){
            array[i] = valorPreenchimento;

        }

        return array;
    }

    //////////////////////////////////////////////

    public static int somaArrayInt(int[] vetor){
        int soma = 0;

        for(int i = 0; i < vetor.length;i++){
            soma += vetor[i];
        }

        return soma;
    }

    //////////////////////////////////////////////


    public static int[] lerVetorInteiros(int quantidade){
        if (quantidade < 1) {
            imprimir("tamanho do vetor inválido, tente novamente");
            return null;
        }

        int[] array;
        array = new int[quantidade];

        for(int i=0; i < array.length; i++){
            System.out.println("Informe o valor (int):");
            int valor = lerValorInteiro();
            array[i] = valor;

        }

        return array;
    }

}
