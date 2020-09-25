package com.example.appmedia



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import androidx.annotation.Nullable


class SliderFragment : Fragment() {
    var item : SliderItem? = null
    var title_layout : LinearLayout? = null
    var title : TextView? = null
    var imageView : ImageView? = null

    var position : Int = -1

   // @JvmName("getEasySliderListener1")
    fun getEasySliderListener1(): EasySliderListener {
        return easySliderListener!!
    }
    fun getEasySliderListener1(easySliderListener: EasySliderListener){
        this.easySliderListener = easySliderListener
    }
    var easySliderListener : EasySliderListener ?= null

    fun newInstance(item: SliderItem, position: Int) : SliderFragment {
        var fragment : SliderFragment = SliderFragment()
        var args : Bundle = Bundle()
        args.putParcelable("item", item)
        args.putInt("position", position)
        fragment.arguments = args
        return fragment
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable("item")
        position = arguments!!.getInt("position")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.slider_item_container, container, false)
        title = rootView.findViewById(R.id.title)
        title_layout = rootView.findViewById(R.id.title_layout)
        imageView = rootView.findViewById(R.id.img)
        if (item!!.getTitle() != null) {
            title?.setText(item!!.getTitle())
            title_layout?.setVisibility(View.VISIBLE)
        } else {
            title_layout?.setVisibility(View.GONE)
        }
        if (item!!.getResID() != 0) {
            Picasso.get()
                    .load(item!!.getResID())
                    .into(imageView)
        }
        if (item!!.getUrl() != null) {
            Picasso.get()
                    .load(item!!.getUrl())
                    .into(imageView)
        }
        rootView.setOnClickListener {
            if (easySliderListener != null) {
                easySliderListener!!.onItemClick(position)
            }
        }
        return rootView
    }

    fun showTitle (){
        var bottomUp : Animation = AnimationUtils.loadAnimation(context, R.anim.bottom_up)
        title_layout?.startAnimation(bottomUp)
        title_layout?.setVisibility(View.VISIBLE)
    }

    fun hideTitle (){
        title_layout?.setVisibility(View.GONE)
    }
}