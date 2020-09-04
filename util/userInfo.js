// 修改昵称
import url_config from "../config";
export const changeUsername = (data)=>{
	return uni.request({
		url: url_config+'/user/updateUser',
		data: data,
		method: 'get', //get、post、delete
		header: {}
	})
}

// 验证密码
export const relogin = (data)=>{
	return uni.request({
		url: url_config+'/user/login',
		data: data,
		method: 'get', //get、post、delete
		header: {}
	})
}
// 修改密码
export const changePwd = (data)=>{
	return uni.request({
		url: url_config+'/user/updateUser',
		data: data,
		method: 'get', //get、post、delete
		header: {}
	})
}

// 上传图片

