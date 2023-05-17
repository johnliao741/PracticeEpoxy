package com.example.practiceepoxy.item_decoration

import android.graphics.Rect
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceepoxy.R


class VerticalItemDecoration(
    val gapSizeRes: Int = R.dimen.padding_16dp,
    val itemGapSize: Int = R.dimen.padding_8dp
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val gapSize = view.resources.getDimensionPixelSize(gapSizeRes)
        val itemGapSize = view.resources.getDimensionPixelSize(itemGapSize)
        outRect.top = itemGapSize
        outRect.bottom = itemGapSize
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = gapSize
        if (parent.getChildAdapterPosition(view) == parent.size - 1) {
            outRect.bottom = gapSize
        }

    }
}