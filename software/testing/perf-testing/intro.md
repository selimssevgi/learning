# performance testing

- perfomance testing should start early and continue through the whole development process

- tests how an application or resource performs under a given load to see its impact

- performance testing is done after functional testing

- performance is measured in terms of:
  - response time = request time(network) + processing time(hw/sw) + response time(network)
  - throughput    = # of trxs(req/res) / unit of time(millis/seconds)
  - reliability   = # of errors / # of requests
  - scalability


### performance requirements

- the average/maximum response time should be ...

- the system should be able to support ... pages per second

- the system should be capable of supporting at least ... users per hour

### types of performance tests

* two main ways to generate load
  1. increase the number of users
  2. increase the number of requests

* smoke test: a single request to test the test

* load test: test the system at the specific load level

* stress test: see at which load level the system stops working

* spike test: sudden increment in the load for a short period of time
