<%--
  Created by IntelliJ IDEA.
  User: southgyu
  Date: 2021-07-26
  Time: 오후 4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<textarea id="content"></textarea>
<button id="send">보내기</button>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var client = new Paho.MQTT.Client("192.168.29.184", 9001, "bigdaditor123");
    client.onConnectionLost = onConnectionLost;
    client.onMessageArrived = onMessageArrived;

    client.connect({
        onSuccess:onConnect,
        userName: "southgyu",
        password: "dcdacapo77"
    });

    function onConnect() {
        console.log("onConnect");
        client.subscribe("topic/v1");
    }

    function onConnectionLost(responseObject) {
        if (responseObject.errorCode !== 0) {
            console.log("onConnectionLost:"+responseObject.errorMessage);
        }
    }

    function onMessageArrived(message) {
        console.log("onMessageArrived:"+message.payloadString);
    }

    $("#send").click(function () {
        let content = $("#content").val();
        client.send(content);
    });
</script>
</html>
