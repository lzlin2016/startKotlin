package com.kotlin.`0开始`.`0基本语法`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 区间&&集合
 * 创建时间:  2017/7/19 13:41
 * 修改备注:
 */
fun main(args: Array<String>) {
//    testInRange()
//    testOutRange()
//    testDieDai() // 测试迭代
    testCollection()
}

/**
 * 使用区间（range）
 *  使用 in 运算符来检测某个数字是否在指定区间内：
 */
fun testInRange() {
    val x = 10
    val y = 9
    if (x in  1..y+1) println("fits in range")
    else println("doesn't fit in range")
}

/**
 * 使用区间（range）
 *  检测某个数字是否在指定区间外:
 */
fun testOutRange() {
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) { // indices 下标索引范围 0~n-1
        println("list size is out of valid list indices range too")
    }
}

/**
 * 使用区间（range）
 *  区间迭代:或数列迭代：
 */
fun testDieDai() {
    // TODO lz step ? 步长为2
    println("=== x in 1..10 step 2 ===")
    for (z in 1..10 step 2) {
        print(" " + z)
    }
    println()

    // TODO lz downTo ? 到..为止, 下降, step 步长
    println("=== x in 9 downTo 0 step 3) ===")
    for (z in 9 downTo 0 step 3) {
        print(" " + z)
    }
    println()

    println("=== 输出0~100 % 2 == 0 ===")
    for (z in 0..100 step 2) {
        print(" " + z)
    }
}

/**
 * 使用集合
 */
fun testCollection()  {
    // 对集合进行迭代:
    val list = listOf("神奇宝贝", "皮皮虾", "orange", "apple", "ali")
    println(list)
    list.forEach { println(it) } // for-each

    println("=== 对集合进行迭代 ===")
    for (item in list) {
        print("" + item + " ")
    }
    println()

    // 使用 in 运算符来判断集合内是否包含某实例 :
    println("=== 使用 in 运算符来判断集合内是否包含某实例： ===")
    when { // 有一个满足条件即返回, 函数
        "orange" in list -> println("juicy")
        "apple" in list -> println("apple is fine too")
    }

    // 使用 lambda 表达式来过滤（filter）和映射（map）集合:
    println("=== 使用 lambda 表达式来过滤（filter）和映射（map）集合： ===")
    list.filter { it.startsWith("a") } // 过滤, 有且仅有list item 都是 string, 才能使用 startsWith
            .sortedBy { it } // 排序
            .map { it.toUpperCase() } // 映射
            .forEach { println(it) } // 遍历
}
