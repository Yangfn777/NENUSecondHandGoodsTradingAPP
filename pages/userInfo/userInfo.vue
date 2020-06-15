<template>
	<view class="list">
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
			<view class="con" style="width: 20%;color: #007AFF;text-align: right;">修改昵称</view>
			<view class="con" style="width: 50%;" @tap="changeName">XXX</view>
		</view>
		<view class="item">联系方式
			<view class="con">XXX</view>
		</view>
		<view class="item" style="color: #007AFF;">修改密码</view>
		<uni-popup ref="popupName" type="center">修改昵称</uni-popup>
		<uni-popup ref="popupPwd" type="center">修改密码</uni-popup>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			changeName(){
				this.$refs.popupName.open()
			}
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
</style>
