import url_config from "../config";
// 获取该用户的发布商品列表
export const listFeedBack = (data)=>{
    return uni.request({
        url: url_config+'/goods/listFeelBack',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}
// 删除反馈
export const deleteFeedBack = (data)=>{
    return uni.request({
        url: url_config+'/goods/deleteFeelBack',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}
// 发布反馈
export const addFeedBack = (data)=>{
    return uni.request({
        url: url_config+'/goods/addFeelBack',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}
