package com.ruthwikkk.sample.flowhiltretrofit.adapters

import ac.lsa.lsaedu.adapters.BaseAdapter
import ac.lsa.lsaedu.adapters.BaseViewHolder
import android.view.View
import com.ruthwikkk.sample.flowhiltretrofit.R
import com.ruthwikkk.sample.flowhiltretrofit.databinding.ListCellRocketBinding
import com.ruthwikkk.sample.flowhiltretrofit.models.Rocket
import com.ruthwikkk.sample.flowhiltretrofit.utils.bindings

class RocketsAdapter : BaseAdapter() {


    override fun layout(type: String) = R.layout.list_cell_rocket

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return RocketsViewHolder(view)
    }


    inner class RocketsViewHolder(view: View) : BaseViewHolder(view){

        private val binding: ListCellRocketBinding by bindings(view)

        override fun bindData(item: Any) {
            if(item is Rocket){

                binding.apply {
                    rocket = item
                }
            }
        }
    }
}