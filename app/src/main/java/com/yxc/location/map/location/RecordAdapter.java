package com.yxc.location.map.location;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yxc.location.R;
import com.yxc.location.map.model.Record;

import java.util.List;

public class RecordAdapter extends BaseAdapter {

	private Context mContext;
	private List<Record> mRecordList;

	public RecordAdapter(Context context, List<Record> list) {
		this.mContext = context;
		this.mRecordList = list;
	}

	@Override
	public int getCount() {
		return mRecordList.size();
	}

	@Override
	public Object getItem(int position) {
		return mRecordList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(mContext, R.layout.recorditem, null);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.record = (TextView) convertView.findViewById(R.id.record);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Record item = mRecordList.get(position);
		holder.date.setText(item.getDate() + ":" + item.id);
		holder.record.setText(item.toString());
		return convertView;
	}

	private class ViewHolder {
		TextView date;
		TextView record;
	}
}
