package com.jasmine.设计模式.备忘录模式_Memento.例2;

import java.util.ArrayList;

/**
 * 备忘录
 *
 * @author jasmineXz
 */
class MementoCaretaker {

    //定义一个集合来存储备忘录
    private ArrayList<ChessmanMemento> mementoList = new ArrayList<>();

    /**
     * 获取备忘录
     * @param i
     * @return
     */
    public ChessmanMemento getMemento(int i) {
        return mementoList.get(i);
    }

    /**
     * 添加备忘录
     * @param memento
     */
    public void addMemento(ChessmanMemento memento) {
        mementoList.add(memento);
    }
}
