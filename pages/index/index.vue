<template>
	<view class="content">
		<!-- 基本用法 -->
		<uni-search-bar @confirm="search" @input="input" class="text-center mt-1 mb-1" style="padding: 0px !important; width:90%"></uni-search-bar>
		<view class="uni-padding-wrap w-100">
			<view class="page-section swiper">
				<view class="page-section-spacing">
					<swiper class="swiper" indicator-dots="true" autoplay="true" interval="2000" duration="500" circular="true">
						<swiper-item><image src="../../static/images/1.jpg"></image></swiper-item>
						<swiper-item><image src="../../static/images/2.jpg"></image></image></swiper-item>
						<swiper-item><image src="../../static/images/3.jpg"></image></swiper-item>
						<swiper-item><image src="../../static/images/4.jpg"></image></swiper-item>
					</swiper>
				</view>
			</view>
		</view>
		<!-- 商品信息 -->
		<view class="d-flex w-100" v-for="(item,index) in goods" :key="index" style="border-bottom:1px solid #BEBEBE">
			<view style="width:20%" class="text-center">
				<image :src="baseUrl+item.head" mode="" style="width: 100rpx;height: 100rpx;border-radius: 100%;"></image>
			</view>
			<view style="width:80%">
				<view class="" style="font-size: 18px; font-weight: 500;">{{item.nick}}</view>
				<view class="" style="color:#767676">{{item.title}}</view>
				<view class="d-flex j-sb">
					<image :src="baseUrl+item.headPic" mode="widthFix" class="mr-1"></image>
					<!-- <image src="../../static/images/11.jpg" mode="widthFix"></image> -->
				</view>
				<view class="" style="color:#007bff">#{{item.type}}</view>
				<view class="mb-1">
					<text style="margin-right:100rpx;">{{item.date}}</text>
					<text @click="goDetail" :id="item.id">浏览</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import uniSearchBar from '@/components/uni-search-bar/uni-search-bar.vue';
export default {
	components: { uniSearchBar },
	data() {
		return {
			baseUrl:'http://47.94.210.131:8080',
			goods:[],
			user:[]
		};
	},
	onShow() {
		uni.request({
				url: 'http://47.94.210.131:8080/goods/list',
				method: 'GET',
				data: {},
				success: res => {
					console.log(res);
					this.goods=res.data.goods;
					this.user=res.data.user;
					//拼接字符串
					for(var i=0;i<this.goods.length;i++) {
					        // console.log(this.goods[i]);
							this.goods[i].nick=this.user[i].username;
							this.goods[i].head=this.user[i].headurl;
							console.log(this.goods[i]);
					    }
				},
				fail: () => {},
				complete: () => {
		
				}
			});
	},
	onLoad() {
		
	},
	methods: {
		goDetail(e){
			//这个商品的id
			var id=e.currentTarget.id
			console.log(id);
			uni.navigateTo({
				url:"../detail/detail?id="+id
			})
		},
		search(e){
			console.log(e);
			uni.request({
					url: 'http://47.94.210.131:8080/goods/queryType?'+'type='+e.value,
					method: 'GET',
					// data:{e.value},
					success: res => {
						
						console.log(res);
						this.goods=res.data;
						// //拼接字符串
						// for(var i=0;i<this.goods.length;i++) {
						//         console.log(this.goods[i]);
						// 		this.goods[i].uu='jj';
						// 		console.log(this.goods[i]);
						//     }
					},
					fail: () => {},
					complete: () => {
			
					}
				});
			uni.navigateTo({
				url:"../search/search?content="+e.value
			})
		},
		input(e){
			console.log(e);
		}
	}
};
</script>

<style>
.content {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	/* color: #4e86ff; */
	padding-bottom:100rpx;
}
</style>
