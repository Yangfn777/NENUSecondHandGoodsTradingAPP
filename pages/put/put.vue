<template>
	<view style="box-sizing: border-box;padding: 10px;">
		<view class="uni-textarea">
			<textarea  style="height: 80px;"
					  v-model="info.description"
					  placeholder="请输入商品描述..." />
			<view class="imgList">
				<text class="title">图片上传</text>
				<text class="num">{{imgList.length?imgList.length:0}}/4</text>
				<view class="d-flex flex-nowrap j-start" style="margin-top: 10px;">
					<view class="img" v-for="(item,index) in imgList" :key="item">
						<image style="width: 100%;height: 100%;" :src="item" mode=""></image>
						<text class="cuIcon-close"
							@tap="deleteImg(index)"
						></text>
					</view>
					<view class="img" v-show="imgList.length<4"
						@tap="chooseImg"
					>
						<text class="cuIcon-add"
						></text>
					</view>
				</view>
				
			</view>
			<view class="item d-flex flex-nowrap j-start">
				<view class="title">商品名称：</view>
				<input type="text" value="" placeholder="请输入商品名称..."
					v-model="info.title"
				/>
			</view>
			<view class="item d-flex flex-nowrap j-start">
				<view class="title">商品类型：</view>
				<view class="con">
					<view class="uni-title" @tap="changeState">{{form.state===-1?"请选择商品类型":stateList[form.state]}}</view>
				</view>
				
			</view>
			<view class="item d-flex flex-nowrap j-start">
				<view class="title">商品价格：</view>
				<input type="text" value="" placeholder="请输入商品价格..."
					v-model="info.prise"
				/>
			</view>

		</view>
		<uniPopup ref="popupState" type="bottom">
			<view class="" style="background-color: #fff;position: relative;bottom: 50px;">
				<picker-view style="height: 150px;width: 750upx;" :indicator-style="indicatorStyle" :value="[0]" @change="bindChange">
					<picker-view-column>
						<view style="text-align: center;" class="item" v-for="(item,index) in stateList" :key="index">{{item}}</view>
					</picker-view-column>
				</picker-view>
			</view>
		</uniPopup>
		<view class="">
			<button type="default" style="background-color: #007AFF;color:#FFFFFF;margin-top:100upx;width:300upx;"
				@click="publishGoods"
			>发布</button>
		</view>
	</view>
</template>

<script>
	import {uniPopup} from '@dcloudio/uni-ui'
	import {putGoods} from "../../util/putGoods";

	export default {
		data() {
			return {
				imgList:[],
				fileList:[],
				stateList:["","书本","衣服","生活用品","娱乐用品"],
				form:{
					state:-1
				},
				indicatorStyle: `height: ${Math.round(uni.getSystemInfoSync().screenWidth/(750/100))}px;`,
				info:{
					type:"",
					description:"",
					prise:"",
					title:"",
					view:0
				},
				userInfo:null
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
			chooseImg(){
				uni.chooseImage({
				    count: 1, //默认9
				    sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				    sourceType: ['album'], //从相册选择
				    success: (res)=>{
				        this.imgList.push(res.tempFilePaths[0]);
						this.fileList.push(res.tempFiles[0])
				    }
				});
			},
			deleteImg(index){
				if(confirm("确定要删除吗")){
					this.imgList.splice(index,1);
					this.fileList.splice(index,1);
				}
			},
			changeState(){
				this.$refs.popupState.open()
			},
			bindChange(e){
				this.form.state = e.target.value[0]
				this.info.type = this.stateList[e.target.value[0]]
			},
			publishGoods(){
				this.info.uid = this.userInfo.id;
				putGoods(this.info).then(res=>{
					let goodId = res[1].data;
					this.imgList.forEach((item,index)=>{
						uni.uploadFile({
							url: 'http://47.94.210.131:8080/goods/addImg', //后端用于处理图片并返回图片地址的接
							filePath: item,
							name:'file',
							formData: {
								'id': goodId,
							},
							success: res => {
								console.log(res);
								// let data = JSON.parse(res.data); //返回的是字符串，需要转成对象格式，打印data如下图
								// if (data.code == 200) {
								// 	console.log(data.msg); //图片地址
								// }
								if(res.data==="1"){
									uni.showToast({
										title: '发布成功',
										duration: 1000
									});
									this.info = {
										type:"",
										description:"",
										prise:"",
										title:"",
										view:0
									}
									uni.navigateTo({
										url: '/pages/publish/publish',
									});
								}
							},
							fail: () => {
								uni.showToast({
									title: '图片上传失败',
									duration: 1000
								});
							}
						});
					})
				}).catch(err=>{
					uni.showToast({
						title: '发布失败',
						duration: 1000
					});
				})
			}
		},
		components:{
			uniPopup
		}
	}
</script>

<style lang="less" scoped>
	.imgList{
		width: 100%;
		box-sizing: border-box;
		padding: 10upx 10upx;
		.num{
			float: right;
			color: #999;
		}
		
		.img{
			position: relative;
			margin-right: 10upx;
			width: 170upx;
			height: 170upx;
			border: 1px solid #999;
			border-radius: 5px;
			overflow: hidden;
			color: #999;
			line-height: 170upx;
			text-align: center;
			font-size: 170upx;
			.cuIcon-close{
				display: block;
				position: absolute;
				top: -10px;
				right: -10px;
				width: 25px;
				height: 25px;
				line-height: 35px;
				text-align: left;
				background-color: rgba(0,0,0,0.6);
				color: #fff;
				border-radius: 50%;
				font-size: 14px;
			}
		}
	}
	.item{
		padding: 0 10px;
		height: 50px;
		line-height: 50px;
		border-bottom: 1px solid #ddd;
		.title{
			line-height: 50px;
		}
		input,.con{
			height: 100%;
			width: 70%;
			padding: 0 10px;
		}
	}
</style>
