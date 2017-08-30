package com.kotlin.`3类和对象`.接口

/**
 * 类的描述: 接口     Kotlin 的接口与 Java 类似，既包含抽象方法的声明，也包含实现。
 *  与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。
 * 创建时间: 2017/8/24  17:25
 * 修改备注:
 */
// TODO lz 无法运行, 报错?????????????????????????????????????????????????????????????
fun main(args: Array<String>) {
    println("这是什么鬼")
}

//// 使用关键字 interface 来定义接口
//interface MyInterface {
//    val prop: Int // 抽象的
//    fun bar()
//
//    val propertyWithImplementation: String
//        get() = "foo"
//
//    fun foo() {
//        print(prop)
//    }
//}
//// 实现接口     一个类或者对象可以实现一个或多个接口。
////  你可以在接口中定义属性。在接口中声明的属性要么是抽象的，要么提供访问器的实现。
////  在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。
//class Child() : MyInterface {
//    override val prop: Int = 29
//
//    override fun bar() {
//        // 方法体
//        println("这是实现接口之后调用的方法 bar()")
//    }
//}