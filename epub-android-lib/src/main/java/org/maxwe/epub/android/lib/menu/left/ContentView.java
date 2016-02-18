package org.maxwe.epub.android.lib.menu.left;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.maxwe.android.utils.views.tablist.IContent;
import org.maxwe.epub.android.lib.model.Content;

import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-18 17:10.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentView extends ListView implements IContent {
    private ArrayAdapter<String> stringArrayAdapter;
    public ContentView(Context context) {
        super(context);
        this.init();
    }

    public ContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();

    }

    public ContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
//        String[] strings = {
//                "00", "01", "02",
//                "03", "04", "05",
//                "06", "07", "08",
//                "09", "10", "11",
//                "12", "13", "14",
//                "15", "16", "17",
//                "18", "19", "20",
//                "21", "22", "23",
//                "24", "25", "26",
//                "27", "28", "29",
//        };
//        this.stringArrayAdapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, strings);
//        this.setAdapter(this.stringArrayAdapter);
    }

    public void init(List<Content> contents){
        String[] strings = new String[contents.size()];
        for (int index =0;index<contents.size();index++){
            strings[index] = contents.get(index).getDisplayName();
        }
        this.stringArrayAdapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, strings);
        this.setAdapter(this.stringArrayAdapter);
    }

}
