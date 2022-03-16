<template>
	<center>
	<div class="view-div">
		<h2>仮商品仮登録</h2>
		<center>
		<table>
			<tr>
				<td>商品コード</td>
				<td><input type="text" v-model="goods.code"></td>
			</tr>
			<tr>
				<td>商品名</td>
				<td><input type="text" v-model="goods.name"></td>
			</tr>
			<tr>
				<td>商品カテゴリ</td>
				<td><input type="text" v-model="goods.category"></td>
			</tr>
		</table>
		</center><br/>
		<button v-on:click="kariRegist">仮登録</button><button v-on:click="prev">戻る</button><br/><br/>
	</div>
	
	<div class="view-div">
		<h2>仮商品登録リスト</h2>
		<div class="th-sticky_wrap">

			<center>
				<table class="st-tbl1">
					<thead>
						<tr>
							<th>コード</th>
							<th>名称</th>
							<th>カテゴリ</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for="(goods) in $store.state.goodsList" v-bind:key="goods.code">
							<td>{{ goods.code}}</td>
							<td>{{ goods.name }}</td>
							<td>{{ goods.category }}</td>
						</tr>
					</tbody>
				</table>
			</center><br/>
			<button v-on:click="regist">本登録</button><br/><br/>
		</div>
	</div>
	</center>
</template>
<script>
	export default {
		name: 'RegistGoods',
		data: () => ({
			goods : {code:'',name : '',category : ''}
		}),
		methods: {
			kariRegist: function(){
				this.$store.dispatch('kariRegistBook', this.goods)

			},
			regist: function(){
				this.$store.dispatch('registBook')
				this.$router.push( "/" )
			},
			prev : function(){
				this.$router.push( "/" )
			}
		}
		
	}
</script>