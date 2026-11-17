package estoque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Caderno", 10);
    }

    @Test
    public void testeEntradaDeProdutos() {
        produto.adicionarUnidades(5);
        assertEquals(15, produto.consultarSaldo(), "O saldo deveria ser 15 após a entrada.");
    }

    @Test
    public void testeSaidaComSaldoSuficiente() {
        boolean sucesso = produto.retirarUnidades(4);
        assertTrue(sucesso, "A retirada deveria ser bem-sucedida.");
        assertEquals(6, produto.consultarSaldo(), "O saldo deveria ser 6 após a retirada.");
    }

    @Test
    public void testeSaidaComSaldoInsuficiente() {
        boolean sucesso = produto.retirarUnidades(15);
        assertFalse(sucesso, "A retirada deveria ser recusada por falta de saldo.");
        assertEquals(10, produto.consultarSaldo(), "O saldo deveria permanecer inalterado em 10.");
    }
}