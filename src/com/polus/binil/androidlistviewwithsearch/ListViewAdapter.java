package com.polus.binil.androidlistviewwithsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ListViewAdapter extends BaseAdapter {

	Context mContext;
	LayoutInflater inflater;
	private List<ItemListPogo> itemListPogo = null;
	private ArrayList<ItemListPogo> arraylist;

	public ListViewAdapter(Context context, List<ItemListPogo> itemLists) 
	{
		mContext = context;
		this.itemListPogo = itemLists;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<ItemListPogo>();
		this.arraylist.addAll(itemLists);
	}

	public class ViewHolder {

		TextView product_name;
		TextView name;
	}

	@Override
	public int getCount() {
		return itemListPogo.size();
	}

	@Override
	public ItemListPogo getItem(int position) {
		return itemListPogo.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) 
	{
		final ViewHolder holder;
		if (view == null) 
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.list_item, null);
            
			holder.product_name  = (TextView) view.findViewById(R.id.product_name);
			holder.name     = (TextView) view.findViewById(R.id.name);
			
			view.setTag(holder);
		} 
		else 
		{
			holder = (ViewHolder) view.getTag();
		}

		// Set the results into TextViews
		holder.name.setText(itemListPogo.get(position).getItemName());
		holder.product_name.setText(itemListPogo.get(position).getProductName());

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) 
			{
				//On things on click

			}
		});

		return view;
	}

	// Filter Class
	public void filter(String charText) 
	{
		charText = charText.toLowerCase(Locale.getDefault());
		itemListPogo.clear();

		if (charText.length() == 0) 
		{
			itemListPogo.addAll(arraylist);
		} 
		else
		{
			for (ItemListPogo wp : arraylist) 
			{
				if (wp.getProductName().toLowerCase(Locale.getDefault())
						.contains(charText)) 
				{
					itemListPogo.add(wp);
				}
				
				else if (wp.getItemName().toLowerCase(Locale.getDefault())
						.contains(charText)) 
				{
					itemListPogo.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}
}
