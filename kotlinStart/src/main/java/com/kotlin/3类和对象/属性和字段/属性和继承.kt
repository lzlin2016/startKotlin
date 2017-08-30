//package 属性和参继承
//
///**
// * 类的描述: 属性和继承
// * 创建时间: 2017/8/24  16:05
// * 修改备注:
// */
//fun main(args: Array<String>) {
//    println("== 继承 ==")
//    Derived1(2).printInfo()
//    println("== 覆盖方法 ==")
//    Derived2().v()
//    Derived2().v1()
//    Derived2().nv()
//    println("== 覆盖属性 ==")
//    println("Bar0().x = ${Bar0().x}")
//    println("Bar11().count = ${Bar11(2).count}")
//    println("Bar12().count = ${Bar12().count}")
//    println("== 调用超类实现 ==")
//    println("Bar2().x = ${Bar2().x}")
//    Bar2().f()
//    println("== 内部类 ==")
//    Bar3().Baz().g()
//    println("== 覆盖规则 ==")
//    C().f()
//    println("== XXX ==")
//}
//
///**
// * 继承
// *  如果该类有一个主构造函数，其基类型可以（并且必须） 用（基类型的）主构造函数参数就地初始化。
// *  如果类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
// *  注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
// */
//open class Base1(p: Int)
//class Derived1(p: Int) : Base1(p) {
//    val info: Int = p;
//    fun printInfo() = println("info = $info")
//}
//
///**
// * 覆盖方法
// *  我们之前提到过，Kotlin 力求清晰显式。与 Java 不同，Kotlin 需要显式标注可覆盖的成员
// *  （我们称之为开放）和覆盖后的成员：
// */
//open class Base2 {
//    open fun v() = println("Base2 v")
//    open fun v1() = println("Base2 v1")
//    fun nv() = println("Base2 nv")
//}
//class Derived2 : Base2() {
//    override fun v() { // 覆盖方法, 默认是open
//        println("Derived2 v")
//    }
//    final override fun v1() { // 覆盖方法, 不能再在子类重写
//        println("Derived2 v1")
//    }
//}
//
///**
// * 覆盖属性
// *  属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。
// *  每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖。
// */
//open class Foo0 {
//    open val x: Int get() = 0 // 常量必须要初始化
//}
//class Bar0 : Foo0() {
//    override var x: Int = 1 // 可以使用var 覆盖val, 反之不行
//}
//// 注意，可以在主构造函数中使用 override 关键字作为属性声明的一部分。
//interface Foo1 {
//    val count: Int
//}
//class Bar11(override val count: Int) : Foo1
//class Bar12 : Foo1 {
//    override var count: Int = 0
//}
//
///**
// * 调用超类实现
// */
//open class Foo3 {
//    open fun f() { println("Foo3.f()") }
//    open val x: Int get() = 1
//}
//class Bar2 : Foo3() {
//    override val x: Int get() = super.x + 1
//    override fun f() {
//        super.f() // 是否继承父类的方法
//        println("Bar2.f()")
//    }
//}
//// 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer： super@类名
//class Bar3 : Foo3() {
//    override fun f() {
//        println("Foo3.f()")
//    }
//    override val x: Int get() = 0
//    inner class Baz {
//        fun g() {
//            super@Bar3.f() // 调用 Foo 实现的 f()
//            println("Foo3.x = ${super@Bar3.x}" ) // 使用 Foo 实现的 x 的 getter
//        }
//    }
//}
//
///**
// * 覆盖规则
// *  在 Kotlin 中，实现继承由下述规则规定：
// *      如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
// *      为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>：
// */
//open class A {
//    open fun f() { println("A") }
//    fun a() { println("a") }
//}
//interface B {
//    fun f() { println("B") } // // 接口成员默认就是“open”的
//    fun b() { println("b") }
//}
//class C : A(), B {
//    override fun f() {   // 编译器要求覆盖 f()：  同时继承两个实现, 需要使用super<Base> 来消除歧义
//        super<A>.f() // 调用 A.f()
//        super<B>.f() // 调用 B.f()
//    }
//}
//
///**
// * 抽象类
// *  类和其中的某些成员可以声明为 abstract 。 抽象成员在本类中可以不用实现。
// *  需要注意的是，我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
// */
//open class Base {
//    open fun f() {}
//}
//abstract class Derived : Base() {
//    override abstract fun f()
//}
//class Sun : Derived() {
//    override fun f() {
//        println("这是什么鬼")
//    }
//}
//
///**
// * 伴生对象
// *  与 Java 或 C# 不同，在 Kotlin 中类没有静态方法。在大多数情况下，它建议简单地使用包级函数。
// *  如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数（例如，工厂方法），你可以把它写成该类内对象声明中的一员。
// *  更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以使用像在 Java/C# 中调用静态方法相同的语法来调用其成员，只使用类名作为限定符。
// */