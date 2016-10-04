
package com.danielbrinker.android.aca.notetoself;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danielbrinker on 9/15/16.
 */
public class DialogNewNote extends DialogFragment {


    private int CAMERA_REQUEST = 123;
    private ImageView mImageView;


    // The filepath for the photo
    public String mCurrentPhotoPath;

    private Button mPhotoButton;



    // Where the captured image is stored
    private Uri mImageUri = Uri.EMPTY;

    // Unified Resource Identifier: URI is a string that identifies that resource

    // Create a new note
    Note newNote = new Note();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // All the rest of the code goes here

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);
        //Was getting some message about how null is not right. Disabled message by accident

        final EditText editTitle = (EditText) dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText) dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = (CheckBox) dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = (CheckBox) dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = (CheckBox) dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);
        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        mImageView = (ImageView) dialogView.findViewById(R.id.imageView1);
        mPhotoButton = (Button) dialogView.findViewById(R.id.button1);


        builder.setView(dialogView).setMessage("Add a new note");

// Handle the cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();


            }
        });


// Handle the OK button
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a new note
                Note newNote = new Note();

                // Set its variables to match the users entries on the form
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());
                newNote.setImageUri(mImageUri);


                // Get a reference to MainActivity
                MainActivity callingActivity = (MainActivity) getActivity();

                // Pass newNote back to MainActivity
                callingActivity.createNewNote(newNote);

                // Quit the dialog
                dismiss();
            }


        });


        mPhotoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(cameraIntent, CAMERA_REQUEST);

                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                    Log.e("error", "error creating file");

                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }


            }
        });


        return builder.create();
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  // filename
                ".jpg",         // extension
                storageDir      // folder
        );

        // Save for use with ACTION_VIEW Intent
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            try {
                mImageView.setImageURI(Uri.parse(mImageUri.toString()));
            } catch (Exception e) {
                Log.e("Error", "Uri not set");
            }
        } else {
            mImageUri = Uri.EMPTY;
        }
    }


}
