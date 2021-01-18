package demo.ht.com.basequickadpater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import demo.ht.com.basequickadpater.adapters.RecyclerViewAdapter;
import demo.ht.com.basequickadpater.beans.ItemBean;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;

import java.util.ArrayList;
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
    }

    //跳转页面
    private void ToActivity(Class<?> activityClass) {
        startActivity(new Intent(MainActivity.this,activityClass));
    }
}