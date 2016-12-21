package com.tudose.mihai.testdatasource.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tudose.mihai.testdatasource.R;

import java.util.ArrayList;

/**
 * Created by Utente on 02/12/2016.
 */

public class ContacsAdapter  extends BaseAdapter{
    ArrayList<Contact> mData;
    Context mContext;
    public ContacsAdapter(Context aContex,ArrayList<Contact> aData){
        mContext=aContex;
        mData=aData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Contact getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).mId;
    }
    class ViewHolder{
        TextView mId;
        TextView mName;
        TextView mSurname;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vCell;
        if (view==null){
            view=LayoutInflater.from(mContext).inflate(R.layout.cell,null);

            ViewHolder vHolder=new ViewHolder();
            TextView vId=(TextView)view.findViewById(R.id.id);
            TextView vName= (TextView)view.findViewById(R.id.nome);
            TextView vSurname=(TextView)view.findViewById(R.id.cognome);
            vHolder.mId=vId;
            vHolder.mName=vName;
            vHolder.mSurname=vSurname;
            view.setTag(vHolder);

        }else
        {
            vCell=view;
        }
        ViewHolder viewHolder=(ViewHolder)view.getTag();
        Contact vContact=getItem(i);
        viewHolder.mId.setText(""+vContact.mId);
        viewHolder.mName.setText(""+vContact.mName);
        viewHolder.mSurname.setText(""+vContact.mSurname);
        return view;
    }
}
