package estoque;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueSteps {

    private Produto produto;
    private boolean resultadoRetirada;

    @Dado("que o produto {string} possui {int} unidades em estoque")
    public void que_o_produto_possui_unidades_em_estoque(String nome, int qtdInicial) {
        produto = new Produto(nome, qtdInicial);
    }

    @Quando("eu adiciono {int} unidades ao estoque")
    public void eu_adiciono_unidades_ao_estoque(int qtd) {
        produto.adicionarUnidades(qtd);
    }

    @Quando("eu solicito a retirada de {int} unidades")
    public void eu_solicito_a_retirada_de_unidades(int qtd) {
        resultadoRetirada = produto.retirarUnidades(qtd);
    }

    @Então("a retirada deve ser aprovada")
    public void a_retirada_deve_ser_aprovada() {
        assertTrue(resultadoRetirada, "A retirada deveria ter sido permitida.");
    }

    @Então("a retirada deve ser recusada")
    public void a_retirada_deve_ser_recusada() {
        assertFalse(resultadoRetirada, "A retirada deveria ter sido recusada.");
    }

    @Então("o saldo do estoque deve ser {int} unidades")
    public void o_saldo_do_estoque_deve_ser_unidades(int saldoEsperado) {
        assertEquals(saldoEsperado, produto.consultarSaldo());
    }
}