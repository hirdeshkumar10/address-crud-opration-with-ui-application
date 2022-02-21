package com.sunglowsys.web;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AddressResource {

    private final Logger log = LoggerFactory.getLogger(AddressResource.class);

    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ModelAndView home() {
        log.debug("REST request to get Address ");
        Page<Address> page = addressService.findAll(PageRequest.of(0,20));
        return new ModelAndView("index","addresses",page.getContent());
    }

    @GetMapping("/addresses")
    public ModelAndView createAddressForm() {
        log.debug("REST request to create Address form:");
        return new ModelAndView("add-address","address",new Address());
    }

    @PostMapping("/addresses")
    public String createAddresses(@ModelAttribute Address address) {
        log.debug("REST request to create Address : {}", address);
        addressService.save(address);
        return "redirect:/";
    }


    @GetMapping("/addresses/{id}")
    public ModelAndView updateAddress(@PathVariable Long id) {
        log.debug("REST request to update Address : {}", id);
        return new ModelAndView("add-address","address",addressService.findById(id).get());
    }

    @GetMapping("/addresses/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        log.debug("REST request to delete Address : {}", id);
        addressService.delete(id);
        return "redirect:/";
    }
}
