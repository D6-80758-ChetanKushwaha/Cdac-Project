package com.app.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.CartEntity;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

	@Query(value = "SELECT * FROM Cart c WHERE c.CustID = :custID", nativeQuery = true)
	List<CartEntity> findProdByCustID(@Param("custID") int custID);

	@Modifying
	@Query(value = "UPDATE Cart c SET c.Qty = :newQty WHERE c.Cart_ID = :cartId", nativeQuery = true)
	void UpdateQty(@Param("newQty") int QT, @Param("cartId") int cid);

	@Modifying
	@Query(value = "DELETE FROM Cart WHERE custid = :cid", nativeQuery = true)
	void DeletecartByCust(@Param("cid") int cid);

}
