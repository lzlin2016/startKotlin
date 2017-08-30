package www.ibenhong.com.startkotlin;

import android.widget.Toast;

/**
 * 类的描述: Toast 工具类
 * 创建时间: 2017/8/29  10:16
 * 修改备注:
 */
public class ToastUtil {
    private static Toast mToast = null;

    public static void show(String info) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.Companion.getAppContext(), info, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(info);
        }
        mToast.show();
    }

    public static void dimiss() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
