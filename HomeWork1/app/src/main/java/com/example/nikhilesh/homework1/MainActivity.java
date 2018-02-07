package com.example.nikhilesh.homework1;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // variable declaration

    ImageView imgBird;
    ImageView imgCat;
    ImageView imgDog;
    TextView txtBird;
    TextView txtCat;
    TextView txtDog;
    Button btnRed;
    Button btnBlue;
    Button btnYellow;
    Button btnGreen;
    Button btnOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBird = findViewById(R.id.imgFirstImage);
        imgCat = findViewById(R.id.imgSecondImage);
        imgDog = findViewById(R.id.imgThirdImage);

        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnYellow = findViewById(R.id.btnYellow);
        btnGreen = findViewById(R.id.btnGreen);
        btnOrange = findViewById(R.id.btnOrange);

        txtBird = findViewById(R.id.txtBird);
        txtBird.setVisibility(View.INVISIBLE);
        txtCat = findViewById(R.id.txtCat);
        txtCat.setVisibility(View.INVISIBLE);
        txtDog = findViewById(R.id.txtDog);
        txtDog.setVisibility(View.INVISIBLE);

        imgBird.setOnClickListener(this);
        imgCat.setOnClickListener(this);
        imgDog.setOnClickListener(this);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnOrange.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {


switch(view.getId()){


    // display or hide the text of the textview according to the image selected
    case R.id.imgFirstImage:
        if(txtBird.getVisibility() == View.INVISIBLE)
        {

            txtBird.setVisibility(View.VISIBLE);
            txtCat.setVisibility(View.INVISIBLE);
            txtDog.setVisibility(View.INVISIBLE);
            break;
        }

        if(txtBird.getVisibility() == View.VISIBLE)
        {
            txtBird.setVisibility(View.INVISIBLE);
            break;
        }

    case R.id.imgSecondImage:
        if(txtCat.getVisibility() == View.INVISIBLE)
        {

            txtCat.setVisibility(View.VISIBLE);
            txtBird.setVisibility(View.INVISIBLE);
            txtDog.setVisibility(View.INVISIBLE);
            break;
        }

        if(txtCat.getVisibility() == View.VISIBLE)
        {
            txtCat.setVisibility(View.INVISIBLE);
            break;
        }

    case R.id.imgThirdImage:
        if(txtDog.getVisibility() == View.INVISIBLE)
        {

            txtDog.setVisibility(View.VISIBLE);
            txtBird.setVisibility(View.INVISIBLE);
            txtCat.setVisibility(View.INVISIBLE);
            break;
        }

        if(txtDog.getVisibility() == View.VISIBLE)
        {
            txtDog.setVisibility(View.INVISIBLE);
            break;
        }


        // set color of selected image
    case R.id.btnRed:
        if(txtBird.getVisibility() == View.VISIBLE)
            imgBird.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        else if(txtDog.getVisibility() == View.VISIBLE)
            imgDog.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        else if(txtCat.getVisibility() == View.VISIBLE)
            imgCat.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        else Toast.makeText(this, "Please select an image before setting the color!",
                    Toast.LENGTH_LONG).show();
        break;


    case R.id.btnBlue:
        if(txtBird.getVisibility() == View.VISIBLE)
            imgBird.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        else if(txtDog.getVisibility() == View.VISIBLE)
            imgDog.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        else if(txtCat.getVisibility() == View.VISIBLE)
            imgCat.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        else Toast.makeText(this, "Please select an image before setting the color!",
                    Toast.LENGTH_LONG).show();
        break;

    case R.id.btnYellow:
        if(txtBird.getVisibility() == View.VISIBLE)
            imgBird.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        else if(txtDog.getVisibility() == View.VISIBLE)
            imgDog.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        else if(txtCat.getVisibility() == View.VISIBLE)
            imgCat.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        else Toast.makeText(this, "Please select an image before setting the color!",
                    Toast.LENGTH_LONG).show();
        break;

    case R.id.btnGreen:
        if(txtBird.getVisibility() == View.VISIBLE)
            imgBird.setColorFilter(Color.rgb(0,100,0), PorterDuff.Mode.SRC_IN);
        else if(txtDog.getVisibility() == View.VISIBLE)
            imgDog.setColorFilter(Color.rgb(0,100,0), PorterDuff.Mode.SRC_IN);
        else if(txtCat.getVisibility() == View.VISIBLE)
            imgCat.setColorFilter(Color.rgb(0,100,0), PorterDuff.Mode.SRC_IN);
        else Toast.makeText(this, "Please select an image before setting the color!",
                    Toast.LENGTH_LONG).show();
        break;

    case R.id.btnOrange:
        if(txtBird.getVisibility() == View.VISIBLE)
            imgBird.setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_IN);
        else if(txtDog.getVisibility() == View.VISIBLE)
            imgDog.setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_IN);
        else if(txtCat.getVisibility() == View.VISIBLE)
            imgCat.setColorFilter(Color.rgb(255,165,0), PorterDuff.Mode.SRC_IN);
        else Toast.makeText(this, "Please select an image before setting the color!",
                    Toast.LENGTH_LONG).show();
        break;



    default:
            break;

        }
    }


}
