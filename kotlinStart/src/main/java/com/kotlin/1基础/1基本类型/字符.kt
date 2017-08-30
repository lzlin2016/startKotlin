package com.kotlin.`1基础`.`1基本类型`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 字符
 * 创建时间:  2017/7/19 16:47
 * 修改备注:
 *  注意数字装箱不必保留同一性, 只保留了相等性:
 */
fun main(args: Array<String>) {
    println(decimalDigitValue('1'))
    println(decimalDigitValue('a'))
}

/**
 * 显式把字符转换为 Int 数字：
 */
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range") // 抛异常
    return c.toInt() - '0'.toInt() // 显式转换为数字
}
