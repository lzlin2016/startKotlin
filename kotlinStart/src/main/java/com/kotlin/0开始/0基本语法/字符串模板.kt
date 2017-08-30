package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 字符串模板
 * 创建时间:  2017/7/19 11:17
 * 修改备注:
 */
fun main(args: Array<String>) {
    test()
}

fun test() {
    // 字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
    // 模板表达式以美元符（$）开头，由一个简单的名字构成:
    val i = 10
    val s = "i = $i" // 求值结果为 " i = 10 "
    println(s)

    // 或者用花括号扩起来的任意表达式:
    val s2 = "abc"
    val str = "$s2.length is ${s2.length}" // / 求值结果为 "abc.length is 3"
    println(str)

    // 原生字符串和转义字符串内部都支持模板。
    // 如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
    val price2 = "${'$'}9.99"
    println(price2)

    // 瞎写
    val price = "价格: $$i"
    val price3 = "$$9.99" // $$9.99 错误
    println(price)
    println(price3)
}