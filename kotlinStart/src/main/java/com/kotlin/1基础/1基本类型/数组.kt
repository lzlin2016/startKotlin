package com.kotlin.`1基础`.`1基本类型`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 数组
 * 创建时间:  2017/7/19 16:50
 * 修改备注:
 */
fun main(args: Array<String>) {
    test()
}

private fun test() {
    // 创建一个 Array<String> 初始化为["0", "1", "4", "9", "16"]
    val asc = Array(5, { i -> (i * i).toString()})
    asc.forEach { println(it) }

    // otlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等。
    // 这些类和 Array 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法:
    val intArr: IntArray = intArrayOf(1, 2, 3)
    intArr[0] = intArr[1] + intArr[2]
    intArr.forEach { println(it) }

    // 测试
    val byteArr = byteArrayOf(1, 2, 5, 3)
    byteArr.forEach { println(it) }
    println("max = " + byteArr.max())
}
