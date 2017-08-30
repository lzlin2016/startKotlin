package com.kotlin.`4函数和Lambda表达式`.lambda表达式

import java.util.concurrent.locks.Lock

/**
 * 类的描述: 高阶函数和lambda 表达式
 * 创建时间: 2017/8/28  13:34
 * 修改备注:
 */
fun main(args: Array<String>) {

}

/**
 * 高阶函数
 */
// 高阶函数是将函数用作参数或者返回值的函数. 这种函数的一个很好的例子是 lock() , 他接收一个锁对象和一个函数, 获取锁, 运行函数并释放锁:
fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    }
    finally {
        lock.unlock()
    }
}

/**
 * Lambda 表达式在下文会有更详细的描述，但为了继续这一段，让我们看一个简短的概述：
 *      1. lambda 表达式总是被大括号括着，
 *      2. 其参数（如果有的话）在 -> 之前声明（参数类型可以省略），
 *      3. 函数体（如果存在的话）在 -> 后面。
 */
// 在kotlin 中有一个约定, 如果函数的最后一个刹那护士是一个函数, 并且你传递一个lambda 表达式作为相应的参数, 你可以在圆括号之外指定它
// 高阶函数的另一个例子是map() :
fun <T, R>  List<T>.map(trasformm: (T) -> R) : List<R> {
    val result = arrayListOf<R>()
    for (item in this)
        result.add(trasformm(item))
    return result
}

// 该函数可以如下调用
fun testmap() {
    val ints = arrayListOf(1)
    val doubled = ints.map { value -> value * 2 }
}
// 请注意，如果 lambda 是该调用的唯一参数，则调用中的圆括号可以完全省略。
// it; 单个参数的隐含名称
// 另一个有用的约定是，如果函数字面值只有一个参数， 那么它的声明可以省略（连同 ->），其名称是 it。

fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection)
        if (max == null || less(max, it))
            max = it
    return max
}
var sum1: ((Int, Int) -> Int)? = null
val sum2 = { x: Int, y: Int -> x + y }
val sum3: (Int, Int) -> Int = { x, y -> x + y }
fun tesLambda表达式() {
    val ints = arrayListOf(1)
    ints.filter { it > 0 } // 这个字面值是“(it: Int) -> Boolean”类型的
    ints.filter {
        val shouldFilter = it > 0
        shouldFilter
    }
    // 等价于
    ints.filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }
}

// 匿名函数
//fun(x: Int, y: Int): Int = x + y
//fun(x: Int, y: Int): Int {
//    return x + y
//}
// ``匿名函数的返回类型推断机制与正常函数一样：对于具有表达式函数体的匿名函数将自动推断返回类型，
// 而具有代码块函数体的返回类型必须显式指定（或者已假定为 Unit）。
// ``请注意，匿名函数参数总是在括号内传递。 允许将函数留在圆括号外的简写语法仅适用于 lambda 表达式。
// Lambda表达式和匿名函数之间的另一个区别是非局部返回的行为。一个不带标签的 return 语句总是在用
// fun 关键字声明的函数中返回。这意味着 lambda 表达式中的 return 将从包含它的函数返回，而匿名函数中的 return 将从匿名函数自身返回。

/**
 * 闭包
 */
//   Lambda 表达式或者匿名函数（以及局部函数和对象表达式） 可以访问其 闭包 ，
// 即在外部作用域中声明的变量。 与 Java 不同的是可以修改闭包中捕获的变量：
fun test闭包() {
    val ints = arrayListOf(1)
    var sum = 0
    ints.filter { it > 0 }.forEach { // 带有过滤条件的 foreach 循环
        sum += it
    }
    print(sum)
}

/**
 * 带接收者的函数字面值
 */
//   Kotlin 提供了使用指定的 接收者对象 调用函数字面值的功能。 在函数字面值的函数体中，可以调用该接收者对象上的方法而无需任何
// 额外的限定符。 这类似于扩展函数，它允许你在函数体内访问接收者对象的成员。 其用法的最重要的示例之一是类型安全的 Groovy-风格构建器。
fun test带接收者的函数字面值() {
    // sum : Int.(other: Int) -> Int
    val sum = fun Int.(other: Int): Int = this + other
    1.sum(2)
}
// 匿名函数语法允许你直接指定函数字面值的接收者类型。 如果你需要使用带接收者的函数类型声明一个变量，并在之后使用它，这将非常有用。
// 当接收者类型可以从上下文推断时，lambda 表达式可以用作带接收者的函数字面值。
class HTML {
    fun body() { /***/ }
}
fun html(init: HTML.() -> Unit): HTML {
    val html = HTML() // 创建接收者对象
    html.init()       // 将该接收者对象传给该 lambda
    return html
}
//  html {      // 带接收者的lambda 由此开始
//      body()  // 调用该接收者对象的一个方法
//  }