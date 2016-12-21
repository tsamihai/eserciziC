package com.tudose.mihai.testdatasource;

import android.app.Activity;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.tudose.mihai.testdatasource.data.ContacsAdapter;
import com.tudose.mihai.testdatasource.data.Contact;
import com.tudose.mihai.testdatasource.data.Dataset;

public class MainActivity extends Activity {
    Dataset mDataset;
    ContacsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataset=Dataset.Get(this);
        ListView vList=(ListView)findViewById(R.id.listview);
        mAdapter=new ContacsAdapter(this,mDataset.getContacts());
        Button vButton=(Button)findViewById(R.id.button);
        vList.setAdapter(mAdapter);
        vList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("DATA","postion"+i+"id="+l);
                mDataset.removeContact(l);
                mAdapter.notifyDataSetChanged();
                return true;

            }
        });
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataset.addContacts(Contact.CreateRandomContacts());
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
