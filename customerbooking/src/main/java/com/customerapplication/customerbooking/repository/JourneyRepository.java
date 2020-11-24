package com.customerapplication.customerbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerapplication.customerbooking.entity.JourneyDetails;

@Repository
public interface JourneyRepository extends JpaRepository<JourneyDetails, Integer> {

	@Query(value ="select b.customer_id,  b.route_name, count(   b.route_name)  from\r\n"
			+ "(SELECT  route_name, customer_id, DATEDIFF(hour,  CURRENT_TIMESTAMP, start_date_time),CURRENT_TIMESTAMP,start_date_time FROM JOURNEY_DETAILS  a\r\n"
			+ "where  DATEDIFF(hour,  CURRENT_TIMESTAMP, start_date_time)  < 48) b\r\n"
			+ "group by b.customer_id , b.route_name  having   count(   b.route_name) >2",nativeQuery = true)
	   List<Object> findLastJorneyDetails();

}



