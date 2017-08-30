package com.kotlin.`1基础`.`4返回和跳转`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 测试返回和跳转
 * 创建时间:  2017/7/20 11:32
 * 修改备注:
 */
fun main(args: Array<String>) {
//    返回和跳转(null)
//    返回和跳转("这是什么鬼")
//    Break和Continue标签(3, 2)
//    这是什么鬼("小鬼")
    标签处返回()
}

fun 这是什么鬼 (name: String?) {
    println("这是一只$name")
}

/**
 * Kotlin 有三种结构化跳转表达式：
 *   1. return。默认从最直接包围它的函数或者匿名函数返回。
 *   2. break。终止最直接包围它的循环。
 *   3. continue。继续下一次最直接包围它的循环。
 */
fun 返回和跳转 (info: String?) {
    val s = info ?: return
    println("info is $s")
}

/**
 * 在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号
 *  要为一个表达式加标签，我们只要在其前加标签即可。
 *  标签限制的
 *      1. break 跳转到刚好位于该标签指定的循环后面的执行点。
 *      2. continue 继续标签指定的循环的下一次迭代。
 */
fun Break和Continue标签(size: Int, limit: Int) {
    loop@ for (i in 1..size) { // 给该语句块一个名称/标签 语句块名称/标签@
        for (j in 1..size) {
            // 结束某个语句块   break@语句块名称/标签
            if ( i == limit && j == limit) break@loop
            println("break 标签: i = $i, j = $j")
        }
    }
    loop@ for (i in 1..size) { // 给该语句块一个名称/标签 语句块名称/标签@
        for (j in 1..size) {
            // 结束本轮, 继续下一轮某个语句块循环   break@语句块名称/标签
            if ( i == limit && j == limit) continue@loop
            println("continue 标签: i = $i, j = $j")
        }
    }
}

fun 标签处返回() {
    val intArrayOf = intArrayOf(1, 2, 3, 4)
//    println("=== 标签限制的 return 允许我们从外层函数返回 ===")
//    intArrayOf.forEach {
//        if (it == 3)    return
//        println(it)
//    }

//    println("=== 从 lambda 表达式中返回，我们必须给它加标签并用以限制 return ===")
//    intArrayOf.forEach lit@ {
//        if (it == 3)    return@lit
//        println(it)
//    }

//    println("=== 隐式标签更方便。 该标签与接受该 lambda 的函数同名 ===")
//    intArrayOf.forEach {
//        if (it == 3)    return@forEach
//        println(it)
//    }

    println("=== 用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回 ===")
    intArrayOf.forEach(fun (value: Int) {
        if (value == 3)    return@forEach
        println(value)
    })

//    当要返一个回值的时候，解析器优先选用标签限制的 return，即
//    return@a 1
//    意为“从标签 @a 返回 1”，而不是“返回一个标签标注的表达式 (@a 1)”。
}