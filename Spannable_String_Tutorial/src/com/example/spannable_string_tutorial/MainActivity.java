package com.example.spannable_string_tutorial;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity {
	
	TextView tv1, tv2, tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1 = (TextView)findViewById(R.id.textview1);
		tv2 = (TextView)findViewById(R.id.textview2);
		tv3 = (TextView)findViewById(R.id.textview3);
		
		String string1 = "Who: who is that What: is this Why: do this";
		String string2 = "What: this is changed Why: to show it works Who: for you to use";
		
		//sub strings
		String subWho = "Who:";
		String subWhat = "What:";
		String subWhy = "Why:";
		
		SpannableString spannableString1 = new SpannableString(string1);
		SpannableString spannableString2 = new SpannableString(string2);
		
		//position of substrings in the string
		int iWho = string1.indexOf(subWho);
		int iWhat = string1.indexOf(subWhat);
		int iWhy = string1.indexOf(subWhy);
		
		//Example 1
		//set the spannable string using position start position of substring and end position using the position of substing + its length
		if (string1.contains(subWho)) {
		spannableString1.setSpan(new ForegroundColorSpan(Color.GREEN), iWho, iWho + subWho.length(), 0);
		spannableString1.setSpan(new RelativeSizeSpan(2f), iWho, iWho + subWho.length(), 0);
		} else {
			notFound(subWho);
		}
		
		if (string1.contains(subWhat)) {
		spannableString1.setSpan(new ForegroundColorSpan(Color.BLUE), iWhat, iWhat + subWhat.length(), 0);
		spannableString1.setSpan(new RelativeSizeSpan(2f), iWhat, iWhat + subWhat.length(), 0);
		} else {
			notFound(subWhat);
		}
		
		if(string1.contains(subWhy)) {
		spannableString1.setSpan(new ForegroundColorSpan(Color.RED), iWhy, iWhy + subWhy.length(), 0);
		spannableString1.setSpan(new RelativeSizeSpan(2f), iWhy, iWhy + subWhy.length(), 0);
		} else {
			notFound(subWhy);
		}
		
		tv1.setText(spannableString1, BufferType.SPANNABLE);
		
		//Example 2, just need to get the indexes of the substrings in the new string
		int iWho2 = string2.indexOf(subWho);
		int iWhat2 = string2.indexOf(subWhat);
		int iWhy2 = string2.indexOf(subWhy);
		
		if(string2.contains(subWho)) {
		spannableString2.setSpan(new ForegroundColorSpan(Color.BLUE), iWho2, iWho2 + subWho.length(), 0);
		spannableString2.setSpan(new RelativeSizeSpan(2f), iWho2, iWho2 + subWho.length(), 0);
		} else {
			notFound(subWho);
		}
		
		if(string2.contains(subWhat)) {
		spannableString2.setSpan(new ForegroundColorSpan(Color.BLUE), iWhat2, iWhat2 + subWhat.length(), 0);
		spannableString2.setSpan(new RelativeSizeSpan(3f), iWhat2, iWhat2 + subWhat.length(), 0);
		} else {
			notFound(subWhat);
		}
		
		if(string2.contains(subWhy)) {
		spannableString2.setSpan(new ForegroundColorSpan(Color.BLUE), iWhy2, iWhy2 + subWhy.length(), 0);
		spannableString2.setSpan(new RelativeSizeSpan(2f), iWhy2, iWhy2 + subWhy.length(), 0);
		} else {
			notFound(subWhy);
		}
		
		tv2.setTextSize(8f);
		tv2.setText(spannableString2, BufferType.SPANNABLE);
		
		//Example 3-using methods. Create an ArrayList and add it to the method
		ArrayList<String> array = new ArrayList<String>();
		array.add("Why");
		array.add("Who");
		array.add("to");
		array.add("What");
		tv3.setText(subString(string1, array), BufferType.SPANNABLE);
	}
	
	public SpannableString subString(String string, ArrayList<String> subStrings) {
		SpannableString spanString = new SpannableString(string);
		int count = subStrings.size();
		for (int iSub = 0; iSub < count; iSub++) {
		if (string.contains(subStrings.get(iSub))) {	
			int i = string.indexOf(subStrings.get(iSub));
			String searchString = subStrings.get(iSub);
			spanString.setSpan(new ForegroundColorSpan(Color.BLUE), i, i + searchString.length(), 0);
			spanString.setSpan(new RelativeSizeSpan(2f), i, i + searchString.length(), 0);	
			Log.d(subStrings.get(iSub), "was found");
		} else if (!string.contains(subStrings.get(iSub))){
			notFound(subStrings.get(iSub));
		}
		}
		return spanString;	
	}
	
	public void notFound(String string) {
		Log.d(string, " was not found");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
