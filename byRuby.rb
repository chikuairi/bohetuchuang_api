# 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
require 'uri'
require 'net/http'

uri = URI('https://example.com/test/api/upload/')
# 入参
res = Net::HTTP.post_form(
    uri, 
    'api_token' => '1d9595d54d66f5d12936', 
    'upload_format' => 'url', # 示例，使用URL方式上传，下面upload_format填写的是完整的包含协议头的URL地址
    'uploadedFile' => 'https://example.com/123.jpg'
)
puts res.body  if res.is_a?(Net::HTTPSuccess)

