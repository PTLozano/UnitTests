import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class AcaoTest {
    @Test
    public void efetuaCompra15PorcentoMenor() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = true;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 0.85)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra15PorcentoMaior() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = true;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 1.15)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra16PorcentoMenor() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = false;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 0.84)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra16PorcentoMaior() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = false;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 1.16)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompraQuantidadeMenor() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = true;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(valorAtual);

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual - 100);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompraQuantidadeMaior() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = false;

        // Act
        float valorAtual = acao.getValorAtual();
        acao.setValorCompra(valorAtual);

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual + 100);

        boolean atual = acao.executarOrdem();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void verificaAcaoDisponivel() {
        // Arrange
        Acao acao = new Acao("VALE3");
        boolean esperado = true;

        // Act
        boolean atual = acao.acaoEstaDisponivel();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void verificaAcaoIndisponivel() {
        // Arrange
        Acao acao = new Acao("ITSA3");
        boolean esperado = false;

        // Act
        boolean atual = acao.acaoEstaDisponivel();

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void compraTodoValorCarteira() throws Exception {
        // Arrange
        final String METHOD = "getValorAtual";
        Acao acao = new Acao("PETR4");
        float valorCarteiraCliente = 12750;
        boolean esperado = true;

        // Fica verificando o objeto e altera o objeto
        Acao spy = PowerMockito.spy(acao);
        PowerMockito.when(spy, METHOD).thenReturn((float) 15000.00);

        // Act
        spy.setValorCompra(valorCarteiraCliente);
        spy.executarOrdem();

        boolean atual = spy.ordemFoiExecutada();

        // Assert
        Assert.assertEquals(esperado, atual);
    }
}
