# spring-integration-channels
Playground for different Spring Integration Channel Usage

> While the Message plays the crucial role of encapsulating data, it is the MessageChannel that decouples message producers from message consumers.
https://docs.spring.io/spring-integration/docs/current/reference/html/

Keep in mind that

1. All of queue-based channels are storing messages in-memory only by default. When persistence is required, you can either provide a 'message-store' attribute within the 'queue' element to reference a persistent MessageStore implementation or you can replace the local channel with one that is backed by a persistent broker, such as a JMS-backed channel or channel adapter. 
2. If transactions are import work with DirectChannels or PublishSubscribeChannel without a task exectutor pool
3. You can define you channels via XML in your context file or in your Java classes (as you wish)

### Playground


![Alt text](docs/overview.png?raw=true "Title")


### Direct Channel (default)

<int:channel>

* The DirectChannel has point-to-point semantics
* The key motivation for providing a channel implementation with this behavior is to support transactions that must span across the channel while still benefiting from the abstraction and loose coupling that the channel provides
* The DirectChannel internally delegates to a Message Dispatcher to invoke its subscribed Message Handlers, and that dispatcher can have a load-balancing strategy exposed via load-balancer or load-balancer-ref attributes (mutually exclusive).  Messages are sent in a round robin fashion to their subscribers

![Alt text](docs/direct-channel.png?raw=true "Title")


###   PublishSubscribeChannel
```<int:publish-subscribe-channel/>```
* The PublishSubscribeChannel implementation broadcasts any Message sent to it to all of its subscribed handlers. 
* You can also specify the task-executor used for publishing messages (if none is specified, it publishes in the sender’s thread)

![Alt text](docs/publish-subscribe-channel.png?raw=true "Title")


###  PublishSubscribeChannel (with task executor)

```
 <int:publish-subscribe-channel id="publishSubscribeChannel" task-executor="executor"/>
    <task:executor id="executor" pool-size="10"/>
```

* If you provide an executor the message dispatching will be handled by the a thread in the executor's pool

![Alt text](docs/publish-subscribe-channel-with-executor.png?raw=true "Title")
    
