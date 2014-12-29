package com.polus.binil.androidlistviewwithsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	// List view
	private ListView lv;
	
	// Listview Adapter
	//ArrayAdapter<String> adapter;
	
	// Search EditText
	EditText inputSearch;
	
	// ArrayList for Listview
	ArrayList<HashMap<String, String>> productList;
	ArrayList<ItemListPogo> arraylist = new ArrayList<ItemListPogo>();
	ListViewAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
   
        // Listview Data
        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
        						"iPhone 4S", "Samsung Galaxy Note 800",
        						"Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
        
        String name[] = {"Apple", "Apricot", "Banana", "Cherry", "Courgette",
				"Date", "Elderberry","Fennel", "Grape", "Guava", "Lemon"};
        
        
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
        
        // Adding items to listview
    
        for (int i = 0; i < 11; i++) 
		{
			ItemListPogo wp = new ItemListPogo(products[i], name[i] );
			arraylist.add(wp);
		}
        
        adapter = new ListViewAdapter(MainActivity.this, arraylist);
        lv.setAdapter(adapter);
        
        
   
        inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				// When user changed the Text
				
				String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
				adapter.filter(text);
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub							
			}
		});
    }
    
    
}
