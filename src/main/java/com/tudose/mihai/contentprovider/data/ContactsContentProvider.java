package com.tudose.mihai.contentprovider.data;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by Utente on 16/12/2016.
 */

public class ContactsContentProvider  extends ContentProvider{

    public static final String CONTENT_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE +"/contacts";
    public static final String CONTENT_ITEM_TYPE= ContentResolver.CURSOR_ITEM_BASE_TYPE+"/contact";
    private static final String AUTHORITY="com.tudose.mihai.data.ContactsContentProvider";
   // private static final String BASE_AUTHORTY_CONTACTS="contacts";

    public static final String BASE_PATH_CONTACTS="contacts";
    public static final Uri  CONTACTS_URI=Uri.parse("content"+AUTHORITY+"/"+BASE_PATH_CONTACTS);
    private static final int CONTACTS=10;
    private static final int CONTACTS_ID=20;
    private static final UriMatcher sURIMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        //content://la_mia_authority/contacts--->10
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_CONTACTS,CONTACTS);
        //content://la_mia_authority/contacts/5--->20
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_CONTACTS+"/#",CONTACTS);
    }
    private DbHelper dbHelper;
    @Override
    public boolean onCreate() {
        dbHelper=new DbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri,
                        String[] projection,
                        String selection,
                        String[] selectionArgs,
                        String sortOrder) {
        SQLiteQueryBuilder vQueryBuilder=new SQLiteQueryBuilder();
        vQueryBuilder.setTables(ContactsHelper.TABLE_NAME);
        int vUriType=sURIMatcher.match(uri);
        switch (vUriType){
            case CONTACTS:
                vQueryBuilder.setTables(ContactsHelper.TABLE_NAME);
                break;
            case CONTACTS_ID:
                vQueryBuilder.setTables(ContactsHelper.TABLE_NAME);
                vQueryBuilder.appendWhere((ContactsHelper._ID+"="+uri.getLastPathSegment()));
                break;
            default:
                throw new IllegalArgumentException("bho"+uri);
        }
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor cursor=vQueryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        db.close();

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        int vUriType=sURIMatcher.match(uri);
        String vResult=null;
        switch (vUriType){
            case CONTACTS:
                vResult=CONTENT_TYPE;
                break;
            case CONTACTS_ID:
                vResult=CONTENT_ITEM_TYPE;
        }
        return vResult;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        int vUriType=sURIMatcher.match(uri);
        SQLiteDatabase vSqlDB=dbHelper.getWritableDatabase();
        long vID=0;
        switch (vUriType){
            case CONTACTS:
                vID=vSqlDB.insert(ContactsHelper.TABLE_NAME,null,contentValues);
                break;
            default:
                throw new IllegalArgumentException("bho"+uri);
                    }
        getContext().getContentResolver().notifyChange(uri,null);
        vSqlDB.close();
        if(vID>=0)
            return Uri.parse("content"+AUTHORITY+"/"+BASE_PATH_CONTACTS+"/"+vID);
            else
            return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType=sURIMatcher.match(uri);
        SQLiteDatabase sqlDB=dbHelper.getWritableDatabase();
        int rowsDeleted=0;
        switch (uriType){
            case CONTACTS:
                rowsDeleted=sqlDB.delete(ContactsHelper.TABLE_NAME,selection,selectionArgs);
                break;
            case CONTACTS_ID:
                String id=uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)){
                    rowsDeleted=sqlDB.delete(ContactsHelper.TABLE_NAME,ContactsHelper._ID+id,null);
                }
                else {
                    rowsDeleted=sqlDB.delete(ContactsHelper.TABLE_NAME,ContactsHelper._ID
                                                +"="+id+"and"+selection,selectionArgs);
                    break;
                }
            default:
                throw new IllegalArgumentException("bho"+uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        int vUriType=sURIMatcher.match(uri);
        SQLiteDatabase sqlDb=dbHelper.getWritableDatabase();
        int rowsUpdated=0;
        switch (vUriType){
            case CONTACTS:
                rowsUpdated=sqlDb.update(ContactsHelper.TABLE_NAME,contentValues,selection,selectionArgs);
                break;
            case CONTACTS_ID:
                String id=uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)){
                    rowsUpdated=sqlDb.update(ContactsHelper.TABLE_NAME,contentValues,
                            ContactsHelper._ID+"="+id,null);
                }else{
                    rowsUpdated=sqlDb.update(ContactsHelper.TABLE_NAME,contentValues,
                            ContactsHelper._ID+"="+id+"and"+selection,selectionArgs);
                }
                break;
            default:
                throw new IllegalArgumentException("bho"+uri);
        }
        if (rowsUpdated>=0){
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return rowsUpdated;
    }
}
