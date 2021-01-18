package demo.ht.com.basequickadpater.beans;

import android.provider.MediaStore;

import com.chad.library.adapter.base.entity.SectionEntity;
/**
 * @ClassName ItemBean
 * 作者: szj
 * 时间: 2021/1/18 10:57
 * CSDN:https://blog.csdn.net/weixin_44819566
 * 公众号:码上变有钱
 */
public class SectionBean extends SectionEntity<MediaStore.Video> {
    private String name;

    /**
     *
     * @param isHeader    是否是多布局
     * @param header    参数name
     */
    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
        this.name = header;
    }

    public SectionBean(MediaStore.Video t) {
        super(t);
    }

    public String getName() {
        return name;
    }
}