package com.example.haitao.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<String> list;
    private List<Integer> heights;
    private Context context;
    public HomeAdapter(Context context, List<String> list, List<Integer> heights) {
        this.context = context;
        this.list = list;
        this.heights = heights;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(list.get(position));
        ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
        lp.height = heights.get(position);
        holder.tv.setLayoutParams(lp);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context).setTitle("删除提示"+position).setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (position >= list.size()-1)
                                    list.remove(list.size()-1);
                                else
                                    list.remove(position);
                                notifyItemRemoved(position);
//                                notifyItemRangeRemoved(position2, list.size());
                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }
    }
}
