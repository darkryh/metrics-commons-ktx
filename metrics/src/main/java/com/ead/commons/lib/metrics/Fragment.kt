package com.ead.commons.lib.metrics

import android.util.Size
import androidx.fragment.app.Fragment

fun Fragment.getAvailableWidthReference(referenceMeasure : Int): Int =
    requireActivity().getAvailableWidthReference(referenceMeasure)


fun Fragment.getDisplayWidth() : Float = requireActivity().getDisplayWidth()


fun Fragment.getNavigationBarHeight(orientation: Int): Int =
    requireActivity().getNavigationBarHeight(orientation)


fun Fragment.getNavigationBarWidth(orientation: Int): Int =
    requireActivity().getNavigationBarWidth(orientation)


fun Fragment.getScreenSize() : Size = requireActivity().getScreenSize()