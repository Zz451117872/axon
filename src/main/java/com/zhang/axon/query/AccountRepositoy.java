package com.zhang.axon.query;

import com.zhang.axon.query.AccountEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoy extends JpaRepository<AccountEntry , String> {
}
