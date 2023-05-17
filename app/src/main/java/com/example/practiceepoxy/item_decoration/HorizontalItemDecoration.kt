package com.example.practiceepoxy.item_decoration

import android.graphics.Rect
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceepoxy.R


class HorizontalItemDecoration(
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
        outRect.left = itemGapSize
        outRect.right = itemGapSize
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.left = gapSize
        if (parent.getChildAdapterPosition(view) == parent.size - 1) {
            outRect.right = gapSize
        }

    }
}