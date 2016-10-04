package com.danielbrinker.android.aca.notetoself;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by danielbrinker on 9/15/16.
 */
public class Note {


    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea" ;
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";
    //private static final String JSON_URI = "";
    private static final String JSON_URI = "uri";

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;
    private Uri mImageUri;


    // Constructor
// Only used when new is called with a JSONObject
    public Note(JSONObject jo) throws JSONException {

        mTitle =  jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
        mImageUri = Uri.parse(jo.getString(JSON_URI));;

    }
    // Now we must provide an empty default constructor
// for when we create a Note as we provide a
// specialized constructor that must be used.
    public Note (){

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public boolean isIdea() {
        return mIdea;
    }

    public void setIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    public boolean isTodo() {
        return mTodo;
    }

    public void setTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    public boolean isImportant() {
        return mImportant;
    }

    public void setImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }


    public Uri getImageUri() {
        return mImageUri;
    }

    public void setImageUri(Uri mImageUri) {
        this.mImageUri = mImageUri;
    }



    public JSONObject convertToJSON() throws JSONException{

        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);
        jo.put(JSON_URI, mImageUri.toString());

        return jo;
    }



}
