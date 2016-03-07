package org.maxwe.epub.android.lib.view.drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

import org.maxwe.epub.typesetter.core.IMeta;
import org.maxwe.epub.typesetter.impl.dev.TextSection;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2016-03-01 13:56.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TextDrawer extends TextView {
    private LinkedList<TextSection> textSections;
    public TextDrawer(Context context, LinkedList<TextSection> textSections) {
        super(context);
        this.setWillNotDraw(false);
        this.textSections = textSections;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.getPaint().setTextSize(30);
        for (TextSection textSection:this.textSections){
            LinkedList<IMeta> metas = textSection.getMetas();
            for (IMeta meta : metas) {
                int startX = meta.getStartX();
                int startY = meta.getStartY();
                String value = meta.getValue();
                canvas.drawText(value, startX, startY, this.getPaint());
            }
        }
    }
}
