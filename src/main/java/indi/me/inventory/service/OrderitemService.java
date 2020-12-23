package indi.me.inventory.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import indi.me.inventory.entity.Inventory;
import indi.me.inventory.entity.Orderitem;
import com.baomidou.mybatisplus.extension.service.IService;
import indi.me.inventory.mapper.OrderitemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author xiaoyulin
 * @since 2020-12-19
 */
@Service
public class OrderitemService  {

    public final static int UNCONFIRMED_ORDER = 0;
    public final static int CONFIRMED_ORDER = 1;

    public final static int BUY = 0;
    public final static int SELL = 1;

    @Autowired
    private OrderitemMapper orderitemMapper;

    // 增加新订单
    public int addNewOrderitem(int inventoryId,String number,int type){
        Orderitem orderitem = new Orderitem();
        orderitem.setInventoryId(inventoryId);
        orderitem.setNumber(new BigDecimal(number));
        orderitem.setTime(new Date().getTime());
        orderitem.setType(type);
        orderitem.setIsConfirm(UNCONFIRMED_ORDER);

        return orderitemMapper.insert(orderitem);
    }

    // 确认订单完成
    public int confirmOrderitem(int id){
        Orderitem orderitem = orderitemMapper.selectById(id);
        orderitem.setIsConfirm(CONFIRMED_ORDER);

        return orderitemMapper.updateById(orderitem);
    }

    // 寻找最近一次包含inventoryId的最近一次贩卖记录
    public Orderitem selectLastSellRecord(int inventoryId){
        LambdaQueryWrapper<Orderitem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Orderitem::getInventoryId,inventoryId)
                .eq(Orderitem::getType,SELL)
                .last("order by check_time desc limit 1");
        return orderitemMapper.selectOne(lambdaQueryWrapper);
    }
    /**
     * 查询最近一段时间进货情况
     * time:持续的时间
     */
    public List<Orderitem> selectRecentlyBuy(int inventoryId,long time){
        LambdaQueryWrapper<Orderitem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(time>=0){
            lambdaQueryWrapper.ge(Orderitem::getTime,new Date().getTime()-time);
        }
        lambdaQueryWrapper.eq(Orderitem::getInventoryId,inventoryId)
                .eq(Orderitem::getType,BUY);
        return orderitemMapper.selectList(lambdaQueryWrapper);
    }

    /**
     * 查询最近一段时间出货情况
     * time:持续的时间
     */
    public List<Orderitem> selectRecentlySell(int inventoryId,long time){
        LambdaQueryWrapper<Orderitem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(time>=0){
            lambdaQueryWrapper.ge(Orderitem::getTime,new Date().getTime()-time);
        }
        lambdaQueryWrapper.eq(Orderitem::getInventoryId,inventoryId)
                .eq(Orderitem::getType,SELL);
        return orderitemMapper.selectList(lambdaQueryWrapper);
    }


}
