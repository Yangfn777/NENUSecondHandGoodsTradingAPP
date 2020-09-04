<template>
	<view class="list">
		<view class="img" style="text-align: center;"
		>
			<image :src="userInfo.headurl?userInfo.headurl:'../../static/images/userpic.png'" class="rounded-circle mt-3" style="width: 145rpx;
			height:145rpx; border:5rpx solid #F1F1F1"
				   @click="upImg"
			></image>
		</view>
		<view class="item">真实姓名
			<view class="con">{{userInfo.realname}}</view>
		</view>
		<view class="item">学生学号
			<view class="con">{{userInfo.stuno}}</view>
		</view>
		<view class="item">学生专业
			<view class="con">{{userInfo.profession}}</view>
		</view>
		<view class="item">学生昵称
			<view class="con" @tap="changeName" style="width: 20%;color: #007AFF;text-align: right;">修改昵称</view>
			<view class="con" style="width: 50%;" >{{userInfo.username}}</view>
		</view>
		<view class="item">联系方式
			<view class="con" @tap="changeTel" style="width: 30%;color: #007AFF;text-align: right;">修改联系方式</view>
			<view class="con" style="width: 40%;">{{userInfo.telnum?userInfo.telnum:"暂无联系方式"}}</view>
		</view>
		<view class="item" style="color: #007AFF;" @tap="changePwd">修改密码</view>
		<uniPopup ref="popupName" type="center">
			<view class="box">
				<view class="title">修改昵称</view>
				<view class="con">
					<input type="text" placeholder="请输入昵称" value="" class="uni-input"
						style="border-bottom: 1x solid #ddd;"
						v-model="newUsername"
					/>
					<button type="primary" size="mini"
						style="display: block; margin-top: 8px;"
						@click="upName"
					>提交修改</button>
				</view>
			</view>
		</uniPopup>
		<uniPopup ref="popuptel" type="center">
			<view class="box">
				<view class="title">修改联系方式</view>
				<view class="con">
					<input type="text" placeholder="请输入联系方式" value="" class="uni-input"
						   style="border-bottom: 1x solid #ddd;"
						   v-model="newtel"
					/>
					<button type="primary" size="mini"
							style="display: block; margin-top: 8px;"
							@click="upTel"
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
						   v-model="oldpwd"
					/>
					<input type="text" password placeholder="请输入新密码" value="" class="uni-input"
						style="border-bottom: 1x solid #ddd;"
						   v-model="newpwd"
					/>
					<input type="text" password placeholder="请再次输入新密码" value="" class="uni-input"
						style="border-bottom: 1x solid #ddd;"
						   v-model="repwd"
					/>
					<button type="primary" size="mini"
						style="display: block; margin-top: 8px;"
							@click="upPassword"
					>提交修改</button>
				</view>
			</view>
		</uniPopup>
	</view>
</template>

<script>

	import {uniPopup} from '@dcloudio/uni-ui'
	import {changeUserInfo,relogin,changePwd} from "../../util/userInfo";

	export default {
		data() {
			return {
				url:"http://47.94.210.131:4430",
				userInfo:null,
				oldpwd:"",
				newpwd:"",
				repwd:"",
				newUsername:"",
				newtel:""
			}
		},
		onShow(){
			uni.getStorage({
				key:"info",
				success:(e)=>{
					this.userInfo = JSON.parse(e.data)//这就是你想要取的token
				}
			})
		},
		methods: {
			changeName(){
				this.$refs.popupName.open()
			},
			changeTel(){
				this.$refs.popuptel.open()
			},
			changePwd() {
				this.$refs.popupPwd.open()
			},
			upName(){
				changeUserInfo({
					id:this.userInfo.id,
					username:this.newUsername,
					password:this.userInfo.password
				}).then(res=>{
					if(res[1].data===1){
						uni.showToast({
							title:"修改成功",
							duration:1500,
							mask:false,
							icon:"none"
						});
						this.$refs.popupName.close()
						this.userInfo.username = this.newUsername
						uni.setStorage({
							key: 'info',
							data: JSON.stringify(this.userInfo),
							success: function() {
							}
						});
						this.newUsername = ""
					}else {
						uni.showToast({
							title:"修改失败",
							duration:1500,
							mask:false,
							icon:"none"
						});
					}
				})
			},
			upTel(){
				changeUserInfo({
					id:this.userInfo.id,
					telnum:this.newtel,
					password:this.userInfo.password,
					username: this.userInfo.username,
				}).then(res=>{
					if(res[1].data===1){
						uni.showToast({
							title:"修改成功",
							duration:1500,
							mask:false,
							icon:"none"
						});
						this.$refs.popuptel.close()
						this.userInfo.telnum = this.newtel
						uni.setStorage({
							key: 'info',
							data: JSON.stringify(this.userInfo),
							success: function() {
							}
						});
						this.newtel = ""
					}else {
						uni.showToast({
							title:"修改失败",
							duration:1500,
							mask:false,
							icon:"none"
						});
					}
				})
			},
			upPassword(){
				if(!(this.newpwd&&this.oldpwd&&this.repwd)){
					uni.showToast({
						title:"请将信息填写完整",
						duration:1500,
						mask:false,
						icon:"none"
					});
					return;
				}
				if(this.newpwd!=this.repwd){
					uni.showToast({
						title:"请使两次密码一致",
						duration:1500,
						mask:false,
						icon:"none"
					});
					return;
				}
				relogin({
					username: this.userInfo.username,
					password:this.oldpwd
				}).then(res=>{
					if(res[1].data){
						changePwd({
							id:this.userInfo.id,
							password:this.newpwd
						}).then(res=>{
							if(res[1].data){
								uni.showToast({
									title:"修改密码成功",
									duration:1500,
									mask:false,
									icon:"none"
								});
								this.$refs.popupPwd.close()
								this.userInfo.password = this.newpwd
								uni.setStorage({
									key: 'info',
									data: JSON.stringify(this.userInfo),
									success: function() {
									}
								});
								this.newpwd=""
								this.oldpwd=""
								this.repwd=""
							}
						})
					}else {
						uni.showToast({
							title:"密码输入不正确",
							duration:1500,
							mask:false,
							icon:"none"
						});
						this.oldpwd=""
					}
				})
			},
			upImg(){
				uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album'], //从相册选择
					success: (res)=>{
						const tempFilePaths = res.tempFilePaths[0];
						this.userInfo.headurl = tempFilePaths;
						uni.uploadFile({
							url: 'http://47.94.210.131:8080/user/uploadHead', //后端用于处理图片并返回图片地址的接
							filePath: tempFilePaths,
							name:'file',
							formData: {
								'id': this.userInfo.id,
							},
							success: res => {
								if(res.data==="1"){
									uni.showToast({
										title: '头像上传成功',
										duration: 1000
									});
									uni.setStorage({
										key: 'info',
										data: JSON.stringify(this.userInfo),
										success: function() {
										}
									});
								}
							},
							fail: () => {
								uni.showToast({
									title: '图片上传失败',
									icon:"none",
									duration: 1000
								});
							}
						});
					},
					error : function(e){
						console.log(e);
					}
				});
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
