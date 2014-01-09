package es.luixal.android_tagcloud;

import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class CloudView extends TextView {

	private Cloud cloud;
	
	
	public CloudView(Context context) {
		super(context);
		this.cloud = new Cloud();
		this.cloud.setMaxWeight(80d);
	}
	
	public CloudView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.cloud = new Cloud();
		this.cloud.setMaxWeight(80d);
	}
	
	public CloudView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.cloud = new Cloud();
		this.cloud.setMaxWeight(80d);
	}
	
	public void refresh() {
		this.setText(this.genSpannableString());
	}
	
	public Cloud getCloud() {
		return this.cloud;
	}
	
	public void addTag(Tag tag) {
		this.cloud.addTag(tag);
	}
	
	public void addTag(String name) {
		this.cloud.addTag(name);
	}
	
	public void addTags(Collection<Tag> tags) {
		this.cloud.addTags(tags);
	}
	
	public void addTags(String... tagNames) {
		for (String tagName:tagNames) {
			this.cloud.addTag(new Tag(tagName));
		}
	}
	
	private SpannableStringBuilder genSpannableString() {
		List<Tag> tags = this.cloud.getOutputTags();
		SpannableStringBuilder builder = new SpannableStringBuilder();
		for (Tag tag:tags) {
			int start = builder.length();
			int end = builder.length() + tag.getName().length();
			builder.append(tag.getName() + " ");
			builder.setSpan(new AbsoluteSizeSpan(tag.getWeightInt(), true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		return builder;
	}
	
}
