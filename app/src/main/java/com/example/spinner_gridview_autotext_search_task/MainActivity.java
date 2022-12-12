package com.example.spinner_gridview_autotext_search_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spinner_gridview_autotext_search_task.Adapter.GridAdapter;
import com.example.spinner_gridview_autotext_search_task.Adapter.SpinnerAdapter;
import com.example.spinner_gridview_autotext_search_task.Model.GridModel;
import com.example.spinner_gridview_autotext_search_task.Model.SpinnerModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    SpinnerModel spinnerModel;
    SpinnerAdapter spinnerAdapter;
    List<SpinnerModel> spinnerModelList=new ArrayList<SpinnerModel>();


    //Gridview
    GridView gridView;
    GridAdapter gridAdapter;
    GridModel gridModel;
    List<GridModel> gridModelList=new ArrayList<>();

     EditText editText;
     List<GridModel> filterlist=new ArrayList<>();
//    ArrayAdapter<GridModel> arrayAdapter;
//   String IndiaStates[]={"Karnataka","Goa","Telangana","Maharashtra"};
//   String[] USAState= {"New South Wales","Victoria"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            spinner = findViewById(R.id.spinner_countries);
            gridView=findViewById(R.id.gridview1);
            editText=findViewById(R.id.edittxt);

            spinnerAdapter = new SpinnerAdapter(this, spinnerModelList);
            spinner.setAdapter(spinnerAdapter);

//            arrayAdapter=new ArrayAdapter<GridModel>(this,R.layout.custom_gridview,gridModelList);
//            gridView.setAdapter(arrayAdapter);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Toast.makeText(MainActivity.this, "Before text change", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    filterlist.clear();
                    if(charSequence.toString().isEmpty())
                    {
                        gridView.setAdapter(new GridAdapter(getApplicationContext(),gridModelList));
                        gridAdapter.notifyDataSetChanged();
                    }else
                    {
                        Filter(charSequence.toString());
                    }

//                   if (gridAdapter != null) {
//                      gridAdapter.getFilter().filter(charSequence);
//                       gridView.setAdapter(new GridAdapter(getApplicationContext(),gridModelList));
//                        gridAdapter.notifyDataSetChanged();
//
//                    } else {
//                       Filter(charSequence.toString());
//                        Log.d("filter", "no filter availible");
//                   }
//
//                                if(charSequence.toString().equals(""))
//                                {
//                                    searchstate();
//                                }
//                                else{
//                                    // searchname(charSequence.toString());
//                                }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    //Toast.makeText(MainActivity.this, "After text change", Toast.LENGTH_SHORT).show();
//                    filterlist.clear();
//                    if(editable.toString().isEmpty())
//                    {
//                        gridView.setAdapter(new GridAdapter(getApplicationContext(),gridModelList));
//                        gridAdapter.notifyDataSetChanged();
//                    }else
//                    {
//                        Filter(editable.toString());
//                    }
                }
            });

            loadCountryData();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Toast.makeText(MainActivity.this, "Selected :"+gridModelList.get(i).getStateName()+"\n"+
                            gridModelList.get(i).getStateLanguage(), Toast.LENGTH_SHORT).show();
                }
            });

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    Toast.makeText(MainActivity.this, ""+spinnerModelList.get(i).getCountryName(), Toast.LENGTH_SHORT).show();




                    if(spinnerModelList.get(i).getCountryName()=="India")
                    {

                        indiaStates();



                    }
                    else if(spinnerModelList.get(i).getCountryName()=="USA" || spinnerModelList.get(i).getCountryName()=="Australia")
                    {

                        usaStates();

                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
          //  LoadSearchStateIndia();
            //loadUsaStatesearch();

        }//end of try
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void Filter(String text) {
        for(GridModel grid:gridModelList)
        {
            if(grid.getStateName().contains(text))
            {
                filterlist.add(grid);
            }
        }
        gridView.setAdapter(new GridAdapter(getApplicationContext(),filterlist));
        gridAdapter.notifyDataSetChanged();
    }

//    private void searchstate() {
//        arrayAdapter=new ArrayAdapter<GridModel>(this, android.R.layout.select_dialog_item,gridModelList);
//       gridView.setAdapter(arrayAdapter);
//    }


//    private void LoadSearchStateIndia() {
//
//        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item,gridModelList);
//        gridView.setAdapter(arrayAdapter);
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                // Toast.makeText(MainActivity.this, "Before text change", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                arrayAdapter.getFilter().filter(charSequence);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                //Toast.makeText(MainActivity.this, "After text change", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//    }

    private void loadCountryData() {
        spinnerModel=new SpinnerModel(R.drawable.india,"India");
        spinnerModelList.add(spinnerModel);
        spinnerModel=new SpinnerModel(R.drawable.usaflag,"USA");
        spinnerModelList.add(spinnerModel);
        spinnerModel=new SpinnerModel(R.drawable.australia1,"Australia");
        spinnerModelList.add(spinnerModel);
        spinnerAdapter.notifyDataSetChanged();

    }
    private void indiaStates() {

        gridModelList.clear();
        gridModel=new GridModel(R.drawable.karnataka,"Karnataka","Kannada","Basavaraj Bommai","BJP");
       gridModelList.add(gridModel);
        gridModel=new GridModel(R.drawable.goa,"Goa","Konkani","Pramod Sawant","BJP");
        gridModelList.add(gridModel);
        gridModel=new GridModel(R.drawable.telangana1,"Telangana","Telugu","K.ChandraShekar Rao","Rashtra samithi");
        gridModelList.add(gridModel);
        gridModel=new GridModel(R.drawable.maharashtra,"Maharashtra","Marathi","Eknath Shinde","BJP");
        gridModelList.add(gridModel);

      gridAdapter=new GridAdapter(getApplicationContext(),gridModelList);
       gridView.setAdapter(gridAdapter);



    }

    private void usaStates() {

        gridModelList.clear();
        gridModel=new GridModel(R.drawable.new_south_wales,"New South Wales","English","capital","Sydney");
        gridModelList.add(gridModel);

        gridModel=new GridModel(R.drawable.victoria,"Victoria","English","capital","Melbourne");
        gridModelList.add(gridModel);

        gridAdapter=new GridAdapter(getApplicationContext(),gridModelList);
        gridView.setAdapter(gridAdapter);


    }


}