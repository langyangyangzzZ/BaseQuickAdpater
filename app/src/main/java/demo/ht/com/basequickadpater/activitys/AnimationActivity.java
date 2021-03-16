package demo.ht.com.basequickadpater.activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import demo.ht.com.basequickadpater.R;
import site.gemus.openingstartanimation.DrawStrategy;
import site.gemus.openingstartanimation.LineDrawStrategy;
import site.gemus.openingstartanimation.NormalDrawStrategy;
import site.gemus.openingstartanimation.OpeningStartAnimation;
import site.gemus.openingstartanimation.RedYellowBlueDrawStrategy;
import site.gemus.openingstartanimation.RotationDrawStrategy;
import site.gemus.openingstartanimation.WidthAndHeightOfView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Bundle;

public class AnimationActivity extends AppCompatActivity {

    private OpeningStartAnimation openingStartAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


//        RedYellowBlueDrawStrategy() 红黄绿动画
//        LineDrawStrategy()
//        RotationDrawStrategy()
//        NormalDrawStrategy() 默认


         openingStartAnimation = new OpeningStartAnimation.Builder(this)
                .setAppIcon(getResources().getDrawable(R.mipmap.log)) //设置图标
                .setColorOfAppIcon(Color.RED) //设置绘制图标线条的颜色
                .setAppName("开机动画") //设置app名称
                .setColorOfAppName(Color.YELLOW) //设置app名称颜色
                .setAppStatement("2021年1月23日,我还想要一次机会") //设置一句话描述
                .setColorOfAppStatement(Color.BLUE) // 设置一句话描述的颜色
                .setAnimationInterval(3000) // 设置动画时间间隔
                .setAnimationFinishTime(3000) // 设置动画的消失时长
                .create();

        openingStartAnimation.show(this);
    }
}