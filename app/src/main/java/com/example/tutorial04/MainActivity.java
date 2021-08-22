package com.example.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity<imageView> extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;
    Button photoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) this.findViewById(R.id.imageView);
        Button photoButton = (Button) this.findViewById(R.id.button2);

        photoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int RequestCode, int resultCode, Intent data){
        int requestCode = 0;
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}