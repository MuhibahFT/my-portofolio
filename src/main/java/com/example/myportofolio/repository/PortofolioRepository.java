package com.example.myportofolio.repository;

import com.example.myportofolio.data.Data;
import com.example.myportofolio.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PortofolioRepository {

    @Autowired
    Data data;

    public Optional<Transaction> findByTrxId(Integer trxId) throws Exception {
        Optional<Transaction> trx = data.fetchTrxDataToModel().stream().filter(it -> it.getTransaction_id()==trxId).findFirst();;
        if(trx.isEmpty()){
            throw new Exception("trx id not found!");
        }
        return trx;
    }

}
