package main.java.com.marketsoftcommunityapi.controller;

import com.google.gson.Gson;
import main.java.com.marketsoftcommunityapi.model.Customer;
import main.java.com.marketsoftcommunityapi.model.Item;
import main.java.com.marketsoftcommunityapi.repository.CustomerRepo;
import main.java.com.marketsoftcommunityapi.repository.ItemRepo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class ItemController {
    private Subject subject = SecurityUtils.getSubject();
    private ItemRepo repo = new ItemRepo();

    @GetMapping("item/all")
    public ResponseEntity getAll() {
        subject.checkPermission("item:display");
        return new ResponseEntity<>(repo.getAll(), HttpStatus.OK);
    }


    @GetMapping("item/all/whereparams")
    public ResponseEntity getAll(@RequestParam("where") String whereClause, @RequestParam("params") String[] params) {
        subject.checkPermission("item:display");
        return new ResponseEntity<>(repo.getAll(whereClause, params), HttpStatus.OK);
    }

    @GetMapping("item/all/where")
    public ResponseEntity getAll(@RequestParam("where") String whereClause, @RequestParam("param") String param) {
        subject.checkPermission("item:display");
        return new ResponseEntity<>(repo.getAll(whereClause, param), HttpStatus.OK);
    }


    @GetMapping("/item")
    public ResponseEntity get(@RequestParam int id) {
        subject.checkPermission("item:display");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/item")
    public ResponseEntity delete(@RequestParam int id){
        subject.checkPermission("item:delete");
        repo.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/item/itemcategory")
    public ResponseEntity deleteItemCategory(@RequestParam String category){
        subject.checkPermission("item:delete");
        repo.deleteItemCategory(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/item/itemcategory")
    public ResponseEntity postItemCategory(@RequestParam("category") String itemType) {
        subject.checkPermission("item:add");
        repo.addItemCategory(itemType);
        return new ResponseEntity<>(itemType, HttpStatus.OK);
    }

    @PostMapping("/item")
    public ResponseEntity post (@RequestParam("item") String json) {
        subject.checkPermission("item:add");
        repo.add(new Gson().fromJson(json, Item.class));
        return new ResponseEntity<>(json , HttpStatus.OK);
    }

    @PutMapping("/item")
    public ResponseEntity<String> put(@RequestParam("item") String json)  {
        subject.checkPermission("item:update");
        repo.update(new Gson().fromJson(json, Item.class));
        return new ResponseEntity<>(HttpStatus.OK);

    }
}