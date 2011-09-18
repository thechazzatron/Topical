package com.ChewieLouie.Topical;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class TopicListActivity extends ListActivity {

	private TextView title = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_list);
		title = (TextView)findViewById( R.id.topicListTitle );
	}
	
    @Override
	protected void onResume() {
		super.onResume();
        addTopicToTitle();
		addTopicListContents();
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
    	Post post = (Post)l.getItemAtPosition( position );
    	Intent intent = new Intent().setClass( getApplicationContext(), ViewPostActivity.class );
    	intent.putExtra( TopicalConstants.IntentExtraKey_ViewTopicID, post.ID );
    	startActivity( intent );
	}

	private void addTopicToTitle()
	{
		String searchQuery = getIntent().getStringExtra(
			TopicalConstants.IntentExtraKey_TopicListTopic );
		CharSequence titlePrefix = getApplicationContext().getText( R.string.topicListTitle );
		title.setText( titlePrefix + ": \"" + searchQuery + "\"" );
	}

	private void addTopicListContents()
	{
        setListAdapter( new TopicListAdapter( this, R.layout.topic_list_item, TopicalActivity.currentTopic ) );
	}
}
