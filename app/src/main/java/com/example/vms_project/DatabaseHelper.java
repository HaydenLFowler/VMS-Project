package com.example.vms_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_SINGED_IN = "SIGNED_IN";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_STAFF_VISITOR = "STAFF_VISITOR";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + USER_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_NAME + " TEXT, " + COLUMN_STAFF_VISITOR + " TEXT, "
                + COLUMN_SINGED_IN + " TEXT )";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, userModel.getName());
        cv.put(COLUMN_STAFF_VISITOR, userModel.getStaff_visitor());
        cv.put(COLUMN_SINGED_IN, userModel.getOnSite());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addOneVisitor(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, userModel.getName());
        cv.put(COLUMN_STAFF_VISITOR, "Visitor");
        cv.put(COLUMN_SINGED_IN, userModel.getOnSite());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<UserModel> getallUsers() {

        List<UserModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            //Go through the results (loop). Insert them into a return list to display.
            do {
                int userID = cursor.getInt(0);
                String userName = cursor.getString(1);
                String staffVisitor = cursor.getString(2);
                String signedIn = cursor.getString(3);
                UserModel newUser = new UserModel(userID, userName, staffVisitor, signedIn);
                returnList.add(newUser);

            } while (cursor.moveToNext());
        } else {
            //Fail - do not add to list.


        }
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteOne(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        String queryString = " DELETE FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + userModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }

    }

    public List<UserModel> getSpecificUserStaff(String initial) {

        List<UserModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USER_NAME + " LIKE '" + initial + "%'" + " AND " + COLUMN_STAFF_VISITOR + '=' + "'Staff'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            //Go through the results (loop). Insert them into a return list to display.
            do {
                int userID = cursor.getInt(0);
                String userName = cursor.getString(1);
                String staffVisitor = cursor.getString(2);
                String signedIn = cursor.getString(3);

                UserModel newUser = new UserModel(userID, userName, staffVisitor, signedIn);
                returnList.add(newUser);

            } while (cursor.moveToNext());
        } else {
            //Fail - do not add to list.


        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<UserModel> getSpecificUserVisitor(String initial) {

        List<UserModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USER_NAME + " LIKE '" + initial + "%'" + " AND " + COLUMN_STAFF_VISITOR + '=' + "'Visitor'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            //Go through the results (loop). Insert them into a return list to display.
            do {
                int userID = cursor.getInt(0);
                String userName = cursor.getString(1);
                String staffVisitor = cursor.getString(2);
                String signedIn = cursor.getString(3);

                UserModel newUser = new UserModel(userID, userName, staffVisitor, signedIn );
                returnList.add(newUser);

            } while (cursor.moveToNext());
        } else {
            //Fail - do not add to list.


        }
        cursor.close();
        db.close();
        return returnList;
    }

   /* public String signIn(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        String sn = COLUMN_SINGED_IN;
        String queryString =
                "UPDATE " + USER_TABLE +
                        " SET " + COLUMN_SINGED_IN + " =  ' true ' " +
                        " WHERE " + COLUMN_ID + " = " + userModel.getId();


        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst() && COLUMN_SINGED_IN == "true") {
            //Go through the results (loop). Insert them into a return list to display.

        String signedIn = cursor.getString(3);

            String queryString1 =
                    "UPDATE " + USER_TABLE +
                            " SET " + COLUMN_SINGED_IN +  '=' + signedIn  +
                            " WHERE " + COLUMN_ID + " = " + userModel.getId();
            Cursor cursor1 = db.rawQuery(queryString1, null);

            sn = signedIn;

        }
        else {


        }
        cursor.close();
        db.close();
        return sn;





    }*/

    public String signIn (UserModel userModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        /*String queryString =
                "UPDATE " + USER_TABLE +
                        " SET " + COLUMN_SINGED_IN + " =  ' false ' " +
                        " WHERE " + COLUMN_ID + " = " + userModel.getId();*/

        String queryString =
                "SELECT " + COLUMN_SINGED_IN + " FROM " + USER_TABLE +
                        " WHERE " + COLUMN_ID + " = " + userModel.getId();

        String check = "";

        Cursor cursor = db.rawQuery(queryString, null);


        if(cursor.moveToFirst()){

             cursor.getString(cursor.getColumnIndex(COLUMN_SINGED_IN));
             if(cursor.getString(cursor.getColumnIndex(COLUMN_SINGED_IN)) == "false")
             {
                 String queryStringUpdate =
                         "UPDATE " + USER_TABLE +
                                 " SET " + COLUMN_SINGED_IN + " =  ' true ' " +
                                 " WHERE " + COLUMN_ID + " = " + userModel.getId();

                 check = cursor.getString(cursor.getColumnIndex(COLUMN_SINGED_IN));

                 cursor.close();
                 db.close();
                 return check;
             }
             else {
                 String queryStringUpdate =
                         "UPDATE " + USER_TABLE +
                                 " SET " + COLUMN_SINGED_IN + " =  ' false ' " +
                                 " WHERE " + COLUMN_ID + " = " + userModel.getId();

                 check = cursor.getString(cursor.getColumnIndex(COLUMN_SINGED_IN));

                 cursor.close();
                 db.close();
                 return check;

             }

        }

        return check;
    }

   /*public String signIn(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        if ( COLUMN_SINGED_IN == "") {

            String queryString =
                    "UPDATE " + USER_TABLE +
                            " SET " + COLUMN_SINGED_IN + " =  ' false ' " +
                            " WHERE " + COLUMN_ID + " = " + userModel.getId();
            Cursor cursor = db.rawQuery(queryString, null);
            if (cursor.moveToFirst()) {
               String sn = cursor.getString(0);
                cursor.close();
                db.close();
                return sn;

            } else {
                cursor.close();
                db.close();
                return "false";
            }
        }
        else if (COLUMN_SINGED_IN == "false") {

            String queryString =
                    " UPDATE " + USER_TABLE +
                            " SET " + COLUMN_SINGED_IN + " = ' true '" +
                            " WHERE " + COLUMN_ID + " = " + userModel.getId();
            Cursor cursor = db.rawQuery(queryString, null);
            if (cursor.moveToFirst()) {
                String sn = cursor.getString(0);

                cursor.close();
                db.close();
                return sn;

            } else {

                cursor.close();
                db.close();
                return "false";
            }


        }

        return null;
    }*/

   /* public String signIn(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Will set COLUMN_SIGNED_IN to the opposite of what it currently is
        String shouldSignIn = isSignedIn(userModel);

        String queryString =
                "UPDATE " + USER_TABLE +
                        " SET " + COLUMN_SINGED_IN + " = " + shouldSignIn +
                        " WHERE " + COLUMN_ID + " = " + userModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            cursor.close();
            return shouldSignIn;

        } else {
            cursor.close();
            return "false";
        }
    }*/



    /*public String isSignedIn(UserModel userModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        String queryString =
                "SELECT " + COLUMN_SINGED_IN + " FROM " + USER_TABLE +
                " WHERE " + COLUMN_ID + " = " + userModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            cursor.close();
            return COLUMN_SINGED_IN;
        } else {
            cursor.close();
            return "false";
        }


    }*/
}
