package com.kotlin.`1基础`.`1基本类型`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 字符串
 * 创建时间:  2017/7/19 17:08
 * 修改备注:
 */
fun main(args: Array<String>) {
//    test()
//    strFor()
    ziMianZhi() // 字符串字面值
}

/**
 * 同一个包名下面不能含有两个相同名称的方法名, 解决思路
 *  1. 声明所有对应该方法为 private, 私有的
 *  2. 只有两个方法时, 可以采用不同的命名方式
 * 给方法命名, 第二种方式
 */
val test = fun() {
    println("这是什么鬼")
}

/**
 * 字符串的元素——字符可以使用索引运算符访问: s[i]。
 * 可以用 for 循环迭代字符串:
 */
fun strFor() {
    val str = "这是什么鬼"
    for (c in str) {
        println(c)
    }
}

/**
 * 字符串字面值
 */
fun ziMianZhi() {
    // 转义采用传统的反斜杠方式
    val str = "Hello, world!\n"
    println(str)

    // TODO lz """括起来的表示强制不转义, 注释也不解析
    // 通过 trimMargin() 函数去除前导空格：
    // 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    val text = """
    每行第一个|表示改行起始位置
    |\n |12 // 不能在这边注释
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)
}
