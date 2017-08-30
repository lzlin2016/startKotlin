package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 基本语法
 * 创建时间:  2017/7/19 10:54
 * 修改备注:
 */
fun main(args: Array<String>) {
    var a = 2;
    var b = 3;
    println("sum ($a, $b) = " + sum (a, b))
    println("sum2 ($a, $b) = " + sum2 (a, b))
    printSum(a, b)
}

/**
 * 求和
 */
fun sum(a: Int, b: Int) : Int {
    return a + b
}
fun sum2(a: Int, b: Int) = a + b

/**
 * 无返回值 Unit
 */
fun printSum(a: Int, b: Int){
    println("printSum ($a, $b) = " + sum (a, b))
}