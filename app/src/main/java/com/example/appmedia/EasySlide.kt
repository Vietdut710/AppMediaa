package com.example.appmedia

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import java.util.*

class EasySlide(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    var root:View? = null
    var pager:ViewPager? = null
    private val sliderIntems : List<SliderItem> = ArrayList()
    private var mSectionPagerAdapter : SliderAdapter?= null
    private var counter : Int = 3000
    var min : Int = 1
    private var dotsLayout : LinearLayout?= null
    private var dots : TextView? = null
    private val active : Int = -1
    private var hasDots : Boolean = true
    private var isFirstSwipe : Boolean = true
    private var easySlideLister :EasySliderListener? = null
    private var dots_container : View?= null
    var context = null
    fun SlideEasy(context: Context, attrs: AttributeSet){
        this.context = context as Nothing?


    }
    init {
        root = inflate(context, R.layout.slider_content, this)
        pager = root?.findViewById(R.id.pager)
        dotsLayout = root?.findViewById(R.id.dots_layout)
        dots_container = root?.findViewById(R.id.dots_container)
        val addOnPageChangeListener = pager?.addOnPageChangeListener(object :ViewPager.OnPageChangeListener {
            @Override
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                switchDots(position,active)
                var newfragment : SliderFragment = mSectionPagerAdapter.item
            }
            @Override
            override fun onPageSelected(position: Int) {
                TODO("Not yet implemented")
            }
            @Override
            override fun onPageScrollStateChanged(state: Int) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun switchDots(position: Int, active: Int) {
        if (active != -1) {
            val oldPosition = dotsLayout!!.getChildAt(active) as TextView
            val newPosition = dotsLayout!!.getChildAt(position) as TextView
            oldPosition.setTextColor(Color.parseColor("#50ffffff"))
            newPosition.setTextColor(Color.WHITE)
        }
    }

}