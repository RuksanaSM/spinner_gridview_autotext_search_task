package com.example.spinner_gridview_autotext_search_task.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spinner_gridview_autotext_search_task.Model.GridModel;
import com.example.spinner_gridview_autotext_search_task.Model.SpinnerModel;
import com.example.spinner_gridview_autotext_search_task.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    List<SpinnerModel> spinnerModelList=new ArrayList<>();
    LayoutInflater layoutInflater;
    List<GridModel> gridModelList=new ArrayList<>();

//    public SpinnerAdapter(Context context,List<GridModel> gridModelList) {
//        this.context = context;
//        this.gridModelList = gridModelList;
//
//    }

    public SpinnerAdapter(Context context, List<SpinnerModel> spinnerModelList) {
        this.context = context;
        this.spinnerModelList = spinnerModelList;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spinnerModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View root=layoutInflater.inflate(R.layout.custom_spinner,null);
        ImageView imgvw=root.findViewById(R.id.image_view_flag_Spinner);
        TextView txtvw=root.findViewById(R.id.text_view_spinner_name);

        imgvw.setImageResource(spinnerModelList.get(i).getImage());
        txtvw.setText(spinnerModelList.get(i).getCountryName());

        return root;
    }
}
