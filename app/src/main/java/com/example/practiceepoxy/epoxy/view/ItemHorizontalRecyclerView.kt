package com.example.practiceepoxy.epoxy.view

import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.practiceepoxy.R
import com.example.practiceepoxy.epoxy.util.KotlinModel
import com.example.practiceepoxy.item_decoration.HorizontalItemDecoration
import com.example.practiceepoxy.model.Product

data class ItemHorizontalRecyclerView(
    var isInit:Boolean,
    val list: List<Product>,
    val listener:(Product)->Unit,
) : KotlinModel(R.layout.horizontal_recycler_view) {

    val view by bind<EpoxyRecyclerView>(R.id.rv_horizontal)

    override fun bind() {
        for (i in 0 until view.itemDecorationCount)
            view.removeItemDecorationAt(i)
        view.addItemDecoration(HorizontalItemDecoration())
        view.withModels {
            list.forEachIndexed { index, product ->
                horizontalItemViewBindingEpoxyHolder {
                    id("product$index")
                    title("product$index")
                    desc("desc$index")
                    imageRes(R.drawable.baseline_cruelty_free_24)
                    listener {
                        listener.invoke(product)
                    }
                }
            }
        }
        if(!isInit){
            view.post {
                if(list.lastIndex >= 0)
                view.smoothScrollToPosition(list.lastIndex)
            }
            isInit = true
        }

    }
}