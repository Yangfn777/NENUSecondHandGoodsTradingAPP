<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	/* 官方ui库 */
	@import url("/common/mixin/uni.css");
	/* 第三方动画库 */
	@import url("/common/mixin/animate.css");
	/* 自定义动画库 */
	@import url("/common/mixin/common.css");
	/* 自定义图标库 */
	@import url("/common/mixin/icon.css");
	/* 类似bootstrap的UI库 */
	@import url("/common/mixin/zcm-main.css");
	@import url("/common/icon.css");
</style>
