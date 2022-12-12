package com.example.spinner_gridview_autotext_search_task.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spinner_gridview_autotext_search_task.MainActivity;
import com.example.spinner_gridview_autotext_search_task.Model.GridModel;
import com.example.spinner_gridview_autotext_search_task.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter implements Filterable {
    Context contextl;
    List<GridModel> gridModelList=new ArrayList<>();
    LayoutInflater layoutInflater;
    GridView gridView;



    ArrayAdapter<GridModel> arrayAdapter;
    public GridAdapter(Context contextl, List<GridModel> gridModelList) {
        this.contextl = contextl;
        this.gridModelList = gridModelList;
        layoutInflater= (LayoutInflater) contextl.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return gridModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return gridModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.custom_gridview,null);
        ImageView stateimg=root.findViewById(R.id.stateimggrid);
        TextView textstatname=root.findViewById(R.id.textveiwstatename);
        TextView textStateLang=root.findViewById(R.id.textveiwstateLang);

        stateimg.setImageResource(gridModelList.get(i).getGridimage());
        textstatname.setText(gridModelList.get(i).getStateName());
        textStateLang.setText(gridModelList.get(i).getStateLanguage());
        return root;
    }

    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            }
        };
        return filter;
    }
}
