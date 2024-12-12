import java.util.Random;
import java.util.Scanner;

public class Trabalho4BI_CaixaDeMercado {

    public static Scanner tecladoScanner = new Scanner(System.in);

    public static int lerValorInteiro() {
        int valor = tecladoScanner.nextInt();
        return valor;
    }

    public static boolean lerBoolean() {
        boolean valor = tecladoScanner.nextBoolean();
        return valor;
    }

    public static float lerValorReal() {
        float valor = tecladoScanner.nextFloat();
        return valor;
    }

    public static String lerTexto() {
        String texto = tecladoScanner.next();
        return texto;
    }

    public static void imprimir(String mensagem) {
        System.out.println(mensagem);
    }

    public static void imprimirVetorString (int[] vetor){
        
        for(int i =/*  */ 0; i < vetor.length;i++){
            System.out.printf("[%d]:  %d\n", i, vetor[i]);
        }
    }

    public static String[][] aumentarVetor(String[][] matrizMae) {
        //metodo que verifica se o vetor encheu, se sim, aumenta o tamanho.

        int linhas = matrizMae.length;
        int colunas = matrizMae [0].length;

        if (matrizMae[linhas - 1][colunas] != " ") {

            String[][] matrizAumentada = new String[linhas + 10][colunas];

            for (int i = 0; i < linhas; i++) {
                for(int j = 0; j < linhas; j++){

                    matrizAumentada[i][j] = matrizMae[i][j];}

            }

            return matrizAumentada;
        }

        return matrizMae;
    }



    public static String[][] criarMatrizPreenchida(int linhas, int colunas, String valorPreenchimento) {


        String[][] matriz = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for(int j = 0; j < colunas; j++) {
                matriz[i][j] = valorPreenchimento;
            }
            

        }

        return matriz;
    }

    public static String[][] acharProdutoSistema(String[][] produtosEscolhidos, String produto) {

        //Verificar se os produtos estâo no sistema

    
            for (int i = 0; i < obterTabelaPrecos().length; i++) {

                if (produto == obterTabelaPrecos()[i][1]) {

                    produtosEscolhidos[i][1] = obterTabelaPrecos()[i][1];

                } else {
                    System.out.println("Produto não achado. Tente novamente");
                    
                }

        }

        return produtosEscolhidos;
        
    }

    public static String[][] passarProdutos() {

        // metodo para Scannear codigos 

        String[][] produtosEscolhidos = criarMatrizPreenchida(10, 2, " ");

        String produto;

        while (true) {

            imprimir("Digite o código do produto.(S para sair)");
            produto = lerTexto();

            if (produto == "S") {
                break;
            }

            produtosEscolhidos = aumentarVetor(produtosEscolhidos);

            produtosEscolhidos = acharProdutoSistema(produtosEscolhidos, produto);

            
        }

        return produtosEscolhidos;

    }

    public static String[][] verificarProdutosDesconto(String[][] produtosEscolhidos, String[][] produtosPromocao){

        for (int i = 0; i < produtosEscolhidos.length; i++) {

            for (int j = 0; j < produtosEscolhidos.length; j++){
                if (produtosEscolhidos[i][j] == produtosPromocao[j][3]) {
                    produtosEscolhidos[i][j] = produtosPromocao[j][3];
                } 
            }
        }

        return produtosEscolhidos;
    }

    public static float somaPreçoTotal(String[][] produtosEscolhidos, String[][] produtosCompraPromocao){

        float somaPrecoTotal = 0;


        for(int i = 0; i < produtosEscolhidos.length; i++){

            somaPrecoTotal = somaPrecoTotal + Float.parseFloat(produtosEscolhidos[i][1]);
        }



        return somaPrecoTotal;
    }

    public static String[][] obterTabelaPrecos() {

        // [11][3]
        String[][] precosProdutos = {
                { "Nome", "Código", "Preço" },
                { "Leite", "70081529", "4,69" },
                { "Leite Condensado", "70081678", "6,99" },
                { "Pão de Forma", "89001698", "5,94" },
                { "Arroz (5kg)", "00001608", "25,98" },
                { "Feijão (1kg)", "00112013", "6,68" },
                { "Mandioca  (500g)", "11112034", "8,99" },
                { "Creme de Leite", "70083254", "3,19" },
                { "Sabão em Pó (1kg)", "98780047", "27,99" },
                { "Macarrão Espaguete (1kg)", "89002140", "6,79" },
                { "Refrigerante de Limão(2L)", "59021124", "5,59" }
        };
        return precosProdutos;
    }

    public static String[][] criarTabelaClienteClube() {

        // [6][2]
        String[][] clientesClube = {
                { "Nome Cliente", "CPF" },
                { "Ana Beatriz da Silva", "123.456.78909" },
                { "João Pedro Oliveira", "98765432100" },
                { "Cláudia Costa Ferreira", "45612378932" },
                { "Carlos Eduardo Almeida", "32165498745" },
                { "Sofia Ribeiro Santos", "78912345687" }
        };

        return clientesClube;
    }

    public static int definirEstação(){
        Random random = new Random();

        int estaçao = random.nextInt(4);

        return estaçao;
    }

    public static String[][] obterTabelaDescontos(int estação) {

        switch (estação) {
            case 1:
                // [3][4]
                String[][] produtosPromocaoOutono = {

                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "11112034", "R$8,99", "8%", "R$8,27" },
                        { "00112013", "R$6,68", "9%", "R$6,08" },
                };

                return produtosPromocaoOutono;

            case 2:
                // [3][4]
                String[][] produtosPromocaoinverno = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "70083254", "R$3,19", "7%", "R$2,97" },
                        { "70081529", "R$4,69", "5%", "R$4,46" },

                };
                return produtosPromocaoinverno;

            case 3:
                // [3][4]
                String[][] produtosPromocaoPrimavera = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "89001698", "R$5,94", "10%", "R$5,35" },
                        { "98780047", "R$27,99", "9%", "R$25,47" },

                };
                return produtosPromocaoPrimavera;

            case 4:
                // [3][4]
                String[][] produtosPromocaoVerão = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "59021124", "R$5,59", "10%", "R$5,03" },
                        { "00001608", "R$25,98", "11%", "R$23,12" }
                };
                return produtosPromocaoVerão;
        }

        return null;
    }

    public static float calcularTroco(float total, float pagamento) {
        float troco = 0;

        troco = total - pagamento;

        return troco;
    }

    public static float pagamento(float totalCompra) {
        float quantiaCliente;
        float troco = 0;

        imprimir("Selecione a forma de pagamento. (1 para dinheiro, 2 para cartao, 3 para vale alimentação)");
        int formaPagamento = lerValorInteiro();

        switch (formaPagamento) {
            case 1:
                imprimir("Informe quantia dada pelo cliente");
                quantiaCliente = lerValorReal();
                if (quantiaCliente > totalCompra) {
                    troco = calcularTroco(totalCompra, quantiaCliente);
                }
                return troco;
                

            case 2:
                imprimir("insira o cartão no leitor");
                imprimir("selecione 1 para credito e 2 para debito");
                int metodoCartao = lerValorInteiro();

                switch (metodoCartao) {
                    case 1:
                        float leitorMaquinaCreditoLimite = lerValorReal();
                        if (leitorMaquinaCreditoLimite >= totalCompra) {
                            imprimir("TRANSAÇÃO APROVADA");
                            break;
                        } else {
                            imprimir("TRANSAÇÃO RECUSADA");
                            break;
                        }

                    case 2:
                        float leitorMaquinaDebitoSaldo = lerValorReal();
                        if (leitorMaquinaDebitoSaldo >= totalCompra) {
                            imprimir("TRANSAÇÃO APROVADA");

                            break;
                        } else {
                            imprimir("TRANSAÇÃO RECUSADA");
                            break;
                        }
                }
                break;

            case 3:

            default:
                imprimir("forma de pagamento invalida");
                break;  
        }

        return troco;
    }

    public static void imprimirNotaFiscal(){

        //impresão da nota fiscal

        System.out.print("________________________________\n"+
                        "|    M3 Comercio de Alimentos    |\n"+
                        "|      Centro, Cascavel Pr       |\n"+
                        "|________________________________|\n"+
                        "|--------------------------------|\n");


                        //for
    }

    public static void main(String[] args) {
       
        int estação = definirEstação();

        String[][] produtosPromoçãoSazonal = obterTabelaDescontos(estação);
        
        String[][] compraCliente = passarProdutos();

        compraCliente = verificarProdutosDesconto(compraCliente, produtosPromoçãoSazonal);

        float total = somaPreçosTotal(compraCliente, produtosPromoçãoSazonal);

        pagamento(total);

        imprimir("Imprimir nota fiscal? 0 para nao 1 para sim");
        boolean finalizar = lerBoolean();
        if (finalizar == true) {
            imprimirNotaFiscal();
        }

        imprimir("OPERAÇÃO FINALIZADA");
    }
}
