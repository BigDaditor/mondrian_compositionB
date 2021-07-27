package lab.bigdaditor.mondrian_compositionb.handler;

import org.eclipse.paho.client.mqttv3.*;

public class MqttHandler implements MqttCallback {

    private static MqttClient client;
    private static MqttConnectOptions options;
    private static MqttMessage mqttMessage;

    public MqttHandler init(String username, String password, String serverURI) {
        options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setKeepAliveInterval(30);
        options.setUserName(username);
        options.setPassword(password.toCharArray());

        try {
            client = new MqttClient(serverURI, "bigdaditor");
            client.setCallback(this);
            client.connect(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean subscribe(String... topics) {
        try {
            if(topics != null) {
                for (String topic : topics) {
                    client.subscribe(topic,0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void publish(String message, int qos) {
        mqttMessage.setPayload(message.getBytes());
        mqttMessage.setQos(0);
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Lost Connection " + throwable.getMessage());
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage.getPayload().toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
