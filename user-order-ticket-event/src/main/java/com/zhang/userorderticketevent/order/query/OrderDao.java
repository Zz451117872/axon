package com.zhang.userorderticketevent.order.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aa on 2018/7/9.
 */
@Repository
public interface OrderDao extends JpaRepository<OrderEntry,String>{
}
