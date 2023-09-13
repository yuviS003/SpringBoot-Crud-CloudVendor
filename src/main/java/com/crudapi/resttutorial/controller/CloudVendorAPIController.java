package com.crudapi.resttutorial.controller;

import com.crudapi.resttutorial.model.CloudVendor;
import com.crudapi.resttutorial.response.ResponseHandler;
import com.crudapi.resttutorial.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIController {

    CloudVendorService cloudVendorService;
    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}") // GET api to fetch cv by id
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping() // GET api to fetch all cv
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping // POST api to create new cloud vendor
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created";
    }

    @PutMapping // PUT api to update existing cloud vendor
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated";
    }
    @DeleteMapping("{vendorId}") // DELETE api to delete cloud vendor
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted";
    }
}
