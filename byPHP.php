<?php
// 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发

$url = "你的接口地址";

// 定义POST DATA 数组
$post_data = [
    'fileArray'=>new \CURLFile('/www/wwwroot/myProduct/demo.jpg'),// 如果使用这个方式请填写文件的绝对路径
    'api_token' => '你的token',
    'mode' => '命名方式',
    'uploadPath' => '上传目录',
    'watermark' => '是否开启水印'

];

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_SAFE_UPLOAD, true);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
$output = curl_exec($ch);
curl_close($ch);

// 打印调用结果
echo $output;

// 以下代码只是调用结果展示，复制代码后删掉或者注释掉下面内容才能运行
// 响应结果
{
    "status":"success",
    "statusCode":"200",
    "resultData":"success：File uploaded",
    "url":"返回的文件链接",
    "originFileName":"原文件名称",
    "lessurl":"不含https://前缀的链接"
} 


?>