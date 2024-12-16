import java.util.Random;
import java.util.Scanner;

public class Trabalho4BI_CaixaDeMercado {

    public static Scanner tecladoScanner = new Scanner(System.in);

    // Constantes

    public static int TABELA_SISTEMA_COLUNA_NOME = 0;
    public static int TABELA_SISTEMA_COLUNA_CODIGO = 1;
    public static int TABELA_SISTEMA_COLUNA_PRECO = 2;

    public static int TABELA_CARRINHO_COLUNA_NOME = 0;
    public static int TABELA_CARRINHO_COLUNA_CODIGO = 1;
    public static int TABELA_CARRINHO_COLUNA_PRECO = 2;
    public static int TABELA_CARRINHO_COLUNA_DESCONTO = 3;
    public static int TABELA_CARRINHO_COLUNA_PRECOFINAL = 4;
    public static int TABELA_CARRINHO_COLUNA_QNTPRODUTOS = 5;

    public static int TABELA_PROMOCAO_COLUNA_CODIGO = 0;
    public static int TABELA_PROMOCAO_COLUNA_PRECO_INICIAL = 1;
    public static int TABELA_PROMOCAO_COLUNA_DESCONTO = 2;
    public static int TABELA_PROMOCAO_COLUNA_PRECO_FINAL = 3;

    public static final float quantiaCliente = 0;

    public static int TABELA_CLIENTES_CLUBE_CPF = 1;

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

    public static void imprimirVetorString(int[] vetor) {

        for (int i = /*  */ 0; i < vetor.length; i++) {
            System.out.printf("[%d]:  %d\n", i, vetor[i]);
        }
    }

    public static String[][] criarMatrizPreenchida(int linhas, int colunas, String valorPreenchimento) {

        String[][] matriz = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valorPreenchimento;
            }

        }

        return matriz;
    }

    public static int procurarValorEmTabela(String[][] tabela, int coluna, String dado) {

        int posicao = -1;

        for (int i = 1; i < tabela.length; i++) {

            if (dado == tabela[i][coluna]) {

                posicao = i;
                break;

            }

        }

        return posicao;

    }

    public static String[][] aumentarVetor(String[][] matrizMae) {
        // metodo que verifica se o vetor encheu, se sim, aumenta o tamanho.

        int linhas = matrizMae.length;
        int colunas = matrizMae[0].length;

        if (matrizMae[linhas - 1][colunas] != " ") {

            String[][] matrizAumentada = new String[linhas + 10][colunas];

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < linhas; j++) {

                    matrizAumentada[i][j] = matrizMae[i][j];
                }

            }

            return matrizAumentada;
        }

        return matrizMae;
    }

    public static String[][] acharProdutoSistema(String[][] carrinho, String produto,
            String[][] produtosPromoçãoSazonal) {

        // Verificar se os produtos estão no sistema, limpando assim o carrinho de
        // codigos errados.

        String[][] tabelaPrecos = obterTabelaPrecos();

        // busco si hay ese produto en el sistema
        int posicaoProduto = procurarValorEmTabela(tabelaPrecos, TABELA_SISTEMA_COLUNA_CODIGO, produto);

        if (posicaoProduto == -1) {

            System.out.println("Produto não achado. Tente novamente");
            return carrinho;

        }
        // busco si ya he colocado ese producto anteriormente, si si, lo sumo, si no, lo
        // agrego.

        int posicaoProdutoCarrinho = procurarValorEmTabela(carrinho, TABELA_CARRINHO_COLUNA_CODIGO, produto);

        // si no lo consiguio, agrego uno nuevo:
        if (posicaoProdutoCarrinho == -1) {

            carrinho = agregarEmCarrinho(carrinho, produtosPromoçãoSazonal,
                    tabelaPrecos[posicaoProduto]);

        } else {

            // si lo consiguio, sumo.

            int qntProdutos = Integer
                    .parseInt(carrinho[posicaoProdutoCarrinho][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);
            qntProdutos++;

            carrinho[posicaoProdutoCarrinho][TABELA_CARRINHO_COLUNA_QNTPRODUTOS] = Integer
                    .toString(qntProdutos);

        }

        return carrinho;

    }

    public static String[][] passarProdutos(String[][] produtosPromoçãoSazonal) {

        // metodo para Scannear codigos

        String[][] carrinho = criarMatrizPreenchida(10, 6, " ");

        String produto;

        while (true) {

            imprimir("Digite o código do produto.(S para sair)");
            produto = lerTexto();

            if (produto == "S") {
                break;
            }

            carrinho = aumentarVetor(carrinho);

            carrinho = acharProdutoSistema(carrinho, produto, produtosPromoçãoSazonal);

        }

        return carrinho;

    }

    public static float somaPreçoTotal(String[][] carrinho) {

        float somaPrecoTotal = 0;

        for (int i = 0; i < carrinho.length; i++) {

            if (carrinho[i][TABELA_CARRINHO_COLUNA_PRECO] == carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL]) {
                somaPrecoTotal = somaPrecoTotal + Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO]);
            } else {
                somaPrecoTotal = somaPrecoTotal + Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL]);

            }

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

    public static String[][] obterTabelaClienteClube() {

        // reducir numero de clientes

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

    public static int definirEstacao() {

        // erro: o 0 também vai ser contado, então estaria contando 5 estações
        Random random = new Random();

        int estacao = random.nextInt(3);

        return estacao;
    }

    public static String[][] obterTabelaDescontos(int estação) {

        switch (estação) {
            case 0:
                // [3][4]
                String[][] produtosPromocaoOutono = {

                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "11112034", "R$8,99", "8%", "R$8,27" },
                        { "00112013", "R$6,68", "9%", "R$6,08" },
                };

                return produtosPromocaoOutono;

            case 1:
                // [3][4]
                String[][] produtosPromocaoinverno = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "70083254", "R$3,19", "7%", "R$2,97" },
                        { "70081529", "R$4,69", "5%", "R$4,46" },

                };
                return produtosPromocaoinverno;

            case 2:
                // [3][4]
                String[][] produtosPromocaoPrimavera = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "89001698", "R$5,94", "10%", "R$5,35" },
                        { "98780047", "R$27,99", "9%", "R$25,47" },

                };
                return produtosPromocaoPrimavera;

            case 3:
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
        float troco = -1;

        imprimir("Informe quantia dada pelo cliente");
        float quantiaCliente = lerValorReal();

        if (quantiaCliente > totalCompra) {
            troco = calcularTroco(totalCompra, quantiaCliente);
            return troco;
        } else if (quantiaCliente == totalCompra) {
            troco = 0;
            return troco;
        } else {
            imprimir("quantia insuficiente");
        }

        return troco;
    }

    public static void imprimirNotaFiscal(String[][] carrinho, int somaPrecoTotal, int troco, int quantiaCliente) {

        float vlTotal = 0;

        // impresão da nota fiscal

        System.out.print("__________________________________________\n" +
                "|       M² Comercio de Alimentos           |\n" +
                "|          Centro, Cascavel Pr             |\n" +
                "|__________________________________________|\n" +
                "|------------------------------------------|\n" +
                "|Codigo   Descrição   Qnt Vl.Unit Vl.Total |\n" +
                "|                                          |\n");

        for (int i = 0; i < carrinho.length; i++) {

            vlTotal = Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO])
                    * Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

            System.out.printf("|s%  s%  s%  s%  f.2%|", carrinho[i][TABELA_CARRINHO_COLUNA_CODIGO],
                    carrinho[i][TABELA_CARRINHO_COLUNA_NOME], carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS],
                    carrinho[i][TABELA_CARRINHO_COLUNA_PRECO], vlTotal);

        }

        System.out.printf("|------------------------------------------|\n" +
                "|Produtos Promocao  Desconto  Preço Final  |");

        for (int i = 0; i < carrinho.length; i++) {

            if (carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] != "0") {

                System.out.printf("|s%  s%  s%|", carrinho[i][TABELA_CARRINHO_COLUNA_NOME],
                        carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO], carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL]);

            }

        }


        System.out.printf("|------------------------------------------|\n" +
                          "|SUBTOTAL                             f.2% |\n", somaPrecoTotal +
                          "|------------------------------------------|\n" +
                          "|Total de Items                         d% |\n", carrinho.length +
                          "|Valor Total R$                       f.2% |\n", somaPrecoTotal +
                          "|Forma de Pagamento              Valor Pago|\n" +
                          "|Dinheiro                             f.2% |\n", quantiaCliente +
                          "|Troco                                f.2% |\n" +
                          "|__________________________________________|\n" +
                          "|     OBRIDADO POR ESCOLHER MERCADOS M²    |\n" +
                          "|              VOLTE SEMPRE!!              |\n" +
                          "|__________________________________________|"
                          );


        
    }=new String[3][4];

    public static String[][] agregarEmCarrinho(String[][] carrinho, String[][] produtosPromocaoSazonal,
            String[] produto) {

        // buscar la posicion del producto en los descuentos e com essa posicion, busco
        // el desceunto y lo asigno en el carrinho.
        int posicaoDesconto = procurarValorEmTabela(produtosPromocaoSazonal, TABELA_PROMOCAO_COLUNA_CODIGO,
                produto[TABELA_SISTEMA_COLUNA_CODIGO]);

        String precoFinal = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_PRECO_INICIAL];
        String desconto = "0";

        if (posicaoDesconto != -1) {

            desconto = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_DESCONTO];

            precoFinal = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_PRECO_FINAL];
        }

        // agregar/adicionar

        for (int i = 1; i < carrinho.length; i++) {

            if (carrinho[i][TABELA_CARRINHO_COLUNA_NOME] == " ") {
                carrinho[i][TABELA_CARRINHO_COLUNA_NOME] = produto[TABELA_SISTEMA_COLUNA_NOME];
                carrinho[i][TABELA_CARRINHO_COLUNA_CODIGO] = produto[TABELA_SISTEMA_COLUNA_CODIGO];
                carrinho[i][TABELA_CARRINHO_COLUNA_PRECO] = produto[TABELA_SISTEMA_COLUNA_PRECO];
                carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] = desconto;
                carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL] = precoFinal;
                break;
            }
        }

        return carrinho;

    }

    public static String[][] acharClienteCadastrado(int estacao){
        String[][] tabelaClientes = obterTabelaClienteClube();

        imprimir("O cliente possui cadastro no clubeM²?(true para sim ou false para não)");
        boolean entrada = lerBoolean();

        if (entrada == true) {
            String[][] produtosPromocaoSazonal = new String[3][4];

            String cpfCliente = lerTexto();

            for (int i = 0; i < tabelaClientes.length; i++) {

                if (cpfCliente == tabelaClientes[i][TABELA_CLIENTES_CLUBE_CPF]) {

                    produtosPromocaoSazonal = obterTabelaDescontos(estacao);

                }

            }

            return produtosPromocaoSazonal;
        }

        return null;
    }

    public static void main(String[] args) {

        imprimir("DIGITE 1 PARA INICIAR OPERAÇÃO.");
        int iniciarOperacao = lerValorInteiro();

        if (iniciarOperacao == 1) {

            String[][] produtosPromocaoSazonal = new String[3][4];

            int estacao = definirEstação();
            // perguntar se tem clube, só se tem procura a promocao.

            acharClienteCadastrado(estacao);

            String[][] carrinho = passarProdutos(produtosPromocaoSazonal);

            float total = somaPreçoTotal(carrinho);

            float troco = pagamento(total);

            imprimir("TROCO: " + troco);

            imprimir("Imprimir nota fiscal?(true para sim ou false para não)");
            boolean finalizar = lerBoolean();

            if (finalizar == true) {
                //imprimirNotaFiscal(carrinho, total, troco quantiaCliente);
            }

            imprimir("OPERAÇÃO FINALIZADA");
        }
    }

}
