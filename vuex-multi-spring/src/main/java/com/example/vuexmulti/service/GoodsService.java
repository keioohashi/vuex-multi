package com.example.vuexmulti.service;

import java.util.*;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.*;


/**
* 商品の取得、追加を行うサービス
**/
@Scope("singleton")
@Service
public class GoodsService {
	
	private List<Goods> goodsList = new ArrayList<Goods>();
	
	/**
	 * 商品情報を取得するメソッド
	**/
	public Goods[] getGoods(){
		return goodsList.toArray( new Goods[]{} );
	}
	
	/**
	 * 商品情報を登録するメソッド
	**/
	public void registGoods( Goods goods ){
		goodsList.add( goods );
	}
	
}