package org.maxwe.epub.android.lib.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.maxwe.epub.android.lib.EPubContainer;
import org.maxwe.epub.android.lib.model.EPub;

/**
 * Created by Pengwei Ding on 2016-01-05 16:28.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new EPubContainer(this, new EPub("test","/sdcard/YMEPub/sample.zip")));
    }
}
