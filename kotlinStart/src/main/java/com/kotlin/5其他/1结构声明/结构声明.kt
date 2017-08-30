package com.kotlin.`5其他`.`1结构声明`

/**
 * 类的描述: 结构声明
 * 创建时间: 2017/8/28  15:06
 * 修改备注:
 */
fun main(args: Array<String>) {

}

//  解构声明 ==> 讲一个对象 解构 成很多变量 eg; val (name, age) = person
//  一个解构声明同事创建多个变量, 并且可以福利使用 eg: println(name)   println(age)
//  一个解构声明会被编译成以下代码; val name = person.component1()  val age = person.component2()
//  其中的 component1() 和 component2() 函数是在 Kotlin 中广泛使用的 约定原则 的另一个例子。
// （参见像 + 和 *、for-循环等操作符）。 任何表达式都可以出现在解构声明的右侧，只要可以对它调用
// 所需数量的 component 函数即可。 当然，可以有 component3() 和 component4() 等等。
//  请注意，componentN() 函数需要用 operator 关键字标记，以允许在解构声明中使用它们。
//eg.
class Status
data class Result(val result: Int, val status: Status)
fun function(/**......**/ ): Result {
    // 各种计算
    val result = 0
    val status = Status()

    return Result(result, status)
}
fun testFunction() {
    val (result, status) = function()
}
// 注意：我们也可以使用标准类 Pair 并且让 function() 返回 Pair<Int, Status>， 但是让数据合理命名通常更好。
//eg. 解构声明和映射
fun test1() { // 可能遍历一个映射（map）最好的方式就是这样：
    val map = hashMapOf<Int, String>()
    for ((key, value) in map) {
        // 使用该 key、value 做些事情
    }
}
// 为使其能用，我们应该
//  1. 通过提供一个 iterator() 函数将映射表示为一个值的序列，
//  2. 通过提供函数 component1() 和 component2() 来将每个元素呈现为一对。


// 下划线用于未使用的变量  ==>   如果在解构声明中你不需要某个变量，那么可以用下划线取代其名称：
//val (_, status) = getResult()


// 在 lambda 表达式中解构
//  你可以对 lambda 表达式参数使用解构声明语法。 如果 lambda 表达式具有 Pair 类型（或者 Map.Entry
// 或任何其他具有相应 componentN 函数的类型）的参数，那么可以通过将它们放在括号中来引入多个新参数来取代单个新参数
fun test2() {
    val map = hashMapOf<Int, String>()

    map.mapValues { entry -> "${entry.value}!" }
    map.mapValues{ (key, value) -> "$value!" }
}
// 注意声明两个参数和声明一个解构对来取代单个参数之间的区别：
//{ a //-> …… } // 一个参数
//{ a, b //-> …… } // 两个参数
//{ (a, b) //-> …… } // 一个解构对
//{ (a, b), c //-> …… } // 一个解构对以及其他参数
// 如果解构的参数中的一个组件未使用，那么可以将其替换为下划线，以避免编造其名称：
fun test3() {
    val map = hashMapOf<Int, String>()
    map.mapValues { (_, value) -> "$value!" }
}
// 你可以指定整个解构的参数的类型或者分别指定特定组件的类型：
fun test4() {
    val map = hashMapOf<Int, String>()

    map.mapValues { (_, value): Map.Entry<Int, String> -> "$value!" }
    map.mapValues { (_, value: String) -> "$value!" }
}