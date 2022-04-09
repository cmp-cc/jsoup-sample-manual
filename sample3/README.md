## Jsoup Dom 操作

**数据提取的前提是你已经很熟悉当前HTML的文档结构，我们通过文档对象（Document），运用类似于DOM方法（Javascript/jQuery ）进行数据提取操作。**

这个实例包含如下内容：
* 增加
   * 增加一个元素节点、属性元素、文本节点
* 查找
   * 使用DOM操作获取元素
   * 使用CSS选择器获取元素
* 删除
   * 移除一个元素节点、属性元素、文本节点
* 修改
   * 修改一个元素、属性元素、文本节点


#### jsoup dom 树
**这里不进行HTML Dom 知识的讲解，只注重实际操作，给予一些Jsoup dom相关解释**
* Document(文档对象) 是所有Dom操作的入口。它也可以理解为root Element (根元素对象)
* Jsoup 对HTML的所有元素进行抽象,每一个元素都为一个Node(节点对象),上层元素继承于Node(节点对象)。Jsoup Class层次关系如下：
   * Node (节点元素)
      * Element (元素节点)
         * Document (文档对象)
         * FormElement (表单对象) 
      * DocumentType (HTML 声明对象)<!DOCTYPE html>
      * XmlDeclaration (XML 声明对象)
      * Comment  (注释节点对象)
      * DataNode (数据节点对象) 
      * TextNode (文本节点对象)

### Elements （元素节点）
**Elements 提供了一系列类似于DOM的方法来查找、数据插入和修改的方法**
* 查找元素
	* getElementById(String id)
	* getElementsByTag(String tag)
	* getElementsByClass(String className)
	* getElementsByAttribute(String key) (and related methods)
	* Element siblings: siblingElements(), firstElementSibling(), lastElementSibling(); nextElementSibling(), previousElementSibling()
	* Graph: parent(), children(), child(int index)
* 元素数据
	* attr(String key)获取属性attr(String key, String value)设置属性
	* attributes()获取所有属性
	* id(), className() and classNames()
	* text()获取文本内容text(String value) 设置文本内容
	* html()获取元素内HTMLhtml(String value)设置元素内的HTML内容
	* outerHtml()获取元素外HTML内容
	* data()获取数据内容（例如：script和style标签)
	* tag() and tagName()
* 操作HTML和文本
	* append(String html), prepend(String html)
	* appendText(String text), prependText(String text)
	* appendElement(String tagName), prependElement(String tagName)
	* html(String value)
        
### select 选择器
**使用 Element / Elements.select(String selector) 方法进行元素查找，它将返回一个Elements集合，集合索引从0开始，你可以对单个元素或集体元素进行处理,**
* Selector选择器概述
	* tagname: 通过标签查找元素，比如：a
	* ns|tag: 通过标签在命名空间查找元素，比如：可以用 fb|name 语法来查找 <fb:name> 元素
	* #id: 通过ID查找元素，比如：#logo
	* .class: 通过class名称查找元素，比如：**.masthead**
	* [attribute]: 利用属性查找元素，比如：[href]
	* [^attr]: 利用属性名前缀来查找元素，比如：可以用[^data-] 来查找带有HTML5 Dataset属性的元素
	* [attr=value]: 利用属性值来查找元素，比如：[width=500]
	* [attr^=value], [attr$=value], [attr*=value]: 利用匹配属性值开头、结尾或包含属性值来查找元素，比如：[href*=/path/]
	* [attr~=regex]: 利用属性值匹配正则表达式来查找元素，比如： img[src~=(?i)\.(png|jpe?g)]
	* *: 这个符号将匹配所有元素
	* * Selector选择器组合使用
	* el#id: 元素+ID，比如： div#logo
	* el.class: 元素+class，比如： div.masthead
	* el[attr]: 元素+class，比如： a[href]
	* 任意组合，比如：a[href].highlight
	* ancestor child: 查找某个元素下子元素，比如：可以用.body p 查找在"body"元素下的所有 p元素
	* parent > child: 查找某个父元素下的直接子元素，比如：可以用div.content > p 查找 p 元素，也可以用body > * 查找body标签下所有直接子元素
	* siblingA + siblingB: 查找在A元素之前第一个同级元素B，比如：div.head + div
	* siblingA ~ siblingX: 查找A元素之前的同级X元素，比如：h1 ~ p
	* el, el, el:多个选择器组合，查找匹配任一选择器的唯一元素，例如：div.masthead, div.logo
* 伪选择器selectors
	* :lt(n): 查找哪些元素的同级索引值（它的位置在DOM树中是相对于它的父节点）小于n，比如：td:lt(3) 表示小于三列的元素
	* :gt(n):查找哪些元素的同级索引值大于n，比如： div p:gt(2)表示哪些div中有包含2个以上的p元素
	* :eq(n): 查找哪些元素的同级索引值与n相等，比如：form input:eq(1)表示包含一个input标签的Form元素
	* :has(seletor): 查找匹配选择器包含元素的元素，比如：div:has(p)表示哪些div包含了p元素
	* not(selector): 查找与选择器不匹配的元素，比如： div:not(.logo) 表示不包含 class=logo 元素的所有 div 列表
	* :contains(text): 查找包含给定文本的元素，搜索不区分大不写，比如： p:contains(jsoup)
	* :containsOwn(text): 查找直接包含给定文本的元素
	* :matches(regex): 查找哪些元素的文本匹配指定的正则表达式，比如：div:matches((?i)login)
	* :matchesOwn(regex): 查找自身包含文本匹配指定正则表达式的元素

### URL 处理
**在数据输入的时候，如果设置baseUri字段，我们可以将页面中的相对路径改为绝对路径处理通过Node.absUrl(String key)方法或者Node.attr("abs:href")**







   