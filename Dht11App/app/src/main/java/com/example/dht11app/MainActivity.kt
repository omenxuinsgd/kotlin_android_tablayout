package com.example.dht11app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*
import java.io.UnsupportedEncodingException


class MainActivity : AppCompatActivity() {
    private lateinit var clientAndroid: MqttAndroidClient
    private lateinit var token: IMqttToken

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connect()
    }

    fun connect() {
        val serverURI = "tcp://broker.hivemq.com:1883"
        // val topicPub = "omenosSub"
        val clientId = MqttClient.generateClientId()
        val options = MqttConnectOptions()
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1)
        options.setCleanSession(false)
        // val qos = 0
        clientAndroid = MqttAndroidClient (this@MainActivity,serverURI,clientId)
        // val content = "Message from MqttPublishSample"
        // val clientId = "JavaSample"
        // mqttAndroidClient = MqttAndroidClient ( context.applicationContext,"YOUR MQTT BROKER ADDRESS","YOUR CLIENT ID" )
        try {
            options.userName = "isungeek"
            options.password = "NUSANERIN32nusanerin32*".toCharArray()
            token = clientAndroid.connect(options)

            token.actionCallback = object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    //publish(client,"payloadd");
//                    subscribe(clientAndroid,"dht")
//                    subscribe(clientAndroid,"bmp")

//                    onBtn.setOnClickListener {
//                        val payload = "1"
//                        var encodedPayload = ByteArray(0)
//                        try {
//                            encodedPayload = payload.toByteArray(charset("UTF-8"))
//                            val message = MqttMessage(encodedPayload)
//                            clientAndroid.publish(topicPub, message)
//                            Toast.makeText(this@MainActivity, "Turn ON Success", Toast.LENGTH_SHORT).show()
//                        } catch (e: UnsupportedEncodingException) {
//                            e.printStackTrace()
//                        } catch (e: MqttException) {
//                            e.printStackTrace()
//                        }
//                    }
//                    //connectionStatus = true
//                    // Give your callback on connection established here
//
//                    offBtn.setOnClickListener{
//                        val payload = "0"
//                        var encodedPayload = ByteArray(0)
//                        try {
//                            encodedPayload = payload.toByteArray(charset("UTF-8"))
//                            val message = MqttMessage(encodedPayload)
//                            clientAndroid.publish(topicPub, message)
//                            Toast.makeText(this@MainActivity, "Turn OFF Success", Toast.LENGTH_SHORT).show()
//                        } catch (e: UnsupportedEncodingException) {
//                            e.printStackTrace()
//                        } catch (e: MqttException) {
//                            e.printStackTrace()
//                        }
//                    }

                    subscribe(clientAndroid, "omenosPub/temp")
                    subscribe(clientAndroid, "omenosPub/hum")
                    clientAndroid.setCallback(object : MqttCallback {
                        override fun connectionLost(cause: Throwable) {}

                        @Throws(Exception::class)
                        override fun messageArrived(topic: String, message: MqttMessage) {
                            Log.d("file", message.toString())
                            if (topic == "omenosPub/temp") {
                                tempTxt.text = message.toString()
                            }
                            if (topic == "omenosPub/hum") {
                                humTxt.text = message.toString()
                            }
                        }

                        override fun deliveryComplete(token: IMqttDeliveryToken) {}
                    })

                    Toast.makeText(this@MainActivity, "Connected", Toast.LENGTH_LONG).show()
                }
                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    //connectionStatus = false
                    Toast.makeText(this@MainActivity, "Check Network", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: MqttException) {
            // Give your callback on connection failure here
            e.printStackTrace()
        }
    }

    fun publish(client: MqttAndroidClient, payload: String) {
        val topic = "foo/bar"
        var encodedPayload = ByteArray(0)
        try {
            encodedPayload = payload.toByteArray(charset("UTF-8"))
            val message = MqttMessage(encodedPayload)
            client.publish(topic, message)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun subscribe(client: MqttAndroidClient, topic: String?) {
        val qos = 1
        try {
            val subToken = client.subscribe(topic, qos)
            subToken.actionCallback = object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    // The message was published
                }

                override fun onFailure(
                    asyncActionToken: IMqttToken,
                    exception: Throwable
                ) {
                    // The subscription could not be performed, maybe the user was not
                    // authorized to subscribe on the specified topic e.g. using wildcards
                }
            }
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }
}