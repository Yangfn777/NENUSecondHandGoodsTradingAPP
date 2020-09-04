<template>
	<view>
		<view v-for="(item,index) in collectList" :key="index"
			  class="d-flex j-start flex-nowrap item"
			  style="position: relative"
			  @tap="navigate(item)"
		>
			<image style="width: 30%;" :src="item.headPic&&item.headPic.length>0?url+item.headPic[0].picUrl:''" mode=""></image>
			<view class="con" style="width: 70%;">
				<view class="title">{{item.title}}</view>
				<view class="des">{{item.description}}</view>
			</view>
			<view @tap.stop="deleteGoods(item,index) "
				style="position: absolute;bottom: 10px;right: 10px;color: red;"
			>删除</view>
		</view>
	</view>
</template>


<script>
	import {listPublishing,getGoodsImg,deleteGoods} from "../../util/publish";

	export default {
		data() {
			return {
				collectList: [],
				userInfo:[],
				url:"http://47.94.210.131:8080"
			}
		},
		methods: {
			navigate(item){
				let id = item.id;
				uni.navigateTo({
					url: `/pages/detail/detail?id=${id}`,
				});
			},
			deleteGoods(item,index){
				uni.showModal({
					title: '提示',
					content: '确认要删除吗？',
					success: (res)=>{
						if (res.confirm) {
							deleteGoods({
								id:item.id
							}).then(res=>{
								if(res[1].data){
									uni.showToast({
										title: '删除成功',
										duration: 1000
									});
									this.collectList.splice(index,1)
								}
							}).catch(err=>{
								throw err;
							})
						} else if (res.cancel) {
							return;
						}
					}
				});

			}
		},
		onShow(){
			uni.getStorage({
				key:"info",
				success:(e)=>{
					this.userInfo = JSON.parse(e.data)//这就是你想要取的token
				}
			})
			listPublishing({
				id:this.userInfo.id
			}).then(res=>{
				this.collectList = res[1].data;
				this.collectList.forEach((item,index)=>{
					getGoodsImg({
						id:item.id
					}).then(res=>{
						item.headPic = res[1].data
					}).catch(err=>{
						throw err;
					})
				})

			}).catch(err=>{
				throw err;
			})
		},
	}
</script>

<style lang="less" scoped>
	.item {
		box-sizing: border-box;
		padding: 10px;
		height: 115px;
		border-bottom: 1px solid #999;
		image {
			height: 100%;
		}

		.con {
			padding-left:10px;
			box-sizing: border-box;
			height: 100%;
			.title{
				color: #999;
				font-weight: bold;
			}
			.des {
				color: #999;
				line-height: 25px;
				display: -webkit-box;
				overflow: hidden;
				/*隐藏溢出的文本  */
				text-overflow: ellipsis;
				word-break: break-all;
				/*自动换行*/
				-moz-box-orient: vertical;
				/*从上到下自动排列子元素*/
				-webkit-box-orient: vertical;
				-webkit-line-clamp: 2;
				/*显示的行数*/
			}
		}
	}
</style>
