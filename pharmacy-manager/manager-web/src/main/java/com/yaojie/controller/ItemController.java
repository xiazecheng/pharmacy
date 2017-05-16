package com.yaojie.controller;

import com.yaojie.pojo.EasyUIDataGridResult;
import com.yaojie.pojo.Item;
import com.yaojie.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author  madao
 * Created by madao on 2016/11/12.
 */
@Controller
@RequestMapping("item")
public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemService itemService;

    /**
     * 新增商品
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addItem(Item item, @RequestParam("desc") String desc,
                                        @RequestParam("itemParams") String itemParams) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("新增商品，item = {}, desc = {}", item, desc);
        }
        /**
         * TODO 校验以后完善
         */
        if (item.getPrice() == null || item.getPrice().intValue() == 0) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("新增商品时用户输入的参数不合法，item = {}, desc = {},itemParams", item, desc);
            }
            // 参数有误，返回400
            //ResponseEntity<Void> build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            Boolean saveItem = this.itemService.saveItem(item, desc,itemParams);
            if (saveItem) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("新增商品成功! id = {}", item.getId());
                }
                //CREATED(201, "Created"),
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            LOGGER.error("新增商品失败! item = " + item + ", desc = " + desc, e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EasyUIDataGridResult> getItemList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "rows", defaultValue = "30") Integer rows) {

        try {
            EasyUIDataGridResult itemList = this.itemService.getItemList(page, rows);
            return ResponseEntity.ok(itemList);
        } catch (Exception e) {

            LOGGER.error("查询商品出错：page="+page+",rows="+rows,e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 更新商品数据
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(Item item, @RequestParam("desc") String desc,
                                           @RequestParam("itemParams") String itemParams){
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("修改商品，item = {}, desc = {}", item, desc);
        }
        /**
         * TODO 校验以后完善
         */
        if (item.getPrice() == null || item.getPrice().intValue() == 0) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("修改商品时用户输入的参数不合法，item = {}, desc = {}", item, desc);
            }
            // 参数有误，返回400
            //ResponseEntity<Void> build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            Boolean updateItem = this.itemService.updateItem(item, desc,itemParams);
            if (updateItem) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("修改商品成功! id = {}", item.getId());
                }
                //CREATED(201, "Created"),
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            LOGGER.error("修改商品失败! item = " + item + ", desc = " + desc, e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
