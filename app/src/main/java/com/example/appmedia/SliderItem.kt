package com.example.appmedia

import android.os.Parcel
import android.os.Parcelable


class SliderItem() : Parcelable {
    private var title : String ?= null
    private var url : String ?= null
    private var resID : Int = 0

    fun SliderItem(title: String, url: String){
        this.title = title
        this.url = url

    }
    fun SliderItem(title: String, resID: Int){
        this.title = title
        this.resID = resID
    }
    protected fun SliderItem(ip: Parcel){
        this.title = ip.readString()
        this.url = ip.readString()
        this.resID = ip.readInt()
    }

//    val CREATOR:Creator<SliderItem> = Creator<SliderItem>(){
//        @Override
//         fun createFromParcel(iu : Parcel):SliderItem {
//            return createFromParcel(iu)
//        }
//        @Override
//        fun newArray(size : Int) : Array<SliderItem>  {
//            return size
//        }
//    }
    companion object CREATOR : Parcelable.Creator<SliderItem>{
    override fun createFromParcel(iu: Parcel): SliderItem {
        return SliderItem(iu)
    }

    override fun newArray(size: Int): Array<SliderItem?> {
        return arrayOfNulls(size)
    }
}

    fun getTitle():String{
        return title!!
    }
    fun setTitle(title: String){
        this.title = title
    }
    fun getUrl():String{
        return url!!
    }
    fun setUrl(url: String){
        this.url = url
    }
    fun getResID():Int{
        return resID
    }
    fun setResID(resID: Int){
        this.resID = resID
    }

    constructor(parcel: Parcel) : this() {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeInt(resID)
    }




}