package demo.ht.com.basequickadpater.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import demo.ht.com.basequickadpater.R;
import demo.ht.com.basequickadpater.databinding.ActivityLeakCanaryBinding;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

public class LeakCanaryActivity extends AppCompatActivity {

    private ActivityLeakCanaryBinding viewDataBinding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_leak_canary);
        test();
        Log.i("内存泄露执行","onCreate");
    }
    //这儿发生泄漏
    public  void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}