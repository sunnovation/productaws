package com.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {



    @PostMapping("/add-data")
    public ResponseEntity<HashMap<String,Object>> addEmployees() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                products().stream()
                        .sorted((p1,p2)-> {
                            return p2.getId() - p1.getId();
                        }).
                        collect(Collectors.toList()));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/fetch-employees")
    public ResponseEntity<HashMap<String,Object>> fetchEmployees() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                products().stream().
                        sorted((p1,p2)->p2.getId()-p1.getId()).
                        collect(Collectors.toList()));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetch-category")
    public ResponseEntity<HashMap<String,Object>> fetchCatigories() {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                products().stream().

                        collect(Collectors.groupingBy(Product::getCategory,Collectors.counting())));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetch-category")
    public ResponseEntity<HashMap<String,Object>> fetchCatigories(@RequestParam String filter) {
        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("status", true);
        response.put("payload",
                products().stream().
                        filter(product ->product.getCategory().equalsIgnoreCase(filter)).
                        collect(Collectors.groupingBy(Product::getCategory,Collectors.counting())));
        response.put("code", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    private List<Product> products(){

        return List.of(

                new Product(1, "MucallGel", UUID.randomUUID().toString(), 315.78, "Medical", LocalDate.now(), DateUtility.exiryDate()),
                new Product(2,"Samsung V2",UUID.randomUUID().toString(),452367.56,"mobile",LocalDate.now(), DateUtility.exiryDate()),
                new Product(3,"HP Laptop",UUID.randomUUID().toString(),782367.56,"Laptop",LocalDate.now(), DateUtility.exiryDate()),
                new Product(4,"Lenovo IPAD",UUID.randomUUID().toString(),952367.56,"Laptop",LocalDate.now(), DateUtility.exiryDate()),
                new Product(5,"Iphone 15 Pro",UUID.randomUUID().toString(),1452367.56,"mobile",LocalDate.now(), DateUtility.exiryDate()),
                new Product(6,"General 6789 Split AC",UUID.randomUUID().toString(),352367.56,"AC",LocalDate.now(), DateUtility.exiryDate()),
                new Product(7,"Samsung AC",UUID.randomUUID().toString(),452367.56,"AC",LocalDate.now(), DateUtility.exiryDate()),
                new Product(8,"DELL 8754",UUID.randomUUID().toString(),672367.56,"Laptop",LocalDate.now(), DateUtility.exiryDate()),
                new Product(9,"HAVELS CILING FAN",UUID.randomUUID().toString(),2367.56,"Electronic",LocalDate.now(), DateUtility.exiryDate()),
                new Product(10,"LG AC",UUID.randomUUID().toString(),52367.56,"AC",LocalDate.now(), DateUtility.exiryDate())



        );

    }

}

