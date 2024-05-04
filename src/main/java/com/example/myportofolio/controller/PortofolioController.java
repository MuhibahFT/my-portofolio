package com.example.myportofolio.controller;

import com.example.myportofolio.data.Data;
import com.example.myportofolio.model.Transaction;
import com.example.myportofolio.model.exception.Response;
import com.example.myportofolio.repository.PortofolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/portofolio")
public class PortofolioController {

    @Autowired
    private Data data;
    @Autowired
    private PortofolioRepository portofolioRepository;

    @GetMapping("/data")
    public ResponseEntity<?> getData(){
        return  new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping("/addData")
    public ResponseEntity<?> addData(@RequestBody Map<String, Object> request){
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("message","success");
        response.put("addedData",request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/dataList")
    public ResponseEntity<?> getList(){
        Map<String,Object> response = new LinkedHashMap<>();

        try{
            response.put("message","success");
            response.put("dataList",data.fetchTrxData());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("error", "99", e.getMessage(), null));
        }

    }

    @GetMapping("/dataSearchData")
    public ResponseEntity<?> searchData(@RequestParam(value = "transaction_id", required = false) Integer trxId){
        Map<String,Object> response = new LinkedHashMap<>();

        try{
            Optional<Transaction> trx = portofolioRepository.findByTrxId(trxId);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "00",null, trx));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("error", "99", e.getMessage(), null));
        }

    }



}
