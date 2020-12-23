package indi.me.inventory.enums;

import lombok.Getter;

@Getter
public enum OrderItemType {
    INCREASE(0),
    REDUCE(1);

    private int type;

    OrderItemType(int type){
        this.type = type;
    }

}
