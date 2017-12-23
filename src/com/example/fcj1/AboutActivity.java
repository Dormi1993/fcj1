package com.example.fcj1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * 通过GET方式向服务器发送数据,通过GET方式上传数据主要适用于数
 * 据大小不超过2KB，且对安全性要求不高的情况下。
 * @author dormi
 *
 */
public class AboutActivity extends Activity {
	private EditText edtName,edtPwd;
	private Button btnSend;
	Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case SendDataToServer.SEND_SUCCESS:
					Toast.makeText(AboutActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
					break;
				case SendDataToServer.SEND_FAIL:
					Toast.makeText(AboutActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		edtName=(EditText)findViewById(R.id.etusername);
		edtPwd=(EditText)findViewById(R.id.etpassword);
		btnSend=(Button)findViewById(R.id.loginButton);
		btnSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name=edtName.getText().toString();
				String pwd=edtPwd.getText().toString();

				if (name.equals("ww") && pwd.equals("1234")){
					startActivity(new Intent(AboutActivity.this, TransmissionActivity.class));
				}
//				if (TextUtils.isEmpty(name)||pwd.equals("")) {
//					Toast.makeText(AboutActivity.this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
//				}else {
//					new SendDataToServer(handler).SendDataToServer(name, pwd);
//				}
			}
		});
	}

}
