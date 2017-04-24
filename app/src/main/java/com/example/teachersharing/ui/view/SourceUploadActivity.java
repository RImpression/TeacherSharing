package com.example.teachersharing.ui.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.util.FileUtils;

import java.net.URISyntaxException;

/**
 * 资源上传
 *
 */

public class SourceUploadActivity extends BaseActivity{

    private EditText sourceName,sourceDescription,sourceType;
    private CheckBox isPublish;
    private Button btnFile,btnUpLoad;
    private TextView tvFileURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_upload);
        initToolbar("资源上传",true);
        initViews();

    }

    private void initViews() {
        sourceName = (EditText) findViewById(R.id.sourceName);
        sourceName = (EditText) findViewById(R.id.sourceDescription);
        sourceType = (EditText) findViewById(R.id.sourceType);
        isPublish = (CheckBox) findViewById(R.id.isPublish);
        btnFile = (Button) findViewById(R.id.btnFile);
        tvFileURL = (TextView) findViewById(R.id.tvFileURL);
        btnUpLoad = (Button) findViewById(R.id.btnUpLoad);
        btnFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileSelected();
            }
        });

        btnUpLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //选择文件路径
    private static final int FILE_SELECT_CODE = 0;
    private void showFileSelected() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult( Intent.createChooser(intent, "Select a File to Upload"), FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }


    private static final String TAG = "ChooseFile";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.d(TAG, "File Uri: " + uri.toString());
                    // Get the path
                    String path = null;
                    try {
                        path = FileUtils.getPath(this, uri);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "File Path: " + path);
                    tvFileURL.setText(path);
                    // Get the file instance
                    // File file = new File(path);
                    // Initiate the upload
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
