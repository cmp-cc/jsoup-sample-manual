## 防止XSS攻击


**该实例来自 Instant Jsoup How-to**
**Jsoup 提供了用于清除无效HTML文档的的方法。用于防止跨站脚本攻击**
**使用Jsoup.clean(String bodyHtml, Whitelist whitelist)方法基于Whitelist 白名单的一种方式**
**Cleaner 只保留通过Whitelist输入的HTML tag标签，其它tag被移除**
**jsoup 支持以下五个预定义的白名单**

方法 | 解释  | 标签内容
----|---- | ---
none() | 只允许文本节点,其它HTML tag将被剔除。|
simpleText() |只允许简单的文本tag。|b ,em ,i strong , u
basicWithImages() |在basic()的基础上增加img以及src属性指向http 或 https|
basic() |允许更加全面的文本节点。|a, b, blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q, small, strike, strong, sub, sup, u, and ul,属性
relaxed() |允许全面的文本标签 和 THML 结构标签|

	





   