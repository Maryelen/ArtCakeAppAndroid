package com.example.artcake.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.artcake.R
import com.example.artcake.persistencia.OrcamentoDAO
import com.example.artcake.ui.activity.recyclerView.OrcamentoAdapter
import kotlinx.android.synthetic.main.meus_pedidos.*


class OrcamentoListActivity : AppCompatActivity() {

    private val orcamentoDao = OrcamentoDAO()
    private lateinit var adapter: OrcamentoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.meus_pedidos)
        configureRecyclerView()
        configureFabAddOrcamento()
        configureRemoveButton()
    }

    private fun configureRemoveButton() {
        excluir_btn.setOnClickListener {
            orcamentoDao.delete()
            val openOrcamentoForm = Intent(this, FormOrcamentoActivity::class.java)
            startActivity(openOrcamentoForm)

        }
    }

    private fun configureFabAddOrcamento() {
        add_listOrcamento_btn.setOnClickListener {
            val openOrcamentoForm = Intent(this, FormOrcamentoActivity::class.java)
            startActivity(openOrcamentoForm)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.clearAllOrcamentos(orcamentoDao.all())
    }

    private fun configureRecyclerView() {
        this.adapter = OrcamentoAdapter(context = this)
        orcamento_list_recyclerview.adapter = adapter
    }

    fun removeAt(position: Int) {

    }

}