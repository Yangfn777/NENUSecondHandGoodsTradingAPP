<template>
	<view class="d-flex j-center flex-wrap" style="margin-top:100rpx;width: 100%;">
		<view class=""><image src="../../static/images/14.jpg" class="rounded-circle" mode="" style="width:200rpx;height:200rpx;"></image></view>
		<view @click="chooseTheImg" class="upload" v-if="hover">上传学生证</view>
		<view class="d-flex j-sb font-md" style="width:78%;line-height:80rpx;height:80rpx;">
			<view :class="{ show: hover }" @click="register">学生注册</view>
			<view :class="{ show: !hover }" @click="login">学生登录</view>
		</view>
		<!-- 注册 -->
		<view class="d-flex j-center flex-wrap" v-if="hover">
			<view class="wrap d-flex a-center">
				<image src="../../static/images/zujian-xingming.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="realname" type="text" value="" placeholder="请输入真实姓名" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/shuzi.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="stuno" type="text" value="" placeholder="请输入学号" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/zhuanzhuanye.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="profession" type="text" value="" placeholder="请输入专业" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/yonghuming.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="username" type="text" value="" placeholder="请输入昵称" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/mima.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="password" type="text" value="" placeholder="请输入密码" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
		</view>
		<!-- 登录 -->
		<view class="d-flex j-center flex-wrap" v-if="!hover">
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/shuzi.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="stuno" type="text" value="" placeholder="请输入学号" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
			<view class="mt-5 wrap wrap d-flex a-center">
				<image src="../../static/images/mima.png" mode="" style="width:70rpx;height:70rpx"></image>
				<input v-model="password" type="text" value="" placeholder="请输入密码" class="p-2" placeholder-style="font-size:28rpx;color:#B2B2B2" />
			</view>
		</view>
		<!-- 点击登录 -->
		<view class="mt-5" style="width:40%" @click="goRegister">
			<button type="default" class=" bg-primary shadow-sm" style="color:#fff">{{ type }}</button>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			hover: true,
			realname: '',
			username: '',
			password: '',
			profession: '',
			stuno: '',
			type: '注册'
		};
	},
	// onLoad(){
	//     console.log('now:' + helper.now());
	// },
	methods: {
		chooseTheImg: function() {
			uni.chooseImage({
				count: 1, //图片可选择数量
				sizeType: ['original', 'compressed'], //original 原图，compressed 压缩图，默认二者都有
				// sourceType: ['album'], //album 从相册选图，camera 使用相机，默认二者都有。
				success: res => {
					console.log(res);
					let src = res.tempFilePaths[0]; //图片的本地文件路径列表
					// uni.getFileSystemManager().readFile({
					// 	filePath: src,
					// 	encoding: 'base64',
					// 	success: r => {
					// 		console.log(r);
					// 	}
					// });
					wx.request({
					        url: src,//临时路径
					        responseType: 'arraybuffer', //设置返回的数据格式为arraybuffer
					        success: res => {
					                const imgFiles = wx.arrayBufferToBase64(res.data)};
									
									console.log(imgFiles),
					    })

					console.log(imgFiles);
					this.uploadTheImg(imgFiles);
				}
			});
		},
		//上传图片
		uploadTheImg(imgFiles) {
			uni.uploadFile({
				url: 'http://47.94.210.131:4430/user/recognize', //后端用于处理图片并返回图片地址的接口
				header: {
					Token: this.userToken
				},
				filePath: imgFiles[0],
				name: 'file',
				success: res => {
					console.log(res);
					let data = JSON.parse(res.data); //返回的是字符串，需要转成对象格式，打印data如下图
					if (data.code == 200) {
						console.log(data.msg); //图片地址
					}
				},
				fail: () => {}
			});
		},
		register: function() {
			this.hover = true;
			this.type = '注册';
			this.realname = '';
			this.stuno = '';
			this.password = '';
		},
		login: function() {
			this.hover = false;
			this.type = '登录';
			this.stuno = '';
			this.password = '';
		},
		goRegister: function() {
			console.log(this.realname);
			if (this.type == '注册') {
				uni.request({
					url: 'http://47.94.210.131:4430/user/register',
					method: 'GET',
					data: { realname: this.realname, username: this.username, password: this.password, profession: this.profession, stuno: this.stuno },
					success: res => {
						var that = this;
						console.log(res);
						uni.showToast({
							title: '注册成功',
							duration: 2000,
							success() {
								setTimeout(function() {
									// uni.switchTab({
									//     url: "../index/index",
									// });
									that.login();
								}, 1000);
							}
						});
					},
					fail: () => {},
					complete: () => {}
				});
			} else {
				uni.request({
					url: 'http://47.94.210.131:4430/user/login',
					method: 'GET',
					data: { password: this.password, stuno: this.stuno },
					success: res => {
						console.log(res);
						if (res.data == '') {
							//本地存储数据
							uni.setStorage({
								key: 'stuno',
								data: this.stuno,
								success: function() {
									console.log('success');
								}
							});
							uni.showToast({
								title: '登录成功',
								duration: 2000,
								success() {
									setTimeout(function() {
										uni.switchTab({
											url: '../index/index'
										});
									}, 1000);
								}
							});
						} else {
							uni.showModal({
								title: '提示',
								content: '您填写的登录信息有误，请确定后再次登录',
								success: function(res) {
									if (res.confirm) {
										console.log('用户点击确定');
									} else if (res.cancel) {
										console.log('用户点击取消');
									}
								}
							});
						}
					},
					fail: () => {},
					complete: () => {}
				});
			}
		}
	}
};
</script>

<style>
.wrap {
	width: 80%;
	border: 1px solid #007aff;
	border-radius: 20rpx;
}
.show {
	color: #007aff;
}
.upload {
	width: 80%;
	text-align: center;
	font-size: 32upx;
	/* color:#007AFF; */
}
</style>
