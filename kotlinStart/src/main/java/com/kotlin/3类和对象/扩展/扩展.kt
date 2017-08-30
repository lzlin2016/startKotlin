package com.kotlin.`3类和对象`.扩展

/**
 * 类的描述: 扩展
 * 创建时间: 2017/8/25  15:01
 * 修改备注:
 */
fun main(args: Array<String>) {
    // val arrayListOf = arrayListOf(1, 2, 3, 4) 得到一个数组, 暂无区别, 建议用 mutableListOf
    val mutableListOf  = mutableListOf(1, 2, "泛化", 4)
    println(mutableListOf)
    mutableListOf.swap(0, 2) // “swap()”内部的“this”得到“mutableListOf”的值, 交换第0和第2位的数值
    println(mutableListOf)
}

/**
 * 扩展函数
 */
// 声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。
//fun MutableList<Int>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // “this”对应该列表
//    this[index1] = this[index2]
//    this[index2] = tmp
//}
// 泛化
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

// 扩展是静态解析的     扩展不能真正的修改他们所扩展的类。
// 通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。

// 如果一个类定义有一个成员函数和一个扩展函数，而这两个函数又有相同的接收者类型、相同的名字并且都适用给定的参数，这种情况总是取成员函数
// 当然，扩展函数重载同样名字但不同签名成员函数也完全可以

/**
 * 可空接收者
 */
// 注意可以为可空的接收者类型定义扩展。这样的扩展可以在对象变量上调用， 即使其值为 null，并且可以在函数体内检测 this == null，
// 这能让你在没有检测 null 的时候调用 Kotlin 中的toString()：检测发生在扩展函数的内部。
fun Any?.toString(): String {
    if (this == null)   return "null"
    // 空检测之后, "this"会自动转换为非空类型, 所以下面的toString解析为Any 类的成员函数
    return toString()
}

// 扩展属性
val <T> List<T>.lastIndex: Int
    get() = size - 1
//      注意：由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
// 这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义。

//// 伴生对象的扩展
//class MyClass {
//    companion object {  }   // 将被称为" Companion "
//}
//fun MyClass.Companion.foo () {
//    // ...
//}
//// 就像伴生对象的其他普通成员，只需用类名作为限定符去调用他们
//fun test() {
//    MyClass.foo() // 直接调用
//}

// 扩展的作用域
//package com.example.usage
//import foo.bar.goo // 导入所有名为“goo”的扩展
//// 或者
//import foo.bar.*   // 从“foo.bar”导入一切
//fun usage(baz: Baz) {
//    baz.goo()
//}

/**
 * 扩展声明为成员
 */
// 在一个类内部你可以为另一个类声明扩展。在这样的扩展内部，有多个 隐式接收者 —— 其中的对象成员可以无需通过限定符访问。
// 扩展声明所在的类的实例称为 分发接收者，扩展方法调用所在的接收者类型的实例称为 扩展接收者 。
//class D {
//    fun bar() {  }
//}
//class C {
//    fun baz() {  }
//
//    fun D.foo() {
//        bar()   // 调用 D.bar
//        baz()   // 调用 C.baz
//    }
//
//    fun caller(d: D) {
//        d.foo()   // 调用扩展函数
//    }
//}
// 对于分发接收者和扩展接收者的成员名字冲突的情况，扩展接收者优先。要引用分发接收者的成员你可以使用 限定的 this 语法。
// 声明为成员的扩展可以声明为 open 并在子类中覆盖。这意味着这些函数的分发对于分发接收者类型是虚拟的，但对于扩展接收者类型是静态的

// 动机

// 在Java中，我们将类命名为“*Utils”：FileUtils、StringUtils 等，著名的 java.util.Collections 也属于同一种命名方式。 关于这些 Utils-类的不愉快的部分是代码写成这样：

// Java
//Collections.swap(list, Collections.binarySearch(list, Collections.max(otherList)), Collections.max(list))
//这些类名总是碍手碍脚的，我们可以通过静态导入达到这样效果：

// Java
//swap(list, binarySearch(list, max(otherList)), max(list))
//这会变得好一点，但是我们并没有从 IDE 强大的自动补全功能中得到帮助。如果能这样就更好了：

// Java
//list.swap(list.binarySearch(otherList.max()), list.max())

//但是我们不希望在 List 类内实现这些所有可能的方法，对吧？这时候扩展将会帮助我们。