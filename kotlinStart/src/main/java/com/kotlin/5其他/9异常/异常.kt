package com.kotlin.`5其他`.`9异常`

import java.lang.Integer.parseInt

/**
 * 类的描述: 异常
 * 创建时间: 2017/8/28  16:52
 * 修改备注:
 */
fun main(args: Array<String>) {

}

/**
 * 异常类  可以使用try- 表达式来捕获异常, 以有零到多个 catch 块。finally 块可以省略。 但是 catch 和 finally 块至少应该存在一个。
 */
// Kotlin 中所有异常类都是 Throwable 类的子孙类。 每个异常都有消息、堆栈回溯信息和可选的原因。
class MyExecption(info: String) : Throwable() {
    init {
        println(info)
    }
}
fun test1() {
    throw MyExecption("here comes an execption! ")
    // 使用 try- 表达式来捕获异常
    try {
        // 一些代码
    }
    catch (e: MyExecption) {
        // 处理程序
    }
    finally {
        // 可选的 finally 块
    }
}

/**
 * Try 是一个表达式   即它可以有一个返回值。
 *  try-表达式的返回值是 try 块中的最后一个表达式或者是（所有）catch 块中的最后一个表达式。
 *  finally 块中的内容不会影响表达式的结果。
 */
fun test2() {
    val input: String = "x1"
    val a: Int? = try { parseInt(input) } catch (e: NumberFormatException) { null }
}

/**
 * 受检的异常    Kotlin 没有受检的异常。
 */

/**
 * Nothing 类型
 */
// 在 Kotlin 中 throw 是表达式，所以你可以使用它（比如）作为 Elvis 表达式的一部分：
class Person {
    val name: String = ""
    val age: Int = 0
}
fun test4(person: Person) {
    val s1 = person.name ?: throw IllegalArgumentException("Name required")
    // 当你调用该函数时，编译器会知道执行不会超出该调用：
    val s2 = person.name ?: fail("Name required")
    println(s2)     // 在此已知“s”已初始化
    // 可能会遇到这个类型的另一种情况是类型推断。这个类型的可空变体 Nothing? 有一个可能的值是 null。
    // 如果用 null 来初始化一个要推断类型的值，而又没有其他信息可用于确定更具体的类型时，编译器会推断出 Nothing? 类型：
    val x = null           // “x”具有类型 `Nothing?`
    val l = listOf(null)   // “l”具有类型 `List<Nothing?>
}
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

/**
 * Java 互操作性    参见 Java 互操作性章节中的异常部分。
 */