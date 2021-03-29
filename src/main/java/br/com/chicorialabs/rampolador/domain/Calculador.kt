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

}