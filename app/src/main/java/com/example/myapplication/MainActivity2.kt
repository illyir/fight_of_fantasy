package com.example.myapplication

import android.R
import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import javax.suckia.Card


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
class FlipAnimation internal constructor(
    ctx: Context,
    img: ImageView,
    card: javax.smartcardio.Card
) :
    Animation.AnimationListener {
    private val animation1: Animation
    private val animation2: Animation
    private var isBackOfCardShowing = true
    private val img: ImageView
    private val ctx: Context
    private val flipped: FlipEnd
    var card: javax.smartcardio.Card

    interface FlipEnd {
        fun flipEnd(img: ImageView?, card: javax.smartcardio.Card?)
    }

    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationEnd(animation: Animation) {
        if (animation === animation1) {
            if (isBackOfCardShowing) {
                img.setImageResource(R.drawable.card_face)
                flipped.flipEnd(img, card)
            } else {
                img.setImageResource(R.drawable.card_back)
            }
            img.clearAnimation()
            img.setAnimation(animation2)
            img.startAnimation(animation2)
        } else {
            isBackOfCardShowing = !isBackOfCardShowing
        }
    }

    override fun onAnimationRepeat(animation: Animation) {}

    init {
        this.img = img
        this.ctx = ctx
        this.card = card
        flipped = ctx
        animation1 = AnimationUtils.loadAnimation(ctx, R.anim.flip_to_middle)
        animation1.setAnimationListener(this)
        animation2 = AnimationUtils.loadAnimation(ctx, R.anim.flip_from_middle)
        animation2.setAnimationListener(this)
        img.clearAnimation()
        img.setAnimation(animation1)
        img.startAnimation(animation1)
    }
}