package com.example.mamad.fara2form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by MAMAD on 5/10/2018.
 */

public class Info_Form implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Activity activity;
    private LinearLayout form_info_layout;
    private EditText name_info,phn_info,email_info;
    private CheckBox checkBox;
    private Button submit_btn;
    private ImageView iv_email;
    private View view1,view2;
    private Context context;

    public Info_Form(Activity activity, int layoutId){
        this.activity=activity;
        this.form_info_layout= (LinearLayout) activity.findViewById(layoutId);
        init();
        anime();

    }

    private void anime() {
        checkBox.animate().alpha(1f).translationX(100f).setDuration(1500);
        name_info.animate().alpha(1f).setDuration(2000);
        phn_info.animate().alpha(1f).setDuration(2000);
        email_info.animate().alpha(1f).setDuration(2000);
        submit_btn.animate().alpha(1f).setDuration(2000);
        iv_email.animate().alpha(1f).setDuration(2000);
        view1.animate().alpha(1f).scaleY(3).setDuration(2000);
        view2.animate().alpha(1f).scaleY(3).setDuration(2000);

        }

    private void init(){
        if (form_info_layout==null){
            return;
        }
        name_info= (EditText) form_info_layout.findViewById(R.id.name_info);
        phn_info= (EditText) form_info_layout.findViewById(R.id.phn_info);
        email_info= (EditText) form_info_layout.findViewById(R.id.email_info);
        checkBox= (CheckBox) form_info_layout.findViewById(R.id.checkBox);
        submit_btn= (Button) form_info_layout.findViewById(R.id.submit_btn);
        iv_email= (ImageView) form_info_layout.findViewById(R.id.iv_email);
        view1 =  form_info_layout.findViewById(R.id.view);
        view2 =  form_info_layout.findViewById(R.id.view2);
        submit_btn.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);//action on check or ~check

    }

    public EditText getName_info() {
        return name_info;
    }

    public EditText getPhn_info() {
        return phn_info;
    }

    public EditText getEmail_info() {
        return email_info;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public Button getSubmit_btn() {
        return submit_btn;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == submit_btn.getId()) {
            String name = name_info.getText().toString().trim();
            String email = email_info.getText().toString().trim();
            String phone = phn_info.getText().toString().trim();
            if (isValidInput(name,email,phone)) {
                Toast.makeText(activity, "Valid input", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(activity,SecondActivity.class);       // way of going to another activity
                intent.putExtra("name",name);                                   // sending information by intent to another activity
                if (checkBox.isChecked()){
                    intent.putExtra("phone",phone);
                }
                intent.putExtra("email",email);
                activity.startActivity(intent);                                 // Start another activity
            }

        }
    }

    public boolean isValidInput(String name, String phone,String email) {
        if (name == null)
            name= name_info.getText().toString().trim();
        if (email == null)
            email= email_info.getText().toString().trim();
        if (phone == null)
            phone= phn_info.getText().toString().trim();
        if (name.length()<3){
            Toast.makeText(activity, "name cannot be less than 3 character", Toast.LENGTH_SHORT).show();
            name_info.requestFocus();
            return false;
        }
        if ((!phone.isEmpty() && phone.length()!=11) && phone.startsWith("09") ){
            Toast.makeText(activity, "Wrong phone number", Toast.LENGTH_SHORT).show();
            phn_info.requestFocus();
            return false;
        }
        if (!email.contains(".") || email.lastIndexOf(".")<email.lastIndexOf("@")
                || email.lastIndexOf("@")<= 0 || email.split("@").length> 2){
            Toast.makeText(activity, "Wrong email address", Toast.LENGTH_SHORT).show();
            email_info.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId()==checkBox.getId()){
            phn_info.setEnabled(isChecked);
        }
    }
}
