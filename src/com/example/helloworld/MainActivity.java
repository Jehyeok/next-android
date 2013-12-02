package com.example.helloworld;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button button;
	private ImageButton imageButton;
	private TextView textView;
	private Button button2;
	private EditText editText;
	private Button changeImgBtn;
	private ImageView imageView;
	
	private boolean changed = true;
	private String imgPath = "";
	private int touchCount = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
		imageButton = (ImageButton) findViewById(R.id.imageButton1);
		imageButton.setOnClickListener(this);
		
		textView = (TextView) findViewById(R.id.textView1);
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
		editText = (EditText) findViewById(R.id.editText1);
		
		changeImgBtn = (Button) findViewById(R.id.button3);
		changeImgBtn.setOnClickListener(this);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			switch(v.getId()) {
			case R.id.button1:
				Toast.makeText(MainActivity.this, "Textview1의 getText() : " + textView.getText().toString(),
													Toast.LENGTH_SHORT).show();
				Log.i("Logtest", "Textview1의 txt: " + textView.getText().toString());
				break;
				
			case R.id.imageButton1:
				++touchCount;
				textView.setText(touchCount + "눌림!");
				Toast.makeText(MainActivity.this, "이미지 버튼 눌림", Toast.LENGTH_SHORT).show();
				Log.i("Logtest", touchCount + "눌림!");
				break;
				
			case R.id.button2:
				Toast.makeText(MainActivity.this, "editText1의 getText() : " + editText.getText().toString(),
													Toast.LENGTH_SHORT).show();
				Log.i("Logtest", "editText1의 txt: " + editText.getText().toString());
				break;
			case R.id.button3:
				if (changed) {
					changed = false;
					imgPath = "flower2.jpeg";
					Log.i("raise Exception", "" + 2/0);
				} else {
					changed = true;
					imgPath = "flower1.jpeg";
				}
				
				InputStream ims;
				try {
					ims = getAssets().open(imgPath);
					Drawable d = Drawable.createFromStream(ims, null);
					
					imageView.setImageDrawable(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			Log.e("error", e.getMessage());
			e.printStackTrace();
		}
	}
}
