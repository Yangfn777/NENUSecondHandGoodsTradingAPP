<template>
	<view class="">
		<view class="w-100 d-flex" style="padding:16rpx;border-bottom: 1px solid #BEBEBE;">
			<view class="" style="width:80%;">
				<view class="" style="font-size: 18px; font-weight: bold;">{{ good.title }}</view>
				<view class="">
					<text class="mr-2">{{ good.time }}</text>
					<text>浏览人数{{ good.num }}人</text>
				</view>
			</view>
			<view class="" style="width: 20%;">
				<image src="../../static/images/shoucang.png" mode="widthFix" v-if="star" style="width: 60rpx;"></image>
				<image src="../../static/images/star-opp.png" mode="widthFix" v-else></image>
			</view>
		</view>
		<view class="" style="padding:16rpx">
			<view class="">图片详情</view>
			<view class="uni-padding-wrap w-100 p-0">
				<view class="page-section swiper">
					<view class="page-section-spacing">
						<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration" circular="true">
							<swiper-item v-for="(item,index) in good.imgList" :key="index"><image :src="item" mode="heightFix" class="w-100"></image></swiper-item>
						</swiper>
					</view>
				</view>
			</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">详细描述</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{good.des}}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">类型标签</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#007AFF">#{{good.meta}}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">价钱</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{good.price}}元</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">联系人</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{good.person}}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">手机号</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{good.tel}}</view>
		</view>
		<view class="" style="border-bottom: 1px solid #BEBEBE;padding:20rpx;background-color: #EEEEEE">
			为保障用户信息的安全，请您先进行学生注册与认证后即可查看具体联系人信息。
		</view>
		<view class="">
			<view class="" style="height:100rpx;line-height: 100rpx;border-bottom:1px solid #BEBEBE">全部留言(0)</view>
			<view class="" style="height:180rpx;line-height: 180rpx;border-bottom:1px solid #BEBEBE;text-align: center;color:#BEBEBE">
				该信息暂时没有留言
			</view>
			<view class="d-flex">
				<input type="text" value="" placeholder="有什么想了解的写出来吧" style="margin-top:20rpx;;border-bottom: 1px solid #BEBEBE;width:70%;height:80rpx;line-height: 80rpx; margin-left:50rpx;">
				<button type="default" style="width:20%;background-color: #007AFF;color: #FFFFFF;margin-top:20rpx;">发送</button>
			</view>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			background: ['color1', 'color2', 'color3'],
			indicatorDots: true,
			autoplay: true,
			interval: 2000,
			duration: 500,
			star: true,
			good: {
				title: '考研复习资料全套',
				time: '2020-6-6 13:00:00',
				num: '32',
				imgList: ['../../static/images/10.jpg','../../static/images/10.jpg'],
				des: '考研资料几乎全新，考试前花了300百购买，现在考研结束，140出，不邮寄，一食堂自行取货！非同校勿扰，谢谢！',
				meta: '书本类',
				price: 140,
				person: '奔跑',
				tel: '183****2881'
			}
		};
	},
	methods: {}
};
</script>

<style>
	@import url("");
</style>
