package com.pasha.writetodo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView itemList;
    FloatingActionButton fabAdd;
    Context context;
    EditText nameEditText;
    EditText phoneEditText;
    List<Item> items;
    FloatingActionButton fabDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;

        itemList = (ListView) findViewById(R.id.itemList);

        setListData();

        fabDeleteAll = (FloatingActionButton) findViewById(R.id.fabDeleteAll);
        fabDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItems();
                setListData();
            }
        });

        fabAdd = (FloatingActionButton) findViewById(R.id.addItem);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create builder
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //set title
                builder.setTitle("Add something:");
                View viewInflated= LayoutInflater.from(context).inflate(R.layout.dlg_new_item, null);

                nameEditText = (EditText)viewInflated.findViewById(R.id.edtText1);
                phoneEditText = (EditText)viewInflated.findViewById(R.id.edtText2);

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        addItem();
                        setListData();

                    }
                });

                //display our inflated view in screen
                builder.setView(viewInflated);

                //show the dialog
                builder.show();
            }
        });


//        MyData db = new MyData(this);
//
//
//
//
//
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//            String log = " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
    }

    public void addItem(){

        MyData db = new MyData(context);
        String name , phone;
        name = nameEditText.getText().toString();
        phone = phoneEditText.getText().toString();


          //CRUD Operation: add data

        Log.d("Insert: ", "Inserting ..");

        db.addItem(new Item(name, phone));

    }

    private void setListData(){

        MyAdapter adapter = new MyAdapter(context);
        itemList.setAdapter(adapter);

    }

    public void deleteItems(){

        MyData db = new MyData(context);

        items = new ArrayList<>();

        List<Item> item = db.getAllItems();

        for(int i = 0 ; i<item.size() ; i++){

            db.deleteContact(item.get(i));


        }


    }


}


