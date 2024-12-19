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

    public static int TABELA_CLIENTES_CLUBE_CPF = 1;

    public static void pularLinha() {
        System.out.println();
    }

    public static int lerValorInteiro() {
        int valor = tecladoScanner.nextInt();
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

    public static String[][] criarMatrizPreenchida(int linhas, int colunas, String valorPreenchimento) {

        String[][] matriz = new String[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valorPreenchimento;
            }

        }

        return matriz;
    }

    public static int obterPosicaoValorEmTabela(String[][] tabela, int coluna, String dado) {
        // Procura o valor na tabela e retorna a posição
        if (tabela == null) {
            return -1;
        }

        int posicao = -1;

        for (int i = 1; i < tabela.length; i++) {

            if (dado.equals(tabela[i][coluna])) {

                posicao = i;
                break;

            }

        }

        return posicao;

    }

    public static String[][] aumentarVetor(String[][] matrizOriginal) {
        // metodo que verifica se o vetor encheu, se sim, aumenta o tamanho.

        int linhas = matrizOriginal.length;
        int colunas = matrizOriginal[0].length;

        if (!matrizOriginal[linhas - 1][colunas - 1].equals (" ")) {

            String[][] matrizAumentada = new String[linhas + 10][colunas];

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {

                    matrizAumentada[i][j] = matrizOriginal[i][j];
                }

            }

            return matrizAumentada;
        }

        return matrizOriginal;
    }

    public static String[][] obterTabelaPrecos() {

        // [11][3]
        String[][] precosProdutos = {
                { "Nome", "Código", "Preço" },
                { "Leite", "70081529", "4.69" },
                { "Leite Condensado", "70081678", "6.99" },
                { "Pão de Forma", "89001698", "5.94" },
                { "Arroz (5kg)", "00001608", "25.98" },
                { "Feijão (1kg)", "00112013", "6.68" },
                { "Mandioca  (500g)", "11112034", "8.99" },
                { "Creme de Leite", "70083254", "3.19" },
                { "Sabão em Pó (1kg)", "98780047", "27.99" },
                { "Macarrão Espaguete (1kg)", "89002140", "6.79" },
                { "Refrigerante de Limão(2L)", "59021124", "5.59" }
        };
        return precosProdutos;
    }

    public static String[][] obterTabelaClienteClube() {

        // reducir numero de clientes

        // [6][2]
        String[][] clientesClube = {
                { "Nome Cliente", "CPF" },
                { "Ana Beatriz da Silva", "12345678909" },
                { "João Pedro Oliveira", "98765432100" },
                { "Cláudia Costa Ferreira", "45612378932" },
                { "Carlos Eduardo Almeida", "32165498745" },
                { "Sofia Ribeiro Santos", "78912345687" },
                { "Mestre Oda", "11111111111" },
                { "Lozão ;D", "22222222222" }
        };

        return clientesClube;
    }

    public static int definirEstacao() {

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
                        { "11112034", "R$8,99", "8", "8.27" },
                        { "00112013", "R$6,68", "9", "6.08" },
                };

                return produtosPromocaoOutono;

            case 1:
                // [3][4]
                String[][] produtosPromocaoinverno = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "70083254", "R$3,19", "7", "2.97" },
                        { "70081529", "R$4,69", "5", "4.46" },

                };
                return produtosPromocaoinverno;

            case 2:
                // [3][4]
                String[][] produtosPromocaoPrimavera = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "89001698", "R$5,94", "10", "5.35" },
                        { "98780047", "R$27,99", "9", "25.47" },

                };
                return produtosPromocaoPrimavera;

            case 3:
                // [3][4]
                String[][] produtosPromocaoVerão = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "59021124", "R$5,59", "10", "5.03" },
                        { "00001608", "R$25,98", "11", "23.12" }
                };
                return produtosPromocaoVerão;
        }

        return null;
    }

    public static String[][] acharClienteCadastrado(int estacao) {
        String[][] produtosPromocaoSazonal = new String[3][4];
        String[][] tabelaClientes = obterTabelaClienteClube();

        while (true) {
            pularLinha();
            imprimir("O cliente possui cadastro no clubeM²?(S para sim ou N para não)");
            String entrada = lerTexto();

            if (entrada.equalsIgnoreCase("S")) {
                pularLinha();
                imprimir("Informe o CPF do cliente");
                String cpfCliente = lerTexto();

                for (int i = 1; i < tabelaClientes.length; i++) {

                    if (cpfCliente.equals(tabelaClientes[i][TABELA_CLIENTES_CLUBE_CPF])) {

                        imprimir("Cliente encontrado: " + tabelaClientes[i][TABELA_SISTEMA_COLUNA_NOME]);
                        pularLinha();

                        produtosPromocaoSazonal = obterTabelaDescontos(estacao);
                        return produtosPromocaoSazonal;

                    } else if (i == tabelaClientes.length - 1) {
                        pularLinha();
                        imprimir("Cliente não encontrado");
                        imprimir("Deseja tentar novamente?(S para Sim N para Nao)");
                        String finalizar = lerTexto();

                        while (true) {
                            if (finalizar.equalsIgnoreCase("S")) {

                                break;
                            } else if (finalizar.equalsIgnoreCase("N")) {
                                return produtosPromocaoSazonal;
                            } else {
                                pularLinha();
                                imprimir("entrada inválida");
                                imprimir("tente novamente");
                            }
                        }

                    }
                }

            } else if (entrada.equalsIgnoreCase("N")) {
                return produtosPromocaoSazonal;
            } else {
                imprimir("entrada inválida");
                imprimir("tente novamente");
            }
        }

    }

    public static String[][] agregarPromocaoEmCarrinho(String[][] carrinho, String[][] produtosPromocaoSazonal,
            String[] produto) {

        /*
         * Procura a posição do produto na tabela de descontos e com essa posição,
         * procura o valor do
         * desconto e adiciona no carrinho.
         */

        int posicaoDesconto = obterPosicaoValorEmTabela(produtosPromocaoSazonal, TABELA_PROMOCAO_COLUNA_CODIGO,
                produto[TABELA_SISTEMA_COLUNA_CODIGO]);

        String precoFinal = " ";
        String desconto;

        if (posicaoDesconto != -1) {

            desconto = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_DESCONTO];

            precoFinal = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_PRECO_FINAL];

        } else {
            desconto = "0";
        }

        // agregar/adicionar

        for (int i = 1; i < carrinho.length; i++) {

            if (carrinho[i][TABELA_CARRINHO_COLUNA_NOME].equals(" ")) {
                carrinho[i][TABELA_CARRINHO_COLUNA_NOME] = produto[TABELA_SISTEMA_COLUNA_NOME];
                carrinho[i][TABELA_CARRINHO_COLUNA_CODIGO] = produto[TABELA_SISTEMA_COLUNA_CODIGO];
                carrinho[i][TABELA_CARRINHO_COLUNA_PRECO] = produto[TABELA_SISTEMA_COLUNA_PRECO];
                carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] = desconto;
                carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL] = precoFinal;
                carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS] = "1"; // Inicializa com um produto
                break;
            }
        }

        return carrinho;

    }

    public static String[][] acharProdutoSistema(String[][] carrinho, String produto,
            String[][] produtosPromoçãoSazonal) {

        /*
         * Verificar se os produtos estão no sistema, limpando assim o carrinho de
         * codigos errados.
         */

        String[][] tabelaPrecos = obterTabelaPrecos();

        // procura o produto no sistema
        int posicaoProduto = obterPosicaoValorEmTabela(tabelaPrecos, TABELA_SISTEMA_COLUNA_CODIGO, produto);

        if (posicaoProduto == -1) {

            pularLinha();
            imprimir("Produto não encontrado. Tente novamente");
            return carrinho;

        }
        /*
         * procura se o produto ja foi posto alguma vez anteriormente, se sim, o soma,
         * se não,
         * o adiciona.
         */

        int posicaoProdutoCarrinho = obterPosicaoValorEmTabela(carrinho, TABELA_CARRINHO_COLUNA_CODIGO, produto);

        // se não achar, adiciona um novo:
        if (posicaoProdutoCarrinho == -1) {

            carrinho = agregarPromocaoEmCarrinho(carrinho, produtosPromoçãoSazonal,
                    tabelaPrecos[posicaoProduto]);

        } else {

            // se conseguir, irá soma-lo.

            // trasnforma para int e soma
            int qntProdutos = Integer.parseInt(carrinho[posicaoProdutoCarrinho][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);
            qntProdutos++;

            // transforma novamente para string
            carrinho[posicaoProdutoCarrinho][TABELA_CARRINHO_COLUNA_QNTPRODUTOS] = Integer
                    .toString(qntProdutos);

        }

        return carrinho;

    }

    public static String[][] passarProdutos(String[][] produtosPromoçãoSazonal) {

        // metodo para Scannear codigos

        String[][] carrinho = criarMatrizPreenchida(10, 6, " ");

        String produto;

        pularLinha();
        imprimir("SCANNER");

        while (true) {

            imprimir("Digite o código do produto.(S para sair)");
            produto = lerTexto();
            pularLinha();

            if (produto.equalsIgnoreCase("S")) {
                return carrinho;
            }

            carrinho = aumentarVetor(carrinho);

            carrinho = acharProdutoSistema(carrinho, produto, produtosPromoçãoSazonal);

        }

    }

    public static float somaPreçoTotal(String[][] carrinho) {

        // somar todos os preços, com descontos ou não, no valor final da compra
        float somaPrecoTotal = 0;

        for (int i = 1; i < carrinho.length; i++) {

            if (!carrinho[i][TABELA_CARRINHO_COLUNA_PRECO].trim().isEmpty()) {
                if (carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO].equals("0")) {

                    somaPrecoTotal += Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO])
                            * Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

                } else {
                    somaPrecoTotal += Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL])
                            * Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

                }
            }
        }

        return somaPrecoTotal;
    }

    public static Transacao pagamento(float totalCompra) {
        // classe para armazenar o valor em dinheiro que o cliente deu como pagamento e
        // o troco
        Transacao cliente = new Transacao();
        cliente.quantiaDada = 0;
        cliente.troco = 0;

        // loop para que a operação só seja finalizada caso o dinheiro seja o suficiente
        while (true) {
            imprimir("Informe quantia dada pelo cliente");
            cliente.quantiaDada = lerValorReal();

            if (cliente.quantiaDada >= totalCompra) {
                cliente.troco = cliente.quantiaDada - totalCompra;
                break;
            } else {
                pularLinha();
                imprimir("PAGAMENTO INSUFICIENTE");
                imprimir("Tente um novo valor");
            }
        }

        return cliente;
    }

    public static float calcularTroco(float total, float pagamento) {
        // calculando o troco
        float troco = 0;

        troco = pagamento - troco;

        return troco;
    }

    public static void imprimirNotaFiscal(String[][] carrinho, float somaPrecoTotal, float troco,
            float quantiaCliente) {

        // loop para aceitar somente caracteres válidos
        while (true) {
            pularLinha();
            imprimir("Imprimir nota fiscal?(S para sim ou N para não)");
            String finalizar = lerTexto();

            if (finalizar.equalsIgnoreCase("S")) {

                float vlTotal = 0;
                int qntItems = 0;

                // impresão da nota fiscal

                System.out.print("___________________________________________\n" +
                        "|       M² Comercio de Alimentos           |\n" +
                        "|          Centro, Cascavel Pr             |\n" +
                        "|__________________________________________|\n" +
                        "|------------------------------------------|\n" +
                        "|Codigo   Descrição   Qnt Vl.Unit Vl.Total |\n" +
                        "|                                          |\n");

                for (int i = 0; i < carrinho.length; i++) {
                    if (!carrinho[i][TABELA_CARRINHO_COLUNA_NOME].equals(" ")) {

                        qntItems += Integer.parseInt(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

                        vlTotal = Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO])
                                * Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

                        System.out.printf("|%-8s %-11s %-5s R$%-4.2f R$%-6.2f|\n",
                                carrinho[i][TABELA_CARRINHO_COLUNA_CODIGO],
                                carrinho[i][TABELA_CARRINHO_COLUNA_NOME],
                                carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS],
                                Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO]),
                                vlTotal);

                    }
                }

                System.out.printf("|------------------------------------------|\n");

                int valorExistente = 0;

                for (int i = 0; i < carrinho.length; i++) {

                    if (carrinho[i][TABELA_CARRINHO_COLUNA_NOME] != " ") {

                        if (carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] != "0") {

                            valorExistente = 1;
                            break;

                        }
                    }
                }

                if (valorExistente == 1) {

                    System.out.printf("|Produtos Promocao  Desconto  Preço Final  |\n");

                    for (int i = 0; i < carrinho.length; i++) {

                        if (carrinho[i][TABELA_CARRINHO_COLUNA_NOME] != " ") {

                            if (carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] != "0") {

                                System.out.printf("|%s                     %.1f%%    R$%.2f      |\n",
                                        carrinho[i][TABELA_CARRINHO_COLUNA_NOME],
                                        Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO]),
                                        Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL]));

                            }

                        }

                    }
                }

                System.out.printf("|------------------------------------------|\n");
                System.out.printf("|SUBTOTAL                             %.2f|\n", somaPrecoTotal);
                System.out.printf("|------------------------------------------|\n");
                System.out.printf("|Total de Items                          %d|\n", qntItems);
                System.out.printf("|Valor Total R$                       %.2f|\n", somaPrecoTotal);
                System.out.printf("|Forma de Pagamento              Valor Pago|\n");
                System.out.printf("|Dinheiro                            %.2f|\n", quantiaCliente);
                System.out.printf("|Troco                                %.2f|\n", troco);
                System.out.printf("|__________________________________________|\n");
                System.out.printf("|     OBRIDADO POR ESCOLHER MERCADOS M²    |\n");
                System.out.printf("|              VOLTE SEMPRE!!              |\n");
                System.out.printf("|__________________________________________|\n");
                pularLinha();

                break;

            } else if (finalizar.equalsIgnoreCase("N")) {
                break;
            } else {
                imprimir("entrada inválida");
                imprimir("tente novamente");
            }
        }

    }

    

    public static void main(String[] args) {

        imprimir("DIGITE 1 PARA INICIAR OPERAÇÃO.");
        int iniciarOperacao = lerValorInteiro();

        if (iniciarOperacao == 1) {

            String[][] produtosPromocaoSazonal = new String[3][4];

            int estacao = definirEstacao();

            produtosPromocaoSazonal = acharClienteCadastrado(estacao);

            String[][] carrinho = passarProdutos(produtosPromocaoSazonal);

            float total = somaPreçoTotal(carrinho);
            pularLinha();
            System.out.printf("Valor total da compra: R$%.2f %n", total);

            Transacao cliente = pagamento(total);
            pularLinha();
            System.out.printf("TROCO: R$%.2f %n", cliente.troco);

            imprimirNotaFiscal(carrinho, total, cliente.troco, cliente.quantiaDada);

            imprimir("OPERAÇÃO FINALIZADA.");
        } else {
            imprimir("TENHA UM BOM DIA!");
        }
    }

    //Madai : Obrigado profesores por tudo, realmente aprecio seu esforço e paciência! Aprendi más do que alguma vez sonhei. Feliz Natal e Ano Novo!

}
