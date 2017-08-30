package com.kotlin.`3类和对象`.属性和字段

/**
 * 类的描述: 属性和字段
 * 创建时间: 2017/8/24  16:46
 * 修改备注:
 */

fun main(args: Array<String>) {
}

// var 需要显示初始化器, 隐含默认 getter() 和 setter()
// val 必须 在构造函数中初始化, 或者直接初始化, 只含有默认 getter()

// 按照惯例，setter 参数的名称是 value
//  自 Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它：
//  val isEmpty get() = this.size == 0  // 具有类型 Boolean

// 需要改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现， 你可以定义访问器而不定义其实现
var setterVisibility: String = "abc"
    private set // 此 setter 是私有的并且有默认实现

// 幕后字段
//  Kotlin 中类不能有字段。然而，当使用自定义访问器时，有时有一个幕后字段（backing field）有时是必要的。
// 为此 Kotlin 提供一个自动幕后字段，它可通过使用 field 标识符访问。
var counter = 0 // 此初始器值直接写入到幕后字段
    set(value) {
        if (value >= 0)
            field = value
    }
//  field 标识符只能用在属性的访问器内。

// 幕后属性
private var _table: Map<String, Int>? = null
// 从各方面看，这正是与 Java 相同的方式。因为通过默认 getter 和 setter 访问私有属性会被优化，所以不会引入函数调用开销。
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // 类型参数已推断出
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

/**
 * 编译期常量
 *  已知值的属性可以使用 const 修饰符标记为 编译期常量。 这些属性需要满足以下要求：
 *  1. 位于顶层或者是 object 的一个成员
 *  2. 用 String 或原生类型 值初始化
 *  3. 没有自定义 getter
 */
// 这些属性可以用在注解中：
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { /****/ }

/**
 * 延迟初始化属性
 *  用 lateinit 修饰符标记该属性：
 */
//public class MyTest {
//    lateinit var subject: TestSubject
//
//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // 直接解引用
//    }
//}
/**
 * 该修饰符只能用于在类体中（不是在主构造函数中）声明的 var 属性，并且仅当该属性没有自定义 getter 或 setter 时,
 * 该属性必须是非空类型，并且不能是原生类型。
 * 在初始化前访问一个 lateinit 属性会抛出一个特定异常，该异常明确标识该属性被访问及它没有初始化的事实。
 */