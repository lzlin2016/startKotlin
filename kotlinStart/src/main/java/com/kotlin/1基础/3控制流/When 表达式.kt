package com.kotlin.`1基础`.`3控制流`

import java.lang.Integer.parseInt

/**
 * 项目名称: StartKotlin
 *
 * 类的描述:  When 表达式
 * 创建时间:  2017/7/19 18:06
 * 修改备注:  when 取代了类 C 语言的 switch 操作符
 *  如果 when 作为一个表达式使用，则必须有 else 分支， 除非编译器能够检测出所有的可能情况都已经覆盖了。
 *  如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
 */
fun main(args: Array<String>) {
    test(1)
    println(startsWithPrefix("prefix start"))
}

fun test(x: Int) {
    // 1. 单独分支, 简单使用
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // 注意这个块
            println("x is neither 1 nor 2")
        }
    }

    // 2. 多个分支
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    // 3. 可以用任意表达式（而不只是常量）作为分支条件
    when (x) {
        parseInt("12") -> println("s encodes x")
        else -> println("s does not encode x")
    }

    // 4. 可以检测一个值在（in）或者不在（!in）一个区间或者集合中
    val validNumbers = intArrayOf(1, 2, 3)
    when (x) {
        in 4..10 -> println("x is in the range")
        in validNumbers -> println("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    // 6. when 也可以用来取代 if-else if链。
    //  如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：
    when {
        // 判断奇偶性
//        x.isOdd() -> print("x is odd")
//        x.isEven() -> print("x is even")
        x % 2 == 0 -> println("x is odd")
        x % 2 != 0 -> println("x is even")
        else -> println("x is funny")
    }
}

/**
 * 5. 一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。
 *      注意： 由于智能转换，你可以访问该类型的方法和属性而无需任何额外的检测。
 */
fun startsWithPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
