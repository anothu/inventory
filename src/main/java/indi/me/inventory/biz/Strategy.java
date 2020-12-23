package indi.me.inventory.biz;

import indi.me.inventory.entity.Inventory;
import indi.me.inventory.entity.Orderitem;
import indi.me.inventory.service.InventoryService;
import indi.me.inventory.service.OrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class Strategy {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderitemService orderitemService;


    //定量控制
    public void controlInventoryByNum(int inventoryId){
        Inventory inventory = inventoryService.selectInventoryById(inventoryId);
        if(inventory == null){
            System.out.println("不存在该货物");
            return;
        }
        BigDecimal number = inventory.getNumber();
        if(number.compareTo(inventory.getLowNum())<=0){
            inventory.setNumber(number.add(inventory.getAddNum()));
            inventoryService.updateInventoryById(inventory);
            System.out.println("增补货物");
        }else{
            System.out.println("尚且不需要增补货物");
        }
    }

    //定期控制
    public void controlInventoryByTime(int inventoryId,Long lastTime){
        Inventory inventory = inventoryService.selectInventoryById(inventoryId);
        if(inventory == null){
            System.out.println("不存在该货物");
            return;
        }
        Orderitem orderitem = orderitemService.selectLastSellRecord(inventoryId);
        long pastTime = new Date().getTime()- orderitem.getTime();
        if (pastTime >= lastTime) {
            inventory.setNumber(inventory.getAddToNum());
            System.out.println("填充货物至指定标准");
        }else {
            System.out.println("尚且不需要增补货物");
        }

    }

    //最大最小系统
    public void controlInventoryByTimeAndNum(){

    }

    //查看近期进货情况
    public void checkBuy(int inventoryId,long time){
        orderitemService.selectRecentlyBuy(inventoryId,time);
    }

    //查看近期出货情况
    public void checkSell(int inventoryId,long time){
        orderitemService.selectRecentlySell(inventoryId,time);
    }

    // todo
    //根据供求关系调整定量和定期


}
