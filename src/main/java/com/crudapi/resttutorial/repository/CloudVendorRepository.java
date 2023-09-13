package com.crudapi.resttutorial.repository;

import com.crudapi.resttutorial.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
