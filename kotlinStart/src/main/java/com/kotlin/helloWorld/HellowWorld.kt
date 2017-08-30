package com.kotlin.helloWorld

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: TODO
 * 创建人: lz - Administrator
 * 创建时间:  2017/7/19 9:22
 * 修改人: lz - Administrator
 * 修改备注:
 */

fun main(args: Array<String>) {
    var r = 3
    val n = 0
    println("c ( $r, $n ) = " + zuhe(n) / (zuhe(r) * zuhe(n-r)) )
    print("这是什么鬼")
}

fun zuhe(x: Int) : Int{
    if (x <= 1) return x
    else return (x * zuhe(x-1))
}
fun zuhe2(x: Int) = {
    if (x <= 1) x
    else (x * zuhe(x - 1))
}

fun getStringLength1(obj: Any) : Int? {
    if (obj is String) return obj.length
    return null
}
fun getStringLength2(obj: Any) : Int? {
    if (obj !is String) return null
    return obj.length
}
fun getStringLength3(obj: Any) : Int? {
    if (obj is String && obj.length > 0) return obj.length
    return null
}
