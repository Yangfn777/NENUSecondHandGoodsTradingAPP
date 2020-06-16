<template>
	<view class="d-flex j-center flex-wrap" style="margin-top:100rpx;width: 100%;">
		<view class="">
			<image src="../../static/images/14.jpg" class="rounded-circle" mode="" style="width:200rpx;height:200rpx;"></image>
		</view>
		<view class="d-flex j-sb font-md" style="width:78%;line-height:80rpx;height:80rpx;">
			<view :class="{'show': hover}" @click="register">学生注册</view>
			<view :class="{'show': !hover}" @click="login">学生登录</view>
		</view>
		<!-- 注册 -->
		<view class="d-flex j-center flex-wrap" v-if="hover">
			<view class="wrap d-flex a-center">
				<image src="../../static/images/zujian-xingming.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="realname" type="text" value="" placeholder="请输入真实姓名" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2"/>
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/shuzi.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="stuno" type="text" value="" placeholder="请输入学号" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/zhuanzhuanye.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="profession" type="text" value="" placeholder="请输入专业" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2"/>
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/yonghuming.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="username" type="text" value="" placeholder="请输入昵称" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2"/>
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/mima.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="password" type="text" value="" placeholder="请输入密码" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2"/>
			</view>
		</view>
		<!-- 登录 -->
		<view class="d-flex j-center flex-wrap" v-if="!hover">
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/shuzi.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="stuno" type="text" value="" placeholder="请输入学号" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/mima.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="password" type="text" value="" placeholder="请输入密码" class="p-2"  placeholder-style="font-size:28rpx;color:#B2B2B2"/>
			</view>
		</view>
		<!-- 点击登录 -->
		<view class="mt-5" style="width:40%">
			<button type="default" class=" bg-primary shadow-sm" style="color:#fff">注册</button>
		</view>
	</view>
</template>

<script>
	export default {
	        data() {  
	            return {
					hover:true,
					realname:'',
					username:'',
					password:'',
					profession:'',
					stuno:''
				};  
	        },  
	        onLoad(){  
	            console.log('now:' + helper.now());  
	        },  
	        methods: {
				register:function(){
					this.hover=true;
				},
				login:function(){
					this.hover=false;
				}
				
	        }  
	    } 
</script>

<style>
	.wrap{
		width:80%;
		border: 1px solid #007AFF;
		border-radius: 20rpx;
	}
	.show{
		color:#007AFF;
	}
</style>
