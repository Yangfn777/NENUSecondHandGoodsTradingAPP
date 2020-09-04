import url_config from "../config";
export const putGoods = (data)=>{
    return uni.request({
        url: url_config+'/goods/addGoods',
        data: data,
        method: 'post', //get、post、delete
        header: {
            'content-type': 'application/x-www-form-urlencoded'
        }
    })
}