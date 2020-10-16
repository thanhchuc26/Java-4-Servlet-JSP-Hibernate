package com.softech.onlineshop.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-25T18:44:03")
@StaticMetamodel(ShopEntity.class)
public class ShopEntity_ { 

    public static volatile SingularAttribute<ShopEntity, Integer> quantity;
    public static volatile SingularAttribute<ShopEntity, Integer> productId;
    public static volatile SingularAttribute<ShopEntity, String> name;
    public static volatile SingularAttribute<ShopEntity, String> description;
    public static volatile SingularAttribute<ShopEntity, Double> unitprice;
    public static volatile SingularAttribute<ShopEntity, String> manufacturer;

}