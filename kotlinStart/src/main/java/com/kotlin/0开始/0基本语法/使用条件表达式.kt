package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 使用条件表达式
 * 创建时间:  2017/7/19 11:31
 * 修改备注:
 */
fun main(args: Array<String>) {
    var a = 2;
    var b = 3;
    println("maxOf1 ($a, $b) = " + maxOf1 (a, b))
    println("maxOf2 ($a, $b) = " + maxOf2 (a, b))
}

fun maxOf1(a: Int, b: Int) : Int {
    if(a > b) return a
    else return b
}

fun maxOf2(a: Int, b: Int) = if(a > b) a else b

