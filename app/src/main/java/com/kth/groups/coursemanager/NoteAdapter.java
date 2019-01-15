package com.kth.groups.coursemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kth.groups.coursemanager.database.table.NoteEntity;

import java.util.List;

public class NoteAdapter extends BaseAdapter {

    private List<NoteEntity> noteEntities;
    private Context mContext;

    public NoteAdapter(Context context,List<NoteEntity> noteEntities){
        super();
        mContext = context;
        this.noteEntities = noteEntities;
    }

    @Override
    public int getCount() {
        return noteEntities != null ? noteEntities.size() : 0;
    }

    @Override
    public NoteEntity getItem(int position) {
        return noteEntities !=null ? noteEntities.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getNote_ID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_note,parent,false);
            holder = new ViewHolder();
            holder.textView_note_image = convertView.findViewById(R.id.note_image);
            holder.textView_note_name = convertView.findViewById(R.id.textView_note_name);
            holder.textView_note_text = convertView.findViewById(R.id.textView_note_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        NoteEntity data = getItem(position);

        if(data != null){
            holder.textView_note_name.setText(data.getNote_name());
            holder.textView_note_text.setText(data.getNote_text());
        }
        return convertView;
    }

    class ViewHolder{
        private ImageView textView_note_image;
        private TextView textView_note_name;
        private TextView textView_note_text;
    }
}
