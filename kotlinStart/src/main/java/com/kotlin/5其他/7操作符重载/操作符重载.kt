package com.kotlin.`5其他`.`7操作符重载`

/**
 * 类的描述: 操作符重载
 * 创建时间: 2017/8/28  16:26
 * 修改备注: Kotlin 允许我们为自己的类型提供预定义的一组操作符的实现。这些操作符具有固定的符号表示
 *   （如 + 或 *）和固定的优先级。为实现这样的操作符，我们为相应的类型（即二元操作符左侧的类型和一元操作符
 *    的参数类型）提供了一个固定名字的成员函数或扩展函数。 重载操作符的函数需要用 operator 修饰符标记。
 */
fun main(args: Array<String>) {

}

fun test1() {
    data class Point(val x: Int, val y: Int)

    operator fun Point.unaryMinus() = Point(-x, -y)

    val point = Point(10, 20)
    println(-point)  // 输出“(-10, -20)”
}


