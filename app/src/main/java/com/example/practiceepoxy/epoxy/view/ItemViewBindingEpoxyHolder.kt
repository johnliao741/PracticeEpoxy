package com.example.practiceepoxy.epoxy.view

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.practiceepoxy.R
import com.example.practiceepoxy.databinding.ViewBindingHolderItemBinding
import com.example.practiceepoxy.epoxy.util.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass
abstract class ItemViewBindingEpoxyHolder : ViewBindingEpoxyModelWithHolder<ViewBindingHolderItemBinding>(R.layout.view_binding_holder_item){
    @EpoxyAttribute  var listener:(() -> Unit)? = null
    @EpoxyAttribute var imageRes : Int? = null
    @EpoxyAttribute lateinit var title : String
    @EpoxyAttribute lateinit var desc : String
    override fun ViewBindingHolderItemBinding.bind() {
        imageRes?.run {
            img.setImageResource(this)
        }
        itemView.setOnClickListener {
            listener?.invoke()
        }
        desc.text = this@ItemViewBindingEpoxyHolder.desc
        title.text = this@ItemViewBindingEpoxyHolder.title

    }

    override fun getDefaultLayout(): Int {
        return R.layout.view_binding_holder_item
    }
}