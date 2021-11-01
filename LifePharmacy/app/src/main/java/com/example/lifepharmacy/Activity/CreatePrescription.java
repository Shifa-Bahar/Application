package com.example.lifepharmacy.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lifepharmacy.ModelResponse.CreatePres.CreatePrescriptionResponse;
import com.example.lifepharmacy.ModelResponse.CreatePresRequest;
import com.example.lifepharmacy.ModelResponse.ImageResponse.ImageResponseBody;
import com.example.lifepharmacy.R;
import com.example.lifepharmacy.data.RetrofitClient;
import com.example.lifepharmacy.helpers.FileUtils;
import com.github.dhaval2404.imagepicker.ImagePicker;
import java.io.File;
import java.util.Collections;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePrescription extends AppCompatActivity {
    Button choose_eid_btn,choose_ins_btn,choose_ps_btn,create_req_btn;
    ImageView choose_eid_img,choose_ins_img,choose_ps_img;
    EditText name,number,flat_num,building,street;
    private String token = "957362|BCjqofWbk4dC4zM6nqmIwJZH5fFygYjBRUCfFq1x";
    Uri uri;
    String img_eid,img_ins,img_ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_prescription);
        
        name = findViewById(R.id.name);
        number= findViewById(R.id.number);
        flat_num= findViewById(R.id.flat_num);
        building= findViewById(R.id.building);
        street= findViewById(R.id.street);
        create_req_btn= findViewById(R.id.create_req_btn);
        
        choose_eid_btn = findViewById(R.id.choose_eid_btn);
        choose_eid_img = findViewById(R.id.choose_eid_img);

        choose_ins_btn = findViewById(R.id.choose_ins_btn);
        choose_ins_img = findViewById(R.id.choose_ins_img);

        choose_ps_btn = findViewById(R.id.choose_ps_btn);
        choose_ps_img = findViewById(R.id.choose_ps_img);

        choose_eid_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(CreatePrescription.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(10);
            }
        });
        choose_ins_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(CreatePrescription.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(20);
            }
        });
        choose_ps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(CreatePrescription.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(30);
            }
        });
        
        create_req_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               createPrescription();
            }
        });
    }

    private void createPrescription() {
        String namet = name.getText().toString();
        String numbert = number.getText().toString();
        String flat_numt = flat_num.getText().toString();
        String buildingt = building.getText().toString();
        String streett = street.getText().toString();

        if(namet.isEmpty()){
            name.requestFocus();
            name.setError("PLEASE ENTER YOUR NAME");
        }
        if(numbert.isEmpty()){
            number.requestFocus();
            number.setError("PLEASE ENTER THE NUMBER");
        }
        if(flat_numt.isEmpty()){
            flat_num.requestFocus();
            flat_num.setError("PLEASE ENTER THE FLAT NUMBER");
        }
        if(buildingt.isEmpty()){
            building.requestFocus();
            building.setError("PLEASE ENTER THE BUILDING NAME");
        }
        if(streett.isEmpty()){
            street.requestFocus();
            street.setError("PLEASE ENTER THE STREET ADDRESS");
        }

        CreatePresRequest req = new CreatePresRequest(namet,numbert,flat_numt,buildingt,streett,
                                img_eid,img_eid,img_ins,img_ins,"notes", Collections.singletonList(img_ps));

        Call<CreatePrescriptionResponse> call = RetrofitClient.getInstance().getApi().createRequest(req,"Bearer "+token);
        call.enqueue(new Callback<CreatePrescriptionResponse>() {
            @Override
            public void onResponse(Call<CreatePrescriptionResponse> call, Response<CreatePrescriptionResponse> response) {
                           if(response.isSuccessful()){
                               Toast.makeText(CreatePrescription.this, "SUCCESSFULLY SUBMITED", Toast.LENGTH_SHORT).show();
                           }else{
                               Toast.makeText(CreatePrescription.this, "ENTER ALL THE INPUT FIELDS", Toast.LENGTH_SHORT).show();
                           }
            }

            @Override
            public void onFailure(Call<CreatePrescriptionResponse> call, Throwable t) {
                Toast.makeText(CreatePrescription.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                uri = data.getData();
                choose_eid_img.setImageURI(uri);
                MultipartBody.Part part = null;

                File file = FileUtils.getFile(this,uri);

                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),file);
                if(part == null) {
                    part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
                }

                Call<ImageResponseBody> call = RetrofitClient.getInstance().getApi().uploadImage(part,"Bearer "+token);

                call.enqueue(new Callback<ImageResponseBody>() {
                    @Override
                    public void onResponse(Call<ImageResponseBody> call, Response<ImageResponseBody> response) {
                        if(response.isSuccessful()){
                            img_eid = response.body().getData().getFile();
                            Log.d("img1-link",img_eid);
                            Toast.makeText(CreatePrescription.this, "Image Upload Sucessfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CreatePrescription.this, "Image Upload fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ImageResponseBody> call, Throwable t) {
                        Toast.makeText(CreatePrescription.this, "failll", Toast.LENGTH_SHORT).show();

                    }
                });
                break;

            case 20:
                uri = data.getData();
                choose_ins_img.setImageURI(uri);
                MultipartBody.Part part2 = null;
                File file2 = FileUtils.getFile(this,uri);
                RequestBody requestFile2 = RequestBody.create(MediaType.parse("multipart/form-data"),file2);
                if(part2 == null) {
                    part2 = MultipartBody.Part.createFormData("file", file2.getName(), requestFile2);
                }
                Call<ImageResponseBody> call2 = RetrofitClient.getInstance().getApi().uploadImage(part2,"Bearer "+token);

                call2.enqueue(new Callback<ImageResponseBody>() {
                    @Override
                    public void onResponse(Call<ImageResponseBody> call, Response<ImageResponseBody> response) {
                        if(response.isSuccessful()){
                            img_ins = response.body().getData().getFile();
                            Log.d("img2-link",img_ins);
                            Toast.makeText(CreatePrescription.this, "Image Upload Sucessfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CreatePrescription.this, "Image Upload fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ImageResponseBody> call, Throwable t) {
                        Toast.makeText(CreatePrescription.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
                break;

            case 30:
                uri = data.getData();
                choose_ps_img.setImageURI(uri);
                MultipartBody.Part part3 = null;

                File file3 = FileUtils.getFile(this,uri);

                RequestBody requestFile3 = RequestBody.create(MediaType.parse("multipart/form-data"),file3);
                if(part3 == null) {
                    part3 = MultipartBody.Part.createFormData("file", file3.getName(), requestFile3);
                }
                Log.d("getname", file3.getName());
                Call<ImageResponseBody> call3 = RetrofitClient.getInstance().getApi().uploadImage(part3,"Bearer "+token);

                call3.enqueue(new Callback<ImageResponseBody>() {
                    @Override
                    public void onResponse(Call<ImageResponseBody> call, Response<ImageResponseBody> response) {
                        if(response.isSuccessful()){
                            img_ps = response.body().getData().getFile();
                            Log.d("img3-link",img_ps);
                            Toast.makeText(CreatePrescription.this, "Image Upload Sucessfull", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CreatePrescription.this, "Image Upload fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ImageResponseBody> call, Throwable t) {
                        Toast.makeText(CreatePrescription.this, "failll", Toast.LENGTH_SHORT).show();

                    }
                });
                break;    

            default:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }

    }
}