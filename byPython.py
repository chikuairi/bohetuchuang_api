import requests
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

# 响应结果
{"result":"success",
 "url":"返回的文件链接",
 "originFileName":"原文件名称",
 "lessurl":"不含https://前缀的链接"
}