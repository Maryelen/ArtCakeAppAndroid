package com.example.artcake.ui.activity.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.artcake.R
import com.example.artcake.model.Orcamento
import kotlinx.android.synthetic.main.meus_pedidos.*
import kotlinx.android.synthetic.main.orcamento_item.view.*


class OrcamentoAdapter (

    private val orcamentos: MutableList<Orcamento> = mutableListOf(),
    private val context: Context) : RecyclerView.Adapter<OrcamentoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createdView = LayoutInflater.from(context).inflate(R.layout.orcamento_item, parent, false)
        return ViewHolder(createdView)
    }

    override fun getItemCount(): Int {
        return orcamentos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orcamento = orcamentos[position]
        holder.bind(orcamento)
    }

    fun add(orcamento: List<Orcamento>) {
        this.orcamentos.addAll(orcamento)
        notifyItemRangeInserted(0, orcamento.size)
    }

    fun clearAllOrcamentos(orcamentos: List<Orcamento>) {
        this.orcamentos.clear()
        this.orcamentos.addAll(orcamentos)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        this.orcamentos.removeAt(position)
        notifyItemRemoved(position)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tipoBolo: TextView = itemView.orcamento_item_tipoBolo
        private val saborBolo: TextView = itemView.orcamento_item_saborBolo
        private val temaBolo: TextView = itemView.orcamento_item_temaBolo
        private val qntPessoas: TextView = itemView.orcamento_item_qndtPessoas
        private val retirarLocal: TextView = itemView.orcamento_item_retirarLocal
        private val dataEvento: TextView = itemView.orcamento_item_dataEvento

        fun bind(orcamento: Orcamento) {
            tipoBolo.text = orcamento.tipoBolo
            saborBolo.text = orcamento.saborBolo
            temaBolo.text = orcamento.temaBolo
            qntPessoas.text = orcamento.qntPessoas.toString()
            retirarLocal.text = orcamento.retirarLocal
            dataEvento.text = orcamento.dataEvento
        }
    }
}
