package com.example.vuexmulti.ac;

import java.lang.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.vuexmulti.service.GoodsService;
import com.example.vuexmulti.service.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	
    /**
     * 商品情報リストを取得
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Goods[] getGoodsList() {
    	return goodsService.getGoods();
    }

	/**
	* 商品情報登録
	* @return 結果
	*/
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist( @RequestBody Goods[] goodsList ){
		
		//5秒間待機
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		
		for( Goods goods : goodsList ){
			System.out.println( goods.getCode() );
			System.out.println( goods.getName() );
			System.out.println( goods.getCategory() );
			
			goodsService.registGoods( goods );
			
		}
		

		
		return "Success";
	}
	

}