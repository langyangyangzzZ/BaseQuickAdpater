package demo.ht.com.basequickadpater.beans;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import demo.ht.com.basequickadpater.BR;

/**
 * @author 正在蜕变的CV工程师
 * @ClassName FromBean
 * 时间: 2021/1/25 9:32
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class FromBean  extends BaseObservable {

    /**
     * content : 墉集欺猫鼠，林藏逐雀鹯。
     * origin : 中秋咏怀借杜子美秋日述怀一百韵和寄柳州假鸣桑先生
     * author : 徐威
     * category : 古诗文-动物-写猫
     */

    private String content;
    private String origin;
    private String author;
    private String category;

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
        notifyPropertyChanged(BR.origin);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }

    @Bindable
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }
}
