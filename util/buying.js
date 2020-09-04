import url_config from "../config";
export const listBuying = (data)=>{
    return uni.request({
        url: url_config+'/goods/listMyMsg',
        data: data,
        method: 'get', //get、post、delete
        header: {}
    })
}