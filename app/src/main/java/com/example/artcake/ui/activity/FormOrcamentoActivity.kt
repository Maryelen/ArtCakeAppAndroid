package com.example.artcake.ui.activity

import android.content.Context;
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.artcake.R
import com.example.artcake.model.Orcamento
import com.example.artcake.persistencia.OrcamentoDAO
import com.example.artcake.ui.activity.recyclerView.OrcamentoAdapter
import kotlinx.android.synthetic.main.meus_pedidos.*
import kotlinx.android.synthetic.main.orcamento.*
import android.widget.Toast


class FormOrcamentoActivity : AppCompatActivity() {


        private val orcamentoDao = OrcamentoDAO()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.orcamento)
            configureSaveButton()
            configureCancelButton()

        }

        private fun configureSaveButton() {
            salvarPedido_btn.setOnClickListener {
                saveOrcamento()
                finish()
            }
        }

    private fun configureCancelButton() {
        cancelar_btn.setOnClickListener {
            setContentView(com.example.artcake.R.layout.meus_pedidos)
            finish()
        }
    }

           private fun saveOrcamento() {
            val created = createOrcamento()
         orcamentoDao.add(created)
            }

    private fun createOrcamento(): Orcamento {
        val tipoBolo = form_tipoBolo.editText?.text.toString()
        val saborBolo = form_saborBolo.editText?.text.toString()
        val temaBolo = form_temaBolo.editText?.text.toString()
        val qntPessoas = form_qntPessoas.editText?.text.toString().toInt()
        val retirarLocal = form_retirarLocal.editText?.text.toString()
        val dataEvento = form_dataEvento.editText?.text.toString()
        return Orcamento(tipoBolo = tipoBolo, saborBolo = saborBolo, temaBolo = temaBolo, qntPessoas = qntPessoas, retirarLocal = retirarLocal,
            dataEvento = dataEvento )
    }



}