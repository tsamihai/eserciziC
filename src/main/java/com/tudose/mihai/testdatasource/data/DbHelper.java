package com.tudose.mihai.testdatasource.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utente on 02/12/2016.
 */

public class DbHelper extends SQLiteOpenHelper {
    private final static String NAME="Contacts.db";
    private final static int VERSIONE=1;



    public DbHelper(Context aContext){
        super(aContext,NAME,null,VERSIONE);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //INSERIRE QUI LE QUERY PER LA  CRAZIONE DEL DB
        sqLiteDatabase.execSQL(ContacsHelper.CREATE_QUERY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //SI PUO INGORARE O LE QUERY PER FARE LE ALTER O DROPARE IL DB E RICREARL
        //SE HO AGGIUNTO SOLO TABELLE POSSO FARE AD
        //SE HO MODIFICATO TANTO DROPPO TUTTO RICREO IL DB E RIFECCIO I DATI

    }
}
