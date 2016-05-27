package com.recycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recycle.inter.ItemDragCallback;
import com.recycle.inter.StartDragCallback;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016-05-10 0010.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> implements ItemDragCallback {

    private final StartDragCallback startDragCallback;
    private List<OrderBean> list;

    public MessageAdapter(List<OrderBean> list, StartDragCallback startDragCallback) {
        this.list = list;
        this.startDragCallback = startDragCallback;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(final MessageHolder holder, int position) {
        OrderBean ob = list.get(position);
        holder.header.setImageResource(ob.getHeader());
        holder.title.setText(ob.getTitle());
        holder.price.setText(ob.getPrice());
        holder.name.setText(ob.getName());
        holder.phone.setText(ob.getPhone());
        holder.state.setText(ob.getState());

        holder.header.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 判断
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startDragCallback.startDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean changeItemPosition(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void itemSwiped(int direction) {
        list.remove(direction);
        notifyItemRemoved(direction);
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        private ImageView header;
        private TextView title;
        private TextView price;
        private TextView name;
        private TextView phone;
        private TextView state;

        public MessageHolder(View itemView) {
            super(itemView);
            this.header = (ImageView) itemView.findViewById(R.id.order_img);
            this.title = (TextView) itemView.findViewById(R.id.order_title);
            this.price = (TextView) itemView.findViewById(R.id.order_price);
            this.name = (TextView) itemView.findViewById(R.id.order_name);
            this.phone = (TextView) itemView.findViewById(R.id.order_phone);
            this.state = (TextView) itemView.findViewById(R.id.order_state);
        }
    }

}
