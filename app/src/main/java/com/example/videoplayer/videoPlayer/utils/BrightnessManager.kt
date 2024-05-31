package com.educate.theteachingapp.videoPlayer.utils

import android.view.WindowManager
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import com.educate.theteachingapp.videoPlayer.extensions.currentBrightness
import com.educate.theteachingapp.videoPlayer.extensions.swipeToShowStatusBars
import com.example.calculator.videoPlayer.ExoPlayerActivity

class BrightnessManager @OptIn(UnstableApi::class) constructor
    (private val activity: ExoPlayerActivity) {

    var currentBrightness = activity.currentBrightness
    val maxBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_FULL

    val brightnessPercentage get() = (currentBrightness / maxBrightness).times(100).toInt()

    fun setBrightness(brightness: Float) {
        currentBrightness = brightness.coerceIn(0f, maxBrightness)
        val layoutParams = activity.window.attributes
        layoutParams.screenBrightness = currentBrightness
        activity.window.attributes = layoutParams

        activity.swipeToShowStatusBars()
    }
}