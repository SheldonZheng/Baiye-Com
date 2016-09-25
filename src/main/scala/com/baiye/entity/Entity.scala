package com.baiye.entity

/**
  * Created by Baiye on 2016/9/24.
  */
case class Entity(name:String,  value:String){

  def this() = { this("","") }

  def this(name:String) = {   this(name,"") }


}
