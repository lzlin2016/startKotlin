package com.kotlin.`4函数和Lambda表达式`

import java.util.concurrent.locks.Lock
import javax.swing.tree.TreeNode

/**
 * 类的描述: TODO lz 自己学习
 * 创建时间: 2017/8/28  14:31
 * 修改备注:
 */

/**
 * 内联函数
 */
//      使用 高阶函数 会带来一些运行时ed效率损失: 每一个函数都是一个对象, 并且会补货一个闭包. 即那些在函数体内会访问到的变量.
// 内存分配(对于函数对象和类) 和虚拟调用会引入运行时间开销. 很多情况可以使用内联化lambda 表达式消除这类的开销.
inline fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    }
    finally {
        lock.unlock()
    }
}
//      inline 修饰符影响函数本身和传给它的 lambda 表达式：所有这些都将内联到调用处。
//      内联可能导致生成的代码增加，但是如果我们使用得当（不内联大函数），它将在性能上有所提升，尤其是在循环中的“超多态（megamorphic）”调用处。

/**
 * 禁止内联
 */
//      如果你只想被（作为参数）传给一个内联函数的 lamda 表达式中只有一些被内联，你可以用 noinline 修饰符标记一些函数参数
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    // ……
}
//      可以内联的 lambda 表达式只能在内联函数内部调用或者作为可内联的参数传递， 但是 noinline 的可以以任何我们喜欢的方式操作：
// 存储在字段中、传送它等等。
//      需要注意的是，如果一个内联函数没有可内联的函数参数并且没有具体化的类型参数，编译器会产生一个警告，
// 因为内联这样的函数很可能并无益处（如果你确认需要内联，则可以关掉该警告）。

/**
 * 非局部返回
 */
//      在 Kotlin 中，我们可以只使用一个正常的、非限定的 return 来退出一个命名或匿名函数。这意味着要退出一个 lambda 表达式，
// 我们必须使用一个标签，并且在 lambda 表达式内部禁止使用裸 return，因为 lambda 表达式不能使包含它的函数返回：
fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // 从 hasZeros 返回
    }
    return false
}
//      位于 lambda 表达式中，但退出包含它的函数 称为非局部返回
//      请注意，一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，例如来自局部对象
// 或嵌套函数。在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，该 lambda 表达式参数需要用 crossinline 修饰符标记:
inline fun f(crossinline body: () -> Unit) {
    val f = object: Runnable {
        override fun run() = body()
    }
    // ……
}
//      break 和 continue 在内联的 lambda 表达式中还不可用，但我们也计划支持它们

/**
 * 具体化的类型参数
 */
// 有时候我们需要访问一个作为参数传给我们的一个类型：
fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T?
}
// 调用           treeNode.findParentOfType(MyTreeNode::class.java)
// ==> 进化版     treeNode.findParentOfType<MyTreeNode>()
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}
//      我们使用 reified 修饰符来限定类型参数，现在可以在函数内部访问它了， 几乎就像是一个普通的类一样。由于函数是内联的，不需要
// 反射，正常的操作符如 !is 和 as 现在都能用了。此外，我们还可以按照上面提到的方式调用它：myTree.findParentOfType<MyTreeNodeType>()。

// 虽然在许多情况下可能不需要反射，但我们仍然可以对一个具体化的类型参数使用它：
inline fun <reified T> membersOf() = T::class.members

fun main(s: Array<String>) {
    println(membersOf<StringBuilder>().joinToString("\n"))
}
// 普通的函数（未标记为内联函数的）不能有具体化参数。 不具有运行时表示的类型（例如非具体化的类型参数或者类似于Nothing的虚构类型） 不能用作具体化的类型参数的实参。

/**
 * 内联属性（自 1.1 起）
 */
// inline 修饰符可用于没有幕后字段的属性的访问器。 你可以标注独立的属性访问器：
//class Foo
class Bar
//val foo: Foo
//    inline get() = Foo()
//
//var bar: Bar
//    get() = /**……**/
//inline set(v) { /**……**/ }

// 你也可以标注整个属性，将它的两个访问器都标记为内联：
//inline var bar: Bar
//    get() = /**……**/
//    set(v) { /**……**/ }
// 在调用处，内联访问器如同内联函数一样内联。


