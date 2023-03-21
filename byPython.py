import requests
# 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
def python_demo():
    url = '你的接口地址'
    files = {'fileArray': ('demo.jpg', open('demo.jpg', 'rb'), "image/jpeg")}
    data = {'api_token': '你的token',
            'mode': '命名方式',
            'uploadPath': '上传目录',
            'watermark': '是否开启水印',
            }
    res = requests.post(url, data=data, files=files)
    print(res.text)
python_demo()

# 以下代码只是调用结果展示，复制代码后删掉或者注释掉下面内容才能运行
# 响应结果
{
    "status":"success",
    "statusCode":"200",
    "resultData":"success：File uploaded",
    "url":"返回的文件链接",
    "originFileName":"原文件名称",
    "lessurl":"不含https://前缀的链接"
} 