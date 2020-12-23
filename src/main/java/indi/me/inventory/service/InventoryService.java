package indi.me.inventory.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import indi.me.inventory.entity.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;
import indi.me.inventory.entity.Orderitem;
import indi.me.inventory.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoyulin
 * @since 2020-12-19
 */
@Service
public class InventoryService {

    public final static int INCREASE_INVENTORY = 0;
    public final static int REDUCE_INVENTORY = 1;

    @Autowired
    private InventoryMapper inventoryMapper;

    //根据输入数量更改存货数量
    public boolean updateInventoryByNumber(int id,String number,int type){
        if(type == REDUCE_INVENTORY){
            number = "-"+number;
        }
        Inventory inventory = inventoryMapper.selectById(id);
        if(inventory == null){
            System.out.println("没有找到相应的货物");
            return false;
        }
        BigDecimal curNum = inventory.getNumber().add(new BigDecimal(number));
        inventory.setNumber(curNum);
        inventoryMapper.updateById(inventory);
        return true;
    }

    //根据订单更改存货数量
    public boolean updateInventoryByOrderItem(Orderitem orderitem){
        return updateInventoryByNumber(orderitem.getInventoryId(),orderitem.getNumber().toString(),orderitem.getType());
    }

    public Inventory selectInventoryById(int id){
        return inventoryMapper.selectById(id);
    }

    public int updateInventoryById(Inventory inventory){
        return inventoryMapper.updateById(inventory);
    }


}
