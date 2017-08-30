package com.kotlin.`3类和对象`.委托

/**
 * 委托属性     TODO lz 学习: 属性委托要求
 *      1. 延迟属性（lazy properties）: 其值只在首次访问时计算，
 *      2. 可观察属性（observable properties）: 监听器会收到有关此属性变更的通知，
 *      3. 把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。
 */

fun main(args: Array<String>) {
//    val e = Example()
//    println(e.p)
}

//class Example {
//    var p: String by Delegate()
//}
// 语法是： val/var <属性名>: <类型> by <表达式>。在 by 后面的表达式是该 委托，
// 因为属性对应的 get()（和 set()）会被委托给它的 getValue() 和 setValue() 方法。
// 属性的委托不必实现任何的接口，但是需要提供一个 getValue() 函数（和 setValue()——对于 var 属性）

// 标准委托
// 1. 延迟属性 Lazy
//      lazy() 是接受一个 lambda 并返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托：
//      第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
// 2. 可观察属性 Observable
//      Delegates.observable() 接受两个参数：初始值和修改时处理程序（handler）。
//      每当我们给属性赋值时会调用该处理程序（在赋值后执行）。它有三个参数：被赋值的属性、旧值和新值：
// 3. 把属性储存在映射中
//      一个常见的用例是在一个映射（map）里存储属性的值。 这经常出现在像解析 JSON 或者做其他“动态”事情的应用中。
//      在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}
fun testLazy() {
    println(lazyValue)
    println(lazyValue)
}
// 这个例子输出：
//computed!
//Hello
//Hello

// 默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）：该值只在一个线程中计算，并且所有线程会看到相同的值。
// 如果初始化委托的同步锁不是必需的，这样多个线程可以同时执行，那么将 LazyThreadSafetyMode.PUBLICATION
// 作为参数传递给 lazy() 函数。 而如果你确定初始化将总是发生在单个线程，那么你可以使用 LazyThreadSafetyMode.NONE 模式，
// 它不会有任何线程安全的保证和相关的开销。

//class User {
//    var name: String by Delegates.observable("<no name>") {
//        prop, old, new ->
//        println("$old -> $new")
//    }
//}
//fun testObservable() {
//    val user = User()
//    user.name = "first"
//    user.name = "second"
//}
//这个例子输出：
//<no name> -> first
//first -> second

// 如果你想能够截获一个赋值并“否决”它，就使用 vetoable() 取代 observable()。
// 在属性被赋新值生效之前会调用传递给 vetoable 的处理程序。

//class User2(val map: Map<String, Any?>) {
//    val name: String by map
//    val age: Int     by map
//}
////在这个例子中，构造函数接受一个映射参数：
//val user = User2(mapOf(
//        "name" to "John Doe",
//        "age"  to 25
//))
// 委托属性会从这个映射中取值（通过字符串键——属性的名称）：
//println(user.name) // Prints "John Doe"
//println(user.age)  // Prints 25
//这也适用于 var 属性，如果把只读的 Map 换成 MutableMap 的话：
//class MutableUser(val map: MutableMap<String, Any?>) {
//    var name: String by map
//    var age: Int     by map
//}