<template>
    <div>
        <input type="file" id="boheimg" @change="fileUpload"/>
    </div>
</template>
<script>
import Axios from "axios";
export default {
    // 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
    methods:{
        fileUpload(event){

            console.log(event);
            
            let file = event.target.files
            let formData = new FormData()
            formData.append('uploadedFile', file[0])
            formData.append("api_token", "你的token");
            formData.append("mode", "命名方式");
            formData.append("uploadPath", "上传目录");
            formData.append("watermark", "是否开启水印");
            
            // 文件上传
            Axios.post('你的接口地址', formData)
            .then((res) => {
                let data = res.data;
                console.log(data);
            }).catch((e)=>{
                console.log(e);
            })
          
        },
        
    }
}
</script>

以下代码只是调用结果展示，复制代码后删掉或者注释掉下面内容才能运行
响应结果
{
    "status":"success",
    "statusCode":"200",
    "resultData":"success：File uploaded",
    "url":"返回的文件链接",
    "originFileName":"原文件名称",
    "lessurl":"不含https://前缀的链接"
} 