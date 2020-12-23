package indi.me.inventory.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoyulin
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String unit;

    private BigDecimal number;

    private BigDecimal lowNum;

    private Long checkTime;

    private BigDecimal addNum;

    private BigDecimal addToNum;

}
