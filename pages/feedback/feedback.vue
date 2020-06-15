<template>
	<view>
		<view class="list">
			<view v-for="(item,index) in feedBackList" :key="index" >
				{{index+1}}. {{item}}
			</view>
		</view>
		<button
			style="width: 50%;"
			@tap="publish"
		 type="primary" size="default">发布反馈</button>
		 <uniPopup ref="popupfeedBack" type="center">
		 	<view class="box">
		 		<view class="title">反馈</view>
		 		<view class="con">
		 			<textarea @blur="bindTextAreaBlur" style="height: 80px;" placeholder="请输入反馈内容..." />
		 			<button type="primary" size="mini"
		 				style="display: block; margin-top: 8px;"
		 			>提交反馈</button>
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
				feedBackList:[
					"反馈信息1",
					"反馈信息2",
					"反馈信息2",
				]
			}
		},
		methods: {
			publish(){
				this.$refs.popupfeedBack.open()
			}
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
			height: 50px;
			line-height: 50px;
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
</style>
