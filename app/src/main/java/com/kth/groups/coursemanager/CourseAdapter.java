package com.kth.groups.coursemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kth.groups.coursemanager.database.table.CourseEntity;

import org.w3c.dom.Text;

import java.util.List;

public class CourseAdapter extends BaseAdapter {

    private List<CourseEntity> courseEntities;
    private  Context mContext;

    public CourseAdapter(Context context,List<CourseEntity> courseEntities){
        super();
        this.mContext = context;
        this.courseEntities = courseEntities;
    }

    @Override
    public int getCount() {
        return courseEntities != null ? courseEntities.size() : 0;
    }

    @Override
    public CourseEntity getItem(int position) {
        return courseEntities != null ? courseEntities.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_course,parent,false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.textView_course_image);
            holder.textView_course_name = convertView.findViewById(R.id.textView_course_name);
            holder.textView_course_details = convertView.findViewById(R.id.textView_course_details);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        CourseEntity data = getItem(position);
        if(data != null){
            holder.textView_course_name.setText(data.getCourse_name());
            holder.textView_course_details.setText("课程编号："+data.getCourse_ID());
        }
        return convertView;
    }


    class ViewHolder{
        private ImageView imageView;
        private TextView textView_course_name;
        private TextView textView_course_details;
    }
}
