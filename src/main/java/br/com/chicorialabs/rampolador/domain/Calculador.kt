package br.com.chicorialabs.rampolador.domain

class Calculador {


    fun calculaInclinacao(dH: Double?, dL: Double?): Double {

        try {
            if (dH != null && dL != null){
                return dH / dL *100
            }
        } catch (ex: ArithmeticException) {
            ex.printStackTrace()
        }

        return Double.POSITIVE_INFINITY
    }

    fun analisaInclinacao(inclinacao: Double): ClassificacaoRampa {
        return when(inclinacao){
            in 0.0..0.01 -> ClassificacaoRampa.PISO_PLANO
            in 0.01..6.25 -> ClassificacaoRampa.RAMPA_CONFORTAVEL
            in 6.26..8.00 -> ClassificacaoRampa.RAMPA_DESAFIADORA
            in 8.01..8.33 -> ClassificacaoRampa.RAMPA_LIMITE
            else -> ClassificacaoRampa.EXCESSO_DE_INCLINACAO
        }
    }


}