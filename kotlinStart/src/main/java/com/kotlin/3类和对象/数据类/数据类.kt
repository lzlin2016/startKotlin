package com.kotlin.`3类和对象`.数据类

/**
 * 类的描述: 数据类
 * 我们经常创建一些只保存数据的类。在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data
 * 创建时间: 2017/8/25  15:30
 * 修改备注:
 */
//fun main(args: Array<String>) {
//    println(User().toString())
//    println(User(age = 6).toString()) // 后面参数, 必须指定字段
//    println(User("张三").toString()) // 前面参数, 可以不用指定字段
//    println(User("张三", 3).toString()) // 前面参数, 可以不用指定字段
//    val jack = User(name = "Jack", age = 1)
//    val olderJack = jack.copy(age = 20)
//}
//
//// 在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。
//data class User(val name: String = "", val age: Int = 0) {
//    // 复制一个对象, 改变他的一些属性, 其余部分保持不变, copy 本身自带
//    fun cp(name: String = this.name, age: Int = this.age) = User(name, age)
//}
//
//// 数据类和解构声明
//fun test() {
//    val jane = User("jane", 35)
//    val (name, age) = jane
//}