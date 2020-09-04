<template>
	<view class="">
		<view class="w-100 d-flex" style="padding:16rpx;border-bottom: 1px solid #BEBEBE;">
			<view class="" style="width:80%;">
				<view class="" style="font-size: 18px; font-weight: bold;">{{ good.title }}</view>
				<view class="">
					<text class="mr-2">{{ good.date }}</text>
					<text>浏览人数{{ good.view }}人</text>
				</view>
			</view>
			<view class="" style="width: 20%;" @click="isStar">
				<image src="../../static/images/shoucang.png" mode="widthFix" v-if="star" style="width: 60rpx;"></image>
				<image src="../../static/images/star-opp.png" mode="widthFix" v-else style="width: 60rpx;"></image>
			</view>
		</view>
		<view class="" style="padding:16rpx">
			<view class="">图片详情</view>
			<view class="uni-padding-wrap w-100 p-0">
				<view class="page-section swiper">
					<view class="page-section-spacing">
						<swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration" circular="true">
							<swiper-item v-for="(item, index) in imgList" :key="index"><image :src="baseUrl + item.picUrl" mode="heightFix" class="w-100"></image></swiper-item>
						</swiper>
					</view>
				</view>
			</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">详细描述</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{ good.description }}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">类型标签</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#007AFF">#{{ good.type }}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">价钱</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{ good.price }}元</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">联系人</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{ user.username }}</view>
		</view>
		<view class="d-flex w-100 p-1 a-center" style="border-bottom: 1px solid #BEBEBE;">
			<view class="text-center" style="width:24%; font-size:16px;font-weight: 600;">手机号</view>
			<view class="" style="width:86%; line-height:1.2 !important; color:#7d7d7d">{{ user.telnum }}</view>
		</view>
		<view class="" style="border-bottom: 1px solid #BEBEBE;padding:20rpx;background-color: #EEEEEE">
			为保障用户信息的安全，请您先进行学生注册与认证后即可查看具体联系人信息。
		</view>
		<view class="">
			<view class="" style="height:100rpx;line-height: 100rpx;border-bottom:1px solid #BEBEBE">全部留言({{ count }})</view>
			<view v-if="count == 0" class="" style="height:180rpx;line-height: 180rpx;border-bottom:1px solid #BEBEBE;text-align: center;color:#BEBEBE">该信息暂时没有留言</view>
			<view v-else class="">
				<view class="" v-for="(item ,index) in select" :key="index" style="padding:10rpx;">
					<image :src="baseUrl+pic" mode="widthFix" style="width: 60rpx;height: 60rpx;border-radius: 100%;vertical-align: middle"></image>
					<text style="margin-left:20rpx;height:60rpx;line-height: 60rpx;vertical-align: middle">{{item.content}}</text>
					<text style="margin-left:20rpx;height:60rpx;line-height: 60rpx;vertical-align: middle">{{item.times}}</text>
					<text style="font-size:24rpx;vertical-align: middle;margin-left:100rpx;color:#007BFF" @click="feedback">回复</text>
				</view>
			</view>
			<view class="" style="position: fixed;bottom:0rpx;display:block">
				<input
					type="text"
					value=""
					placeholder="有什么想了解的写出来吧"
					v-model="content"
					style="margin-top:20rpx;border-bottom: 1px solid #BEBEBE;width:400rpx;height:80rpx;line-height: 80rpx; margin-left:30rpx;display: inline-block;"
				/>
				<button type="default" style="width:200rpx;background-color: #007AFF;color: #FFFFFF;margin-top:20rpx;display:inline-block" @click="addSelect">发送</button>
			</view>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			baseUrl: 'http://47.94.210.131:8080',
			background: ['color1', 'color2', 'color3'],
			indicatorDots: true,
			autoplay: true,
			interval: 2000,
			duration: 500,
			star: true,
			good: {},
			imgList: [],
			user: {},
			sellerId: null,
			buyerId: null,
			goodsId: null,
			content: null,
			times: null,
			//留言数
			count: 0,
			//留言数组
			select: null,
			pic:null,
		};
	},
	onLoad(option) {
		this.buyerId = 1;
		//获取用户本身的id
		uni.getStorage({
			key: 'stuno',
			success(e) {
				console.log(e);
				//通过学号来获得id

				this.buyerId = 2;
			}
		});
		//获得商品的id
		console.log(option.id);
		this.goodsId = option.id;
		uni.request({
			url: 'http://47.94.210.131:8080/goods/queryId?' + 'id=' + parseInt(option.id),
			method: 'GET',
			// data: {},
			success: res => {
				console.log(res);
				this.good = res.data;
				//获取留言
				uni.request({
					url: 'http://47.94.210.131:8080/comment/buyerSelect',
					method: 'GET',
					data: {
						buyerId: res.data.userId,
						goodsId: option.id
					},
					success: res => {
						console.log(res);
						this.select=res.data;
						this.count=res.data.length;
					}
				});
				//根据id查所有的图片
				uni.request({
					url: 'http://47.94.210.131:8080/goods/listImg?' + 'id=' + parseInt(res.data.id),
					// url:'http://47.94.210.131:4430/goods//listImg?'+'id='+19,
					method: 'GET',
					// data: {},
					success: res => {
						console.log(res);
						this.imgList = res.data;
					},
					fail: () => {},
					complete: () => {}
				});
				//查询用户信息
				this.sellerId = res.data.userId;
				uni.request({
					url: 'http://47.94.210.131:8080/user/queryId?' + 'id=' + parseInt(res.data.userId),
					method: 'GET',
					// data: {},
					success: res => {
						this.user = res.data;
						console.log(res);
					},
					fail: () => {},
					complete: () => {}
				});
			},
			fail: () => {},
			complete: () => {}
		});
	},
	methods: {
		isStar: function(e) {
			this.star = !this.star;
		},
		getTime: function() {
			var date = new Date(),
				year = date.getFullYear(),
				month = date.getMonth() + 1,
				day = date.getDate(),
				hour = date.getHours() < 10 ? '0' + date.getHours() : date.getHours(),
				minute = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes(),
				second = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
			month >= 1 && month <= 9 ? (month = '0' + month) : '';
			day >= 0 && day <= 9 ? (day = '0' + day) : '';
			var timer = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
			return timer;
		},
		addSelect: function(e) {
			//获得时间
			this.times = this.getTime();
			console.log(this.times);
			console.log(this.content);
			//获取头像
			uni.request({
				url: 'http://47.94.210.131:8080/user/queryId',
				method: 'GET',
				data: {
					id: this.buyerId
				},
				success: res => {
					console.log(res);
					this.pic=res.data.headurl;
				}
			});
			//增加留言
			uni.request({
				url: 'http://47.94.210.131:8080/comment/addComment',
				method: 'GET',
				data: {
					sellerId: this.sellerId,
					buyerId: this.buyerId,
					goodsId: this.goodsId,
					content: this.content
					// times:this.times,
				},
				success: res => {
					this.content = null;
					console.log(res);
					//获取留言
					uni.request({
						url: 'http://47.94.210.131:8080/comment/buyerSelect',
						method: 'GET',
						data: {
							buyerId: this.buyerId,
							goodsId: this.goodsId
						},
						success: res => {
							console.log(res);
							this.select = res.data;
							this.count=res.data.length;
						}
					});
				}
			});
		},
		feedback:function(e){
			
		}
	}
};
</script>

<style>
@import url('');
</style>
