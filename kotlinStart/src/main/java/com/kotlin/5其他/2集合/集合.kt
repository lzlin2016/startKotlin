package com.kotlin.`5其他`.`2集合`

/**
 * 类的描述: 集合: List、Set、Map <== listOf()、 mutableListOf()、 setOf()、 mutableSetOf()、 mapOf()
 * 创建时间: 2017/8/28  15:33
 * 修改备注:
 */
fun main(args: Array<String>) {
    testList及Set类型的基本用法()
}

/**
 *      Kotlin 的 List<out T> 类型是一个提供只读操作如 size、get等的接口。和 Java 类似，
 * 它继承自 Collection<T> 进而继承自 Iterable<T>。改变 list 的方法是由 MutableList<T> 加入的。
 * 这一模式同样适用于 Set<out T>/MutableSet<T> 及 Map<K, out V>/MutableMap<K, V>。
 */
fun testList及Set类型的基本用法() {
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readonlyView: List<Int> = numbers
    println(numbers)        // 输出"[1, 2, 3]"
    numbers.add(4)
    println(readonlyView)   // 输出"[1, 2, 3, 4]"
//    readonlyView.clear() // --> 不能编译

    val strings  = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)
}
//      Kotlin 没有专门的语法结构创建 list 或 set。 要用标准库的方法，如 listOf()、 mutableListOf()、
// setOf()、 mutableSetOf()。 在非性能关键代码中创建 map 可以用一个简单的惯用法来完成：mapOf(a to b, c to d)

class Controller {
    private val _items = mutableListOf<String>()
    val items: List<String> get() = _items.toList()
}
fun testList和set有很多有用的扩展方法() {
    val items = listOf(1, 2, 3, 4)
    items.first() == 1
    items.last() == 4
    items.filter { it % 2 == 0 }   // 返回 [2, 4]

    val rwList = mutableListOf(1, 2, 3)
    rwList.requireNoNulls()        // 返回 [1, 2, 3]
    if (rwList.none { it > 6 }) println("No items above 6")  // 输出“No items above 6”
    val item = rwList.firstOrNull()
}
// Map 遵循同样模式。它们可以容易地实例化和访问，像这样：
fun test2() {
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // 输出“1”
    val snapshot: Map<String, Int> = HashMap(readWriteMap)
}