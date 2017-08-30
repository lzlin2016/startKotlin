package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 定义局部变量
 * 创建时间:  2017/7/19 11:12
 * 修改备注:
 */
fun main(args: Array<String>) {
    // 一次赋值（只读）的局部变量:
    val a: Int = 1; // 立即赋值
    val b = 2; // 自动推断出 "Int" 类型
    val c : Int //如果没有初始值类型不能省略
    c = 3

    // 可变变量：
    var x = 5 // 自动推断出 "Int" 类型
    x += 1
}