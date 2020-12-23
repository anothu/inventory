package indi.me.inventory.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author xiaoyulin
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("orderItem")
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer inventoryId;

    private BigDecimal number;

    private Long time;

    /**
     * 0 购入
     * 1 卖出
     */
    private Integer type;

    /**
     *  0 未确认
     *  1 已确认
     * */
    private Integer isConfirm;


}
