package org.maxwe.epub.android.lib.view.drawer;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import org.maxwe.epub.typesetter.core.IMeta;
import org.maxwe.epub.typesetter.impl.dev.ImageSection;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2016-03-01 13:56.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图片显示区域
 */
public class ImageDrawer extends ImageView {
    private LinkedList<ImageSection> imageSections;
    public ImageDrawer(Context context, LinkedList<ImageSection> imageSections) {
        super(context);
        this.setWillNotDraw(false);
        this.imageSections = imageSections;
        for (ImageSection imageSection:imageSections){
            LinkedList<IMeta> metas = imageSection.getMetas();
            for (IMeta iMeta:metas){
                this.setImageURI(Uri.parse(iMeta.getValue()));
            }
        }
    }
}
