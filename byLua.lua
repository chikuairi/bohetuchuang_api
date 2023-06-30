-- 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
local http = require("socket.http")
local ltn12 = require("ltn12")
local url = require("socket.url")

-- 创建一个帮助函数，用来构建查询字符串
local function buildQueryString(data)
  local queryString = {}
  for key, value in pairs(data) do
    table.insert(queryString, url.escape(key) .. "=" .. url.escape(value))
  end
  return table.concat(queryString, "&")
end

-- 准备数据
local postData = {
  api_token = "你的API_token",
  upload_format = "url", -- 设置上传方式，这里设置为 url
  uploadedFile = "https://example.com/123.jpg" -- 通过url上传方式要在 uploadedFile 字段填写一个包含协议的URL
}

-- 将数据编码为URL参数的格式
local postDataEncoded = buildQueryString(postData)

-- 通过POST发送请求
local response = {}
local res, code, headers, status = http.request({
  url = "你的接口地址",  
  method = "POST", -- 发送请求方式，必须是 POST
  headers = {
    ["Content-Type"] = "application/x-www-form-urlencoded",
    ["Content-Length"] = string.len(postDataEncoded)
  },
  source = ltn12.source.string(postDataEncoded),
  sink = ltn12.sink.table(response)
})

-- 验证状态码
if code == 200 then
  local responseBody = table.concat(response)  -- 响应结果表转换为字符串
  print("请求成功：" .. responseBody)
else
  print("请求失败，错误码：" .. code)
end
