package com.customerapplication.customerbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerapplication.customerbooking.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

}
