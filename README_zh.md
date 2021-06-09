**简体中文 | [English](https://github.com/zhukangHong/relax/blob/master/README.md) |**<br>

# 概述
这是一款IDEA插件，主要用于~~提高工作效率~~ 阅读，支持上翻下翻一键隐藏和保存进度

# 快速开始
## 安装
下载.zip文件，拖拉扔到idea界面重启就完事咯

## 配置
源代码已经写好了读取配置文件的绝对路径，**E://config.properties**，必须要有以下的配置项

#你看到进度，以字为单位，可以手动修改来跳过前面无聊的部分
offset=0  

 #每页显示多少字,主要还是看控件长度
size=40     

#文档的绝对路径，目前只支持txt
bookUrl=e\://book.txt  

## 使用
点击顶部菜单栏，帮助（help）-Read，就会在底部弹出一个窗口
**使用一定要获得焦点**
- 扣 'q' 翻页
- 扣 'w' 上页
- 扣 'a' 一键隐藏
- 点击右下角的按钮保存当前进度

## 预览
首先确认你以开启这个插件，在**File-Setting-Plugins**
![](https://iamkb.oss-cn-hongkong.aliyuncs.com/image/plugins/enable.png)

点击顶部菜单栏**Help-Read**，看到下面弹出的界面了没
![](https://iamkb.oss-cn-hongkong.aliyuncs.com/image/plugins/%E5%90%AF%E5%8A%A8.png)

按q就能看到文字出来了，记得要点一下那片英文，以获取焦点
![](https://iamkb.oss-cn-hongkong.aliyuncs.com/image/plugins/start.png)

如果你领导突然在你后面冒出来，快速按下a，他就会以为你在努力工作~~如果没有获得焦点，你就爽了~~
![](https://iamkb.oss-cn-hongkong.aliyuncs.com/image/plugins/hide.png)

最后按右下角的按钮保存进度，藏的比较好
![](https://iamkb.oss-cn-hongkong.aliyuncs.com/image/plugins/save.png)

## 联系我
如果你有更好的想法或者需求可以告诉我，最好做好提交过来
**mail：414251867@qq.com**


