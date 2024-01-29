package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.response.ResponseHandler;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.thinkconstructive.restdemo.model.CloudVendor;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDeltals(){
        return cloudVendorService.getAllCloudVendor();

    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDeltals(@PathVariable("vendorId") String vendorId){
       return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));

    }
    @PostMapping
    public String CreateCloudVendor(@RequestBody CloudVendor cloudVendor){
         cloudVendorService.createCloudVendor(cloudVendor);
         return "Cloud Vendor created Successfully";

    }
    @PutMapping
    public String updateCloudVedor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVedor(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully";
    }
}
