<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>WebSocket</title>
</head>
<body>

<div>
    <div id="connect-container">
        <div>
            <button id="connect" οnclick="connect('/ListMap/websocket');">Connect</button>
        </div>
        <div>
            <textarea id="message" style="width: 350px">Here is a message!</textarea>
        </div>
        <div>
            <button id="send" οnclick="send();">Send message</button>
        </div>
    </div>
    <div id="console"></div>
</div>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath }/statics/layui/jquery-2.1.1.js"></script>

<script type="text/javascript">

    var webSocket = null;
    var url = null;

    /**
     * 创建连接
     */
    function connect(urlPath) {

        /**
         * 判断协议 - http or https
         */
        url = isUrl(urlPath);

        /**
         * 显示信息
         */
        console.log("链接url为:" + url);

        /**
         * 建立连接
         */
        webSocket = new WebSocket(url);

        /**
         * 连接成功
         */
        webSocket.onopen = function () {
            console.log('Info: 连接成功.');
        };

        /**
         * 连接失败
         */
        webSocket.onerror = function () {
            console.log('Info: 连接失败.');
        };

        /**
         * 连接断开
         */
        webSocket.onclose = function (event) {
            console.log('Info: 连接断开.');
            console.log(event.data);
        };

        /**
         * 来自服务器的消息
         */
        webSocket.onmessage = function (event) {
            var data = JSON.parse(event.data);
            showText(data['messageDate'] + '<br/>Info: 来自服务器的消息. ' + data['messageText']);
        };

    }

    /**
     * 发送消息
     */
    function send() {

        // 判断是否已连接
        if (webSocket != null) {
            // 新建data对象，并规定属性名与相应的值
            var data = {};
            // 发送者ID
            data['fromId'] = 'NZ-ID-' + new Date().getTime();
            // 发送者Name
            data['fromName'] = 'NZ-NAME-' + new Date().getTime();
            // 接收者ID - userSocketSessionMap - key
            // 注意 - NZ1 代表是第一个连接人的key - 测试
            // 消息发送的也是给第一个连接者
            data['toId'] = 'NZ1';
            // 发送的消息
            data['messageText'] = document.getElementById('message').value;
            // 将对象封装成JSON后发送至服务器
            webSocket.send(JSON.stringify(data));
            // 显示消息
            console.log('Sent: ' + data['messageText']);
        } else {
            console.log('Send: 连接未建立，请连接。');
        }

    }

    /**
     * 显示文本
     * @param message
     */
    function showText(message) {

        var console = $('#console');

        $(console).html($(console).html() + "<br/>" + message);

    }

    /**
     * 判断协议 - http or https
     */
    function isUrl(urlPath) {

        if (window.location.protocol == 'http:') {
            return 'ws://' + window.location.host + urlPath;
        } else {
            return 'wss://' + window.location.host + urlPath;
        }

    }

</script>

</html>
