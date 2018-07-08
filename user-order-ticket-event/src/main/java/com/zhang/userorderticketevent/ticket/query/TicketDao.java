package com.zhang.userorderticketevent.ticket.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aa on 2018/7/9.
 */
@Repository
public interface TicketDao extends JpaRepository<TicketEntry,String> {
}
