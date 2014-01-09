package es.luixal.android_tagcloud.demo;

import es.luixal.android_tagcloud.CloudView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private final String[] TAGS = new String[]{
			"cat",
			"dog",
			"mouse",
			"jiraffe",
			"elephant",
			"rinho",
			"whale",
			"dog",
			"dog",
			"dog",
			"cat",
			"cat",
			"rinho",
			"rinho",
			"mouse",
			"rinho",
			"rinho",
			"rinho",
			"rinho",
			"rinho",
			"rinho",
			"rinho",
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		CloudView cloudView = (CloudView)findViewById(R.id.cloud_view);
		cloudView.addTags(TAGS);
		cloudView.refresh();
	}

}
