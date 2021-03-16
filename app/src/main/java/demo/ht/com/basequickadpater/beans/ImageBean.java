package demo.ht.com.basequickadpater.beans;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import demo.ht.com.basequickadpater.BR;
import demo.ht.com.basequickadpater.R;

/**
 * @author 正在蜕变的CV工程师
 * @ClassName ImageBean
 * 时间: 2021/1/22 14:48
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class ImageBean   extends BaseObservable {

    @Bindable
    private String  url;

    public ImageBean(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @BindingAdapter("url")  //bind后的名字任意起，注方法一定要为静态，否则报错
    public static void getImage(ImageView view, String url){
        Glide.with(view.getContext())
         .load(url)
         .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
         .into(view);
    }
}
