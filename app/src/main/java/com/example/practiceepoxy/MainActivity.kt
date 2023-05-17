package com.example.practiceepoxy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.example.practiceepoxy.databinding.ActivityMainBinding
import com.example.practiceepoxy.epoxy.*
import com.example.practiceepoxy.epoxy.view.ItemDataClass
import com.example.practiceepoxy.epoxy.view.ItemHorizontalRecyclerView
import com.example.practiceepoxy.epoxy.view.ItemViewBindingDataClass
import com.example.practiceepoxy.epoxy.view.itemViewBindingEpoxyHolder
import com.example.practiceepoxy.item_decoration.VerticalItemDecoration
import com.example.practiceepoxy.model.Product

class MainActivity : AppCompatActivity() {
    var isFirstList = true
    private lateinit var binding: ActivityMainBinding
    val list: MutableList<Product> = MutableList(3,
        { index ->
            Product(
                image = R.mipmap.ic_launcher,
                title = "Title$index",
                description = "Description$index"
            )
        }
    )
    val list2: MutableList<Product> = MutableList(3,
        { index ->
            Product(
                image = R.mipmap.ic_launcher,
                title = "Title$index",
                description = "Description$index"
            )
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setData(list,list2)
        initHandler()


    }

    private fun initView() {
        binding.tvMode.text = if (isFirstList) "First List" else "Second List"
        binding.rv.addItemDecoration(VerticalItemDecoration())
    }

    private fun initHandler() {
        binding.tvMode.setOnClickListener {
            isFirstList = !isFirstList
            binding.tvMode.text = if (isFirstList) "First List" else "Second List"
        }
        binding.fabAdd.setOnClickListener {

            val size = if (isFirstList) list.size else list2.size
            if (isFirstList)
                list.add(
                    Product(
                        image = R.mipmap.ic_launcher,
                        title = "Title$size",
                        description = "Description$size"
                    )
                )
            else
                list2.add(
                    Product(
                        image = R.mipmap.ic_launcher,
                        title = "Title$size",
                        description = "Description$size"
                    )
                )
            setData(list, list2,isFirstList)
        }
        binding.btnRemove.setOnClickListener {
            if (isFirstList){
                if(list.lastIndex >= 1)
                    list.removeAt(list.lastIndex)
            } else{
                Log.e("size","${list2.lastIndex}")
                if(list2.lastIndex >= 1)
                    list2.removeAt(list2.lastIndex)
            }

            setData(list, list2,isFirstList)
        }
    }

    fun setData(list: List<Product>, list2: List<Product>,isInit:Boolean = true) {
        binding.rv.withModels {
            ItemDataClass("Header")
                .id("data class")
                .addTo(this)
            list.forEachIndexed { index, product ->
                itemViewBindingEpoxyHolder {
                    id("view binding $index")
                    title(product.title)
                    desc(product.description)
                    imageRes(product.image)
                    listener {
                        Log.e("Click", "click ${product.title}")
                    }
                }
            }
            ItemViewBindingDataClass(title = "Footer")
                .id("Footer")
                .addTo(this)
            ItemHorizontalRecyclerView(isInit = isInit,
                list = list2.toList()
            ) {
                Log.e("Click", "click$it")
            }.id("Horizontal")
                .addTo(this)
        }
    }

}