package www.ibenhong.com.startkotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import www.ibenhong.com.startkotlin.bean.Test;
import www.ibenhong.com.startkotlin.utils.GsonUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvAnysic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGotokotlin).setOnClickListener(this);
        findViewById(R.id.btnAnysic).setOnClickListener(this);
        tvAnysic = (TextView) findViewById(R.id.tvAnysic);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGotokotlin:
                startActivity(new Intent(this, KotlinActivity.class));
                finish();
                break;
            case R.id.btnAnysic:
                String info = "{\n" +
                        "    \"errcode\": 0, \n" +
                        "    \"errmsg\": \"ok\", \n" +
                        "    \"data\": {\n" +
                        "        \"orderDetail\": {\n" +
                        "            \"type\": \"38\", \n" +
                        "            \"id\": \"136238\", \n" +
                        "            \"name\": \"选码\", \n" +
                        "            \"orderid\": \"17070793865\", \n" +
                        "            \"betbonus\": \"2.00\", \n" +
                        "            \"bonus\": \"97.60\", \n" +
                        "            \"zjcount\": \"1\", \n" +
                        "            \"bonusprop\": \"97.60\", \n" +
                        "            \"fandian\": \"0.00\", \n" +
                        "            \"actionno\": \"2017079\", \n" +
                        "            \"actiontime\": \"2017-07-07 10:17:45\", \n" +
                        "            \"playedid\": \"305\", \n" +
                        "            \"actiondata\": \"7\", \n" +
                        "            \"actionnum\": \"1\", \n" +
                        "            \"lotteryno\": \"03,08,11,21,36,48,37\", \n" +
                        "            \"typeName\": \"这是什么鬼\", \n" +
                        "            \"icon\": \"icon-tic-liuhecai\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
                Test test = GsonUtils.INSTANCE.GsonToBean(info, Test.class);
                tvAnysic.setText(test.toString());
                break;
        }
    }
}
