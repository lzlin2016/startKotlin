package www.ibenhong.com.startkotlin

import android.widget.Toast

/**
 * 类的描述: Toast 工具类
 * 创建时间: 2017/8/29  10:16
 * 修改备注:
 */
object ToastUtils {
    var mToast: Toast = Toast.makeText(MyApplication.appContext, "", Toast.LENGTH_SHORT)

    fun show(info: String?) {
        mToast.setText(info)
        mToast.show()
    }

    fun dimiss() {
        mToast.cancel()
    }
}