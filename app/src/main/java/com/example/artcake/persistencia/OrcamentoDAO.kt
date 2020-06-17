package com.example.artcake.persistencia
import com.example.artcake.model.Orcamento


class OrcamentoDAO {

    companion object {
        private val orcamentos: MutableList<Orcamento> = mutableListOf()
    }


    fun all (): List<Orcamento> {
        return orcamentos
    }

    fun add(vararg orcamento: Orcamento){
        orcamentos.addAll(orcamento)
    }

    fun delete(){
        orcamentos.clear()
    }

}