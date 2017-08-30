package www.ibenhong.com.startkotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout.HORIZONTAL
import org.jetbrains.anko.*

/**
 * 参考学习资料: https://segmentfault.com/p/1210000009463931/read
 */
class LoginActivity : AppCompatActivity() {
    var mActiivty: LoginActivity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginUi().setContentView(this@LoginActivity)
    }

    lateinit var et_account: EditText
    lateinit var et_password: EditText
    inner class LoginUi : AnkoComponent<LoginActivity> {
        override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
            verticalLayout {
                backgroundColor = context.resources.getColor(android.R.color.white)
                gravity = Gravity.CENTER_HORIZONTAL
                imageView(R.mipmap.ic_launcher).lparams {
                    width = dip(100)
                    height = dip(100)
                    topMargin = dip(64)
                }

                linearLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    orientation = HORIZONTAL
                    backgroundResource = R.drawable.selector_bg_sign
                    imageView {
                        image = resources.getDrawable(R.mipmap.ic_launcher)
                    }.lparams(width = dip(20), height = dip(20)) {
                        leftMargin = dip(6)
                        rightMargin = dip(6)
                    }
                    et_account = editText {
                        hint = "登录账户"
                        hintTextColor = Color.parseColor("#666666")
                        textSize = 16f
                        backgroundColor = Color.parseColor("#00FFFF")
                    }.lparams(weight = 1f)
                }.lparams(width = dip(300), height = dip(40)) {
                    topMargin = dip(45)
                }

                linearLayout {
                    orientation = HORIZONTAL
                    backgroundResource = R.drawable.selector_bg_sign
                    gravity = Gravity.CENTER_VERTICAL
                    imageView {
                        image = resources.getDrawable(R.mipmap.ic_launcher)
                    }.lparams(width = dip(20), height = dip(20))  {
                        leftMargin = dip(6)
                        rightMargin = dip(6)
                    }
                    et_password = editText {
                        hint = "登录密码"
                        hintTextColor = Color.parseColor("#666666")
                        textSize = 16f
                        background = null
                    }
                }.lparams {
                    width = dip(300)
                    height = dip(40)
                    topMargin = dip(10)

                }

                button("登录") {
                    gravity = Gravity.CENTER
                    background = resources.getDrawable(R.drawable.yuanjiao_biankuan_selected_radiu5)
                    textColor = Color.WHITE
                    onClick {
                        if (et_account.text.toString().isNotEmpty() && et_password.text.toString().isNotEmpty())
                            startActivity<MainActivity>() else toast("请输入账户或者密码")
                    }
                }.lparams(width = dip(300), height = dip(44)) {
                    topMargin = dip(18)
                }
                linearLayout {
                    orientation = HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    checkBox("记住密码") {
                        textColor = Color.parseColor("#666666")
                        textSize = 16f
                        leftPadding = dip(5)
                    }
                    textView("隐私协议") {
                        textColor = Color.parseColor("#1783e3")
                        gravity = Gravity.RIGHT
                        textSize = 16f
                    }.lparams(width = matchParent)
                }.lparams(width = dip(300)) {
                    topMargin = dip(18)
                }

                textView("Copyright © Code4Android") {
                    textSize = 14f
                    gravity = Gravity.CENTER or Gravity.BOTTOM

                }.lparams {
                    bottomMargin = dip(35)
                    weight = 1f
                }
            }
        }
    }
}
