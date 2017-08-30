package com.kotlin.`5其他`.`8空安全`

/**
 * 类的描述: 空安全
 * 创建时间: 2017/8/28  16:30
 * 修改备注: NPE 描述Java 的 NullPointerException
 *  Kotlin 的类型系统旨在从我们的代码中消除 NullPointerException。NPE 的唯一可能的原因可能是
 *      1. 显式调用 throw NullPointerException()
 *      2. 使用了下文描述的 !! 操作符
 *      3. 外部 Java 代码导致的
 *      4. 对于初始化，有一些数据不一致（如一个未初始化的 this 用于构造函数的某个地方）
 */
fun main(args: Array<String>) {
}

// 可空类型与非空类型: String 非空引用, String? 可空引用

// 在条件中检查 null    只适用变量不可变的情况下, 否则可能在改变之后又变为空
fun test1(b: String) {
    val l = if (b != null) b.length else -1  // 显示手动检查

    if (b != null && b.length > 0) {
        print("String of length ${b.length}")
    } else {
        print("Empty string")
    }
}

//  安全的调用    第二个选择是安全调用操作符，写作 ?.
// eg.  b?.length   如果 b 非空，就返回 b.length，否则返回 null，这个表达式的类型是 Int?。
//      安全调用在链式调用中很有用。例如，如果一个员工 Bob 可能会（或者不会）分配给一个部门，
// 并且可能有另外一个员工是该部门的负责人，那么获取 Bob 所在部门负责人（如果有的话）的名字，我们写作：
// bob?.department?.head?.name      如果任意一个属性（环节）为空，这个链式调用就会返回 null。
//  如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用：
fun test2() {
    val listWithNulls: List<String?> = listOf("A", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // 输出 A 并忽略 null
    }
}

//  Elvis 操作符
//  当我们有一个可空的引用 r 时，我们可以说“如果 r 非空，我使用它；否则使用某个非空的值 x”：
// val l: Int = if (b != null) b.length else -1
//  除了完整的 if-表达式，这还可以通过 Elvis 操作符表达，写作 ?:：
// val l = b?.length ?: -1
//  如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
// 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
//  请注意，因为 throw 和 return 在 Kotlin 中都是表达式，所以它们也可以用在 elvis 操作符右侧。这可能会非常方便，例如，检查函数参数：
//fun foo(node: Node): String? {
//    val parent = node.getParent() ?: return null
//    val name = node.getName() ?: throw IllegalArgumentException("name expected")
//    // ……
//}

// !! 操作符
//  第三种选择是为 NPE 爱好者准备的。我们可以写 b!! ，这会返回一个非空的 b 值
// （例如：在我们例子中的 String）或者如果 b 为空，就会抛出一个 NPE 异常：
//  val l = b!!.length 因此，如果你想要一个 NPE，你可以得到它，但是你必须显式要求它，否则它不会不期而至

// 安全的类型转换
// 如果对象不是目标类型，那么常规类型转换可能会导致 ClassCastException。 另一个选择是使用安全的类型转换，如果尝试转换不成功则返回 null：
// val aInt: Int? = a as? Int

// 可空类型的集合
// 如果你有一个可空类型元素的集合，并且想要过滤非空元素，你可以使用 filterNotNull 来实现。
fun test4() {
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
}








