package com.example.mycontactbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class View_List extends AppCompatActivity {
    public static ArrayList<ClassContact> contactsList = new ArrayList<>();
    private AdapterList adapter;


    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.second_activity);


        Intent intent = getIntent();
        ArrayList<ClassContact> parent = intent.getParcelableArrayListExtra("Person");

        if (parent != null && parent.size() > 0) {
            contactsList = parent;

        } else {
            //El codigo tiene una funcionalidad que si no hay contactos muestre un id que indica eso puede probarlo
            ClassContact ivan = new ClassContact("Ivan", "9857845", "Savings Account", "5300");
            contactsList.add(ivan);
        }

        adapter = new AdapterList(this, R.layout.adapterlist, contactsList);
        ListView myListView = (ListView) findViewById(R.id.ListView);
        myListView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_view_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putParcelableArrayListExtra("Person", contactsList);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}