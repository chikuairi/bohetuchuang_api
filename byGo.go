// 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"net/url"
	"strings"
)

func main() {
	// 准备要发送的数据
	data := url.Values{}
	data.Set("api_token", "你的API_token")
	data.Set("upload_format", "url")                                               // 设置上传方式，这里设置为 url
	data.Set("uploadedFile", "https://static.zixiaoyun.com/riyugo/image/logo.jpg") // 通过url上传方式要在 uploadedFile 字段填写一个包含协议的URL

	// 发送 POST 请求 -- 发送请求方式，必须是 POST
	resp, err := http.Post("你的接口地址", "application/x-www-form-urlencoded", strings.NewReader(data.Encode()))
	if err != nil {
		fmt.Println("请求失败:", err)
		return
	}
	defer func(Body io.ReadCloser) {
		err := Body.Close()
		if err != nil {

		}
	}(resp.Body)

	// 读取响应内容
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("无法读取响应内容:", err)
		return
	}

	// 验证响应状态
	if resp.StatusCode == http.StatusOK {
		// 打印响应内容
		fmt.Println("请求成功:", string(body))
	} else {
		// 打印报错信息
		fmt.Println("请求失败，错误码:", resp.StatusCode)
	}
}
