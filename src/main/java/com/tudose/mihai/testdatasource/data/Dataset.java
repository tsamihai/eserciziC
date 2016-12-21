package com.tudose.mihai.testdatasource.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Utente on 02/12/2016.
 */

public class Dataset {
    private static Dataset mInstance=null;  //sigleton
    public static Dataset Get(Context aContext){            //sigleton
        if(mInstance==null){                //sigleton
            mInstance=new Dataset(aContext);        //sigleton
        }                                   //sigleton
        return mInstance;                   //sigleton
    }
    ArrayList<Contact> mContacts;
    DbHelper mdbHelper;
    private Dataset(Context aContext){
        mContacts= new ArrayList<>();
        mdbHelper=new DbHelper(aContext);
    }
    public ArrayList<Contact> getContacts(){
        SQLiteDatabase vDB=mdbHelper.getReadableDatabase();
        Cursor vCursor=vDB.query(ContacsHelper.TABLE_NAME,null,null,null,null,null,null); //select semplice, l'accesso ai dati ritorna un oggetto di tipo cursor
        while (vCursor.moveToNext()){                                           //un puntatore che punta alla cella -1, ad ogni iterazione lui va avanti e mi ritorna i valori della cella
            Contact vContact=new Contact();                                     //movetonect() true se si muove, false se non ci sono più valori
            vContact.mId=vCursor.getLong(vCursor.getColumnIndex(ContacsHelper._ID));///bisogna accertarsi che iol valore che si va a leggere sia di tipo giusto int,long,string..
            vContact.mName=vCursor.getString(vCursor.getColumnIndex(ContacsHelper.NAME));
            vContact.mSurname=vCursor.getString(vCursor.getColumnIndex(ContacsHelper.SURNAME));
            mContacts.add(vContact);
        }
        vCursor.close();//il cursore deve essere sempre chiuso
        vDB.close();
        return mContacts;
    }
    public  Contact addContacts(Contact aContac){
        SQLiteDatabase vDB=mdbHelper.getWritableDatabase();
        ContentValues vValue= new ContentValues();
        vValue.put(ContacsHelper.NAME,aContac.mName);
        vValue.put(ContacsHelper.SURNAME,aContac.mSurname);
        long vInsertDB=vDB.insert(ContacsHelper.TABLE_NAME,null,vValue);

        aContac.mId=vInsertDB;
        mContacts.add(aContac);
        return aContac;
    }
    int findContactsByID(Long aId){
        int vRemovePosition=-1;
        for (int vIndex=0;vIndex<mContacts.size();vIndex++) {
            if(mContacts.get(vIndex).mId==aId){
                vRemovePosition=vIndex;
                break;
            }
        }
        return vRemovePosition;
    }
    public  boolean removeContact(long aID){
        //mContacts.rem
        //TODO
        //trovare l'oggetto con quel id e rimuoverlo
        SQLiteDatabase vDB=mdbHelper.getWritableDatabase();
        int vRows=vDB.delete(ContacsHelper.TABLE_NAME,ContacsHelper._ID + " = " +aID,null);
        int indexToRemove=findContactsByID(aID);
        if (indexToRemove>=0){
            mContacts.remove(indexToRemove);
        }
        //al click aprire un altro dialog per modifica il nome e cognome inseriti
        //al click del tasto button aggiungere un dialog che permetta di scrivere nome e cognome, il dialog deve essere lo stesso
        //implementato una sola volta
        return (vRows>0);
    }


}
