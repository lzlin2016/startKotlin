package com.kotlin.`3类和对象`.嵌套类

import java.awt.event.ActionListener

fun main(args: Array<String>) {
}

// 嵌套
class Outer1 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}
val demo1 = Outer1.Nested().foo() // == 2

// 内部类  类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}
val demo2 = Outer2().Inner().foo() // == 1

// 匿名内部类    使用对象表达式创建匿名内部类实例：
//window.addMouseListener(object: MouseAdapter() {
//    override fun mouseClicked(e: MouseEvent) {
//        // ……
//    }
//
//    override fun mouseEntered(e: MouseEvent) {
//        // ……
//    }
//})
// 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例，你可以使用带接口类型前缀的lambda表达式创建它：
val listener = ActionListener { println("clicked") }