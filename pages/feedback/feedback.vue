<template>
	<view>
		<view class="list">
			<view v-for="(item,index) in feedBackList" :key="index"
				style="position: relative;padding: 10upx;border-bottom: 1px solid #aaa;"
				class="clearfix"
			>
				<view style="word-wrap:break-word">
					{{index+1}}. {{item.str}}
				</view>
				<view class="info clearfix"

				>
					<view style="float: left;color:#7dabdc;">{{item.date}}</view>
					<view style="float: right;color: #dc3545"
						@tap="deleteFeedback(item,index)"
					>删除</view>
				</view>

			</view>

		</view>
		<button
			style="width: 50%;margin: 10px auto"
			@tap="publish"
		 type="primary" size="default">发布反馈</button>
		 <uniPopup ref="popupfeedBack" type="center">
		 	<view class="box">
		 		<view class="title">反馈</view>
		 		<view class="con">
		 			<textarea style="height: 80px;" placeholder="请输入反馈内容..."
						v-model="str"
					/>
		 			<button type="primary" size="mini"
		 				style="display: block; margin-top: 8px;"
							@tap="addFeedback"
		 			>提交反馈</button>
		 		</view>
		 	</view>
		 </uniPopup>
	</view>
</template>

<script>
	import {uniPopup} from '@dcloudio/uni-ui'
	import {listFeedBack,deleteFeedBack,addFeedBack} from "../../util/feedback";

	export default {
		data() {
			return {
				feedBackList:[],
				str:'',
				info:null
			}
		},
		methods: {
			publish(){
				this.$refs.popupfeedBack.open()
			},
			deleteFeedback(item,index){
				uni.showModal({
					title: '提示',
					content: '确定要删除吗？',
					success: (res)=>{
						if (res.confirm) {
							deleteFeedBack({
								id:item.id
							}).then(res=>{
								if(res[1].data){
									this.feedBackList.splice(index,1)
									uni.showToast({
										title: '删除成功',
										duration: 1000
									});
								}
							}).catch(err=>{
								uni.showToast({
									title: '删除失败',
									icon:"none",
									duration: 1000
								});
								throw err;
							})
						} else if (res.cancel) {
							return;
						}
					}
				});

			},
			addFeedback(){
				addFeedBack({
					uid:this.info.id,
					str:this.str
				}).then(res=>{
					if(res[1].data===1){
						uni.showToast({
							title: '反馈成功',
							duration: 1000
						});
						this.$refs.popupfeedBack.close()
						let data = {
							uid:this.info.id,
							str:this.str
						}
						this.feedBackList.push(data)
					}
				}).catch(err=>{
					uni.showToast({
						title: '删除失败',
						icon:"none",
						duration: 1000
					});
					throw err
				})
			}
		},
		onShow(){
			uni.getStorage({
				key:"info",
				success:(e)=>{
					this.info = JSON.parse(e.data)//这就是你想要取的token
				}
			})
			listFeedBack({
				id:this.info.id
			}).then(res=>{
				this.feedBackList = res[1].data;
				console.log(this.feedBackList)
			}).catch(err=>{
				throw err;
			})
		},
		components:{
			uniPopup
		}
	}
</script>

<style lang="less">
	.list{
		padding: 0 10px;
		> view{
			/*height: 50px;*/
			/*line-height: 50px;*/
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
		.con{
			padding-top: 10px;
		}
		.uni-input{
			border-bottom: 1px solid #ddd;
		}
	}
	.info{
		position: relative;
		left: 50%;
		/*margin-top: 10px;*/
		height: 30px;
		line-height: 30px;
		width: 50%;
	}
	.clearfix{
		display: block;
		content: "";
		clear: both;
	}
</style>
