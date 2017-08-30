package com.kotlin.`3类和对象`.泛型

/**
 * 类的描述: 泛型 TODO lz 学习此章 重点
 * 创建时间: 2017/8/25  16:10
 * 修改备注:
 */
fun main(args: Array<String>) {
    println("这是什么鬼")
    // 一般来说，要创建这样类的实例，我们需要提供类型参数：
    val box1: Box<Int> = Box<Int>(1)
    // 但是如果类型参数可以推断出来，例如从构造函数的参数或者从其他途径，允许省略类型参数：
    val box2 = Box(1) // 1 具有类型 Int，所以编译器知道我们说的是 Box<Int>。
}

class Box<T>(t: T) {
    var value = t
}