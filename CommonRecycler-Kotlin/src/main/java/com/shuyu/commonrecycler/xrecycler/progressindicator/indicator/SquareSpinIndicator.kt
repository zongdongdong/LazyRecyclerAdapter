package com.shuyu.commonrecycler.xrecycler.progressindicator.indicator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.animation.LinearInterpolator

import java.util.ArrayList

/**
 * Created by Jack on 2015/10/16.
 */
open class SquareSpinIndicator : BaseIndicatorController() {

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawRect(RectF((width / 5).toFloat(), (height / 5).toFloat(), (width * 4 / 5).toFloat(), (height * 4 / 5).toFloat()), paint)
    }

    override fun createAnimation(): List<Animator> {
        val animators = ArrayList<Animator>()
        val rotation5 = PropertyValuesHolder.ofFloat("rotationX", 0f, 180f, 180f, 0f, 0f)
        val rotation6 = PropertyValuesHolder.ofFloat("rotationY", 0f, 0f, 180f, 180f, 0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(target, rotation6, rotation5)
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        animator.duration = 2500
        animator.start()
        animators.add(animator)
        return animators
    }
}
