package com.kotlin.`1基础`.`3控制流`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: While 循环
 * 创建时间:  2017/7/20 9:43
 * 修改备注:
 */
fun main(args: Array<String>) {
    testWhile(5)
    testDoWhile(5)
    testBreakContinue(5, 3)
}

/**
 * 测试 while
 */
fun testWhile (count: Int) {
    var i = count
    println("=== testWhile print $count ===")
    while (i > 0) { // while 条件满足 一直做
        println("i = $i")
        i --
    }
}

/**
 * 测试 do while
 */
fun testDoWhile (count: Int) {
    var i = count
    println("=== testDoWhile print $count ===")
    do {
        println("i = $i")
        i --
    } while (i > 0) // do 一直做 while 直到条件不满足
}

/**
 * 测试 循环中的Break和continue
 */
fun testBreakContinue (count: Int, breakIndex: Int) {
    // 在循环中 Kotlin 支持传统的 break 和 continue 操作符
    println("=== testBreakContinue print $count continue ${count - 1} break ${breakIndex} ===")
    var i = count
    while (i > 0) {
        if(i == count - 1) {
            i --
            continue
        } // 结束本轮循环, 继续当前循环下一轮
        println("i = $i")
        if (i == breakIndex)   break // 结束当前循环
        i --
    }
}
