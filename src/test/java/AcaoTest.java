import org.junit.Assert;
import org.junit.Test;

public class AcaoTest {
    @Test
    public void efetuaCompra15PorcentoMenor(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 0.85)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();
        boolean esperado = true;

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra15PorcentoMaior(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 1.15)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();
        boolean esperado = true;

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra16PorcentoMenor(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 0.84)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();
        boolean esperado = false;

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompra16PorcentoMaior(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(((float) (valorAtual * 1.16)));

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual);

        boolean atual = acao.executarOrdem();
        boolean esperado = false;

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompraQuantidadeMenor(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(valorAtual);

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual - 100);

        boolean atual = acao.executarOrdem();
        boolean esperado = true;

        // Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void efetuaCompraQuantidadeMaior(){
        // Arrange
        Acao acao = new Acao("VALE3");

        // Act
        float valorAtual= acao.getValorAtual();
        acao.setValorCompra(valorAtual);

        int quantidadeAtual = acao.getQuantidadeAtual();
        acao.setQuantidadeCompra(quantidadeAtual + 100);

        boolean atual = acao.executarOrdem();
        boolean esperado = false;

        // Assert
        Assert.assertEquals(esperado, atual);
    }


}
