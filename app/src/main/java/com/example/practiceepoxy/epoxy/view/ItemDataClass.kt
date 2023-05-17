package com.example.practiceepoxy.epoxy.view

import android.widget.TextView
import com.example.practiceepoxy.R
import com.example.practiceepoxy.epoxy.util.KotlinModel

data class ItemDataClass(
    val title: String
) : KotlinModel(R.layout.view_binding_title_item) {

    val titleView by bind<TextView>(R.id.title)

    override fun bind() {
        titleView.text = title
    }
}