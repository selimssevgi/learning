# Spring Web Flow

- is built on a foundation of Spring MVC

- all requests to a flow first go through DispatcherServlet

### flow executor

- drives the execution of a flow


```xml
<flow:flow-executor id="flowExecutor" />
```

- when a user enters a flow, the flow executor creates and launches an instance
  of the flow execution for that user

- although the flow executor is responsible for creating and executing flows; it
  is not responsible for loading flow definitions, that is responsibility of flow registry

### flow registry

- its job is to load flow definitions and make them available to the flow executor

```xml
<flow:flow-registry id="flowRegistry" base-path="/WEB-INF/flows">
  <flow:flow-location-pattern value="*-flow.xml" />
</flow:flow-registry>
```

- "/WEB-INF/flows/order/order-flow.xml"
- "/WEB-INF/flows/" -> flow registry base path
- "order" -> flow id
- "order-flow.xml" -> flow definition

### handling flow requests

- DispatcherServlet typically dispatches requests to controllers

- for flows, you need a FlowHandlerMapping to help DispatcherServlet know that
  it should flow requests to Spring Web Flow.

```xml
<bean class="org.springframework.webflow.mvc.servlet.FlowHandlerMapping">
  <property name="flowRegistry" ref="flowRegistry" />
</bean>
```

- whereas the FlowHandlerMapping's job is to direct flow requests to SWFlow, it
  is the job of a FlowHandlerAdapter to answer that call.

- A FlowHandlerAdapter is equivalent to a Spring MVC controller in that it
  handles the requests coming in for a flow and processes those requests

```xml
<bean class="org.springframework.webflow.mvc.servlet.FlowHandlerAdapter">
  <property name="flowExecutor" ref="flowExecutor" />
</bean>
```

### components of a flow

- a flow is defined by three primary elements:
  - states
  - transitions
  - flow data

- states are points in a flow where something happens

- if flow states are like the points on a map where you might stop during a road
  trip, then transitions are the roads that connect those points.

- as you travel from town to town, you may pick up some souvenirs, memories, and
  empty snack bags along the way.

- as a flow progresses, it collects some data: the current condition of the flow

#### states

- SWF defines five different kinds of state:

state type        | what is is for
-------------------------------------------------
action            | where the logic of a flow takes place
decision          | branch flow in two directions
end               | last stop for a flow, once reached, the flow is terminated
subflow           | a new flow in the context of a flow that is already underway
view              | pauses the flow and invites the user to participate in flow

```xml
<!-- welcome.jsp -->
<view-state id="welcome" view="welcome" />
<view-state id="welcome" view="greeting" />
<view-state id="takePayment" model="flowScope.paymentDetails" />

<action-state id="saveOrder">
  <evaluate expression="pizzaFlowActions.saveOrder(order)" />
  <transition to="thankYou" />
</action-state>

<decision-state id="checkDeliveryArea">
  <if test="pizzaFlowActions.checkDeliveryArea(customer.zipCode)"
    then="addCustomer"
    else="deliverWarning" />
</decision-state>
```

### flow data

- flow data is stored in variables that can be referenced at various points in the flow

- SWF defines five scopes:

scope        | lifespan and visibility
--------------------------------------------------
conversation | created with starting with top-level flow, destroyed with ending.  also available to subflows
flow         | only visible in the flow it was created by
request      | created and destroyed by a request lifespan
flash        | like flow, also cleared after a view state renders
view         | created and destroyed by a view state, visible only in the view state
