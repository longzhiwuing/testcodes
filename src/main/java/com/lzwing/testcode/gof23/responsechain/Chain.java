package com.lzwing.testcode.gof23.responsechain;

import java.util.List;

/**
 * Created by cat on 2017-02-28.
 */
public class Chain {

    private List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed(){
        if(index >= handlers.size()){
            return ;
        }
        handlers.get(index++).execute(this);
    }
}
