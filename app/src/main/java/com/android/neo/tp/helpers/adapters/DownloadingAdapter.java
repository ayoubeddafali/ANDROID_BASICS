package com.android.neo.tp.helpers.adapters;


import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.neo.tp.MainActivity;
import com.android.neo.tp.R;
import com.android.neo.tp.fragments.DownloadingFragment;
import com.android.neo.tp.helpers.models.Download;

import org.w3c.dom.Text;

import java.util.List;

public class DownloadingAdapter extends ArrayAdapter<Download> {
    private FragmentActivity fragment;
    public DownloadingAdapter(Context context, List<Download> downloads, FragmentActivity activity){
        super(context, 0, downloads);
        this.fragment = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Download item = (Download) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_fragment_item, parent, false);
        }
        TextView header = (TextView) convertView.findViewById(R.id.download_header);
        header.setText(item.getHeader());
        DownloadingFragment d = new DownloadingFragment();
        fragment.getSupportFragmentManager().beginTransaction().add(R.id.download_item_fragment, d).commit();

        return convertView;
    }

}
