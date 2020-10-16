package com.softech.asgshop.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-21T20:41:51")
@StaticMetamodel(ProductEntity.class)
public class ProductEntity_ { 

    public static volatile SingularAttribute<ProductEntity, Integer> quantity;
    public static volatile SingularAttribute<ProductEntity, Integer> productId;
    public static volatile SingularAttribute<ProductEntity, BigDecimal> price;
    public static volatile SingularAttribute<ProductEntity, String> name;
    public static volatile SingularAttribute<ProductEntity, String> description;

}