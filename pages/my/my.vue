<template>
	<view class="d-flex j-center a-center position-relative flex-wrap" style="height: 400rpx;">
		<image src="../../static/images/bg.jpg" style="height: 400rpx; width: 100%;z-index:-1;top:0;left:0" class="position-absolute"></image>
		<view class="d-flex a-center">
			<image src="../../static/images/userpic.png" class="rounded-circle" style="width: 145rpx;
			height:145rpx; border:5rpx solid #F1F1F1"></image>
			<view class="a-center ml-4">昵称</view>
			<view class="ml-4" @tap="login" style="color:#007AFF">未登录注册</view>
		</view>
	</view>
</template>

<script>
	export default {
	        data() {  
	            return {};  
	        },  
	        onLoad(){  
	            console.log('now:' + helper.now());  
	        },  
	        methods: {
				login:function(e){
					uni.navigateTo({
						url:"../login/login"
					})
				}
	        }  
	    }  
</script>

<style>
</style>
