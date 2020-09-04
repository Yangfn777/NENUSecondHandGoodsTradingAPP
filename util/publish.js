import url_config from "../config";
// 获取该用户的发布商品列表
export const listPublishing = (data)=>{
    return uni.request({
        url: url_config+'/goods/listGoods',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}
// 通过商品id获取商品图片
export const getGoodsImg = (data)=>{
    return uni.request({
        url: url_config+'/goods/listImg',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}