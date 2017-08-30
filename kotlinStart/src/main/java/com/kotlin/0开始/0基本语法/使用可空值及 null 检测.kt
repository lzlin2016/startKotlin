package com.kotlin.`0开始`.`0基本语法`

import com.kotlin.helloWorld.zuhe
import com.kotlin.helloWorld.zuhe as 组合 // 修改命名空间

/**
 * 项目名称: StartKotlin
 *
 * 类的描述: 使用可空值及 null 检测
 * 创建时间:  2017/7/19 11:36
 * 修改备注:
 */
fun main(args: Array<String>) {
    println(parseInt(5))
    println(parseInt("这是什么鬼"))

    println(parseInt(zuhe(5)))
    println(parseInt(组合(5)))
}

fun parseInt(obj: Any): Int? { // ? 可为空
    if (obj is Int) return obj // 自动类型转换
    else  { // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        println("obj is no an Int, obj = $obj")
        return null
    }
}