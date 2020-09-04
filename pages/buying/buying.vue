<template>
	<view>
		<view v-for="(item,index) in collectList" :key="item" class="d-flex j-start flex-nowrap item">
			<image style="width: 30%;" :src="item.img" mode=""></image>
			<view class="con" style="width: 70%;">
				<view class="title">{{item.title}}</view>
				<view class="des">{{item.description}}</view>
			</view>

		</view>
	</view>
</template>


<script>
	import {listBuying} from "../../util/buying";

	export default {
		data() {
			return {
				collectList: [{
					img: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592245750656&di=118c01c35298d4a9af8286dfeec66693&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2Fmi%2Fhz%2FQJ6507898187.jpg",
					title: "书本",
					description: "几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，"
				},
				{
					img: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592245750656&di=118c01c35298d4a9af8286dfeec66693&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2Fmi%2Fhz%2FQJ6507898187.jpg",
					title: "书本",
					description: "几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，"
				},
				{
					img: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592245750656&di=118c01c35298d4a9af8286dfeec66693&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2Fmi%2Fhz%2FQJ6507898187.jpg",
					title: "书本",
					description: "几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，几乎全新，300出，不邮寄，"
				},
				]
			}
		},
		created(){
			listBuying({id:1}).then(res=>{
				console.log(res)
			})
		},
		methods: {

		}
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
				-webkit-line-clamp: 3;
				/*显示的行数*/
			}
		}
	}
</style>
