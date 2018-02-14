package com.pace.cs639spring.hw2.cs639springhw2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Message;
import android.provider.CalendarContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

Button _btnRed;
Button _btnAddF;
ListObject _lstListItem;
int _intPosition;

TextView txt;

    public ListObject getlistItem() {
        return _lstListItem;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureListView();
    }

    private void configureListView() {
        final ListView listView = findViewById(R.id.lstView);
        final EditText myAddFactEditText = findViewById(R.id.edtText);
        _btnAddF = findViewById(R.id.btnAddFact);
        _intPosition = -1;
        listView.setItemsCanFocus(false);
        final List<ListObject> lObjects = new ArrayList<>();
        List<String> _lstCatDesc = new ArrayList<String>();
        List<String> _lstDogDesc = new ArrayList<String>();
        List<String> _lstBirdDesc = new ArrayList<String>();
        List<String> _lstElephantDesc = new ArrayList<String>();
        List<String> _lstLizardDesc = new ArrayList<String>();
        List<String> _lstMonkeyDesc = new ArrayList<String>();
        List<String> _lstPigDesc = new ArrayList<String>();
        List<String> _lstSnakeDesc = new ArrayList<String>();
        List<String> _lstCowdDesc = new ArrayList<String>();
        List<String> _lstDeerDesc = new ArrayList<String>();


        _lstBirdDesc.add("This is a bird");
        _lstCatDesc.add("This is a Cat");
        _lstDogDesc.add("This is a Dog");
        _lstElephantDesc.add("This is a Elephant");
        _lstLizardDesc.add("This is a Lizard");
        _lstMonkeyDesc.add("This is a Monkey");
        _lstPigDesc.add("This is a Pig");
         _lstSnakeDesc.add("This is a Snake");
        _lstCowdDesc.add("This is a Cow");
        _lstDeerDesc.add("This is a Deer");

        lObjects.add(new ListObject(R.drawable.bird, _lstBirdDesc));
        lObjects.add(new ListObject(R.drawable.cat, _lstCatDesc));
        lObjects.add(new ListObject(R.drawable.dog, _lstDogDesc));
        lObjects.add(new ListObject(R.drawable.elephant, _lstElephantDesc));
        lObjects.add(new ListObject(R.drawable.lizard, _lstLizardDesc));
        lObjects.add(new ListObject(R.drawable.monkey, _lstMonkeyDesc));
        lObjects.add(new ListObject(R.drawable.pig, _lstPigDesc));
        lObjects.add(new ListObject(R.drawable.snake, _lstSnakeDesc));
        lObjects.add(new ListObject(R.drawable.cow, _lstCowdDesc));
        lObjects.add(new ListObject(R.drawable.deer, _lstDeerDesc));




        final AnimalDisplayListViewAdapter adapter = new AnimalDisplayListViewAdapter(this,lObjects);
        listView.setAdapter(adapter);

        _btnAddF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Toast.makeText(MainActivity.this,"In add fact click",Toast.LENGTH_LONG ).show();

                if(_intPosition < 0 || _intPosition > lObjects.size()){
                    Toast.makeText(MainActivity.this,"Please select an image",Toast.LENGTH_LONG ).show();
                }
            else {
                    ListObject myObject = lObjects.get(_intPosition);
                    String strTemp = myAddFactEditText.getText().toString();
                    myObject.mName.add(strTemp);

                    Toast.makeText(MainActivity.this, "Fact Added", Toast.LENGTH_LONG).show();
                    adapter.notifyDataSetChanged();
                }

            }
        });




        /*final Button _btnRed = findViewById(R.id.btnRed);
        _btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            _intPosition = position;
            _lstListItem =  (ListObject) listView.getSelectedItem();


        }
    });
}


    }

