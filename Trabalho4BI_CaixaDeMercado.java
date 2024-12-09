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



    public static String[] passarProdutos(String[][] precosProdutos){

        //metodo para Scannear codigos e verificar se estão no sistema

        String[] produtosEscolhidos;

        String produto;
        
         for(int i = 0; i < precosProdutos.length; i++){

                produto = lerTexto();

                if(produto == precosProdutos[i][0]){

                    produtosEscolhidos[i] = produto;
                }else{
                    System.out.println("Produto não achado. Tente novamente");;
                }
            }




        


        }


    

    
    public static String[][] criarTabelaPrecos (){

        //[11][3]
        String[][] precosProdutos = {
            {"Nome", "Código", "Preço"},
            {"Leite", "70081529", "4,69"},
            {"Leite Condensado", "70081678", "6,99"},
            {"Pão de Forma", "89001698", "5,94"},
            {"Arroz emb5kg", "00001608", "25,98"},
            {"Feijão emb1kg", "00112013", "6,68"},
            {"Mandioca  (500g)", "11112034", "8,99"},
            {"Creme de Leite", "70083254", "3,19"},
            {"Sabão em Pó emb1kg", "98780047", "27,99"},
            {"Macarrão Espaguete emb1kg", "89002140", "6,79"},
            {"Refrigerante de Limão", "59021124", "5,59"}
        };
      return precosProdutos;
    }

    

    public static String[][] criarTabelaClienteClube (){

        //[6][2]
        String[][] clientesClube = {
                {"Nome Cliente", "CPF"},
                {"Ana Beatriz da Silva", "123.456.789-09"},
                {"João Pedro Oliveira", "987.654.321-00"},
                {"Cláudia Costa Ferreira", "456.123.789-32"},
                {"Carlos Eduardo Almeida", "321.654.987-45"},
                {"Sofia Ribeiro Santos", "789.123.456-87"}
            };
        

        return clientesClube;
    }

    public static String[][] criarTabelaDescontos(){
         Random random = new Random();

         int estaçao = random.nextInt(4);

         switch (estaçao) {
            case 1:
                //[4][4]
                String[][] produtosPromocaoOutono ={
                    
                    {"Produto", "Preço Original", "Desconto", "Preço com Desconto"},
                    {"Mandioca (500g)", "R$8,99", "8%", "R$8,27"},
                    {"Macarrão Espaguete (1kg)", "R$6,79", "3%", "R$6,59"},
                    {"Feijão (1kg)", "R$6,68", "9%", "R$6,08"},
                                            };

                return produtosPromocaoOutono;
         
            case 2:
                //[3][4]
                String[][] produtosPromocaoinverno = {
                    {"Produto", "Preço Original", "Desconto", "Preço com Desconto"},
                    {"Creme de Leite", "R$3,19", "7%", "R$2,97"},
                    {"Leite", "R$4,69", "5%", "R$4,46"},
                    
                            };
                return produtosPromocaoinverno;

            case 3:
                //[3][4]
                String[][] produtosPromocaoPrimavera = {
                    {"Produto", "Preço Original", "Desconto", "Preço com Desconto"},
                    {"Pão de Forma", "R$5,94", "10%", "R$5,35"},
                    {"Sabão em Pó (1kg)", "R$27,99", "9%", "R$25,47"},
                    
                            };
                return produtosPromocaoPrimavera;

            case 4:
                //[3][4]
                String[][] produtosPromocaoVerão = {
                    {"Produto", "Preço Original", "Desconto", "Preço com Desconto"},
                    {"Refrigerante de Limão", "R$5,59", "10%", "R$5,03"},
                    {"Arroz (5kg)", "R$25,98", "11%", "R$23,12"}
                    };
                return produtosPromocaoVerão;
        }

    return null;
    }

    public static float calcularTroco (float total, float pagamento){
        float troco = 0;

        troco = total - pagamento;

        return troco;
    }


    public static void pagamento(float totalCompra){
        float quantiaCliente;
        float troco;

        imprimir("Selecione a forma de pagamento. (1 para dinheiro, 2 para cartao, 3 para vale alimentação)");
        int formaPagamento = lerValorInteiro();

        switch (formaPagamento) {
            case 1:
                imprimir("Informe quantia dada pelo cliente");
                quantiaCliente = lerValorReal();
                if (quantiaCliente > totalCompra) {
                    troco = calcularTroco(totalCompra, quantiaCliente);
                }
                break;
        
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
                        }else{
                            imprimir("TRANSAÇÃO RECUSADA");
                            break;
                        }
                
                    case 2:
                    float leitorMaquinaDebitoSaldo = lerValorReal();
                        if (leitorMaquinaDebitoSaldo >= totalCompra) {
                            imprimir("TRANSAÇÃO APROVADA");
                            
                            break;
                        }else{
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
    }


    public static void imprimirNotaFiscal(){

        //impresão da nota fiscal

        System.out.print("________________________________\n"+
                        "|    M3 Comercio de Alimentos    |\n"+
                        "|      Centro, Cascavel Pr       |\n"+
                        "|________________________________|\n"+
                        "|--------------------------------|\n");


                        for
    }
    

    public static void main(String[] args) {
        String[][] produtosPromoçãoSazonal = criarTabelaDescontos();

        ////////////////////////////////////////////
        

        imprimir("Imprimir nota fiscal? 0 para nao 1 para sim");
        boolean finalizar = lerBoolean();
        if (finalizar == true) {
            imprimirNotaFiscal();
        }

        imprimir("OPERAÇÃO FINALIZADA");
    }
}
