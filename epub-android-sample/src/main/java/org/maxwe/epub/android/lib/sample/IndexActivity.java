package org.maxwe.epub.android.lib.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Pengwei Ding on 2016-03-05 16:11.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class IndexActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.org_maxwe_activity_index);
        View viewById = this.findViewById(R.id.org_maxwe_epub_act_index_open);
        viewById.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.org_maxwe_epub_act_index_open){
            Intent intent = new Intent(this, ReaderActivity.class);
            this.startActivity(intent);
        }
    }
}
