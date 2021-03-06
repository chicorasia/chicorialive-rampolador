package br.com.chicorialabs.rampolador

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.chicorialabs.rampolador.databinding.ActivityMainBinding
import br.com.chicorialabs.rampolador.extension.formataInclinacao
import br.com.chicorialabs.rampolador.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val inclinacaoTxt by lazy {
        binding.mainInclinacaoResultado
    }

    private val desnivelSld by lazy {
        binding.mainDesnivelSld
    }

    private val comprimentoSld by lazy {
        binding.mainComprimentoSld
    }

    private val comentarioTxt by lazy {
        binding.mainResultadoComentarioTxt
    }

    lateinit private var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initViewModel()
        initDesnivelSld()
        initComprimentoSld()
        initObserver()

    }

    private fun initObserver() {
        mViewModel.inclinacao.observe(this, { inclinacaoCalculada: Double? ->
            inclinacaoTxt.text = "i: ${inclinacaoCalculada?.formataInclinacao()} %"
            comentarioTxt.text = mViewModel.classificacaoRampa.value?.classificacao
            binding.root.setBackgroundColor(getColor(mViewModel.classificacaoRampa.value?.cor
                ?: R.color.piso_plano))
        })
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initComprimentoSld() {
        comprimentoSld.addOnChangeListener { _, value, _ ->
            mViewModel.comprimento.value = value.toDouble()
            mViewModel.atualizaInclinacao()
        }
    }

    private fun initDesnivelSld() {
        desnivelSld.addOnChangeListener { _, value, _ ->
            mViewModel.desnivel.value = value.toDouble()
            mViewModel.atualizaInclinacao()
        }
    }


}