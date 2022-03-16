<template>
			登録状況：{{ $store.state.registStatus }}<br/><br/>
			<button v-on:click="registGoods">商品登録</button><button v-on:click="getGoods">表示更新</button>
			<br/><br/>
			<center>
		<div class="th-sticky_wrap">

			<table class="st-tbl1">
				<thead>
					<tr>
						<th>コード</th>
						<th>名称</th>
						<th>カテゴリ</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(goods) in goodsList" v-bind:key="goods.code">
						<td>{{ goods.code}}</td>
						<td>{{ goods.name }}</td>
						<td>{{ goods.category }}</td>
					</tr>
				</tbody>
			</table>

		</div>
			</center>
		
</template>

<script>
import * as axios from 'axios'

export default {
	components: {
	},
	name: 'GoodsList',
	data: () => ({
		goodsList: []
	}),
	mounted () {
		this.getGoods()
	},
	methods: {
		registGoods: function(){
			this.$router.push( "/regist" )
		},
		getGoods: function(){
			axios.get('http://localhost:8090/goods/list')
				.then(response => {
				this.goodsList = response.data
				console.log( response.data[1] );
			})
		}
	}
}
</script>

