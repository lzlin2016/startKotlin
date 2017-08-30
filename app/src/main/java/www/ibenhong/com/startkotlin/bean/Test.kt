package www.ibenhong.com.startkotlin.bean

/**
 * Created by Administrator on 2017/8/29.
 */
data class Test(var errcode: Int,
                var errmsg: String,
                var data: Data) {
    data class Data(var orderDetail: OrderDetail) {
        data class OrderDetail(var `type`: String,
                               var id: String,
                               var name: String,
                               var orderid: String,
                               var betbonus: String,
                               var bonus: String,
                               var zjcount: String,
                               var bonusprop: String,
                               var fandian: String,
                               var actionno: String,
                               var actiontime: String,
                               var playedid: String,
                               var actiondata: String,
                               var actionnum: String,
                               var lotteryno: String,
                               var typeName: String,
                               var icon: String)
    }
}