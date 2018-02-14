package com.pace.cs639spring.hw2.cs639springhw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplayListViewAdapter extends BaseAdapter {
    Context mContext;
    List<ListObject> mExamples;
    int decision = 0;

    AnimalDisplayListViewAdapter(Context context, List<ListObject> exampleObjectList) {
        mContext = context;
        mExamples = exampleObjectList;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.row_structure, null);
            ViewHolder viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.imgView),
                    (TextView) convertView.findViewById(R.id.txtView), (Button) convertView.findViewById(R.id.btnNextFact)
                    , (Button) convertView.findViewById(R.id.btnDelete));
            convertView.setTag(viewHolder);
        }


        final ListObject object = (ListObject) getItem(position);
         final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.mImageView.setBackgroundResource(object._imgImage);
        if(viewHolder.mTextView.getText() == "")
        viewHolder.mTextView.setText(object.mName.get(0));
        viewHolder.btnNext.setTag(object);
        viewHolder.btnDelete.setTag(object);



        Button btnNF = convertView.findViewById(R.id.btnNextFact);
        Button btnDF = convertView.findViewById(R.id.btnDelete);
        Button btnAF = convertView.findViewById(R.id.btnAddFact);






        viewHolder.btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Next Button Clicked at" + position,Toast.LENGTH_LONG).show();
                /*ListObject myObject = lObjects.get(_intPosition);
                String strTemp = myAddFactEditText.getText().toString();
                myObject.mName.add(strTemp);

                Toast.makeText(mContext, "Fact Added", Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();*/

                    if(object.mName.size() > 1) {

                        object._intCount = object._intCount + 1;
                        String str = object.mName.get(object._intCount).toString();
                        viewHolder.mTextView.setText(str);
                        notifyDataSetChanged();
                    }
                    else{

                        Toast.makeText(mContext,"Only one item is present in the list" ,Toast.LENGTH_LONG).show();

                    }



            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(object._intCount >= 1) {
                    int temp = object._intCount;
                    object.mName.remove(temp);
                    object._intCount = object._intCount - 1;

                    viewHolder.mTextView.setText(object.mName.get(object._intCount).toString());
                    Toast.makeText(mContext, "Fact deleted at" + position, Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                }
                else{

                    Toast.makeText(mContext,"Only one item cannot delete" ,Toast.LENGTH_LONG).show();
                }

            }
        });


        // set events for button click to set color for image

        decision++;
        if(decision > 2){
            decision = 0;
        }
        notifyDataSetChanged();

        return convertView;
    }

    @Override
    public int getCount() {
        return mExamples.size();
    }

    @Override
    public Object getItem(int position) {
        return mExamples.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        Button btnNext;
        Button btnDelete;

        ViewHolder(ImageView imageView, TextView textView, Button _btnNext, Button _btnDelete) {
            mImageView = imageView;
            mTextView = textView;
            btnNext = _btnNext;
            btnDelete = _btnDelete;
        }

    }
}
