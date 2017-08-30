package www.ibenhong.com.startkotlin

import android.app.Application
import android.content.Context

/**
 * Created by Administrator on 2017/8/29.
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}
