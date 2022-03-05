package au.com.belong.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import au.com.belong.phone.dto.PhoneDto;
import au.com.belong.phone.service.PhoneService;

import java.util.List;

/**
 * REST controller for managing {@link au.com.belong.phone.model.Phone}.
 */
@RestController
@RequestMapping("api/v1/phone")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;

    }

    @GetMapping
    public ResponseEntity<List<PhoneDto>> getAllPhoneNumbers() throws Exception {
        List<PhoneDto> phoneDtoList = phoneService.findAllPhoneNumbers();
        return  ResponseEntity.ok().body(phoneDtoList);
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PhoneDto>> getPhoneByCustomerId(@PathVariable("customerId") String customerId) throws Exception {
        List<PhoneDto> phoneDtoList= phoneService.findPhoneByCustomerId(customerId);
        return ResponseEntity.ok().body(phoneDtoList);
    }
    
    @PutMapping("/activate/{phoneId}")
    public ResponseEntity<PhoneDto> activatePhone(@PathVariable("phoneId") String phoneID) throws Exception {
        phoneService.activatePhoneById(phoneID);
        PhoneDto phoneDto = phoneService.findPhoneByPhoneId(phoneID);
        return ResponseEntity.ok(phoneDto);
    }

}
