package com.example.composecarousel


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import kotlin.math.abs


/**
 * A Carousel with horizontal orientation
 * **/
@Composable
fun HorizontalCarousel(
    itemsCount: Int,
    parentModifier: Modifier = Modifier.fillMaxWidth(),
    width: Dp,
    content: @Composable (modifier: Modifier, index: Int) -> Unit,
) {
    val listState = rememberLazyListState(Int.MAX_VALUE / 2)

    BoxWithConstraints(
        modifier = parentModifier,
    ) {
        val halfRowWidth = constraints.maxWidth / 2

        LazyRow(
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(-width / 2),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(
                count = itemsCount,
                itemContent = { globalIndex ->

                    val scale by remember {
                        derivedStateOf {
                            val currentItem =
                                listState.layoutInfo.visibleItemsInfo.firstOrNull { it.index == globalIndex }
                                    ?: return@derivedStateOf 0.85f

                            (
                                1f - minOf(
                                    2f,
                                    abs(currentItem.offset + (currentItem.size / 2) - halfRowWidth).toFloat() / halfRowWidth,
                                ) * 0.4f
                                )
                        }
                    }

                    content(
                        index = globalIndex % itemsCount,
                        modifier = Modifier
                            .width(width)
                            .scale(scale)
                            .zIndex(scale),
                    )
                },
            )
        }
    }
}


