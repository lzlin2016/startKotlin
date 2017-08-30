package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 循环
 * 创建时间:  2017/7/19 11:49
 * 修改备注:
 */
fun main(args: Array<String>) {
    testFor()
    testFor2()
    testWhile()

    println("=== 使用 when 表达式 ===")
    println(describe(1))
    println(describe("Hello"))
    println(describe(1.0))
    println(describe(1L))
    println(describe("" + 0))
}

/**
 * 使用 for 循环
 */
fun testFor() {
    println("=== 使用 for 循环 ===")
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

/**
 * 使用 for 循环
 */
fun testFor2() {
    println("=== 使用 for 循环 ===")
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * 使用 while 循环
 */
fun testWhile() {
    println("=== 使用 while 循环 ===")
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index ++
    }
}

/**
 * 使用 when 表达式
 */
fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }
