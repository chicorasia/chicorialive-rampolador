package br.com.chicorialabs.rampolador.domain

import org.junit.Assert.*
import org.junit.Test

class CalculadorTest {

    @Test
    fun deve_RetornarClassificacaoPisoPlano_QuandoRecebeInclinacaoZero(){

        //instanciar o calculador
        val calculador = Calculador()
        val inclinacao = calculador.calculaInclinacao(0.0, 1.0)
        val classificacaoRampa: ClassificacaoRampa = calculador.analisaInclinacao(inclinacao)
        assertEquals(ClassificacaoRampa.PISO_PLANO, classificacaoRampa)

    }

    @Test
    fun deve_RetornarClassificacaoRampaConfortavel_QuandoRecebeInclinacaoAbaixoDe625(){

        //instanciar o calculador
        val calculador = Calculador()
        val inclinacao = calculador.calculaInclinacao(0.5, 10.0)
        val classificacaoRampa: ClassificacaoRampa = calculador.analisaInclinacao(inclinacao)
        assertEquals(ClassificacaoRampa.RAMPA_CONFORTAVEL, classificacaoRampa)

    }

    @Test
    fun deve_RetornarClassificacaoRampaDesafiadora_QuandoRecebeInclinacaoAte800(){

        //instanciar o calculador
        val calculador = Calculador()
        val inclinacao = calculador.calculaInclinacao(0.8, 10.0)
        val classificacaoRampa: ClassificacaoRampa = calculador.analisaInclinacao(inclinacao)
        assertEquals(ClassificacaoRampa.RAMPA_DESAFIADORA, classificacaoRampa)

    }

    @Test
    fun deve_RetornarClassificacaoRampaLimite_QuandoRecebeInclinacaoAte833(){

        //instanciar o calculador
        val calculador = Calculador()
        val inclinacao = calculador.calculaInclinacao(0.99, 12.0)
        val classificacaoRampa: ClassificacaoRampa = calculador.analisaInclinacao(inclinacao)
        assertEquals(ClassificacaoRampa.RAMPA_LIMITE, classificacaoRampa)
    }

    @Test
    fun deve_RetornarClassificacaoExcessoInclinacao_QuandoRecebeInclinacaoSuperiorA833(){

        //instanciar o calculador
        val calculador = Calculador()
        val inclinacao = calculador.calculaInclinacao(1.0, 10.0)
        val classificacaoRampa: ClassificacaoRampa = calculador.analisaInclinacao(inclinacao)
        assertEquals(ClassificacaoRampa.EXCESSO_DE_INCLINACAO, classificacaoRampa)
    }

}