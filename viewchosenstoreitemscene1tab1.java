package com.sari3food.sari3fooooooooood;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class viewchosenstoreitemscene1tab1 extends AppCompatActivity implements  Bottom_sheet_Dialoge_ta9yim.BottomSheetListener,CarRecyclerViewDataAdapter.AdapterCallback{

    BottomNavigationView navigationbottombar;

    List<List<String>> mobileArray;

    CarRecyclerViewDataAdapter carDataAdapter1;

    private TextView mTextView,mTextView1;
    Button btnstarvaleur;
    private List<CarRecyclerViewItem> carItemList = null;

    TextView textlistview ;
ListView listView;
    Integer i;
    LinearLayout bottomSheet;

    RecyclerView rc1;
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewchosenstoreitemscene1tab1);
        i=0;
        listView=findViewById(R.id.dynamiquelist);

        bottomSheet =findViewById(R.id.llBottomSheet);
          mobileArray = new ArrayList<>();

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setPeekHeight(280);


        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_child_toolbar);
        setSupportActionBar(myChildToolbar);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        ab.setTitle("");


        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        navigationbottombar = findViewById(R.id.bottombaritemscene1);
        navigationbottombar.getMenu().add(Menu.NONE, 1, Menu.NONE, "بيتزا");
        navigationbottombar.getMenu().add(Menu.NONE, 2, Menu.NONE, "معلبات");
        navigationbottombar.getMenu().add(Menu.NONE, 1, Menu.NONE, "بقلويات");
        navigationbottombar.getMenu().add(Menu.NONE, 2, Menu.NONE, "عجائن");

        navigationbottombar.getMenu().add(Menu.NONE, 2, Menu.NONE, "مشروبات");
        btnstarvaleur=findViewById(R.id.starbutton);
        mTextView = findViewById(R.id.textView7);
        mTextView1=findViewById(R.id.textView10);

        btnstarvaleur.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                Bottom_sheet_Dialoge_ta9yim bottomSheet = new Bottom_sheet_Dialoge_ta9yim();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });
        FloatingActionButton floatingActionButton= findViewById(R.id.floatingActionButton4);
        Button button = findViewById(R.id.butoontest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        carItemList = new ArrayList<CarRecyclerViewItem>();


      navigationbottombar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                CharSequence title = item.getTitle();
                if (title.equals("مشروبات")) {

                    carItemList.clear();

                  carItemList.add(new CarRecyclerViewItem("Audi", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("BMW", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Benz", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Jeep", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Audi", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("BMW", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Benz", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Jeep", R.drawable.penguins));

                    carItemList.add(new CarRecyclerViewItem("Audi", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("BMW", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Benz", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Jeep", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Audi", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("BMW", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Benz", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Jeep", R.drawable.penguins));





                }

                else if (title.equals("عجائن")) {
                    carItemList.clear();
                    carItemList.add(new CarRecyclerViewItem("Land Rover", R.drawable.penguins));
                    carItemList.add(new CarRecyclerViewItem("Future", R.drawable.penguins));


                }
                else {
                    carItemList.clear();
                }
                // Create the recyclerview.
                RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
                // Create the grid layout manager with 2 columns.
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                // Set layout manager.
                carRecyclerView.setLayoutManager(gridLayoutManager);

                // Create car recycler view data adapter with car item list.
                CarRecyclerViewDataAdapter carDataAdapter = new CarRecyclerViewDataAdapter(carItemList,viewchosenstoreitemscene1tab1.this);
                // Set data adapter.
                carRecyclerView.setAdapter(carDataAdapter);

                return true;
            }
        });








    }

    @Override
    public void onButtonClicked(String text) {
        mTextView.setText(text);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ResourceType")
    @Override
    public void onMethodCallback(String text)
    {
        List<String> x = new ArrayList<>();
        x.add(text);
        x.add("1");

        TextView txt=findViewById(R.id.textView10);
        if(txt.getText().equals(null)){
            txt.setText("1");
            mobileArray.add(x);






        }else {
            txt.setText(String.valueOf(Integer.parseInt(txt.getText().toString())+1));

boolean fined=false;

            for (List<String> object: mobileArray) {
               if(text.equals(object)){
                   fined=true;
               }
            }


            if(!fined)
            {
                x.add(text);
                x.add("1");
                mobileArray.add(x);
            }


        }
        if(txt.getText().equals("3"))
        {
            Toast.makeText(viewchosenstoreitemscene1tab1.this,text,Toast.LENGTH_SHORT).show();
        }

        ArrayList<String> mobile12= new ArrayList<>();
        mobile12.clear();
        for(int i=0;i<mobileArray.size();i++)
        {
            for(int j=i+1;j<mobileArray.size();j++)
        {
            if(mobileArray.get(i).get(0).equals(mobileArray.get(j).get(0)))
            {
                List<String> y = new ArrayList<>();
                y.add(mobileArray.get(i).get(0));
                y.add(String.valueOf(Integer.valueOf(mobileArray.get(i).get(1))+1));
                mobileArray.set(i,y);

                mobileArray.remove(mobileArray.get(j));


        }

        }

        }
        for(int i=0;i<mobileArray.size();i++)
        {
            mobile12.add( mobileArray.get(i).get(0)+"................"+ mobileArray.get(i).get(1));
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.textviewdynamiquelist,mobile12);

        listView.setAdapter(adapter);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onMethodCallback2(String text) {
        TextView txt=findViewById(R.id.textView10);
        if(!txt.getText().equals(null))
        {
            if(!txt.getText().equals("0") && Integer.valueOf(txt.getText().toString()) > 0)
            {
                for(int i=0;i<mobileArray.size();i++)
                {

                        if(mobileArray.get(i).get(0).equals(text))
                        {
                            List<String> y = new ArrayList<>();
                            y.add(mobileArray.get(i).get(0));

                            y.add(String.valueOf(Integer.valueOf(mobileArray.get(i).get(1))-1));
                            mobileArray.set(i,y);


                            if(mobileArray.get(i).get(1).equals("0"))
                            {
                                mobileArray.remove(mobileArray.get(i));
                            }


                        }



                }
                txt.setText(String.valueOf(Integer.parseInt(txt.getText().toString())-1));
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                mobileArray.remove(text);
            }else{
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }

        }
        if(txt.getText().equals("3"))
        {
            Toast.makeText(viewchosenstoreitemscene1tab1.this,text,Toast.LENGTH_SHORT).show();
        }

        ArrayList<String> mobile12= new ArrayList<>();
        mobile12.clear();

        for(int i=0;i<mobileArray.size();i++)
        {
            mobile12.add( mobileArray.get(i).get(0)+"................"+ mobileArray.get(i).get(1));
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.textviewdynamiquelist,mobile12);

        listView.setAdapter(adapter);


    }
}
