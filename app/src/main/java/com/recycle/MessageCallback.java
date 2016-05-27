package com.recycle;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.recycle.inter.ItemDragCallback;

/**
 * Created by Administrator on 2016-05-10 0010.
 */
public class MessageCallback extends ItemTouchHelper.Callback {

    private ItemDragCallback itemCallback;

    public MessageCallback(ItemDragCallback itemCallback) {
        this.itemCallback = itemCallback;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // callback 监听哪些动作，其中注意：判断方向
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipe = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(drag, swipe);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // 监听滑动：水平，垂直
        // 数据集合中的两个数据进行位置交换，同时完成后刷新RecycleView
        this.itemCallback.changeItemPosition(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // 滑动删除动作回调
        // 删除数据集合position位置数据，并且刷新adapter
        this.itemCallback.itemSwiped(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        // 长按条目拖动开关
        return true;
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        // 在之前执行某些动画
        if (isCurrentlyActive && actionState == ItemTouchHelper.ACTION_STATE_SWIPE) { // 判断侧滑动作
            float num = 1 - Math.abs(dX / viewHolder.itemView.getWidth());
            viewHolder.itemView.setAlpha(num);
            viewHolder.itemView.setScaleX(Math.max(0.75f, num));
            viewHolder.itemView.setScaleY(Math.max(0.75f, num));
            if (num <= 0) {
                viewHolder.itemView.setAlpha(1);
                viewHolder.itemView.setScaleX(1);
                viewHolder.itemView.setScaleY(1);
            }
        } else {
            viewHolder.itemView.setAlpha(1);
            viewHolder.itemView.setScaleX(1);
            viewHolder.itemView.setScaleY(1);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
