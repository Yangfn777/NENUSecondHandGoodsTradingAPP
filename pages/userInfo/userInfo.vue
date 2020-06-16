<template>
	<view class="list">
		<view class="img" style="text-align: center;">
			<image src="../../static/images/userpic.png" class="rounded-circle mt-3" style="width: 145rpx;
			height:145rpx; border:5rpx solid #F1F1F1"></image>
		</view>
		<view class="item">真实姓名
			<view class="con">XXX</view>
		</view>
		<view class="item">学生学号
			<view class="con">XXX</view>	
		</view>
		<view class="item">学生专业
			<view class="con">XXX</view>
		</view>
		<view class="item">学生昵称
			<view class="con" @tap="changeName" style="width: 20%;color: #007AFF;text-align: right;">修改昵称</view>
			<view class="con" style="width: 50%;" >XXX</view>
		</view>
		<view class="item">联系方式
			<view class="con">XXX</view>
		</view>
		<view class="item" style="color: #007AFF;" @tap="changePwd">修改密码</view>
		<uniPopup ref="popupName" type="center">
			<view class="box">
				<view class="title">修改昵称</view>
				<view class="con">
					<input type="text" placeholder="请输入昵称" value="" class="uni-input" 
						style="border-bottom: 1x solid #ddd;"
					/>
					<button type="primary" size="mini"
						style="display: block; margin-top: 8px;"
					>提交修改</button>
				</view>
			</view>
		</uniPopup>
		<uniPopup ref="popupPwd" type="center">
			<view class="box">
				<view class="title">修改密码</view>
				<view class="con">
					<input type="text" password placeholder="请输入原密码" value="" class="uni-input" 
						style="border-bottom: 1x solid #ddd;"
					/>
					<input type="text" password placeholder="请输入新密码" value="" class="uni-input"
						style="border-bottom: 1x solid #ddd;"
					/>
					<input type="text" password placeholder="请再次输入新密码" value="" class="uni-input"
						style="border-bottom: 1x solid #ddd;"
					/>
					<button type="primary" size="mini"
						style="display: block; margin-top: 8px;"
					>提交修改</button>
				</view>
			</view>
		</uniPopup>
	</view>
</template>

<script>
	
	import {uniPopup} from '@dcloudio/uni-ui'
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			changeName(){
				this.$refs.popupName.open()
			},
			changePwd(){
				this.$refs.popupPwd.open()
			}
		},
		components: {
		    uniPopup,
		}
	}
</script>

<style lang="less" scoped>
	.list .item{
		box-sizing: border-box;
		padding: 0 10px;
		height: 50px;
		line-height: 50px;
		border-bottom: 1px solid #999;
		.con{
			box-sizing: border-box;
			height: 50px;
			line-height: 50px;
			width: 70%;
			float: right;
		}
	}
	
	.box{
		padding: 15px;
		width: 550upx;
		background-color: #fff;
		border-radius: 8px;
		.title{
			border-bottom: 1px solid #999;
			text-align: center;
			color: #007AFF;
		}
		.uni-input{
			border-bottom: 1px solid #ddd;
		}
	}
</style>
