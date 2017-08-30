package com.kotlin.`5其他`.`4类型检查及转换`

/**
 * 类的描述: 类型的检查与转换“is”与“as”
 *          as   不安全的转换    val x1: String? = y as String? // 需要换成可空类型
 *          as?  安全的转换      val x: String? = y as? String  // 可以为空
 * 创建时间: 2017/8/28  16:07
 * 修改备注: is 取反 !is 操作符
 */
fun main(args: Array<String>) {

}

/**
 * 智能转换 不需要显示转换, 编译器追踪is-检查, 并在需要的时候自动插入(安全的)转换
 */
fun demo(x: Any) {
    if (x is String) {
        print(x.length) // x 自动转换为字符串
    }

    if (x !is String) return
    print(x.length) // x 自动转换为字符串

    // 或者在 && 和 || 的右侧：
    // `||` 右侧的 x 自动转换为字符串
    if (x !is String || x.length == 0) return
    // `&&` 右侧的 x 自动转换为字符串
    if (x is String && x.length > 0) {
        print(x.length) // x 自动转换为字符串
    }

    // 这些 智能转换 用于 when-表达式 和 while-循环 也一样：
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}

/**
 * 智能转换 适用规则
 *  1. val 局部变量——总是可以；
 *  2. val 属性——如果属性是 private 或 internal，或者该检查在声明属性的同一模块中执行。智能转换不适用于 open 的属性或者具有自定义 getter 的属性；
 *  3. var 局部变量——如果变量在检查和使用之间没有修改、并且没有在会修改它的 lambda 中捕获；
 *  4. var 属性——决不可能（因为该变量可以随时被其他代码修改）。
 */


// “不安全的”转换操作符      通常，如果转换是不可能的，转换操作符会抛出一个异常。
// 因此，我们称之为不安全的。 Kotlin 中的不安全转换由中缀操作符 as（参见operator precedence）完成：
fun demo1() {
    val y = null
    val x: String = y as String
    val x1: String? = y as String?
}

// “安全的”（可空）转换操作符   为了避免抛出异常，可以使用安全转换操作符 as?，它可以在失败时返回 null：
fun demo2() {
    val y = null
    val x: String? = y as? String
    // 请注意，尽管事实上 as? 的右边是一个非空类型的 String，但是其转换的结果是可空的。
}