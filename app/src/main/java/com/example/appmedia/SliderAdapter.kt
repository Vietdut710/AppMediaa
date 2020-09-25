package com.example.appmedia

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class SliderAdapter() : Fragment() {
    var sliderItems: List<SliderItem>? = null
    var easySliderListener: EasySliderListener? = null

    fun SliderAdapter(sliderItems: List<SliderItem>, easySliderListener: EasySliderListener?) {

        this.sliderItems = sliderItems
        this.easySliderListener = easySliderListener
    }



    fun getCount() : Int {
        return sliderItems!!.size
    }

    fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}