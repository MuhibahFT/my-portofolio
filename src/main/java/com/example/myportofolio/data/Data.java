package com.example.myportofolio.data;

import com.example.myportofolio.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Data {

    // get data https://www.mockaroo.com/

    public Object fetchTrxData() throws JsonProcessingException {

        String json = "[{\"transaction_id\":1,\"product_name\":\"Guinea Fowl\",\"quantity\":1,\"unit_price\":713.99,\"total_price\":713.99,\"transaction_date\":\"9/15/2021\",\"customer_name\":\"Meara McKague\",\"customer_email\":\"mmckague0@so-net.ne.jp\",\"payment_method\":\"PayPal\",\"shipping_address\":\"5327 Judy Plaza\"},\n" +
                "{\"transaction_id\":2,\"product_name\":\"Stainless Steel Cleaner Vision\",\"quantity\":14,\"unit_price\":158.66,\"total_price\":2221.24,\"transaction_date\":\"1/8/2021\",\"customer_name\":\"Winslow Bletcher\",\"customer_email\":\"wbletcher1@cam.ac.uk\",\"payment_method\":\"PayPal\",\"shipping_address\":\"9056 Hauk Center\"},\n" +
                "{\"transaction_id\":3,\"product_name\":\"Sauce - Caesar Dressing\",\"quantity\":68,\"unit_price\":714.47,\"total_price\":48583.96,\"transaction_date\":\"3/25/2021\",\"customer_name\":\"Renelle Witcombe\",\"customer_email\":\"rwitcombe2@nationalgeographic.com\",\"payment_method\":\"PayPal\",\"shipping_address\":\"00755 Daystar Parkway\"},\n" +
                "{\"transaction_id\":4,\"product_name\":\"Wine - Clavet Saint Emilion\",\"quantity\":46,\"unit_price\":577.48,\"total_price\":26564.08,\"transaction_date\":\"3/29/2021\",\"customer_name\":\"Ring Pau\",\"customer_email\":\"rpau3@posterous.com\",\"payment_method\":\"Cash\",\"shipping_address\":\"75054 Old Gate Crossing\"},\n" +
                "{\"transaction_id\":5,\"product_name\":\"Bagel - Whole White Sesame\",\"quantity\":48,\"unit_price\":35.25,\"total_price\":1692.0,\"transaction_date\":\"11/28/2021\",\"customer_name\":\"Calv Tideswell\",\"customer_email\":\"ctideswell4@netlog.com\",\"payment_method\":\"PayPal\",\"shipping_address\":\"12 Commercial Crossing\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        // Convert JSON string to Map
        List<Map<String, Object>> list = objectMapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});

        return list;
    }

    public List<Transaction> fetchTrxDataToModel() throws JsonProcessingException {

        String json = "[{\"transaction_id\":1,\"product_name\":\"Guinea Fowl\",\"quantity\":1,\"unit_price\":713.99,\"total_price\":713.99,\"transaction_date\":\"9/15/2021\",\"customer_name\":\"Meara McKague\",\"customer_email\":\"mmckague0@so-net.ne.jp\",\"payment_method\":\"PayPal\",\"shipping_address\":\"5327 Judy Plaza\"},\n" +
                "{\"transaction_id\":2,\"product_name\":\"Stainless Steel Cleaner Vision\",\"quantity\":14,\"unit_price\":158.66,\"total_price\":2221.24,\"transaction_date\":\"1/8/2021\",\"customer_name\":\"Winslow Bletcher\",\"customer_email\":\"wbletcher1@cam.ac.uk\",\"payment_method\":\"PayPal\",\"shipping_address\":\"9056 Hauk Center\"},\n" +
                "{\"transaction_id\":3,\"product_name\":\"Sauce - Caesar Dressing\",\"quantity\":68,\"unit_price\":714.47,\"total_price\":48583.96,\"transaction_date\":\"3/25/2021\",\"customer_name\":\"Renelle Witcombe\",\"customer_email\":\"rwitcombe2@nationalgeographic.com\",\"payment_method\":\"PayPal\",\"shipping_address\":\"00755 Daystar Parkway\"},\n" +
                "{\"transaction_id\":4,\"product_name\":\"Wine - Clavet Saint Emilion\",\"quantity\":46,\"unit_price\":577.48,\"total_price\":26564.08,\"transaction_date\":\"3/29/2021\",\"customer_name\":\"Ring Pau\",\"customer_email\":\"rpau3@posterous.com\",\"payment_method\":\"Cash\",\"shipping_address\":\"75054 Old Gate Crossing\"},\n" +
                "{\"transaction_id\":5,\"product_name\":\"Bagel - Whole White Sesame\",\"quantity\":48,\"unit_price\":35.25,\"total_price\":1692.0,\"transaction_date\":\"11/28/2021\",\"customer_name\":\"Calv Tideswell\",\"customer_email\":\"ctideswell4@netlog.com\",\"payment_method\":\"PayPal\",\"shipping_address\":\"12 Commercial Crossing\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        // Convert JSON array to List<Transaction>
        List<Transaction> transactions = objectMapper.readValue(json, new TypeReference<List<Transaction>>() {});

        return transactions;
    }

}
