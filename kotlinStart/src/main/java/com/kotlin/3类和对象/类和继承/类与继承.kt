package com.kotlin.`3类和对象`

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 类与继承
 * 创建时间:  2017/8/21 14:26
 * 修改备注:
 */
fun main(args: Array<String>) {
    println("这是什么鬼")
    创建类的实例()
}

/**
 * 类 Kotlin 中使用关键字 class 声明类
 *  类声明由类名、类头（指定其类型参数、主构造函数等）和由大括号包围的类体构成。
 *  类头和类体都是可选的； 如果一个类没有类体，可以省略花括号。
 */
class Empty

/**
 * 构造函数
 * 在 Kotlin 中的一个类可以有一个主构造函数和一个或多个次构造函数。主构造函数是类头的一部分：它跟在类名（和可选的类型参数）后。
 */
class Person1 constructor(firstname: String) {   }
// 如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
class Person2 (firstname: String)
// 主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中：
class Customer1(name: String) {
    init {
        println("Customer initialized with value ${name}")
    }
}
//  注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用：
class Customer2(name: String ) {
    val customerKey= name.toUpperCase()
}
// 事实上，声明属性以及从主构造函数初始化属性，Kotlin 有简洁的语法：
class Person3(val firstname: String, val lastName: String, var age:Int) {   }
// 与普通属性一样，主构造函数中声明的属性可以是可变的（var）或只读的（val）。
// 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
//class Customer3 public @Inject constructor(name: String) {  }

/**
 * 次构造函数,  TODO 注释掉的为报错?????????????????????????????
 */
//// 类也可以声明前缀有 constructor的次构造函数：
//class Person10 {
//    constructor(parent: Person10) {
////        parent.children.add(this)
//    }
//}
//// 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。
//// 委托到同一个类的另一个构造函数用 this 关键字即可：
//class Person11(val name: String) {
//    constructor(name: String, parent: Person11) : this(name) {
////        parent.children.add(this)
//    }
//}
// 声明一个带有非默认可见性的空的主构造函数
class Person13 private constructor()
// 注意：在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。
// 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库。
class Customer10(val customerName: String = "") // 带参数, 默认customerName = ""

/**
 * 创建类的实例
 */
fun 创建类的实例() { // 注意 Kotlin 并没有 new 关键字。 创建嵌套类、内部类和匿名内部类的类实例在嵌套类中有述。
    val customer1 = Customer2("Test创建类的实例")
    println(customer1.customerKey)
}

/**
 * 类成员, 可以包含
 *  1. 构造函数和初始化块
 *  2. 函数
 *  3. 属性
 *  4. 嵌套类和内部类
 *  5. 对象声明
 */

/**
 * 继承
 *  在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认超类：
 */
class Example // 从 Any 隐式继承
// Any 不是 java.lang.Object；尤其是，它除了 equals()、hashCode()和toString()外没有任何成员。

// 要声明一个显式的超类型，我们把类型放到类头的冒号之后：
//open class Base(p: Int)
//class Derived(p: Int) : Base(p)
// 如果该类有一个主构造函数，其基类型可以（并且必须） 用（基类型的）主构造函数参数就地初始化。
// 如果类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
//  注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

/**
 * 覆盖属性
 */
//open class Base {
//    open fun v() {}
//    fun nv() {}
//}
//class Derived : Base() {
//    override fun v() {}
//}