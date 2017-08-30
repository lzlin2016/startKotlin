package com.kotlin.`3类和对象`.可见性修饰符

/**
 * 类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。 （getter 总是与属性有着相同的可见性。）
 * 在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。
 * 如果没有显式指定修饰符的话，默认可见性是 public。
 */

// 包名   函数、属性和类、对象和接口可以在顶层声明，即直接在包内：
/**
 *      -- 如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；
 *      -- 如果你声明为 private，它只会在声明它的文件内可见；
 *      -- 如果你声明为 internal，它会在相同模块内随处可见；
 *      -- protected 不适用于顶层声明。
 */

/** 类和接口   对于类内部声明的成员：
 *      -- private 意味着只在这个类内部（包含其所有成员）可见；
 *      -- protected—— 和 private一样 + 在子类中可见。
 *      -- internal —— 能见到类声明的 本模块内 的任何客户端都可见其 internal 成员；
 *      -- public —— 能见到类声明的任何客户端都可见其 public 成员。
 *  注意 对于Java用户：Kotlin 中外部类不能访问内部类的 private 成员。
 *      如果你覆盖一个 protected 成员并且没有显式指定其可见性，该成员还会是 protected 可见性。
 */

// 构造函数     要指定一个类的的主构造函数的可见性，使用以下语法（注意你需要添加一个显式 constructor 关键字）：
// 这里的构造函数是私有的。默认情况下，所有构造函数都是 public，这实际上等于类可见的地方它就可见（即 一个 internal 类的构造函数只能在相同模块内可见).

// 局部声明     局部变量、函数和类不能有可见性修饰符。

fun main(args: Array<String>) {
}

// 可空接收者    注意可以为可空的接收者类型定义扩展。检测发生在扩展函数的内部。
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

//  扩展属性        和函数类似，Kotlin 支持扩展属性：
val <T> List<T>.lastIndex: Int
    get() = size - 1