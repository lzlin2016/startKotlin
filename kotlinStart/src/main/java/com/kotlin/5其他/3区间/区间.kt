package com.kotlin.`5其他`.`3区间`

/**
 * 类的描述: 区间
 * 创建时间: 2017/8/28  15:54
 * 修改备注: 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
 *          区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。
 *    rangeTo()     整型类型的 rangeTo() 操作符只是调用 *Range 类的构造函数
 *          浮点数（Double、 Float）未定义它们的 rangeTo 操作符，而使用标准库提供的泛型 Comparable 类型的操作符：
 *    downTo()      扩展函数 downTo() 是为任何整型类型对定义的
 *    reversed()    扩展函数 reversed() 是为每个 *Progression 类定义的，并且所有这些函数返回反转后的数列。
 *    step()        扩展函数 step() 是为每个 *Progression 类定义的， 所有这些函数都返回带有修改了 step 值
 *                  （函数参数）的数列。 步长（step）值必须始终为正，因此该函数不会更改迭代的方向。
 *        请注意，返回数列的 last 值可能与原始数列的 last 值不同，以便保持不变式 (last - first) % step == 0 成立。
 *        eg. (1..12 step 2).last == 11  // 值为 [1, 3, 5, 7, 9, 11] 的数列
 *            (1..12 step 3).last == 10  // 值为 [1, 4, 7, 10] 的数列
 *            (1..12 step 4).last == 9   // 值为 [1, 5, 9] 的数列
 */
fun main(args: Array<String>) {

}

// 整型区间（IntRange、 LongRange、 CharRange）有一个额外的特性：它们可以迭代。 编译器负责将其转换为类似 Java 的基于索引的 for-循环而无额外开销。
fun test1() {
    for (i in 1..10) { // 等同于 1<= i && i <= 10
        println(i)
    }
    for (i in 1..4) print(i) // 输出“1234”
    for (i in 4..1) print(i) // 什么都不输出
    for (i in 4 downTo 1) print(i) // 输出“4321” downTo 倒序迭代数字
    for (i in 1..4 step 2) print(i) // 输出“13”  任意步长迭代
//    for (int i = first; i != last; i += step) { /**....**/ }
    // 要创建一个不包括其结束元素的区间，可以使用 until 函数：
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10  until 不包括上区间
        println(i)
    }
}