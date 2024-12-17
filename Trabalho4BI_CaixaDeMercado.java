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

    public static int obterPosicaoValorEmTabela(String[][] tabela, int coluna, String dado) {
    //Procura o valor na tabela e retorna a posição
        if (tabela == null) {
            return -1;
        }

        int posicao = -1;

        for (int i = 1; i < tabela.length; i++) {

            if (dado.equals (tabela[i][coluna])) {

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

        if (matrizOriginal[linhas - 1][colunas - 1] != " ") {

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
                { "Sofia Ribeiro Santos", "78912345687" }
        };

        return clientesClube;
    }

    public static int definirEstacao() {

        Random random = new Random();

        int estacao = random.nextInt(4);

        return estacao;
    }

    public static String[][] obterTabelaDescontos(int estação) {

        switch (estação) {
            case 0:
                // [3][4]
                String[][] produtosPromocaoOutono = {

                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "11112034", "R$8,99", "8%", "8.27" },
                        { "00112013", "R$6,68", "9%", "6.08" },
                };

                return produtosPromocaoOutono;

            case 1:
                // [3][4]
                String[][] produtosPromocaoinverno = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "70083254", "R$3,19", "7%", "2.97" },
                        { "70081529", "R$4,69", "5%", "4.46" },

                };
                return produtosPromocaoinverno;

            case 2:
                // [3][4]
                String[][] produtosPromocaoPrimavera = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "89001698", "R$5,94", "10%", "5.35" },
                        { "98780047", "R$27,99", "9%", "25.47" },

                };
                return produtosPromocaoPrimavera;

            case 3:
                // [3][4]
                String[][] produtosPromocaoVerão = {
                        { "Produto", "Preço Original", "Desconto", "Preço com Desconto" },
                        { "59021124", "R$5,59", "10%", "5.03" },
                        { "00001608", "R$25,98", "11%", "23.12" }
                };
                return produtosPromocaoVerão;
        }

        return null;
    }

    public static String[][] acharClienteCadastrado(int estacao) {
        String[][] produtosPromocaoSazonal = new String[3][4];
        String[][] tabelaClientes = obterTabelaClienteClube();

        imprimir("O cliente possui cadastro no clubeM²?(true para sim ou false para não)");
        boolean entrada = lerBoolean();

        if (entrada == true) {
            
            imprimir("Informe o CPF do cliente");
            String cpfCliente = lerTexto();

            for (int i = 1; i < tabelaClientes.length; i++) {

                if (cpfCliente.equals (tabelaClientes[i][TABELA_CLIENTES_CLUBE_CPF])) {

                    imprimir("Cliente encontrado");
                    System.out.println(tabelaClientes[i][TABELA_SISTEMA_COLUNA_NOME]);

                   
                    produtosPromocaoSazonal = obterTabelaDescontos(estacao);
                    break;

                }else{
                    imprimir("-");
                }
            }
        }

        return produtosPromocaoSazonal;
    }

    public static String[][] agregarEmCarrinho(String[][] carrinho, String[][] produtosPromocaoSazonal,
            String[] produto) {

        /*Procura a posição do produto na tabela de descontos e com essa posição, procura o valor do 
        desconto e adiciona no carrinho.*/

        int posicaoDesconto = obterPosicaoValorEmTabela(produtosPromocaoSazonal, TABELA_PROMOCAO_COLUNA_CODIGO,
                produto[TABELA_SISTEMA_COLUNA_CODIGO]);

                String precoFinal = " ";
                String desconto;


        if (posicaoDesconto != -1) {

            desconto = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_DESCONTO];

            precoFinal = produtosPromocaoSazonal[posicaoDesconto][TABELA_PROMOCAO_COLUNA_PRECO_FINAL];
            
        }else{
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
                break;
            }
        }

        return carrinho;

    }

    public static String[][] acharProdutoSistema(String[][] carrinho, String produto,
            String[][] produtosPromoçãoSazonal) {

        /* Verificar se os produtos estão no sistema, limpando assim o carrinho de
        codigos errados.*/

        String[][] tabelaPrecos = obterTabelaPrecos();

        // procura o produto no sistema
        int posicaoProduto = obterPosicaoValorEmTabela(tabelaPrecos, TABELA_SISTEMA_COLUNA_CODIGO, produto);

        if (posicaoProduto == -1) {

            System.out.println("Produto não achado. Tente novamente");
            return carrinho;

        }
        /*  procura se o produto ja foi posto alguma vez anteriormente, se sim, o soma, se não, 
        o adiciona.*/

        int posicaoProdutoCarrinho = obterPosicaoValorEmTabela(carrinho, TABELA_CARRINHO_COLUNA_CODIGO, produto);

        // se não achar, adiciona um novo:
        if (posicaoProdutoCarrinho == -1) {

            carrinho = agregarEmCarrinho(carrinho, produtosPromoçãoSazonal,
                    tabelaPrecos[posicaoProduto]);

        } else {

            // se conseguir, irá soma-lo.

            //trasnforma para int e soma
            int qntProdutos = Integer
                    .parseInt(carrinho[posicaoProdutoCarrinho][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);
            qntProdutos++;

            //transforma novamente para string
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

            if (produto.equals("S")) {
                return carrinho;
            }

            carrinho = aumentarVetor(carrinho);

            carrinho = acharProdutoSistema(carrinho, produto, produtosPromoçãoSazonal);

        }

    }

    

    public static float somaPreçoTotal(String[][] carrinho) {

        //somar todos os preços, com descontos ou não, no valor final da compra
        float somaPrecoTotal = 0;

        for (int i = 1; i < carrinho.length; i++) {

            if (carrinho[i][2] != null && !carrinho[i][2].trim().isEmpty()) {
                 if (carrinho[i][3].equals("0")) {
                    somaPrecoTotal = somaPrecoTotal + Float.parseFloat(carrinho[i][2]);
                    
                 }else{
                     somaPrecoTotal = somaPrecoTotal + Float.parseFloat(carrinho[i][4]);
                 }
            }
        }

        return somaPrecoTotal;
    }

    

    public static Transacao pagamento(float totalCompra) {
        //classe para armazenar o valor em dinheiro que o cliente deu como pagamento e o troco
        Transacao cliente = new Transacao();
        cliente.quantiaDada = 0;
        cliente.troco = 0;

        //loop para que a operação só seja finalizada caso o dinheiro seja o suficiente
        while (true) {
            imprimir("Informe quantia dada pelo cliente");
            cliente.quantiaDada = lerValorReal();

            if (cliente.quantiaDada >= totalCompra) {
                cliente.troco = cliente.quantiaDada - totalCompra;
                break;
            } else {
                imprimir("PAGAMENTO INSUFICIENTE");
                imprimir("Tente um novo valor");
            } 
        }
        

        return cliente;
    }

    public static float calcularTroco(float total, float pagamento) {
        //calculando o troco
        float troco = 0;

        troco = pagamento - troco;

        return troco;
    }

    public static void imprimirNotaFiscal(String[][] carrinho, float somaPrecoTotal, float troco, float quantiaCliente) {

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
            if (!carrinho[i][TABELA_CARRINHO_COLUNA_NOME].equals(" ")) {
                

            vlTotal = Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_PRECO])
                    * Float.parseFloat(carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS]);

            System.out.printf("|s%        s%        s%        s%        f.2%|", carrinho[i][TABELA_CARRINHO_COLUNA_CODIGO],
                    carrinho[i][TABELA_CARRINHO_COLUNA_NOME], carrinho[i][TABELA_CARRINHO_COLUNA_QNTPRODUTOS],
                    carrinho[i][TABELA_CARRINHO_COLUNA_PRECO], vlTotal);
                    }
        }

        System.out.printf("|------------------------------------------|\n" +
                "|Produtos Promocao  Desconto  Preço Final  |");

        for (int i = 0; i < carrinho.length; i++) {

            if (carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO] != "0") {

                System.out.printf("|s%                     s%                s%      |", carrinho[i][TABELA_CARRINHO_COLUNA_NOME],
                        carrinho[i][TABELA_CARRINHO_COLUNA_DESCONTO], carrinho[i][TABELA_CARRINHO_COLUNA_PRECOFINAL]);

            }

        }

        System.out.printf("|------------------------------------------|\n" +
                "|SUBTOTAL                             f.2% |\n",
                somaPrecoTotal +
                        "|------------------------------------------|\n" +
                        "|Total de Items                         d% |\n",
                carrinho.length +
                        "|Valor Total R$                       f.2% |\n",
                somaPrecoTotal +
                        "|Forma de Pagamento              Valor Pago|\n" +
                        "|Dinheiro                             f.2% |\n",
                quantiaCliente +
                        "|Troco                                f.2% |\n",
                troco +
                        "|__________________________________________|\n" +
                        "|     OBRIDADO POR ESCOLHER MERCADOS M²    |\n" +
                        "|              VOLTE SEMPRE!!              |\n" +
                        "|__________________________________________|");

    }

    public static void main(String[] args) {
        

        imprimir("DIGITE 1 PARA INICIAR OPERAÇÃO.");
        int iniciarOperacao = lerValorInteiro();

        if (iniciarOperacao == 1) {

            String[][] produtosPromocaoSazonal = new String[3][4];

            int estacao = definirEstacao();
            // perguntar se tem clube, só se tem procura a promocao.

            System.out.println(estacao);

            produtosPromocaoSazonal = acharClienteCadastrado(estacao);

            String[][] carrinho = passarProdutos(produtosPromocaoSazonal);

            float total = somaPreçoTotal(carrinho);

            System.out.printf("Valor total da compra: R$%.2f %n", total);

            Transacao cliente = pagamento(total);

            System.out.printf("TROCO: R$%.2f %n", cliente.troco);

            imprimir("Imprimir nota fiscal?(true para sim ou false para não)");
            boolean finalizar = lerBoolean();

            if (finalizar == true) {
                imprimirNotaFiscal(carrinho, total, cliente.troco, cliente.quantiaDada);
            }

            imprimir("OPERAÇÃO FINALIZADA");
        }
    }

}
