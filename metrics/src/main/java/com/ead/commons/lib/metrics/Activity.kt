package com.ead.commons.lib.metrics

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.graphics.Insets
import android.graphics.Rect
import android.os.Build
import android.util.Size
import android.view.Display
import android.view.WindowInsets
import android.view.WindowMetrics


fun Activity.getAvailableWidthReference(referenceMeasure : Int): Int =
    (getDisplayWidth() / referenceMeasure).toInt()


fun Activity.getDisplayWidth() : Float {
    val metrics = resources.displayMetrics
    return metrics.widthPixels / metrics.density
}


@SuppressLint("DiscouragedApi")
fun Activity.getNavigationBarHeight(orientation: Int): Int {
    val id: Int = resources.getIdentifier(
        if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height"
        else "navigation_bar_height_landscape", "dimen", "android")
    return if (id > 0) resources.getDimensionPixelSize(id)
    else 0
}

@SuppressLint("DiscouragedApi")
fun Activity.getNavigationBarWidth(orientation: Int): Int {
    val id: Int = resources.getIdentifier(
        if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_width"
        else "navigation_bar_width_landscape", "dimen", "android")
    return if (id > 0) resources.getDimensionPixelSize(id)
    else 0
}


fun Activity.getScreenSize() : Size =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val metrics: WindowMetrics = windowManager.currentWindowMetrics
        val windowInsets = metrics.windowInsets
        val insets: Insets = windowInsets.getInsetsIgnoringVisibility(
            WindowInsets.Type.navigationBars()
                    or WindowInsets.Type.displayCutout()
        )
        val insetsWidth: Int = insets.right + insets.left
        val insetsHeight: Int = insets.top + insets.bottom
        val bounds: Rect = metrics.bounds
        Size(
            bounds.width() - insetsWidth,
            bounds.height() - insetsHeight
        )
    } else {
        @Suppress("DEPRECATION") val display: Display = windowManager.defaultDisplay
        @Suppress("DEPRECATION")
        Size(
            display.width,
            display.height
        )
    }