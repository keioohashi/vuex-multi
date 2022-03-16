import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import * as axios from 'axios'


export default new Vuex.Store({
  state: {
    registStatus:'',
    goodsList:[]
  },
  mutations: {
	
	kariRegistGoods: function(state, value){
		let goods = {'code':value.code, 'name':value.name, 'category':value.category}
		state.goodsList.push( goods )
	},
	clearKariRegistGoods: function(state){
		state.goodsList = []
	},
    setRegistStatus: function(state, value) {
      state.registStatus = value
    },
  },
  actions: {
	kariRegistBook: function( { commit }, goods ){
		commit( "kariRegistGoods", goods );
	},

    registBook: function({ commit }){

		commit('setRegistStatus', "処理中")
		
		axios.post('http://localhost:8090/goods/regist', this.state.goodsList)
			.then(response => {
			
			if( response.data == "Success" ){
				commit('clearKariRegistGoods')
				commit('setRegistStatus', "登録完了")
			}else{
				commit('setRegistStatus', "登録エラー")
			}
		})
		
	}
  },
  modules: {
  },
  
  plugins: [createPersistedState( {
    storage: window.sessionStorage  
  }
  )]  
})