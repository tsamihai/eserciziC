package com.tudose.mihai.contentprovider.data;

import android.provider.BaseColumns;

/**
 * Created by Utente on 16/12/2016.
 */

public class ContactsHelper implements BaseColumns {
    public static final String TABLE_NAME="Contacts";
    public final static String NAME="name";
    public final static String SURNAME="surname";
    public final static String CREATE_QUERY=
            " CREATE TABLE " + TABLE_NAME
                    + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME + " TEXT NOT NULL, "
                    + SURNAME + " TEXT NOT NULL "
                    + " ) ;";
}
