package com.example.practiceepoxy.epoxy.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.practiceepoxy.model.Product

class ProductController : TypedEpoxyController<List<Product>>() {

    lateinit var clickListener : () ->Unit
    override fun buildModels(data: List<Product>?) {
        data?.run {
            this.forEach {

//                ItemViewBindingEpoxyHolder_().run {
//                    title = it.title
//                    desc = it.description
//                    imageRes = it.image
//                    listener = {
//                        clickListener()
//
//                    }
//                }
            }
        }
    }
}