package com.example.practiceepoxy.epoxy.view

import com.example.practiceepoxy.epoxy.util.ViewBindingKotlinModel
import com.example.practiceepoxy.R
import com.example.practiceepoxy.databinding.ViewBindingTitleItemBinding

data class ItemViewBindingDataClass(
    val title: String
) : ViewBindingKotlinModel<ViewBindingTitleItemBinding>(R.layout.view_binding_title_item) {
    override fun ViewBindingTitleItemBinding.bind() {
        title.text = this@ItemViewBindingDataClass.title
    }
}