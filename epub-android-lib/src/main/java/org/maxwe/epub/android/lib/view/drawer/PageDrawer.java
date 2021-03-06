package org.maxwe.epub.android.lib.view.drawer;

import android.content.Context;
import android.widget.FrameLayout;

import org.maxwe.epub.typesetter.core.IParagraph;
import org.maxwe.epub.typesetter.core.ISection;
import org.maxwe.epub.typesetter.impl.dev.AudioSection;
import org.maxwe.epub.typesetter.impl.dev.ImageSection;
import org.maxwe.epub.typesetter.impl.dev.Page;
import org.maxwe.epub.typesetter.impl.dev.TextSection;
import org.maxwe.epub.typesetter.impl.dev.VideoSection;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2016-03-01 14:09.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class PageDrawer extends FrameLayout {

    private LinkedList<TextSection> textSections = new LinkedList<>();
    private LinkedList<ImageSection> imageSections = new LinkedList<>();
    private LinkedList<AudioSection> audioSections = new LinkedList<>();
    private LinkedList<VideoSection> videoSections = new LinkedList<>();

    public PageDrawer(Context context,Page page) {
        super(context);
        LinkedList<IParagraph> paragraphs = page.getParagraphs();
        for (IParagraph paragraph : paragraphs) {
            LinkedList<ISection> sections = paragraph.getSections();
            for (ISection section : sections) {
                if (section instanceof TextSection) {
                    this.textSections.add((TextSection)section);
                } else if (section instanceof ImageSection) {
                    this.imageSections.add((ImageSection)section);
                } else if (section instanceof AudioSection) {

                } else if (section instanceof VideoSection) {

                }
            }
        }

        if (!this.textSections.isEmpty()) {
            this.addView(new TextDrawer(this.getContext(), this.textSections));
        }

        if (!this.imageSections.isEmpty()) {
            this.addView(new ImageDrawer(this.getContext(),this.imageSections));
        }

        if (!this.audioSections.isEmpty()) {

        }

        if (!this.videoSections.isEmpty()) {

        }
    }
}
