package com.luv2code.springboot.AssignmentDemo.dao;

;
import com.luv2code.springboot.AssignmentDemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    public List<Item> findAllByOrderByItemNameAsc();

    @Query("select i from Item i where i.vendorId = :vendor_id")

    public List<Item> findItemByVendorId(int vendor_id);



    @Modifying
    @Query(value ="delete from items i where i.vendor_id= :vendor_id", nativeQuery = true)
    @Transactional
    public void deleteItemsByVendorId(@Param("vendor_id") int vendor_id);


	
}
