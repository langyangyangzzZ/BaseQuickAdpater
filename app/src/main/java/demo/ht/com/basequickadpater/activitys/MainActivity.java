package demo.ht.com.basequickadpater.activitys;

import androidx.appcompat.app.AppCompatActivity;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.utils.CRC16Utli;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
        Button bt5 = findViewById(R.id.bt5);
        Button bt6 = findViewById(R.id.bt6);
        Button bt7 = findViewById(R.id.bt7);
        Button bt8 = findViewById(R.id.bt8);
        Button bt9 = findViewById(R.id.bt9);

        /*
         * 普通布局
         */
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(OrdinaryActivity.class);
            }
        });

        /*
         * 双布局
         */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(SectionActivity.class);
            }
        });

        /*
         * 多布局
         */
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(MultiActivity.class);
            }
        });

        /*
         * 拖拽布局
         */
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(RemoveActivity.class);
            }
        });

        /**
         * 三级列表
         */
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(ExpandActivity.class);
            }
        });

        /**
         * 百分比布局
         */
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(PercentActivity.class);
            }
        });

        /**
         * DataBinding
         */
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(BinActivity.class);
            }
        });

        //内存泄露
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(LeakCanaryActivity.class);
            }
        });

        //开机动画
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivity(AnimationActivity.class);
            }
        });

    }


    //跳转页面
    private void ToActivity(Class<?> activityClass) {
        startActivity(new Intent(MainActivity.this, activityClass));
    }

    ArrayList<String> list = new ArrayList<String>() {{
        add("高温");
        add("低压");
        add("过放");
        add("过充");
        add("过压");
    }};

    public Random mRandom = new Random();

    String str = "";

    public void onTextClick(View view) {

        String buttonStr = list.get(mRandom.nextInt(list.size()));

        Toast.makeText(this, buttonStr, Toast.LENGTH_SHORT).show();

        //不包含
        if (!str.contains(buttonStr)) {
            str += buttonStr;
        }

        Log.i("buttonStr", str);


    }

    /**
     * CRC校验测试
     */
    public void onCRCClick(View view) {
        byte[] byCRC = new byte[]{0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8};

        //byCRC转换为 可校验的CRC int类型
        int crc16_usb = CRC16Utli.CRC16_USB(byCRC);

        //int类型转换为byte类型 (这里的bytes[0] bytes[1] 就是最终得到的CRC校验码)
        byte[] bytes = CRC16Utli.intTo2Byte(crc16_usb);

        ////byte转换为可查看的String类型
        String str = CRC16Utli.encodeHexStr(bytes);

        Log.i("CRC校验码测试", crc16_usb + "\n" + bytes.toString() + "\n" + str);
    }
}