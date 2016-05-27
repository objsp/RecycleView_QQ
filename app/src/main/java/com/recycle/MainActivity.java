package com.recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.recycle.inter.StartDragCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StartDragCallback {

    private RecyclerView recycleview;
    private MessageAdapter adapter;
    private ItemTouchHelper touchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recycleview = (RecyclerView) this.findViewById(R.id.recycleview);
        setAdapter();
        setTouch();
    }

    private void setAdapter() {
        List<OrderBean> list = DataBiz.getDataSources();
        this.adapter = new MessageAdapter(list, this);
        /** 非常重要，非常特殊 */
        this.recycleview.setLayoutManager(new LinearLayoutManager(this));
        this.recycleview.setAdapter(this.adapter);
    }

    private void setTouch() {
        MessageCallback messageCallback = new MessageCallback(this.adapter);
        touchHelper = new ItemTouchHelper(messageCallback);
        touchHelper.attachToRecyclerView(this.recycleview);
    }

    @Override
    public void startDrag(RecyclerView.ViewHolder holder) {
        this.touchHelper.startDrag(holder);
    }
}
