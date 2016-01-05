package org.maxwe.epub.android.lib.sample;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        Button open = (Button) inflate.findViewById(R.id.open);
        open.setOnClickListener(this);
        return inflate;
    }

    @Override
    public void onClick(View v) {
        this.startActivity(new Intent(this.getContext(),ReaderActivity.class));
    }
}
