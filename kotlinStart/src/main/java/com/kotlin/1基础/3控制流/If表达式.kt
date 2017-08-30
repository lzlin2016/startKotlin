package com.kotlin.`1基础`.`3控制流`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: If表达式
 * 创建时间:  2017/7/19 17:57
 * 修改备注:在 Kotlin 中，if是一个表达式，即它会返回一个值。
 *          因此就不需要三元运算符（条件 ? 然后 : 否则），因为普通的 if 就能胜任这个角色。
 */
fun main(args: Array<String>) {

}

/**
 * 如果你使用 if 作为表达式而不是语句（
 *  例如：返回它的值或者把它赋给变量），该表达式需要有 else 分支。
 */
fun test(a: Int, b: Int) {
    // 传统用法
    var max1 = a
    if (a < b) max1 = b

    // With else
    var max2: Int
    if (a > b) {
        max2 = a
    } else {
        max2 = b
    }

    // 作为表达式
    val max3 = if (a > b) a else b
}