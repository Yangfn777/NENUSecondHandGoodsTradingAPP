<template>
	<view class="j-center a-center position-relative" style="height: 100%;">
		<view
				v-if="!info"
				class="login" @tap="login" style="color:#2929ff">登录/注册</view>
		<view class="head position-relative" >
			<image class="bg" :src="'../../static/images/16.jpg'" mode=""></image>
			<view class="" style="height: 100%;position: relative;z-index: 1;">
				<image :src="userInfo.headurl?userInfo.headurl:'../../static/images/userpic.png'" class="rounded-circle mt-5" style="width: 145rpx;
				height:145rpx; border:5rpx solid #F1F1F1"></image>
				<view class="a-center" v-if="info">{{info?info.username:''}}</view>

			</view>
		</view>
		<view class="list">
			<view class="item" @tap="userInfo">个人信息</view>
			<view class="item" @tap="publish">我的发布</view>
			<view class="item" @tap="feedback">我的反馈</view>
		</view>
	</view>
	
</template>

<script>
	export default {
	        data() {  
	            return {
	            	info:null,
					baseUrl:'http://47.94.210.131:8080',
				};
	        },
			onShow(){
				uni.getStorage({
					key:"info",
					success:(e)=>{
						this.info = JSON.parse(e.data)//这就是你想要取的token
					}
				})
				console.log(this.info);
			},
	        methods: {
				login(){
					uni.navigateTo({
						url:"../login/login"
					})
				},
				userInfo(){
					if(!this.info){
						uni.showToast({
							title:"请您先登录哦",
							duration:1000,
							icon:"none"
						});
						return;
					}
					uni.navigateTo({
						url:"../userInfo/userInfo"
					})
				},
				publish(){
					if(!this.info){
						uni.showToast({
							title:"请您先登录哦",
							duration:1000,
							icon:"none"
						});
						return;
					}
					uni.navigateTo({
						url:"../publish/publish"
					})
				},
				feedback(){
					if(!this.info){
						uni.showToast({
							title:"请您先登录哦",
							duration:1000,
							icon:"none"
						});
						return;
					}
					uni.navigateTo({
						url:"../feedback/feedback"
					})
				},
	        }  
	    }  
</script>

<style lang="less" scoped>
	.login{
		position: absolute;
		top: 10px;
		right: 10px;
		z-index: 30;
	}
	.head{
		height: 30%;
		text-align: center;
		overflow: hidden;
		.bg{
			position: absolute;
			top: 0;
			left: 0;
			z-index: 0;
		}
	}
	
	.list .item{
		height: 50px;
		line-height: 30px;
		font-size: 18px;
		padding: 10px;
		box-sizing: border-box;
		border-bottom: 1px solid #999;
		cursor: pointer;
	}
	
</style>
