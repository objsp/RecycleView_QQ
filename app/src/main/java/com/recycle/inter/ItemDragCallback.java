package com.recycle.inter;

/**
 * Created by Administrator on 2016-05-10 0010.
 */
public interface ItemDragCallback {

    boolean changeItemPosition(int fromPosition, int toPosition);

    void itemSwiped(int direction);
}
