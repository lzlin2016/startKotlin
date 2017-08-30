package www.ibenhong.com.startkotlin.bean

/**
 * SimpleBean

 * 类的描述: 简单通用bean , 用于项目中临时查看 kotlin 写法
 * 创建时间: 2017/8/29  18:03
 * 修改备注:
 */

class SimpleBean {

    var index: Int = 0
    var txt: String? = null

    override fun toString(): String {
        return "SimpleBean{" +
                "index=" + index +
                ", txt='" + txt + '\'' +
                '}'
    }
}

class Bean  {
    var index: Int = 0
    var txt: String? = null

    constructor(index: Int, txt: String?) {
        this.index = index
        this.txt = txt
    }

    override fun toString(): String {
        return "Bean1(index=$index, txt=$txt)"
    }
}
