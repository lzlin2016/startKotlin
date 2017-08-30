package www.ibenhong.com.startkotlin

//activity_login就是我们的布局
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import kotlinx.android.synthetic.main.activity_kotlin.*
import org.jetbrains.anko.*
import www.ibenhong.com.startkotlin.bean.Bean

/**
 * KotlinActivity 类
 *
 * 类的描述: 测试kotlin类
 * 创建时间: 2017/8/24  15:06
 * 修改备注:
 */

class KotlinActivity : AppCompatActivity(), OnClickListener {
    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            btnGotoIndex -> {
                ToastUtils.show("KotlinActivity start! ")
//                toast("这是什么鬼2")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            btnToast -> {
//                toast("这是什么鬼")
//                showDialog()
                startActivity<LoginActivity>()
            }
        }
    }

    /**
     * 实现快速对话框
     */
    fun showDialog() {
        alert ("我是Dialog"){
            yesButton { toast("yes")}
//            okButton { toast("ok") }
            noButton { toast("no")}
        }.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        btnGotoIndex.onClick { // 添加点击监听事件
            ToastUtils.show("KotlinActivity start! ")
//                toast("这是什么鬼2")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
//        btnGotoIndex.setOnClickListener(this)
        btnToast.setOnClickListener(this)

        testBean();

        val btnGotoIndex2 = find<Button>(R.id.btnGotoIndex) // 查找控件

        // 直接在代码中书写布局
//        verticalLayout {
//            val rg = radioGroup {
//                val cb1 = checkBox("这是什么鬼")
//                val cb2 = checkBox("这是什么鬼")
//                val cb3 = checkBox("这是什么鬼")
//                val rb1 = radioButton()
//                val rb2 = radioButton()
//                val rb3 = radioButton()
//            }
//            val tv = textView("我是一个TextView")
//            val edt = editText("EditText")
//            button("Button") {
//                onClick {
//                    toast("$!")
//                }
//            }
//        }
    }

    fun testBean() {
        for (index in 1..10) {
            var bean: Bean = Bean(index, "This is name${index}")
            println(bean.toString())
        }
    }
}
