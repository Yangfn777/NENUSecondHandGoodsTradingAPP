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
				<image :src="item.headPic" mode="" style="width: 100rpx;height: 100rpx;border-radius: 100%;"></image>
			</view>
			<view style="width:80%">
				<view class="" style="font-size: 18px; font-weight: 500;">{{item.nick}}</view>
				<view class="" style="color:#767676">{{item.title}}</view>
				<view class="d-flex j-sb">
					<image :src="item.imgList[0]" mode="widthFix" class="mr-1"></image>
					<image :src="item.imgList[1]" mode="widthFix"></image>
				</view>
				<view class="" style="color:#007bff">#{{item.meta}}</view>
				<view class="mb-1">
					<text style="margin-right:100rpx;">{{item.time}}</text>
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
			goods:[{
				id:0,
				headPic:'../../static/images/5.jpg',
				nick:'奔跑',
				title:'出售考研书籍',
				imgList:['../../static/images/10.jpg','../../static/images/10.jpg'],
				meta:'书本类',
				time:'2020-6-6 13:00:00'
			},
			{
				id:1,
				headPic:'../../static/images/6.jpg',
				nick:'向上',
				title:'出售洗面奶和护肤品',
				imgList:['../../static/images/11.jpg','../../static/images/12.jpg'],
				meta:'生活用品类',
				time:'2020-6-6 13:00:00'
			}]
		};
	},
	onLoad() {},
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
}
</style>
